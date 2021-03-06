package it.acsoftware.brokerportlet.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.model.BrokerModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Broker service. Represents a row in the &quot;LiOT_Broker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.acsoftware.brokerportlet.model.BrokerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BrokerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrokerImpl
 * @see it.acsoftware.brokerportlet.model.Broker
 * @see it.acsoftware.brokerportlet.model.BrokerModel
 * @generated
 */
public class BrokerModelImpl extends BaseModelImpl<Broker>
    implements BrokerModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a broker model instance should use the {@link it.acsoftware.brokerportlet.model.Broker} interface instead.
     */
    public static final String TABLE_NAME = "LiOT_Broker";
    public static final Object[][] TABLE_COLUMNS = {
            { "brokerId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "name", Types.VARCHAR },
            { "protocol", Types.VARCHAR },
            { "url", Types.VARCHAR },
            { "port", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "type_", Types.VARCHAR },
            { "connectionUsername", Types.VARCHAR },
            { "connectionPassword", Types.VARCHAR },
            { "topics", Types.VARCHAR },
            { "customProps", Types.VARCHAR },
            { "sslEnabled", Types.BOOLEAN },
            { "sslSecret", Types.VARCHAR },
            { "sslCertificateUUid", Types.VARCHAR },
            { "startAtStartup", Types.BOOLEAN },
            { "mqttClientId", Types.VARCHAR },
            { "mqttQos", Types.INTEGER },
            { "mqttCleanSession", Types.BOOLEAN },
            { "kafkaZookeeperHost", Types.VARCHAR },
            { "kafkaThreadsPerTopic", Types.INTEGER },
            { "kafkaGroupId", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table LiOT_Broker (brokerId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,protocol VARCHAR(75) null,url VARCHAR(75) null,port VARCHAR(75) null,description VARCHAR(75) null,type_ VARCHAR(75) null,connectionUsername VARCHAR(75) null,connectionPassword VARCHAR(75) null,topics VARCHAR(75) null,customProps VARCHAR(75) null,sslEnabled BOOLEAN,sslSecret VARCHAR(75) null,sslCertificateUUid VARCHAR(75) null,startAtStartup BOOLEAN,mqttClientId VARCHAR(75) null,mqttQos INTEGER,mqttCleanSession BOOLEAN,kafkaZookeeperHost VARCHAR(75) null,kafkaThreadsPerTopic INTEGER,kafkaGroupId VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table LiOT_Broker";
    public static final String ORDER_BY_JPQL = " ORDER BY broker.name ASC";
    public static final String ORDER_BY_SQL = " ORDER BY LiOT_Broker.name ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.it.acsoftware.brokerportlet.model.Broker"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.it.acsoftware.brokerportlet.model.Broker"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.it.acsoftware.brokerportlet.model.Broker"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long NAME_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.it.acsoftware.brokerportlet.model.Broker"));
    private static ClassLoader _classLoader = Broker.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Broker.class };
    private long _brokerId;
    private long _groupId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _originalName;
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
    private long _columnBitmask;
    private Broker _escapedModel;

    public BrokerModelImpl() {
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

    @Override
    public long getBrokerId() {
        return _brokerId;
    }

    @Override
    public void setBrokerId(long brokerId) {
        _brokerId = brokerId;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
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
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _columnBitmask = -1L;

        if (_originalName == null) {
            _originalName = _name;
        }

        _name = name;
    }

    public String getOriginalName() {
        return GetterUtil.getString(_originalName);
    }

    @Override
    public String getProtocol() {
        if (_protocol == null) {
            return StringPool.BLANK;
        } else {
            return _protocol;
        }
    }

    @Override
    public void setProtocol(String protocol) {
        _protocol = protocol;
    }

    @Override
    public String getUrl() {
        if (_url == null) {
            return StringPool.BLANK;
        } else {
            return _url;
        }
    }

    @Override
    public void setUrl(String url) {
        _url = url;
    }

    @Override
    public String getPort() {
        if (_port == null) {
            return StringPool.BLANK;
        } else {
            return _port;
        }
    }

    @Override
    public void setPort(String port) {
        _port = port;
    }

    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @Override
    public String getType() {
        if (_type == null) {
            return StringPool.BLANK;
        } else {
            return _type;
        }
    }

    @Override
    public void setType(String type) {
        _type = type;
    }

    @Override
    public String getConnectionUsername() {
        if (_connectionUsername == null) {
            return StringPool.BLANK;
        } else {
            return _connectionUsername;
        }
    }

    @Override
    public void setConnectionUsername(String connectionUsername) {
        _connectionUsername = connectionUsername;
    }

    @Override
    public String getConnectionPassword() {
        if (_connectionPassword == null) {
            return StringPool.BLANK;
        } else {
            return _connectionPassword;
        }
    }

    @Override
    public void setConnectionPassword(String connectionPassword) {
        _connectionPassword = connectionPassword;
    }

    @Override
    public String getTopics() {
        if (_topics == null) {
            return StringPool.BLANK;
        } else {
            return _topics;
        }
    }

    @Override
    public void setTopics(String topics) {
        _topics = topics;
    }

    @Override
    public String getCustomProps() {
        if (_customProps == null) {
            return StringPool.BLANK;
        } else {
            return _customProps;
        }
    }

    @Override
    public void setCustomProps(String customProps) {
        _customProps = customProps;
    }

    @Override
    public Boolean getSslEnabled() {
        return _sslEnabled;
    }

    @Override
    public void setSslEnabled(Boolean sslEnabled) {
        _sslEnabled = sslEnabled;
    }

    @Override
    public String getSslSecret() {
        if (_sslSecret == null) {
            return StringPool.BLANK;
        } else {
            return _sslSecret;
        }
    }

    @Override
    public void setSslSecret(String sslSecret) {
        _sslSecret = sslSecret;
    }

    @Override
    public String getSslCertificateUUid() {
        if (_sslCertificateUUid == null) {
            return StringPool.BLANK;
        } else {
            return _sslCertificateUUid;
        }
    }

    @Override
    public void setSslCertificateUUid(String sslCertificateUUid) {
        _sslCertificateUUid = sslCertificateUUid;
    }

    @Override
    public Boolean getStartAtStartup() {
        return _startAtStartup;
    }

    @Override
    public void setStartAtStartup(Boolean startAtStartup) {
        _startAtStartup = startAtStartup;
    }

    @Override
    public String getMqttClientId() {
        if (_mqttClientId == null) {
            return StringPool.BLANK;
        } else {
            return _mqttClientId;
        }
    }

    @Override
    public void setMqttClientId(String mqttClientId) {
        _mqttClientId = mqttClientId;
    }

    @Override
    public int getMqttQos() {
        return _mqttQos;
    }

    @Override
    public void setMqttQos(int mqttQos) {
        _mqttQos = mqttQos;
    }

    @Override
    public Boolean getMqttCleanSession() {
        return _mqttCleanSession;
    }

    @Override
    public void setMqttCleanSession(Boolean mqttCleanSession) {
        _mqttCleanSession = mqttCleanSession;
    }

    @Override
    public String getKafkaZookeeperHost() {
        if (_kafkaZookeeperHost == null) {
            return StringPool.BLANK;
        } else {
            return _kafkaZookeeperHost;
        }
    }

    @Override
    public void setKafkaZookeeperHost(String kafkaZookeeperHost) {
        _kafkaZookeeperHost = kafkaZookeeperHost;
    }

    @Override
    public int getKafkaThreadsPerTopic() {
        return _kafkaThreadsPerTopic;
    }

    @Override
    public void setKafkaThreadsPerTopic(int kafkaThreadsPerTopic) {
        _kafkaThreadsPerTopic = kafkaThreadsPerTopic;
    }

    @Override
    public String getKafkaGroupId() {
        if (_kafkaGroupId == null) {
            return StringPool.BLANK;
        } else {
            return _kafkaGroupId;
        }
    }

    @Override
    public void setKafkaGroupId(String kafkaGroupId) {
        _kafkaGroupId = kafkaGroupId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Broker.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Broker toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Broker) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        BrokerImpl brokerImpl = new BrokerImpl();

        brokerImpl.setBrokerId(getBrokerId());
        brokerImpl.setGroupId(getGroupId());
        brokerImpl.setCompanyId(getCompanyId());
        brokerImpl.setUserId(getUserId());
        brokerImpl.setUserName(getUserName());
        brokerImpl.setCreateDate(getCreateDate());
        brokerImpl.setModifiedDate(getModifiedDate());
        brokerImpl.setName(getName());
        brokerImpl.setProtocol(getProtocol());
        brokerImpl.setUrl(getUrl());
        brokerImpl.setPort(getPort());
        brokerImpl.setDescription(getDescription());
        brokerImpl.setType(getType());
        brokerImpl.setConnectionUsername(getConnectionUsername());
        brokerImpl.setConnectionPassword(getConnectionPassword());
        brokerImpl.setTopics(getTopics());
        brokerImpl.setCustomProps(getCustomProps());
        brokerImpl.setSslEnabled(getSslEnabled());
        brokerImpl.setSslSecret(getSslSecret());
        brokerImpl.setSslCertificateUUid(getSslCertificateUUid());
        brokerImpl.setStartAtStartup(getStartAtStartup());
        brokerImpl.setMqttClientId(getMqttClientId());
        brokerImpl.setMqttQos(getMqttQos());
        brokerImpl.setMqttCleanSession(getMqttCleanSession());
        brokerImpl.setKafkaZookeeperHost(getKafkaZookeeperHost());
        brokerImpl.setKafkaThreadsPerTopic(getKafkaThreadsPerTopic());
        brokerImpl.setKafkaGroupId(getKafkaGroupId());

        brokerImpl.resetOriginalValues();

        return brokerImpl;
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

        if (!(obj instanceof Broker)) {
            return false;
        }

        Broker broker = (Broker) obj;

        long primaryKey = broker.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        BrokerModelImpl brokerModelImpl = this;

        brokerModelImpl._originalCompanyId = brokerModelImpl._companyId;

        brokerModelImpl._setOriginalCompanyId = false;

        brokerModelImpl._originalName = brokerModelImpl._name;

        brokerModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Broker> toCacheModel() {
        BrokerCacheModel brokerCacheModel = new BrokerCacheModel();

        brokerCacheModel.brokerId = getBrokerId();

        brokerCacheModel.groupId = getGroupId();

        brokerCacheModel.companyId = getCompanyId();

        brokerCacheModel.userId = getUserId();

        brokerCacheModel.userName = getUserName();

        String userName = brokerCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            brokerCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            brokerCacheModel.createDate = createDate.getTime();
        } else {
            brokerCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            brokerCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            brokerCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        brokerCacheModel.name = getName();

        String name = brokerCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            brokerCacheModel.name = null;
        }

        brokerCacheModel.protocol = getProtocol();

        String protocol = brokerCacheModel.protocol;

        if ((protocol != null) && (protocol.length() == 0)) {
            brokerCacheModel.protocol = null;
        }

        brokerCacheModel.url = getUrl();

        String url = brokerCacheModel.url;

        if ((url != null) && (url.length() == 0)) {
            brokerCacheModel.url = null;
        }

        brokerCacheModel.port = getPort();

        String port = brokerCacheModel.port;

        if ((port != null) && (port.length() == 0)) {
            brokerCacheModel.port = null;
        }

        brokerCacheModel.description = getDescription();

        String description = brokerCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            brokerCacheModel.description = null;
        }

        brokerCacheModel.type = getType();

        String type = brokerCacheModel.type;

        if ((type != null) && (type.length() == 0)) {
            brokerCacheModel.type = null;
        }

        brokerCacheModel.connectionUsername = getConnectionUsername();

        String connectionUsername = brokerCacheModel.connectionUsername;

        if ((connectionUsername != null) && (connectionUsername.length() == 0)) {
            brokerCacheModel.connectionUsername = null;
        }

        brokerCacheModel.connectionPassword = getConnectionPassword();

        String connectionPassword = brokerCacheModel.connectionPassword;

        if ((connectionPassword != null) && (connectionPassword.length() == 0)) {
            brokerCacheModel.connectionPassword = null;
        }

        brokerCacheModel.topics = getTopics();

        String topics = brokerCacheModel.topics;

        if ((topics != null) && (topics.length() == 0)) {
            brokerCacheModel.topics = null;
        }

        brokerCacheModel.customProps = getCustomProps();

        String customProps = brokerCacheModel.customProps;

        if ((customProps != null) && (customProps.length() == 0)) {
            brokerCacheModel.customProps = null;
        }

        brokerCacheModel.sslEnabled = getSslEnabled();

        brokerCacheModel.sslSecret = getSslSecret();

        String sslSecret = brokerCacheModel.sslSecret;

        if ((sslSecret != null) && (sslSecret.length() == 0)) {
            brokerCacheModel.sslSecret = null;
        }

        brokerCacheModel.sslCertificateUUid = getSslCertificateUUid();

        String sslCertificateUUid = brokerCacheModel.sslCertificateUUid;

        if ((sslCertificateUUid != null) && (sslCertificateUUid.length() == 0)) {
            brokerCacheModel.sslCertificateUUid = null;
        }

        brokerCacheModel.startAtStartup = getStartAtStartup();

        brokerCacheModel.mqttClientId = getMqttClientId();

        String mqttClientId = brokerCacheModel.mqttClientId;

        if ((mqttClientId != null) && (mqttClientId.length() == 0)) {
            brokerCacheModel.mqttClientId = null;
        }

        brokerCacheModel.mqttQos = getMqttQos();

        brokerCacheModel.mqttCleanSession = getMqttCleanSession();

        brokerCacheModel.kafkaZookeeperHost = getKafkaZookeeperHost();

        String kafkaZookeeperHost = brokerCacheModel.kafkaZookeeperHost;

        if ((kafkaZookeeperHost != null) && (kafkaZookeeperHost.length() == 0)) {
            brokerCacheModel.kafkaZookeeperHost = null;
        }

        brokerCacheModel.kafkaThreadsPerTopic = getKafkaThreadsPerTopic();

        brokerCacheModel.kafkaGroupId = getKafkaGroupId();

        String kafkaGroupId = brokerCacheModel.kafkaGroupId;

        if ((kafkaGroupId != null) && (kafkaGroupId.length() == 0)) {
            brokerCacheModel.kafkaGroupId = null;
        }

        return brokerCacheModel;
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
