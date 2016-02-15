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

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.model.JobDateScheduleModel;
import it.acsoftware.apachesparkmanager.model.JobDateScheduleSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the JobDateSchedule service. Represents a row in the &quot;ApacheSparkManager_JobDateSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.acsoftware.apachesparkmanager.model.JobDateScheduleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobDateScheduleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobDateScheduleImpl
 * @see it.acsoftware.apachesparkmanager.model.JobDateSchedule
 * @see it.acsoftware.apachesparkmanager.model.JobDateScheduleModel
 * @generated
 */
@JSON(strict = true)
public class JobDateScheduleModelImpl extends BaseModelImpl<JobDateSchedule>
    implements JobDateScheduleModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a job date schedule model instance should use the {@link it.acsoftware.apachesparkmanager.model.JobDateSchedule} interface instead.
     */
    public static final String TABLE_NAME = "ApacheSparkManager_JobDateSchedule";
    public static final Object[][] TABLE_COLUMNS = {
            { "jobDateScheduleId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "scheduleName", Types.VARCHAR },
            { "chronExpression", Types.VARCHAR },
            { "params", Types.VARCHAR },
            { "jarName", Types.VARCHAR },
            { "mainClass", Types.VARCHAR },
            { "active_", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table ApacheSparkManager_JobDateSchedule (jobDateScheduleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,scheduleName VARCHAR(75) null,chronExpression VARCHAR(75) null,params VARCHAR(75) null,jarName VARCHAR(75) null,mainClass VARCHAR(75) null,active_ BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table ApacheSparkManager_JobDateSchedule";
    public static final String ORDER_BY_JPQL = " ORDER BY jobDateSchedule.jobDateScheduleId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY ApacheSparkManager_JobDateSchedule.jobDateScheduleId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.it.acsoftware.apachesparkmanager.model.JobDateSchedule"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.it.acsoftware.apachesparkmanager.model.JobDateSchedule"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.it.acsoftware.apachesparkmanager.model.JobDateSchedule"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long JOBDATESCHEDULEID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.it.acsoftware.apachesparkmanager.model.JobDateSchedule"));
    private static ClassLoader _classLoader = JobDateSchedule.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            JobDateSchedule.class
        };
    private long _jobDateScheduleId;
    private long _groupId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _scheduleName;
    private String _chronExpression;
    private String _params;
    private String _jarName;
    private String _mainClass;
    private Boolean _active;
    private long _columnBitmask;
    private JobDateSchedule _escapedModel;

    public JobDateScheduleModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static JobDateSchedule toModel(JobDateScheduleSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        JobDateSchedule model = new JobDateScheduleImpl();

        model.setJobDateScheduleId(soapModel.getJobDateScheduleId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setScheduleName(soapModel.getScheduleName());
        model.setChronExpression(soapModel.getChronExpression());
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
    public static List<JobDateSchedule> toModels(
        JobDateScheduleSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<JobDateSchedule> models = new ArrayList<JobDateSchedule>(soapModels.length);

        for (JobDateScheduleSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _jobDateScheduleId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setJobDateScheduleId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _jobDateScheduleId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return JobDateSchedule.class;
    }

    @Override
    public String getModelClassName() {
        return JobDateSchedule.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("jobDateScheduleId", getJobDateScheduleId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("scheduleName", getScheduleName());
        attributes.put("chronExpression", getChronExpression());
        attributes.put("params", getParams());
        attributes.put("jarName", getJarName());
        attributes.put("mainClass", getMainClass());
        attributes.put("active", getActive());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long jobDateScheduleId = (Long) attributes.get("jobDateScheduleId");

        if (jobDateScheduleId != null) {
            setJobDateScheduleId(jobDateScheduleId);
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

        String scheduleName = (String) attributes.get("scheduleName");

        if (scheduleName != null) {
            setScheduleName(scheduleName);
        }

        String chronExpression = (String) attributes.get("chronExpression");

        if (chronExpression != null) {
            setChronExpression(chronExpression);
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
    public long getJobDateScheduleId() {
        return _jobDateScheduleId;
    }

    @Override
    public void setJobDateScheduleId(long jobDateScheduleId) {
        _jobDateScheduleId = jobDateScheduleId;
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
    public String getScheduleName() {
        if (_scheduleName == null) {
            return StringPool.BLANK;
        } else {
            return _scheduleName;
        }
    }

    @Override
    public void setScheduleName(String scheduleName) {
        _scheduleName = scheduleName;
    }

    @JSON
    @Override
    public String getChronExpression() {
        if (_chronExpression == null) {
            return StringPool.BLANK;
        } else {
            return _chronExpression;
        }
    }

    @Override
    public void setChronExpression(String chronExpression) {
        _chronExpression = chronExpression;
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
            JobDateSchedule.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public JobDateSchedule toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (JobDateSchedule) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        JobDateScheduleImpl jobDateScheduleImpl = new JobDateScheduleImpl();

        jobDateScheduleImpl.setJobDateScheduleId(getJobDateScheduleId());
        jobDateScheduleImpl.setGroupId(getGroupId());
        jobDateScheduleImpl.setCompanyId(getCompanyId());
        jobDateScheduleImpl.setUserId(getUserId());
        jobDateScheduleImpl.setUserName(getUserName());
        jobDateScheduleImpl.setCreateDate(getCreateDate());
        jobDateScheduleImpl.setModifiedDate(getModifiedDate());
        jobDateScheduleImpl.setScheduleName(getScheduleName());
        jobDateScheduleImpl.setChronExpression(getChronExpression());
        jobDateScheduleImpl.setParams(getParams());
        jobDateScheduleImpl.setJarName(getJarName());
        jobDateScheduleImpl.setMainClass(getMainClass());
        jobDateScheduleImpl.setActive(getActive());

        jobDateScheduleImpl.resetOriginalValues();

        return jobDateScheduleImpl;
    }

    @Override
    public int compareTo(JobDateSchedule jobDateSchedule) {
        long primaryKey = jobDateSchedule.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof JobDateSchedule)) {
            return false;
        }

        JobDateSchedule jobDateSchedule = (JobDateSchedule) obj;

        long primaryKey = jobDateSchedule.getPrimaryKey();

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
        JobDateScheduleModelImpl jobDateScheduleModelImpl = this;

        jobDateScheduleModelImpl._originalCompanyId = jobDateScheduleModelImpl._companyId;

        jobDateScheduleModelImpl._setOriginalCompanyId = false;

        jobDateScheduleModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<JobDateSchedule> toCacheModel() {
        JobDateScheduleCacheModel jobDateScheduleCacheModel = new JobDateScheduleCacheModel();

        jobDateScheduleCacheModel.jobDateScheduleId = getJobDateScheduleId();

        jobDateScheduleCacheModel.groupId = getGroupId();

        jobDateScheduleCacheModel.companyId = getCompanyId();

        jobDateScheduleCacheModel.userId = getUserId();

        jobDateScheduleCacheModel.userName = getUserName();

        String userName = jobDateScheduleCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            jobDateScheduleCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            jobDateScheduleCacheModel.createDate = createDate.getTime();
        } else {
            jobDateScheduleCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            jobDateScheduleCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            jobDateScheduleCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        jobDateScheduleCacheModel.scheduleName = getScheduleName();

        String scheduleName = jobDateScheduleCacheModel.scheduleName;

        if ((scheduleName != null) && (scheduleName.length() == 0)) {
            jobDateScheduleCacheModel.scheduleName = null;
        }

        jobDateScheduleCacheModel.chronExpression = getChronExpression();

        String chronExpression = jobDateScheduleCacheModel.chronExpression;

        if ((chronExpression != null) && (chronExpression.length() == 0)) {
            jobDateScheduleCacheModel.chronExpression = null;
        }

        jobDateScheduleCacheModel.params = getParams();

        String params = jobDateScheduleCacheModel.params;

        if ((params != null) && (params.length() == 0)) {
            jobDateScheduleCacheModel.params = null;
        }

        jobDateScheduleCacheModel.jarName = getJarName();

        String jarName = jobDateScheduleCacheModel.jarName;

        if ((jarName != null) && (jarName.length() == 0)) {
            jobDateScheduleCacheModel.jarName = null;
        }

        jobDateScheduleCacheModel.mainClass = getMainClass();

        String mainClass = jobDateScheduleCacheModel.mainClass;

        if ((mainClass != null) && (mainClass.length() == 0)) {
            jobDateScheduleCacheModel.mainClass = null;
        }

        jobDateScheduleCacheModel.active = getActive();

        return jobDateScheduleCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{jobDateScheduleId=");
        sb.append(getJobDateScheduleId());
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
        sb.append(", scheduleName=");
        sb.append(getScheduleName());
        sb.append(", chronExpression=");
        sb.append(getChronExpression());
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
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("it.acsoftware.apachesparkmanager.model.JobDateSchedule");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>jobDateScheduleId</column-name><column-value><![CDATA[");
        sb.append(getJobDateScheduleId());
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
            "<column><column-name>scheduleName</column-name><column-value><![CDATA[");
        sb.append(getScheduleName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>chronExpression</column-name><column-value><![CDATA[");
        sb.append(getChronExpression());
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