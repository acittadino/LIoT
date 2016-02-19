package it.acsoftware.brokerportlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrokerSoap implements Serializable {
    private long _brokerId;
    private long _groupId;
    private long _companyId;
    private long _userId;
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

    public BrokerSoap() {
    }

    public static BrokerSoap toSoapModel(Broker model) {
        BrokerSoap soapModel = new BrokerSoap();

        soapModel.setBrokerId(model.getBrokerId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setProtocol(model.getProtocol());
        soapModel.setUrl(model.getUrl());
        soapModel.setPort(model.getPort());
        soapModel.setDescription(model.getDescription());
        soapModel.setType(model.getType());
        soapModel.setConnectionUsername(model.getConnectionUsername());
        soapModel.setConnectionPassword(model.getConnectionPassword());
        soapModel.setTopics(model.getTopics());
        soapModel.setCustomProps(model.getCustomProps());
        soapModel.setSslEnabled(model.getSslEnabled());
        soapModel.setSslSecret(model.getSslSecret());
        soapModel.setSslCertificateUUid(model.getSslCertificateUUid());
        soapModel.setStartAtStartup(model.getStartAtStartup());
        soapModel.setMqttClientId(model.getMqttClientId());
        soapModel.setMqttQos(model.getMqttQos());
        soapModel.setMqttCleanSession(model.getMqttCleanSession());
        soapModel.setKafkaZookeeperHost(model.getKafkaZookeeperHost());
        soapModel.setKafkaThreadsPerTopic(model.getKafkaThreadsPerTopic());
        soapModel.setKafkaGroupId(model.getKafkaGroupId());

        return soapModel;
    }

    public static BrokerSoap[] toSoapModels(Broker[] models) {
        BrokerSoap[] soapModels = new BrokerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BrokerSoap[][] toSoapModels(Broker[][] models) {
        BrokerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BrokerSoap[models.length][models[0].length];
        } else {
            soapModels = new BrokerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BrokerSoap[] toSoapModels(List<Broker> models) {
        List<BrokerSoap> soapModels = new ArrayList<BrokerSoap>(models.size());

        for (Broker model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BrokerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _brokerId;
    }

    public void setPrimaryKey(long pk) {
        setBrokerId(pk);
    }

    public long getBrokerId() {
        return _brokerId;
    }

    public void setBrokerId(long brokerId) {
        _brokerId = brokerId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getProtocol() {
        return _protocol;
    }

    public void setProtocol(String protocol) {
        _protocol = protocol;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getPort() {
        return _port;
    }

    public void setPort(String port) {
        _port = port;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public String getConnectionUsername() {
        return _connectionUsername;
    }

    public void setConnectionUsername(String connectionUsername) {
        _connectionUsername = connectionUsername;
    }

    public String getConnectionPassword() {
        return _connectionPassword;
    }

    public void setConnectionPassword(String connectionPassword) {
        _connectionPassword = connectionPassword;
    }

    public String getTopics() {
        return _topics;
    }

    public void setTopics(String topics) {
        _topics = topics;
    }

    public String getCustomProps() {
        return _customProps;
    }

    public void setCustomProps(String customProps) {
        _customProps = customProps;
    }

    public Boolean getSslEnabled() {
        return _sslEnabled;
    }

    public void setSslEnabled(Boolean sslEnabled) {
        _sslEnabled = sslEnabled;
    }

    public String getSslSecret() {
        return _sslSecret;
    }

    public void setSslSecret(String sslSecret) {
        _sslSecret = sslSecret;
    }

    public String getSslCertificateUUid() {
        return _sslCertificateUUid;
    }

    public void setSslCertificateUUid(String sslCertificateUUid) {
        _sslCertificateUUid = sslCertificateUUid;
    }

    public Boolean getStartAtStartup() {
        return _startAtStartup;
    }

    public void setStartAtStartup(Boolean startAtStartup) {
        _startAtStartup = startAtStartup;
    }

    public String getMqttClientId() {
        return _mqttClientId;
    }

    public void setMqttClientId(String mqttClientId) {
        _mqttClientId = mqttClientId;
    }

    public int getMqttQos() {
        return _mqttQos;
    }

    public void setMqttQos(int mqttQos) {
        _mqttQos = mqttQos;
    }

    public Boolean getMqttCleanSession() {
        return _mqttCleanSession;
    }

    public void setMqttCleanSession(Boolean mqttCleanSession) {
        _mqttCleanSession = mqttCleanSession;
    }

    public String getKafkaZookeeperHost() {
        return _kafkaZookeeperHost;
    }

    public void setKafkaZookeeperHost(String kafkaZookeeperHost) {
        _kafkaZookeeperHost = kafkaZookeeperHost;
    }

    public int getKafkaThreadsPerTopic() {
        return _kafkaThreadsPerTopic;
    }

    public void setKafkaThreadsPerTopic(int kafkaThreadsPerTopic) {
        _kafkaThreadsPerTopic = kafkaThreadsPerTopic;
    }

    public String getKafkaGroupId() {
        return _kafkaGroupId;
    }

    public void setKafkaGroupId(String kafkaGroupId) {
        _kafkaGroupId = kafkaGroupId;
    }
}
