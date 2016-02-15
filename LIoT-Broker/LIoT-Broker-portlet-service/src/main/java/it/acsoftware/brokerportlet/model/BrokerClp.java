package it.acsoftware.brokerportlet.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BrokerClp extends BaseModelImpl<Broker> implements Broker {
    private long _brokerId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _protocol;
    private String _url;
    private String _port;
    private String _description;
    private String _type;
    private String _connectionUsername;
    private String _connectionPassword;
    private String _topics;
    private String _customProps;
    private Boolean _sslEnabled;
    private String _sslSecret;
    private String _sslCertificateUUid;
    private Boolean _startAtStartup;
    private String _mqttClientId;
    private int _mqttQos;
    private Boolean _mqttCleanSession;
    private String _kafkaZookeeperHost;
    private int _kafkaThreadsPerTopic;
    private String _kafkaGroupId;
    private BaseModel<?> _brokerRemoteModel;
    private Class<?> _clpSerializerClass = it.acsoftware.brokerportlet.service.ClpSerializer.class;

    public BrokerClp() {
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
    public long getPrimaryKey() {
        return _brokerId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setBrokerId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _brokerId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getBrokerId() {
        return _brokerId;
    }

    @Override
    public void setBrokerId(long brokerId) {
        _brokerId = brokerId;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setBrokerId", long.class);

                method.invoke(_brokerRemoteModel, brokerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_brokerRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_brokerRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_brokerRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_brokerRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_brokerRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_brokerRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_brokerRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProtocol() {
        return _protocol;
    }

    @Override
    public void setProtocol(String protocol) {
        _protocol = protocol;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setProtocol", String.class);

                method.invoke(_brokerRemoteModel, protocol);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUrl() {
        return _url;
    }

    @Override
    public void setUrl(String url) {
        _url = url;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setUrl", String.class);

                method.invoke(_brokerRemoteModel, url);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPort() {
        return _port;
    }

    @Override
    public void setPort(String port) {
        _port = port;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setPort", String.class);

                method.invoke(_brokerRemoteModel, port);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_brokerRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public void setType(String type) {
        _type = type;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setType", String.class);

                method.invoke(_brokerRemoteModel, type);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getConnectionUsername() {
        return _connectionUsername;
    }

    @Override
    public void setConnectionUsername(String connectionUsername) {
        _connectionUsername = connectionUsername;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setConnectionUsername",
                        String.class);

                method.invoke(_brokerRemoteModel, connectionUsername);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getConnectionPassword() {
        return _connectionPassword;
    }

    @Override
    public void setConnectionPassword(String connectionPassword) {
        _connectionPassword = connectionPassword;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setConnectionPassword",
                        String.class);

                method.invoke(_brokerRemoteModel, connectionPassword);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTopics() {
        return _topics;
    }

    @Override
    public void setTopics(String topics) {
        _topics = topics;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setTopics", String.class);

                method.invoke(_brokerRemoteModel, topics);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCustomProps() {
        return _customProps;
    }

    @Override
    public void setCustomProps(String customProps) {
        _customProps = customProps;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setCustomProps", String.class);

                method.invoke(_brokerRemoteModel, customProps);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getSslEnabled() {
        return _sslEnabled;
    }

    @Override
    public void setSslEnabled(Boolean sslEnabled) {
        _sslEnabled = sslEnabled;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setSslEnabled", Boolean.class);

                method.invoke(_brokerRemoteModel, sslEnabled);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSslSecret() {
        return _sslSecret;
    }

    @Override
    public void setSslSecret(String sslSecret) {
        _sslSecret = sslSecret;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setSslSecret", String.class);

                method.invoke(_brokerRemoteModel, sslSecret);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSslCertificateUUid() {
        return _sslCertificateUUid;
    }

    @Override
    public void setSslCertificateUUid(String sslCertificateUUid) {
        _sslCertificateUUid = sslCertificateUUid;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setSslCertificateUUid",
                        String.class);

                method.invoke(_brokerRemoteModel, sslCertificateUUid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getStartAtStartup() {
        return _startAtStartup;
    }

    @Override
    public void setStartAtStartup(Boolean startAtStartup) {
        _startAtStartup = startAtStartup;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setStartAtStartup",
                        Boolean.class);

                method.invoke(_brokerRemoteModel, startAtStartup);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMqttClientId() {
        return _mqttClientId;
    }

    @Override
    public void setMqttClientId(String mqttClientId) {
        _mqttClientId = mqttClientId;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setMqttClientId", String.class);

                method.invoke(_brokerRemoteModel, mqttClientId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getMqttQos() {
        return _mqttQos;
    }

    @Override
    public void setMqttQos(int mqttQos) {
        _mqttQos = mqttQos;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setMqttQos", int.class);

                method.invoke(_brokerRemoteModel, mqttQos);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getMqttCleanSession() {
        return _mqttCleanSession;
    }

    @Override
    public void setMqttCleanSession(Boolean mqttCleanSession) {
        _mqttCleanSession = mqttCleanSession;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setMqttCleanSession",
                        Boolean.class);

                method.invoke(_brokerRemoteModel, mqttCleanSession);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKafkaZookeeperHost() {
        return _kafkaZookeeperHost;
    }

    @Override
    public void setKafkaZookeeperHost(String kafkaZookeeperHost) {
        _kafkaZookeeperHost = kafkaZookeeperHost;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setKafkaZookeeperHost",
                        String.class);

                method.invoke(_brokerRemoteModel, kafkaZookeeperHost);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKafkaThreadsPerTopic() {
        return _kafkaThreadsPerTopic;
    }

    @Override
    public void setKafkaThreadsPerTopic(int kafkaThreadsPerTopic) {
        _kafkaThreadsPerTopic = kafkaThreadsPerTopic;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setKafkaThreadsPerTopic",
                        int.class);

                method.invoke(_brokerRemoteModel, kafkaThreadsPerTopic);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKafkaGroupId() {
        return _kafkaGroupId;
    }

    @Override
    public void setKafkaGroupId(String kafkaGroupId) {
        _kafkaGroupId = kafkaGroupId;

        if (_brokerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerRemoteModel.getClass();

                Method method = clazz.getMethod("setKafkaGroupId", String.class);

                method.invoke(_brokerRemoteModel, kafkaGroupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getBrokerRemoteModel() {
        return _brokerRemoteModel;
    }

    public void setBrokerRemoteModel(BaseModel<?> brokerRemoteModel) {
        _brokerRemoteModel = brokerRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _brokerRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_brokerRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BrokerLocalServiceUtil.addBroker(this);
        } else {
            BrokerLocalServiceUtil.updateBroker(this);
        }
    }

    @Override
    public Broker toEscapedModel() {
        return (Broker) ProxyUtil.newProxyInstance(Broker.class.getClassLoader(),
            new Class[] { Broker.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BrokerClp clone = new BrokerClp();

        clone.setBrokerId(getBrokerId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setProtocol(getProtocol());
        clone.setUrl(getUrl());
        clone.setPort(getPort());
        clone.setDescription(getDescription());
        clone.setType(getType());
        clone.setConnectionUsername(getConnectionUsername());
        clone.setConnectionPassword(getConnectionPassword());
        clone.setTopics(getTopics());
        clone.setCustomProps(getCustomProps());
        clone.setSslEnabled(getSslEnabled());
        clone.setSslSecret(getSslSecret());
        clone.setSslCertificateUUid(getSslCertificateUUid());
        clone.setStartAtStartup(getStartAtStartup());
        clone.setMqttClientId(getMqttClientId());
        clone.setMqttQos(getMqttQos());
        clone.setMqttCleanSession(getMqttCleanSession());
        clone.setKafkaZookeeperHost(getKafkaZookeeperHost());
        clone.setKafkaThreadsPerTopic(getKafkaThreadsPerTopic());
        clone.setKafkaGroupId(getKafkaGroupId());

        return clone;
    }

    @Override
    public int compareTo(Broker broker) {
        int value = 0;

        value = getName().compareTo(broker.getName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BrokerClp)) {
            return false;
        }

        BrokerClp broker = (BrokerClp) obj;

        long primaryKey = broker.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(55);

        sb.append("{brokerId=");
        sb.append(getBrokerId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", protocol=");
        sb.append(getProtocol());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", port=");
        sb.append(getPort());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", connectionUsername=");
        sb.append(getConnectionUsername());
        sb.append(", connectionPassword=");
        sb.append(getConnectionPassword());
        sb.append(", topics=");
        sb.append(getTopics());
        sb.append(", customProps=");
        sb.append(getCustomProps());
        sb.append(", sslEnabled=");
        sb.append(getSslEnabled());
        sb.append(", sslSecret=");
        sb.append(getSslSecret());
        sb.append(", sslCertificateUUid=");
        sb.append(getSslCertificateUUid());
        sb.append(", startAtStartup=");
        sb.append(getStartAtStartup());
        sb.append(", mqttClientId=");
        sb.append(getMqttClientId());
        sb.append(", mqttQos=");
        sb.append(getMqttQos());
        sb.append(", mqttCleanSession=");
        sb.append(getMqttCleanSession());
        sb.append(", kafkaZookeeperHost=");
        sb.append(getKafkaZookeeperHost());
        sb.append(", kafkaThreadsPerTopic=");
        sb.append(getKafkaThreadsPerTopic());
        sb.append(", kafkaGroupId=");
        sb.append(getKafkaGroupId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(85);

        sb.append("<model><model-name>");
        sb.append("it.acsoftware.brokerportlet.model.Broker");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>brokerId</column-name><column-value><![CDATA[");
        sb.append(getBrokerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>protocol</column-name><column-value><![CDATA[");
        sb.append(getProtocol());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url</column-name><column-value><![CDATA[");
        sb.append(getUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>port</column-name><column-value><![CDATA[");
        sb.append(getPort());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>connectionUsername</column-name><column-value><![CDATA[");
        sb.append(getConnectionUsername());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>connectionPassword</column-name><column-value><![CDATA[");
        sb.append(getConnectionPassword());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>topics</column-name><column-value><![CDATA[");
        sb.append(getTopics());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>customProps</column-name><column-value><![CDATA[");
        sb.append(getCustomProps());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sslEnabled</column-name><column-value><![CDATA[");
        sb.append(getSslEnabled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sslSecret</column-name><column-value><![CDATA[");
        sb.append(getSslSecret());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sslCertificateUUid</column-name><column-value><![CDATA[");
        sb.append(getSslCertificateUUid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startAtStartup</column-name><column-value><![CDATA[");
        sb.append(getStartAtStartup());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mqttClientId</column-name><column-value><![CDATA[");
        sb.append(getMqttClientId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mqttQos</column-name><column-value><![CDATA[");
        sb.append(getMqttQos());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mqttCleanSession</column-name><column-value><![CDATA[");
        sb.append(getMqttCleanSession());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kafkaZookeeperHost</column-name><column-value><![CDATA[");
        sb.append(getKafkaZookeeperHost());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kafkaThreadsPerTopic</column-name><column-value><![CDATA[");
        sb.append(getKafkaThreadsPerTopic());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kafkaGroupId</column-name><column-value><![CDATA[");
        sb.append(getKafkaGroupId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
