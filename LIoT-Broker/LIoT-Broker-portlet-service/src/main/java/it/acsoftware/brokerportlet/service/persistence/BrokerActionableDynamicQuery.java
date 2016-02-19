package it.acsoftware.brokerportlet.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BrokerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public BrokerActionableDynamicQuery() throws SystemException {
        setBaseLocalService(BrokerLocalServiceUtil.getService());
        setClass(Broker.class);

        setClassLoader(it.acsoftware.brokerportlet.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("brokerId");
    }
}
