package it.acsoftware.apachesparkmanager.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
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

import it.acsoftware.apachesparkmanager.model.JobEventSchedule;
import it.acsoftware.apachesparkmanager.model.JobEventScheduleModel;
import it.acsoftware.apachesparkmanager.model.JobEventScheduleSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the JobEventSchedule service. Represents a row in the &quot;ApacheSparkManager_JobEventSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.acsoftware.apachesparkmanager.model.JobEventScheduleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobEventScheduleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobEventScheduleImpl
 * @see it.acsoftware.apachesparkmanager.model.JobEventSchedule
 * @see it.acsoftware.apachesparkmanager.model.JobEventScheduleModel
 * @generated
 */
@JSON(strict = true)
public class JobEventScheduleModelImpl extends BaseModelImpl<JobEventSchedule>
    implements JobEventScheduleModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a job event schedule model instance should use the {@link it.acsoftware.apachesparkmanager.model.JobEventSchedule} interface instead.
     */
    public static final String TABLE_NAME = "ApacheSparkManager_JobEventSchedule";
    public static final Object[][] TABLE_COLUMNS = {
            { "jobEventScheduleId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "eventName", Types.VARCHAR },
            { "params", Types.VARCHAR },
            { "jarName", Types.VARCHAR },
            { "mainClass", Types.VARCHAR },
            { "active_", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table ApacheSparkManager_JobEventSchedule (jobEventScheduleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,eventName VARCHAR(75) null,params VARCHAR(75) null,jarName VARCHAR(75) null,mainClass VARCHAR(75) null,active_ BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table ApacheSparkManager_JobEventSchedule";
    public static final String ORDER_BY_JPQL = " ORDER BY jobEventSchedule.eventName ASC";
    public static final String ORDER_BY_SQL = " ORDER BY ApacheSparkManager_JobEventSchedule.eventName ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.it.acsoftware.apachesparkmanager.model.JobEventSchedule"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.it.acsoftware.apachesparkmanager.model.JobEventSchedule"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.it.acsoftware.apachesparkmanager.model.JobEventSchedule"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long EVENTNAME_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.it.acsoftware.apachesparkmanager.model.JobEventSchedule"));
    private static ClassLoader _classLoader = JobEventSchedule.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            JobEventSchedule.class
        };
    private long _jobEventScheduleId;
    private long _groupId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _eventName;
    private String _originalEventName;
    private String _params;
    private String _jarName;
    private String _mainClass;
    private Boolean _active;
    private long _columnBitmask;
    private JobEventSchedule _escapedModel;

    public JobEventScheduleModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static JobEventSchedule toModel(JobEventScheduleSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        JobEventSchedule model = new JobEventScheduleImpl();

        model.setJobEventScheduleId(soapModel.getJobEventScheduleId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setEventName(soapModel.getEventName());
        model.setParams(soapModel.getParams());
        model.setJarName(soapModel.getJarName());
        model.setMainClass(soapModel.getMainClass());
        model.setActive(soapModel.getActive());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<JobEventSchedule> toModels(
        JobEventScheduleSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<JobEventSchedule> models = new ArrayList<JobEventSchedule>(soapModels.length);

        for (JobEventScheduleSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _jobEventScheduleId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setJobEventScheduleId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _jobEventScheduleId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return JobEventSchedule.class;
    }

    @Override
    public String getModelClassName() {
        return JobEventSchedule.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("jobEventScheduleId", getJobEventScheduleId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("eventName", getEventName());
        attributes.put("params", getParams());
        attributes.put("jarName", getJarName());
        attributes.put("mainClass", getMainClass());
        attributes.put("active", getActive());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long jobEventScheduleId = (Long) attributes.get("jobEventScheduleId");

        if (jobEventScheduleId != null) {
            setJobEventScheduleId(jobEventScheduleId);
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

        String eventName = (String) attributes.get("eventName");

        if (eventName != null) {
            setEventName(eventName);
        }

        String params = (String) attributes.get("params");

        if (params != null) {
            setParams(params);
        }

        String jarName = (String) attributes.get("jarName");

        if (jarName != null) {
            setJarName(jarName);
        }

        String mainClass = (String) attributes.get("mainClass");

        if (mainClass != null) {
            setMainClass(mainClass);
        }

        Boolean active = (Boolean) attributes.get("active");

        if (active != null) {
            setActive(active);
        }
    }

    @JSON
    @Override
    public long getJobEventScheduleId() {
        return _jobEventScheduleId;
    }

    @Override
    public void setJobEventScheduleId(long jobEventScheduleId) {
        _jobEventScheduleId = jobEventScheduleId;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    @JSON
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

    @JSON
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

    @JSON
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

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @JSON
    @Override
    public String getEventName() {
        if (_eventName == null) {
            return StringPool.BLANK;
        } else {
            return _eventName;
        }
    }

    @Override
    public void setEventName(String eventName) {
        _columnBitmask = -1L;

        if (_originalEventName == null) {
            _originalEventName = _eventName;
        }

        _eventName = eventName;
    }

    public String getOriginalEventName() {
        return GetterUtil.getString(_originalEventName);
    }

    @JSON
    @Override
    public String getParams() {
        if (_params == null) {
            return StringPool.BLANK;
        } else {
            return _params;
        }
    }

    @Override
    public void setParams(String params) {
        _params = params;
    }

    @JSON
    @Override
    public String getJarName() {
        if (_jarName == null) {
            return StringPool.BLANK;
        } else {
            return _jarName;
        }
    }

    @Override
    public void setJarName(String jarName) {
        _jarName = jarName;
    }

    @JSON
    @Override
    public String getMainClass() {
        if (_mainClass == null) {
            return StringPool.BLANK;
        } else {
            return _mainClass;
        }
    }

    @Override
    public void setMainClass(String mainClass) {
        _mainClass = mainClass;
    }

    @JSON
    @Override
    public Boolean getActive() {
        return _active;
    }

    @Override
    public void setActive(Boolean active) {
        _active = active;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            JobEventSchedule.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public JobEventSchedule toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (JobEventSchedule) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        JobEventScheduleImpl jobEventScheduleImpl = new JobEventScheduleImpl();

        jobEventScheduleImpl.setJobEventScheduleId(getJobEventScheduleId());
        jobEventScheduleImpl.setGroupId(getGroupId());
        jobEventScheduleImpl.setCompanyId(getCompanyId());
        jobEventScheduleImpl.setUserId(getUserId());
        jobEventScheduleImpl.setUserName(getUserName());
        jobEventScheduleImpl.setCreateDate(getCreateDate());
        jobEventScheduleImpl.setModifiedDate(getModifiedDate());
        jobEventScheduleImpl.setEventName(getEventName());
        jobEventScheduleImpl.setParams(getParams());
        jobEventScheduleImpl.setJarName(getJarName());
        jobEventScheduleImpl.setMainClass(getMainClass());
        jobEventScheduleImpl.setActive(getActive());

        jobEventScheduleImpl.resetOriginalValues();

        return jobEventScheduleImpl;
    }

    @Override
    public int compareTo(JobEventSchedule jobEventSchedule) {
        int value = 0;

        value = getEventName().compareTo(jobEventSchedule.getEventName());

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

        if (!(obj instanceof JobEventSchedule)) {
            return false;
        }

        JobEventSchedule jobEventSchedule = (JobEventSchedule) obj;

        long primaryKey = jobEventSchedule.getPrimaryKey();

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
        JobEventScheduleModelImpl jobEventScheduleModelImpl = this;

        jobEventScheduleModelImpl._originalCompanyId = jobEventScheduleModelImpl._companyId;

        jobEventScheduleModelImpl._setOriginalCompanyId = false;

        jobEventScheduleModelImpl._originalEventName = jobEventScheduleModelImpl._eventName;

        jobEventScheduleModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<JobEventSchedule> toCacheModel() {
        JobEventScheduleCacheModel jobEventScheduleCacheModel = new JobEventScheduleCacheModel();

        jobEventScheduleCacheModel.jobEventScheduleId = getJobEventScheduleId();

        jobEventScheduleCacheModel.groupId = getGroupId();

        jobEventScheduleCacheModel.companyId = getCompanyId();

        jobEventScheduleCacheModel.userId = getUserId();

        jobEventScheduleCacheModel.userName = getUserName();

        String userName = jobEventScheduleCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            jobEventScheduleCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            jobEventScheduleCacheModel.createDate = createDate.getTime();
        } else {
            jobEventScheduleCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            jobEventScheduleCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            jobEventScheduleCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        jobEventScheduleCacheModel.eventName = getEventName();

        String eventName = jobEventScheduleCacheModel.eventName;

        if ((eventName != null) && (eventName.length() == 0)) {
            jobEventScheduleCacheModel.eventName = null;
        }

        jobEventScheduleCacheModel.params = getParams();

        String params = jobEventScheduleCacheModel.params;

        if ((params != null) && (params.length() == 0)) {
            jobEventScheduleCacheModel.params = null;
        }

        jobEventScheduleCacheModel.jarName = getJarName();

        String jarName = jobEventScheduleCacheModel.jarName;

        if ((jarName != null) && (jarName.length() == 0)) {
            jobEventScheduleCacheModel.jarName = null;
        }

        jobEventScheduleCacheModel.mainClass = getMainClass();

        String mainClass = jobEventScheduleCacheModel.mainClass;

        if ((mainClass != null) && (mainClass.length() == 0)) {
            jobEventScheduleCacheModel.mainClass = null;
        }

        jobEventScheduleCacheModel.active = getActive();

        return jobEventScheduleCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{jobEventScheduleId=");
        sb.append(getJobEventScheduleId());
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
        sb.append(", eventName=");
        sb.append(getEventName());
        sb.append(", params=");
        sb.append(getParams());
        sb.append(", jarName=");
        sb.append(getJarName());
        sb.append(", mainClass=");
        sb.append(getMainClass());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("it.acsoftware.apachesparkmanager.model.JobEventSchedule");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>jobEventScheduleId</column-name><column-value><![CDATA[");
        sb.append(getJobEventScheduleId());
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
            "<column><column-name>eventName</column-name><column-value><![CDATA[");
        sb.append(getEventName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>params</column-name><column-value><![CDATA[");
        sb.append(getParams());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>jarName</column-name><column-value><![CDATA[");
        sb.append(getJarName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mainClass</column-name><column-value><![CDATA[");
        sb.append(getMainClass());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
