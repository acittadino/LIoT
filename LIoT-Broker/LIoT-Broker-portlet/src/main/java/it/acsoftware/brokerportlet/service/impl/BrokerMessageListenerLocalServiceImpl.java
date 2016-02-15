package it.acsoftware.brokerportlet.service.impl;

import it.acsoftware.brokerportlet.BeanValidationException;
import it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;
import it.acsoftware.brokerportlet.model.BrokerMessageListener;
import it.acsoftware.brokerportlet.service.base.BrokerMessageListenerLocalServiceBaseImpl;

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
 * The implementation of the broker message listener local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.brokerportlet.service.base.BrokerMessageListenerLocalServiceBaseImpl
 * @see it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil
 */
public class BrokerMessageListenerLocalServiceImpl extends
		BrokerMessageListenerLocalServiceBaseImpl {
	private static Log logger = LogFactoryUtil
			.getLog(BrokerMessageListenerLocalServiceImpl.class);

	public BrokerMessageListener saveOrUpdateBrokerMessageListener(
			BrokerMessageListener bml, Locale currentLocale,
			PortletConfig config) throws SystemException,
			BeanValidationException {
		check(bml, currentLocale, config);
		boolean isNew = bml.isNew();
		bml = brokerMessageListenerPersistence.update(bml);

		if (isNew && bml != null) {
			try {
				Group g = GroupLocalServiceUtil.getCompanyGroup(bml
						.getCompanyId());
				ResourceLocalServiceUtil.addResources(bml.getCompanyId(),
						g.getGroupId(), bml.getUserId(),
						BrokerMessageListener.class.getName(),
						bml.getBrokerMessageListenerId(), false, true, false);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		return bml;
	}

	private void check(BrokerMessageListener bml, Locale currentLocale,
			PortletConfig config) throws BeanValidationException {
		if (Validator.isNull(bml))
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale,
					"it.acsoftware.brokerportlet.validationBeanNull"));

		boolean valid = true;
		boolean alreadyExists = false;

		StringBuilder invalidFields = new StringBuilder();

		if (Validator.isNull(bml.getName())) {
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.brokerportlet.label.broker.name"))
					.append(",");
		}

		if (Validator.isNull(bml.getTopics())) {
			valid = false;
			invalidFields
					.append(LanguageUtil
							.get(config, currentLocale,
									"it.acsoftware.brokerportlet.label.brokerMessageListener.topics"))
					.append(",");
		}

		if (Validator.isNull(bml.getBrokerId())) {
			valid = false;
			invalidFields
					.append(LanguageUtil
							.get(config, currentLocale,
									"it.acsoftware.brokerportlet.label.brokerMessageListener.broker"))
					.append(",");
		}

		if (valid) {
			try {
				BrokerMessageListener bmlDb = null;
				try {
					bmlDb = brokerMessageListenerPersistence.findByName(
							bml.getCompanyId(), bml.getName());
					invalidFields.append(LanguageUtil.get(config,
							currentLocale,
							"it.acsoftware.brokerportlet.label.broker.name"));
				} catch (NoSuchBrokerMessageListenerException e) {
					logger.debug("no broker found with name:" + bml.getName());
				}

				if (bmlDb != null
						&& (bml.isNew() || bmlDb.getBrokerId() != bml
								.getBrokerId()))
					alreadyExists = true;
			} catch (Exception e) {
				logger.info("Broker Message Listener not exists, adding...");
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

	public List<BrokerMessageListener> findByCompany(long companyId) {
		try {
			return brokerMessageListenerPersistence.findByCompany(companyId);
		} catch (Exception e) {
			return new ArrayList<BrokerMessageListener>();
		}
	}

	public List<BrokerMessageListener> findByBrokerId(long brokerId) {
		try {
			return brokerMessageListenerPersistence.findByBrokerId(brokerId);
		} catch (Exception e) {
			return new ArrayList<BrokerMessageListener>();
		}
	}
}
