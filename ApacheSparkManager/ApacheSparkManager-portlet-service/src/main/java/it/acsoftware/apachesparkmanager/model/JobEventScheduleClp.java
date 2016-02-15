package it.acsoftware.apachesparkmanager.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.acsoftware.apachesparkmanager.service.ClpSerializer;
import it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JobEventScheduleClp extends BaseModelImpl<JobEventSchedule>
    implements JobEventSchedule {
    private long _jobEventScheduleId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _eventName;
    private String _params;
    private String _jarName;
    private String _mainClass;
    private Boolean _active;
    private BaseModel<?> _jobEventScheduleRemoteModel;
    private Class<?> _clpSerializerClass = it.acsoftware.apachesparkmanager.service.ClpSerializer.class;

    public JobEventScheduleClp() {
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

    @Override
    public long getJobEventScheduleId() {
        return _jobEventScheduleId;
    }

    @Override
    public void setJobEventScheduleId(long jobEventScheduleId) {
        _jobEventScheduleId = jobEventScheduleId;

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setJobEventScheduleId",
                        long.class);

                method.invoke(_jobEventScheduleRemoteModel, jobEventScheduleId);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_jobEventScheduleRemoteModel, groupId);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_jobEventScheduleRemoteModel, companyId);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_jobEventScheduleRemoteModel, userId);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_jobEventScheduleRemoteModel, userName);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_jobEventScheduleRemoteModel, createDate);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_jobEventScheduleRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEventName() {
        return _eventName;
    }

    @Override
    public void setEventName(String eventName) {
        _eventName = eventName;

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setEventName", String.class);

                method.invoke(_jobEventScheduleRemoteModel, eventName);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setParams", String.class);

                method.invoke(_jobEventScheduleRemoteModel, params);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setJarName", String.class);

                method.invoke(_jobEventScheduleRemoteModel, jarName);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setMainClass", String.class);

                method.invoke(_jobEventScheduleRemoteModel, mainClass);
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

        if (_jobEventScheduleRemoteModel != null) {
            try {
                Class<?> clazz = _jobEventScheduleRemoteModel.getClass();

                Method method = clazz.getMethod("setActive", Boolean.class);

                method.invoke(_jobEventScheduleRemoteModel, active);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getJobEventScheduleRemoteModel() {
        return _jobEventScheduleRemoteModel;
    }

    public void setJobEventScheduleRemoteModel(
        BaseModel<?> jobEventScheduleRemoteModel) {
        _jobEventScheduleRemoteModel = jobEventScheduleRemoteModel;
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

        Class<?> remoteModelClass = _jobEventScheduleRemoteModel.getClass();

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

        Object returnValue = method.invoke(_jobEventScheduleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            JobEventScheduleLocalServiceUtil.addJobEventSchedule(this);
        } else {
            JobEventScheduleLocalServiceUtil.updateJobEventSchedule(this);
        }
    }

    @Override
    public JobEventSchedule toEscapedModel() {
        return (JobEventSchedule) ProxyUtil.newProxyInstance(JobEventSchedule.class.getClassLoader(),
            new Class[] { JobEventSchedule.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        JobEventScheduleClp clone = new JobEventScheduleClp();

        clone.setJobEventScheduleId(getJobEventScheduleId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setEventName(getEventName());
        clone.setParams(getParams());
        clone.setJarName(getJarName());
        clone.setMainClass(getMainClass());
        clone.setActive(getActive());

        return clone;
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

        if (!(obj instanceof JobEventScheduleClp)) {
            return false;
        }

        JobEventScheduleClp jobEventSchedule = (JobEventScheduleClp) obj;

        long primaryKey = jobEventSchedule.getPrimaryKey();

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
