package it.acsoftware.brokerportlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Broker}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Broker
 * @generated
 */
public class BrokerWrapper implements Broker, ModelWrapper<Broker> {
    private Broker _broker;

    public BrokerWrapper(Broker broker) {
        _broker = broker;
    }

    @Override
    public Class<?> getModelClass() {
        return Broker.class;
    }

    @Override
    public String getModelClassName() {
        return Broker.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("brokerId", getBrokerId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("protocol", getProtocol());
        attributes.put("url", getUrl());
        attributes.put("port", getPort());
        attributes.put("description", getDescription());
        attributes.put("type", getType());
        attributes.put("connectionUsername", getConnectionUsername());
        attributes.put("connectionPassword", getConnectionPassword());
        attributes.put("topics", getTopics());
        attributes.put("customProps", getCustomProps());
        attributes.put("sslEnabled", getSslEnabled());
        attributes.put("sslSecret", getSslSecret());
        attributes.put("sslCertificateUUid", getSslCertificateUUid());
        attributes.put("startAtStartup", getStartAtStartup());
        attributes.put("mqttClientId", getMqttClientId());
        attributes.put("mqttQos", getMqttQos());
        attributes.put("mqttCleanSession", getMqttCleanSession());
        attributes.put("kafkaZookeeperHost", getKafkaZookeeperHost());
        attributes.put("kafkaThreadsPerTopic", getKafkaThreadsPerTopic());
        attributes.put("kafkaGroupId", getKafkaGroupId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long brokerId = (Long) attributes.get("brokerId");

        if (brokerId != null) {
            setBrokerId(brokerId);
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

        String protocol = (String) attributes.get("protocol");

        if (protocol != null) {
            setProtocol(protocol);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String port = (String) attributes.get("port");

        if (port != null) {
            setPort(port);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String connectionUsername = (String) attributes.get(
                "connectionUsername");

        if (connectionUsername != null) {
            setConnectionUsername(connectionUsername);
        }

        String connectionPassword = (String) attributes.get(
                "connectionPassword");

        if (connectionPassword != null) {
            setConnectionPassword(connectionPassword);
        }

        String topics = (String) attributes.get("topics");

        if (topics != null) {
            setTopics(topics);
        }

        String customProps = (String) attributes.get("customProps");

        if (customProps != null) {
            setCustomProps(customProps);
        }

        Boolean sslEnabled = (Boolean) attributes.get("sslEnabled");

        if (sslEnabled != null) {
            setSslEnabled(sslEnabled);
        }

        String sslSecret = (String) attributes.get("sslSecret");

        if (sslSecret != null) {
            setSslSecret(sslSecret);
        }

        String sslCertificateUUid = (String) attributes.get(
                "sslCertificateUUid");

        if (sslCertificateUUid != null) {
            setSslCertificateUUid(sslCertificateUUid);
        }

        Boolean startAtStartup = (Boolean) attributes.get("startAtStartup");

        if (startAtStartup != null) {
            setStartAtStartup(startAtStartup);
        }

        String mqttClientId = (String) attributes.get("mqttClientId");

        if (mqttClientId != null) {
            setMqttClientId(mqttClientId);
        }

        Integer mqttQos = (Integer) attributes.get("mqttQos");

        if (mqttQos != null) {
            setMqttQos(mqttQos);
        }

        Boolean mqttCleanSession = (Boolean) attributes.get("mqttCleanSession");

        if (mqttCleanSession != null) {
            setMqttCleanSession(mqttCleanSession);
        }

        String kafkaZookeeperHost = (String) attributes.get(
                "kafkaZookeeperHost");

        if (kafkaZookeeperHost != null) {
            setKafkaZookeeperHost(kafkaZookeeperHost);
        }

        Integer kafkaThreadsPerTopic = (Integer) attributes.get(
                "kafkaThreadsPerTopic");

        if (kafkaThreadsPerTopic != null) {
            setKafkaThreadsPerTopic(kafkaThreadsPerTopic);
        }

        String kafkaGroupId = (String) attributes.get("kafkaGroupId");

        if (kafkaGroupId != null) {
            setKafkaGroupId(kafkaGroupId);
        }
    }

    /**
    * Returns the primary key of this broker.
    *
    * @return the primary key of this broker
    */
    @Override
    public long getPrimaryKey() {
        return _broker.getPrimaryKey();
    }

    /**
    * Sets the primary key of this broker.
    *
    * @param primaryKey the primary key of this broker
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _broker.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the broker ID of this broker.
    *
    * @return the broker ID of this broker
    */
    @Override
    public long getBrokerId() {
        return _broker.getBrokerId();
    }

    /**
    * Sets the broker ID of this broker.
    *
    * @param brokerId the broker ID of this broker
    */
    @Override
    public void setBrokerId(long brokerId) {
        _broker.setBrokerId(brokerId);
    }

    /**
    * Returns the group ID of this broker.
    *
    * @return the group ID of this broker
    */
    @Override
    public long getGroupId() {
        return _broker.getGroupId();
    }

    /**
    * Sets the group ID of this broker.
    *
    * @param groupId the group ID of this broker
    */
    @Override
    public void setGroupId(long groupId) {
        _broker.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this broker.
    *
    * @return the company ID of this broker
    */
    @Override
    public long getCompanyId() {
        return _broker.getCompanyId();
    }

    /**
    * Sets the company ID of this broker.
    *
    * @param companyId the company ID of this broker
    */
    @Override
    public void setCompanyId(long companyId) {
        _broker.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this broker.
    *
    * @return the user ID of this broker
    */
    @Override
    public long getUserId() {
        return _broker.getUserId();
    }

    /**
    * Sets the user ID of this broker.
    *
    * @param userId the user ID of this broker
    */
    @Override
    public void setUserId(long userId) {
        _broker.setUserId(userId);
    }

    /**
    * Returns the user uuid of this broker.
    *
    * @return the user uuid of this broker
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _broker.getUserUuid();
    }

    /**
    * Sets the user uuid of this broker.
    *
    * @param userUuid the user uuid of this broker
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _broker.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this broker.
    *
    * @return the user name of this broker
    */
    @Override
    public java.lang.String getUserName() {
        return _broker.getUserName();
    }

    /**
    * Sets the user name of this broker.
    *
    * @param userName the user name of this broker
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _broker.setUserName(userName);
    }

    /**
    * Returns the create date of this broker.
    *
    * @return the create date of this broker
    */
    @Override
    public java.util.Date getCreateDate() {
        return _broker.getCreateDate();
    }

    /**
    * Sets the create date of this broker.
    *
    * @param createDate the create date of this broker
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _broker.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this broker.
    *
    * @return the modified date of this broker
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _broker.getModifiedDate();
    }

    /**
    * Sets the modified date of this broker.
    *
    * @param modifiedDate the modified date of this broker
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _broker.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this broker.
    *
    * @return the name of this broker
    */
    @Override
    public java.lang.String getName() {
        return _broker.getName();
    }

    /**
    * Sets the name of this broker.
    *
    * @param name the name of this broker
    */
    @Override
    public void setName(java.lang.String name) {
        _broker.setName(name);
    }

    /**
    * Returns the protocol of this broker.
    *
    * @return the protocol of this broker
    */
    @Override
    public java.lang.String getProtocol() {
        return _broker.getProtocol();
    }

    /**
    * Sets the protocol of this broker.
    *
    * @param protocol the protocol of this broker
    */
    @Override
    public void setProtocol(java.lang.String protocol) {
        _broker.setProtocol(protocol);
    }

    /**
    * Returns the url of this broker.
    *
    * @return the url of this broker
    */
    @Override
    public java.lang.String getUrl() {
        return _broker.getUrl();
    }

    /**
    * Sets the url of this broker.
    *
    * @param url the url of this broker
    */
    @Override
    public void setUrl(java.lang.String url) {
        _broker.setUrl(url);
    }

    /**
    * Returns the port of this broker.
    *
    * @return the port of this broker
    */
    @Override
    public java.lang.String getPort() {
        return _broker.getPort();
    }

    /**
    * Sets the port of this broker.
    *
    * @param port the port of this broker
    */
    @Override
    public void setPort(java.lang.String port) {
        _broker.setPort(port);
    }

    /**
    * Returns the description of this broker.
    *
    * @return the description of this broker
    */
    @Override
    public java.lang.String getDescription() {
        return _broker.getDescription();
    }

    /**
    * Sets the description of this broker.
    *
    * @param description the description of this broker
    */
    @Override
    public void setDescription(java.lang.String description) {
        _broker.setDescription(description);
    }

    /**
    * Returns the type of this broker.
    *
    * @return the type of this broker
    */
    @Override
    public java.lang.String getType() {
        return _broker.getType();
    }

    /**
    * Sets the type of this broker.
    *
    * @param type the type of this broker
    */
    @Override
    public void setType(java.lang.String type) {
        _broker.setType(type);
    }

    /**
    * Returns the connection username of this broker.
    *
    * @return the connection username of this broker
    */
    @Override
    public java.lang.String getConnectionUsername() {
        return _broker.getConnectionUsername();
    }

    /**
    * Sets the connection username of this broker.
    *
    * @param connectionUsername the connection username of this broker
    */
    @Override
    public void setConnectionUsername(java.lang.String connectionUsername) {
        _broker.setConnectionUsername(connectionUsername);
    }

    /**
    * Returns the connection password of this broker.
    *
    * @return the connection password of this broker
    */
    @Override
    public java.lang.String getConnectionPassword() {
        return _broker.getConnectionPassword();
    }

    /**
    * Sets the connection password of this broker.
    *
    * @param connectionPassword the connection password of this broker
    */
    @Override
    public void setConnectionPassword(java.lang.String connectionPassword) {
        _broker.setConnectionPassword(connectionPassword);
    }

    /**
    * Returns the topics of this broker.
    *
    * @return the topics of this broker
    */
    @Override
    public java.lang.String getTopics() {
        return _broker.getTopics();
    }

    /**
    * Sets the topics of this broker.
    *
    * @param topics the topics of this broker
    */
    @Override
    public void setTopics(java.lang.String topics) {
        _broker.setTopics(topics);
    }

    /**
    * Returns the custom props of this broker.
    *
    * @return the custom props of this broker
    */
    @Override
    public java.lang.String getCustomProps() {
        return _broker.getCustomProps();
    }

    /**
    * Sets the custom props of this broker.
    *
    * @param customProps the custom props of this broker
    */
    @Override
    public void setCustomProps(java.lang.String customProps) {
        _broker.setCustomProps(customProps);
    }

    /**
    * Returns the ssl enabled of this broker.
    *
    * @return the ssl enabled of this broker
    */
    @Override
    public java.lang.Boolean getSslEnabled() {
        return _broker.getSslEnabled();
    }

    /**
    * Sets the ssl enabled of this broker.
    *
    * @param sslEnabled the ssl enabled of this broker
    */
    @Override
    public void setSslEnabled(java.lang.Boolean sslEnabled) {
        _broker.setSslEnabled(sslEnabled);
    }

    /**
    * Returns the ssl secret of this broker.
    *
    * @return the ssl secret of this broker
    */
    @Override
    public java.lang.String getSslSecret() {
        return _broker.getSslSecret();
    }

    /**
    * Sets the ssl secret of this broker.
    *
    * @param sslSecret the ssl secret of this broker
    */
    @Override
    public void setSslSecret(java.lang.String sslSecret) {
        _broker.setSslSecret(sslSecret);
    }

    /**
    * Returns the ssl certificate u uid of this broker.
    *
    * @return the ssl certificate u uid of this broker
    */
    @Override
    public java.lang.String getSslCertificateUUid() {
        return _broker.getSslCertificateUUid();
    }

    /**
    * Sets the ssl certificate u uid of this broker.
    *
    * @param sslCertificateUUid the ssl certificate u uid of this broker
    */
    @Override
    public void setSslCertificateUUid(java.lang.String sslCertificateUUid) {
        _broker.setSslCertificateUUid(sslCertificateUUid);
    }

    /**
    * Returns the start at startup of this broker.
    *
    * @return the start at startup of this broker
    */
    @Override
    public java.lang.Boolean getStartAtStartup() {
        return _broker.getStartAtStartup();
    }

    /**
    * Sets the start at startup of this broker.
    *
    * @param startAtStartup the start at startup of this broker
    */
    @Override
    public void setStartAtStartup(java.lang.Boolean startAtStartup) {
        _broker.setStartAtStartup(startAtStartup);
    }

    /**
    * Returns the mqtt client ID of this broker.
    *
    * @return the mqtt client ID of this broker
    */
    @Override
    public java.lang.String getMqttClientId() {
        return _broker.getMqttClientId();
    }

    /**
    * Sets the mqtt client ID of this broker.
    *
    * @param mqttClientId the mqtt client ID of this broker
    */
    @Override
    public void setMqttClientId(java.lang.String mqttClientId) {
        _broker.setMqttClientId(mqttClientId);
    }

    /**
    * Returns the mqtt qos of this broker.
    *
    * @return the mqtt qos of this broker
    */
    @Override
    public int getMqttQos() {
        return _broker.getMqttQos();
    }

    /**
    * Sets the mqtt qos of this broker.
    *
    * @param mqttQos the mqtt qos of this broker
    */
    @Override
    public void setMqttQos(int mqttQos) {
        _broker.setMqttQos(mqttQos);
    }

    /**
    * Returns the mqtt clean session of this broker.
    *
    * @return the mqtt clean session of this broker
    */
    @Override
    public java.lang.Boolean getMqttCleanSession() {
        return _broker.getMqttCleanSession();
    }

    /**
    * Sets the mqtt clean session of this broker.
    *
    * @param mqttCleanSession the mqtt clean session of this broker
    */
    @Override
    public void setMqttCleanSession(java.lang.Boolean mqttCleanSession) {
        _broker.setMqttCleanSession(mqttCleanSession);
    }

    /**
    * Returns the kafka zookeeper host of this broker.
    *
    * @return the kafka zookeeper host of this broker
    */
    @Override
    public java.lang.String getKafkaZookeeperHost() {
        return _broker.getKafkaZookeeperHost();
    }

    /**
    * Sets the kafka zookeeper host of this broker.
    *
    * @param kafkaZookeeperHost the kafka zookeeper host of this broker
    */
    @Override
    public void setKafkaZookeeperHost(java.lang.String kafkaZookeeperHost) {
        _broker.setKafkaZookeeperHost(kafkaZookeeperHost);
    }

    /**
    * Returns the kafka threads per topic of this broker.
    *
    * @return the kafka threads per topic of this broker
    */
    @Override
    public int getKafkaThreadsPerTopic() {
        return _broker.getKafkaThreadsPerTopic();
    }

    /**
    * Sets the kafka threads per topic of this broker.
    *
    * @param kafkaThreadsPerTopic the kafka threads per topic of this broker
    */
    @Override
    public void setKafkaThreadsPerTopic(int kafkaThreadsPerTopic) {
        _broker.setKafkaThreadsPerTopic(kafkaThreadsPerTopic);
    }

    /**
    * Returns the kafka group ID of this broker.
    *
    * @return the kafka group ID of this broker
    */
    @Override
    public java.lang.String getKafkaGroupId() {
        return _broker.getKafkaGroupId();
    }

    /**
    * Sets the kafka group ID of this broker.
    *
    * @param kafkaGroupId the kafka group ID of this broker
    */
    @Override
    public void setKafkaGroupId(java.lang.String kafkaGroupId) {
        _broker.setKafkaGroupId(kafkaGroupId);
    }

    @Override
    public boolean isNew() {
        return _broker.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _broker.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _broker.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _broker.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _broker.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _broker.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _broker.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _broker.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _broker.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _broker.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _broker.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BrokerWrapper((Broker) _broker.clone());
    }

    @Override
    public int compareTo(it.acsoftware.brokerportlet.model.Broker broker) {
        return _broker.compareTo(broker);
    }

    @Override
    public int hashCode() {
        return _broker.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.acsoftware.brokerportlet.model.Broker> toCacheModel() {
        return _broker.toCacheModel();
    }

    @Override
    public it.acsoftware.brokerportlet.model.Broker toEscapedModel() {
        return new BrokerWrapper(_broker.toEscapedModel());
    }

    @Override
    public it.acsoftware.brokerportlet.model.Broker toUnescapedModel() {
        return new BrokerWrapper(_broker.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _broker.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _broker.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _broker.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BrokerWrapper)) {
            return false;
        }

        BrokerWrapper brokerWrapper = (BrokerWrapper) obj;

        if (Validator.equals(_broker, brokerWrapper._broker)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Broker getWrappedBroker() {
        return _broker;
    }

    @Override
    public Broker getWrappedModel() {
        return _broker;
    }

    @Override
    public void resetOriginalValues() {
        _broker.resetOriginalValues();
    }
}
