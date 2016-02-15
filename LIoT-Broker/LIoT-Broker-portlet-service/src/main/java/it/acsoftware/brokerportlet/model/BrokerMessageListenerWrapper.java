package it.acsoftware.brokerportlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BrokerMessageListener}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrokerMessageListener
 * @generated
 */
public class BrokerMessageListenerWrapper implements BrokerMessageListener,
    ModelWrapper<BrokerMessageListener> {
    private BrokerMessageListener _brokerMessageListener;

    public BrokerMessageListenerWrapper(
        BrokerMessageListener brokerMessageListener) {
        _brokerMessageListener = brokerMessageListener;
    }

    @Override
    public Class<?> getModelClass() {
        return BrokerMessageListener.class;
    }

    @Override
    public String getModelClassName() {
        return BrokerMessageListener.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("brokerMessageListenerId", getBrokerMessageListenerId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("brokerId", getBrokerId());
        attributes.put("topics", getTopics());
        attributes.put("type", getType());
        attributes.put("messageBusDestination", getMessageBusDestination());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long brokerMessageListenerId = (Long) attributes.get(
                "brokerMessageListenerId");

        if (brokerMessageListenerId != null) {
            setBrokerMessageListenerId(brokerMessageListenerId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long brokerId = (Long) attributes.get("brokerId");

        if (brokerId != null) {
            setBrokerId(brokerId);
        }

        String topics = (String) attributes.get("topics");

        if (topics != null) {
            setTopics(topics);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String messageBusDestination = (String) attributes.get(
                "messageBusDestination");

        if (messageBusDestination != null) {
            setMessageBusDestination(messageBusDestination);
        }
    }

    /**
    * Returns the primary key of this broker message listener.
    *
    * @return the primary key of this broker message listener
    */
    @Override
    public long getPrimaryKey() {
        return _brokerMessageListener.getPrimaryKey();
    }

    /**
    * Sets the primary key of this broker message listener.
    *
    * @param primaryKey the primary key of this broker message listener
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _brokerMessageListener.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the broker message listener ID of this broker message listener.
    *
    * @return the broker message listener ID of this broker message listener
    */
    @Override
    public long getBrokerMessageListenerId() {
        return _brokerMessageListener.getBrokerMessageListenerId();
    }

    /**
    * Sets the broker message listener ID of this broker message listener.
    *
    * @param brokerMessageListenerId the broker message listener ID of this broker message listener
    */
    @Override
    public void setBrokerMessageListenerId(long brokerMessageListenerId) {
        _brokerMessageListener.setBrokerMessageListenerId(brokerMessageListenerId);
    }

    /**
    * Returns the group ID of this broker message listener.
    *
    * @return the group ID of this broker message listener
    */
    @Override
    public long getGroupId() {
        return _brokerMessageListener.getGroupId();
    }

    /**
    * Sets the group ID of this broker message listener.
    *
    * @param groupId the group ID of this broker message listener
    */
    @Override
    public void setGroupId(long groupId) {
        _brokerMessageListener.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this broker message listener.
    *
    * @return the company ID of this broker message listener
    */
    @Override
    public long getCompanyId() {
        return _brokerMessageListener.getCompanyId();
    }

    /**
    * Sets the company ID of this broker message listener.
    *
    * @param companyId the company ID of this broker message listener
    */
    @Override
    public void setCompanyId(long companyId) {
        _brokerMessageListener.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this broker message listener.
    *
    * @return the user ID of this broker message listener
    */
    @Override
    public long getUserId() {
        return _brokerMessageListener.getUserId();
    }

    /**
    * Sets the user ID of this broker message listener.
    *
    * @param userId the user ID of this broker message listener
    */
    @Override
    public void setUserId(long userId) {
        _brokerMessageListener.setUserId(userId);
    }

    /**
    * Returns the user uuid of this broker message listener.
    *
    * @return the user uuid of this broker message listener
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListener.getUserUuid();
    }

    /**
    * Sets the user uuid of this broker message listener.
    *
    * @param userUuid the user uuid of this broker message listener
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _brokerMessageListener.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this broker message listener.
    *
    * @return the user name of this broker message listener
    */
    @Override
    public java.lang.String getUserName() {
        return _brokerMessageListener.getUserName();
    }

    /**
    * Sets the user name of this broker message listener.
    *
    * @param userName the user name of this broker message listener
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _brokerMessageListener.setUserName(userName);
    }

    /**
    * Returns the create date of this broker message listener.
    *
    * @return the create date of this broker message listener
    */
    @Override
    public java.util.Date getCreateDate() {
        return _brokerMessageListener.getCreateDate();
    }

    /**
    * Sets the create date of this broker message listener.
    *
    * @param createDate the create date of this broker message listener
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _brokerMessageListener.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this broker message listener.
    *
    * @return the modified date of this broker message listener
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _brokerMessageListener.getModifiedDate();
    }

    /**
    * Sets the modified date of this broker message listener.
    *
    * @param modifiedDate the modified date of this broker message listener
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _brokerMessageListener.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this broker message listener.
    *
    * @return the name of this broker message listener
    */
    @Override
    public java.lang.String getName() {
        return _brokerMessageListener.getName();
    }

    /**
    * Sets the name of this broker message listener.
    *
    * @param name the name of this broker message listener
    */
    @Override
    public void setName(java.lang.String name) {
        _brokerMessageListener.setName(name);
    }

    /**
    * Returns the description of this broker message listener.
    *
    * @return the description of this broker message listener
    */
    @Override
    public java.lang.String getDescription() {
        return _brokerMessageListener.getDescription();
    }

    /**
    * Sets the description of this broker message listener.
    *
    * @param description the description of this broker message listener
    */
    @Override
    public void setDescription(java.lang.String description) {
        _brokerMessageListener.setDescription(description);
    }

    /**
    * Returns the broker ID of this broker message listener.
    *
    * @return the broker ID of this broker message listener
    */
    @Override
    public long getBrokerId() {
        return _brokerMessageListener.getBrokerId();
    }

    /**
    * Sets the broker ID of this broker message listener.
    *
    * @param brokerId the broker ID of this broker message listener
    */
    @Override
    public void setBrokerId(long brokerId) {
        _brokerMessageListener.setBrokerId(brokerId);
    }

    /**
    * Returns the topics of this broker message listener.
    *
    * @return the topics of this broker message listener
    */
    @Override
    public java.lang.String getTopics() {
        return _brokerMessageListener.getTopics();
    }

    /**
    * Sets the topics of this broker message listener.
    *
    * @param topics the topics of this broker message listener
    */
    @Override
    public void setTopics(java.lang.String topics) {
        _brokerMessageListener.setTopics(topics);
    }

    /**
    * Returns the type of this broker message listener.
    *
    * @return the type of this broker message listener
    */
    @Override
    public java.lang.String getType() {
        return _brokerMessageListener.getType();
    }

    /**
    * Sets the type of this broker message listener.
    *
    * @param type the type of this broker message listener
    */
    @Override
    public void setType(java.lang.String type) {
        _brokerMessageListener.setType(type);
    }

    /**
    * Returns the message bus destination of this broker message listener.
    *
    * @return the message bus destination of this broker message listener
    */
    @Override
    public java.lang.String getMessageBusDestination() {
        return _brokerMessageListener.getMessageBusDestination();
    }

    /**
    * Sets the message bus destination of this broker message listener.
    *
    * @param messageBusDestination the message bus destination of this broker message listener
    */
    @Override
    public void setMessageBusDestination(java.lang.String messageBusDestination) {
        _brokerMessageListener.setMessageBusDestination(messageBusDestination);
    }

    @Override
    public boolean isNew() {
        return _brokerMessageListener.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _brokerMessageListener.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _brokerMessageListener.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _brokerMessageListener.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _brokerMessageListener.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _brokerMessageListener.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _brokerMessageListener.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _brokerMessageListener.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _brokerMessageListener.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _brokerMessageListener.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _brokerMessageListener.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BrokerMessageListenerWrapper((BrokerMessageListener) _brokerMessageListener.clone());
    }

    @Override
    public int compareTo(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener) {
        return _brokerMessageListener.compareTo(brokerMessageListener);
    }

    @Override
    public int hashCode() {
        return _brokerMessageListener.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.acsoftware.brokerportlet.model.BrokerMessageListener> toCacheModel() {
        return _brokerMessageListener.toCacheModel();
    }

    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener toEscapedModel() {
        return new BrokerMessageListenerWrapper(_brokerMessageListener.toEscapedModel());
    }

    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener toUnescapedModel() {
        return new BrokerMessageListenerWrapper(_brokerMessageListener.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _brokerMessageListener.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _brokerMessageListener.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _brokerMessageListener.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BrokerMessageListenerWrapper)) {
            return false;
        }

        BrokerMessageListenerWrapper brokerMessageListenerWrapper = (BrokerMessageListenerWrapper) obj;

        if (Validator.equals(_brokerMessageListener,
                    brokerMessageListenerWrapper._brokerMessageListener)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public BrokerMessageListener getWrappedBrokerMessageListener() {
        return _brokerMessageListener;
    }

    @Override
    public BrokerMessageListener getWrappedModel() {
        return _brokerMessageListener;
    }

    @Override
    public void resetOriginalValues() {
        _brokerMessageListener.resetOriginalValues();
    }
}
