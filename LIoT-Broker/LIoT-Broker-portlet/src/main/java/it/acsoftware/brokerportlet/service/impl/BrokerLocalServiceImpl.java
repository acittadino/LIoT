package it.acsoftware.brokerportlet.service.impl;

import it.acsoftware.brokerportlet.BeanValidationException;
import it.acsoftware.brokerportlet.NoSuchBrokerException;
import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.base.BrokerLocalServiceBaseImpl;
import it.acsosftware.brokerportlet.util.BrokerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletConfig;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;

/**
 * The implementation of the broker local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.acsoftware.brokerportlet.service.BrokerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.brokerportlet.service.base.BrokerLocalServiceBaseImpl
 * @see it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil
 */
public class BrokerLocalServiceImpl extends BrokerLocalServiceBaseImpl {
	private static Log logger = LogFactoryUtil.getLog(BrokerLocalServiceImpl.class);

	public Broker saveOrUpdateBroker(Broker broker, Locale currentLocale,
			PortletConfig config) throws SystemException,
			BeanValidationException {
		check(broker, currentLocale, config);
		boolean isNew = broker.isNew();
		broker = brokerPersistence.update(broker);

		if (isNew && broker != null) {
			try {
				Group g = GroupLocalServiceUtil.getCompanyGroup(broker
						.getCompanyId());
				ResourceLocalServiceUtil.addResources(broker.getCompanyId(),
						g.getGroupId(), broker.getUserId(),
						Broker.class.getName(), broker.getBrokerId(), false,
						true, false);
			} catch (Exception e) {
				logger.error(e);
			}
		}

		// add broker to the broker service layer
		try {
			BrokersManagerLocalServiceUtil.addBrokerServiceDefinition(
					broker, true);
		} catch (Exception e) {
			logger.error(e);
		}

		return broker;
	}

	private void check(Broker broker, Locale currentLocale, PortletConfig config)
			throws BeanValidationException {
		if (Validator.isNull(broker))
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale,
					"it.acsoftware.brokerportlet.validationBeanNull"));

		boolean valid = true;
		boolean alreadyExists = false;
		StringBuilder invalidFields = new StringBuilder();

		if (Validator.isNull(broker.getName())) {
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.brokerportlet.label.broker.name"))
					.append(",");
		}

		if(Validator.isNull(broker.getProtocol())){
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.brokerportlet.label.broker.protocol"))
					.append(",");
		}
		
		if (Validator.isNull(broker.getUrl()) || !Validator.isUri(broker.getUrl())) {
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.brokerportlet.label.broker.host"))
					.append(",");
		}

		if (Validator.isNull(broker.getPort())
				|| !Validator.isNumber(broker.getPort())) {
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.brokerportlet.label.broker.port"))
					.append(",");
		}

		if (BrokerType.valueOf(broker.getType()).equals(BrokerType.MQTT)) {
			if (Validator.isNull(broker.getMqttClientId())) {
				valid = false;
				invalidFields
						.append(LanguageUtil
								.get(config, currentLocale,
										"it.acsoftware.brokerportlet.label.broker.mqtt.clientId"))
						.append(",");
			}
		} else if (BrokerType.valueOf(broker.getType())
				.equals(BrokerType.KAFKA)) {
			if (Validator.isNull(broker.getKafkaZookeeperHost())) {
				valid = false;
				invalidFields
						.append(LanguageUtil
								.get(config, currentLocale,
										"it.acsoftware.brokerportlet.label.broker.kafka.zookeeperHost"))
						.append(",");
			}

			if (Validator.isNull(broker.getKafkaGroupId())) {
				valid = false;
				invalidFields
						.append(LanguageUtil
								.get(config, currentLocale,
										"it.acsoftware.brokerportlet.label.broker.kafka.groupId"))
						.append(",");
			}
		}

		if (valid) {
			try {
				Broker brokerDb = null;
				try {
					brokerDb = brokerPersistence.findByName(
							broker.getCompanyId(), broker.getName());
					invalidFields.append(LanguageUtil.get(config,
							currentLocale,
							"it.acsoftware.brokerportlet.label.broker.name"));
				} catch (NoSuchBrokerException e) {
					logger.debug("no broker found with code:"
							+ broker.getName());
				}

				if (brokerDb != null
						&& (broker.isNew() || brokerDb.getBrokerId() != broker
								.getBrokerId()))
					alreadyExists = true;
			} catch (Exception e) {
				logger.info("Broker not exists, adding...");
			}
		} else if (!valid) {
			String invalid = invalidFields.substring(0,
					invalidFields.length() - 1);
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale,
					"it.acsoftware.brokerportlet.validationError")
					+ " " + invalid);
		} else if (valid && alreadyExists) {
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale, "it.acsoftware.brokerportlet.alreadyExists")
					+ " " + invalidFields.toString());
		}
	}

	public void startupBrokerServices(long companyId) {
		try {
			List<Broker> brokers = brokerPersistence.findByCompany(companyId);
			for (int i = 0; i < brokers.size(); i++) {
				try {
					Broker b = brokers.get(i);
					BrokersManagerLocalServiceUtil
							.addBrokerServiceDefinition(b, true);
					if (b.getStartAtStartup()) {
						BrokersManagerLocalServiceUtil.startServer(
								b.getBrokerId());
					}
				} catch (Exception e) {
					logger.error(e);
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public List<Broker> findByCompanyId(long companyId) {
		try {
			return brokerPersistence.findByCompany(companyId);
		} catch (Exception e) {
			logger.error(e);
			return new ArrayList<Broker>();
		}
	}

	public Broker findByName(long companyId, String name) {
		try {
			return brokerPersistence.findByName(companyId, name);
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
}
