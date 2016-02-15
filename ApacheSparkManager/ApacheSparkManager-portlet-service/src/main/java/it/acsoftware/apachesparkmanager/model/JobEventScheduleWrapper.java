package it.acsoftware.apachesparkmanager.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link JobEventSchedule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobEventSchedule
 * @generated
 */
public class JobEventScheduleWrapper implements JobEventSchedule,
    ModelWrapper<JobEventSchedule> {
    private JobEventSchedule _jobEventSchedule;

    public JobEventScheduleWrapper(JobEventSchedule jobEventSchedule) {
        _jobEventSchedule = jobEventSchedule;
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

    /**
    * Returns the primary key of this job event schedule.
    *
    * @return the primary key of this job event schedule
    */
    @Override
    public long getPrimaryKey() {
        return _jobEventSchedule.getPrimaryKey();
    }

    /**
    * Sets the primary key of this job event schedule.
    *
    * @param primaryKey the primary key of this job event schedule
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _jobEventSchedule.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the job event schedule ID of this job event schedule.
    *
    * @return the job event schedule ID of this job event schedule
    */
    @Override
    public long getJobEventScheduleId() {
        return _jobEventSchedule.getJobEventScheduleId();
    }

    /**
    * Sets the job event schedule ID of this job event schedule.
    *
    * @param jobEventScheduleId the job event schedule ID of this job event schedule
    */
    @Override
    public void setJobEventScheduleId(long jobEventScheduleId) {
        _jobEventSchedule.setJobEventScheduleId(jobEventScheduleId);
    }

    /**
    * Returns the group ID of this job event schedule.
    *
    * @return the group ID of this job event schedule
    */
    @Override
    public long getGroupId() {
        return _jobEventSchedule.getGroupId();
    }

    /**
    * Sets the group ID of this job event schedule.
    *
    * @param groupId the group ID of this job event schedule
    */
    @Override
    public void setGroupId(long groupId) {
        _jobEventSchedule.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this job event schedule.
    *
    * @return the company ID of this job event schedule
    */
    @Override
    public long getCompanyId() {
        return _jobEventSchedule.getCompanyId();
    }

    /**
    * Sets the company ID of this job event schedule.
    *
    * @param companyId the company ID of this job event schedule
    */
    @Override
    public void setCompanyId(long companyId) {
        _jobEventSchedule.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this job event schedule.
    *
    * @return the user ID of this job event schedule
    */
    @Override
    public long getUserId() {
        return _jobEventSchedule.getUserId();
    }

    /**
    * Sets the user ID of this job event schedule.
    *
    * @param userId the user ID of this job event schedule
    */
    @Override
    public void setUserId(long userId) {
        _jobEventSchedule.setUserId(userId);
    }

    /**
    * Returns the user uuid of this job event schedule.
    *
    * @return the user uuid of this job event schedule
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventSchedule.getUserUuid();
    }

    /**
    * Sets the user uuid of this job event schedule.
    *
    * @param userUuid the user uuid of this job event schedule
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _jobEventSchedule.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this job event schedule.
    *
    * @return the user name of this job event schedule
    */
    @Override
    public java.lang.String getUserName() {
        return _jobEventSchedule.getUserName();
    }

    /**
    * Sets the user name of this job event schedule.
    *
    * @param userName the user name of this job event schedule
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _jobEventSchedule.setUserName(userName);
    }

    /**
    * Returns the create date of this job event schedule.
    *
    * @return the create date of this job event schedule
    */
    @Override
    public java.util.Date getCreateDate() {
        return _jobEventSchedule.getCreateDate();
    }

    /**
    * Sets the create date of this job event schedule.
    *
    * @param createDate the create date of this job event schedule
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _jobEventSchedule.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this job event schedule.
    *
    * @return the modified date of this job event schedule
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _jobEventSchedule.getModifiedDate();
    }

    /**
    * Sets the modified date of this job event schedule.
    *
    * @param modifiedDate the modified date of this job event schedule
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _jobEventSchedule.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the event name of this job event schedule.
    *
    * @return the event name of this job event schedule
    */
    @Override
    public java.lang.String getEventName() {
        return _jobEventSchedule.getEventName();
    }

    /**
    * Sets the event name of this job event schedule.
    *
    * @param eventName the event name of this job event schedule
    */
    @Override
    public void setEventName(java.lang.String eventName) {
        _jobEventSchedule.setEventName(eventName);
    }

    /**
    * Returns the params of this job event schedule.
    *
    * @return the params of this job event schedule
    */
    @Override
    public java.lang.String getParams() {
        return _jobEventSchedule.getParams();
    }

    /**
    * Sets the params of this job event schedule.
    *
    * @param params the params of this job event schedule
    */
    @Override
    public void setParams(java.lang.String params) {
        _jobEventSchedule.setParams(params);
    }

    /**
    * Returns the jar name of this job event schedule.
    *
    * @return the jar name of this job event schedule
    */
    @Override
    public java.lang.String getJarName() {
        return _jobEventSchedule.getJarName();
    }

    /**
    * Sets the jar name of this job event schedule.
    *
    * @param jarName the jar name of this job event schedule
    */
    @Override
    public void setJarName(java.lang.String jarName) {
        _jobEventSchedule.setJarName(jarName);
    }

    /**
    * Returns the main class of this job event schedule.
    *
    * @return the main class of this job event schedule
    */
    @Override
    public java.lang.String getMainClass() {
        return _jobEventSchedule.getMainClass();
    }

    /**
    * Sets the main class of this job event schedule.
    *
    * @param mainClass the main class of this job event schedule
    */
    @Override
    public void setMainClass(java.lang.String mainClass) {
        _jobEventSchedule.setMainClass(mainClass);
    }

    /**
    * Returns the active of this job event schedule.
    *
    * @return the active of this job event schedule
    */
    @Override
    public java.lang.Boolean getActive() {
        return _jobEventSchedule.getActive();
    }

    /**
    * Sets the active of this job event schedule.
    *
    * @param active the active of this job event schedule
    */
    @Override
    public void setActive(java.lang.Boolean active) {
        _jobEventSchedule.setActive(active);
    }

    @Override
    public boolean isNew() {
        return _jobEventSchedule.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _jobEventSchedule.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _jobEventSchedule.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _jobEventSchedule.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _jobEventSchedule.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _jobEventSchedule.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _jobEventSchedule.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _jobEventSchedule.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _jobEventSchedule.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _jobEventSchedule.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _jobEventSchedule.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new JobEventScheduleWrapper((JobEventSchedule) _jobEventSchedule.clone());
    }

    @Override
    public int compareTo(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule) {
        return _jobEventSchedule.compareTo(jobEventSchedule);
    }

    @Override
    public int hashCode() {
        return _jobEventSchedule.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.acsoftware.apachesparkmanager.model.JobEventSchedule> toCacheModel() {
        return _jobEventSchedule.toCacheModel();
    }

    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule toEscapedModel() {
        return new JobEventScheduleWrapper(_jobEventSchedule.toEscapedModel());
    }

    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule toUnescapedModel() {
        return new JobEventScheduleWrapper(_jobEventSchedule.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _jobEventSchedule.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _jobEventSchedule.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _jobEventSchedule.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof JobEventScheduleWrapper)) {
            return false;
        }

        JobEventScheduleWrapper jobEventScheduleWrapper = (JobEventScheduleWrapper) obj;

        if (Validator.equals(_jobEventSchedule,
                    jobEventScheduleWrapper._jobEventSchedule)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public JobEventSchedule getWrappedJobEventSchedule() {
        return _jobEventSchedule;
    }

    @Override
    public JobEventSchedule getWrappedModel() {
        return _jobEventSchedule;
    }

    @Override
    public void resetOriginalValues() {
        _jobEventSchedule.resetOriginalValues();
    }
}
