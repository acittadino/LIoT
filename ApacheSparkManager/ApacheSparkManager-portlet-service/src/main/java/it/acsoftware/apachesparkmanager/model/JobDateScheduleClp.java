package it.acsoftware.apachesparkmanager.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.acsoftware.apachesparkmanager.service.ClpSerializer;
import it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JobDateScheduleClp extends BaseModelImpl<JobDateSchedule>
    implements JobDateSchedule {
    private long _jobDateScheduleId;
    private long _groupId;
    private long _companyId;
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
    private BaseModel<?> _jobDateScheduleRemoteModel;
    private Class<?> _clpSerializerClass = it.acsoftware.apachesparkmanager.service.ClpSerializer.class;

    public JobDateScheduleClp() {
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

    @Override
    public long getJobDateScheduleId() {
        return _jobDateScheduleId;
    }

    @Override
    public void setJobDateScheduleId(long jobDateScheduleId) {
        _jobDateScheduleId = jobDateScheduleId;

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setJobDateScheduleId",
                        long.class);

                method.invoke(_jobDateScheduleRemoteModel, jobDateScheduleId);
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

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_jobDateScheduleRemoteModel, groupId);
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

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_jobDateScheduleRemoteModel, companyId);
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

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_jobDateScheduleRemoteModel, userId);
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

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_jobDateScheduleRemoteModel, userName);
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

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_jobDateScheduleRemoteModel, createDate);
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

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_jobDateScheduleRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScheduleName() {
        return _scheduleName;
    }

    @Override
    public void setScheduleName(String scheduleName) {
        _scheduleName = scheduleName;

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setScheduleName", String.class);

                method.invoke(_jobDateScheduleRemoteModel, scheduleName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChronExpression() {
        return _chronExpression;
    }

    @Override
    public void setChronExpression(String chronExpression) {
        _chronExpression = chronExpression;

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setChronExpression",
                        String.class);

                method.invoke(_jobDateScheduleRemoteModel, chronExpression);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getParams() {
        return _params;
    }

    @Override
    public void setParams(String params) {
        _params = params;

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setParams", String.class);

                method.invoke(_jobDateScheduleRemoteModel, params);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getJarName() {
        return _jarName;
    }

    @Override
    public void setJarName(String jarName) {
        _jarName = jarName;

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setJarName", String.class);

                method.invoke(_jobDateScheduleRemoteModel, jarName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMainClass() {
        return _mainClass;
    }

    @Override
    public void setMainClass(String mainClass) {
        _mainClass = mainClass;

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setMainClass", String.class);

                method.invoke(_jobDateScheduleRemoteModel, mainClass);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getActive() {
        return _active;
    }

    @Override
    public void setActive(Boolean active) {
        _active = active;

        if (_jobDateScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobDateScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setActive", Boolean.class);

                method.invoke(_jobDateScheduleRemoteModel, active);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public java.util.HashMap<java.lang.String, java.lang.String> getParamsMap() {
        try {
            String methodName = "getParamsMap";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.util.HashMap<java.lang.String, java.lang.String> returnObj = (java.util.HashMap<java.lang.String, java.lang.String>) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getJobDateScheduleRemoteModel() {
        return _jobDateScheduleRemoteModel;
    }

    public void setJobDateScheduleRemoteModel(
        BaseModel<?> jobDateScheduleRemoteModel) {
        _jobDateScheduleRemoteModel = jobDateScheduleRemoteModel;
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

        Class<?> remoteModelClass = _jobDateScheduleRemoteModel.getClass();

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

        Object returnValue = method.invoke(_jobDateScheduleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            JobDateScheduleLocalServiceUtil.addJobDateSchedule(this);
        } else {
            JobDateScheduleLocalServiceUtil.updateJobDateSchedule(this);
        }
    }

    @Override
    public JobDateSchedule toEscapedModel() {
        return (JobDateSchedule) ProxyUtil.newProxyInstance(JobDateSchedule.class.getClassLoader(),
            new Class[] { JobDateSchedule.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        JobDateScheduleClp clone = new JobDateScheduleClp();

        clone.setJobDateScheduleId(getJobDateScheduleId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setScheduleName(getScheduleName());
        clone.setChronExpression(getChronExpression());
        clone.setParams(getParams());
        clone.setJarName(getJarName());
        clone.setMainClass(getMainClass());
        clone.setActive(getActive());

        return clone;
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

        if (!(obj instanceof JobDateScheduleClp)) {
            return false;
        }

        JobDateScheduleClp jobDateSchedule = (JobDateScheduleClp) obj;

        long primaryKey = jobDateSchedule.getPrimaryKey();

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
