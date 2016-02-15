package it.acsoftware.brokerportlet.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.acsoftware.brokerportlet.model.BrokerMessageListener;
import it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BrokerMessageListenerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public BrokerMessageListenerActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(BrokerMessageListenerLocalServiceUtil.getService());
        setClass(BrokerMessageListener.class);

        setClassLoader(it.acsoftware.brokerportlet.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("brokerMessageListenerId");
    }
}
