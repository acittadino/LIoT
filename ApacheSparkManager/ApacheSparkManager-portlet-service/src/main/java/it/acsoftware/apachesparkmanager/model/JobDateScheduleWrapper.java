package it.acsoftware.apachesparkmanager.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link JobDateSchedule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobDateSchedule
 * @generated
 */
public class JobDateScheduleWrapper implements JobDateSchedule,
    ModelWrapper<JobDateSchedule> {
    private JobDateSchedule _jobDateSchedule;

    public JobDateScheduleWrapper(JobDateSchedule jobDateSchedule) {
        _jobDateSchedule = jobDateSchedule;
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

    /**
    * Returns the primary key of this job date schedule.
    *
    * @return the primary key of this job date schedule
    */
    @Override
    public long getPrimaryKey() {
        return _jobDateSchedule.getPrimaryKey();
    }

    /**
    * Sets the primary key of this job date schedule.
    *
    * @param primaryKey the primary key of this job date schedule
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _jobDateSchedule.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the job date schedule ID of this job date schedule.
    *
    * @return the job date schedule ID of this job date schedule
    */
    @Override
    public long getJobDateScheduleId() {
        return _jobDateSchedule.getJobDateScheduleId();
    }

    /**
    * Sets the job date schedule ID of this job date schedule.
    *
    * @param jobDateScheduleId the job date schedule ID of this job date schedule
    */
    @Override
    public void setJobDateScheduleId(long jobDateScheduleId) {
        _jobDateSchedule.setJobDateScheduleId(jobDateScheduleId);
    }

    /**
    * Returns the group ID of this job date schedule.
    *
    * @return the group ID of this job date schedule
    */
    @Override
    public long getGroupId() {
        return _jobDateSchedule.getGroupId();
    }

    /**
    * Sets the group ID of this job date schedule.
    *
    * @param groupId the group ID of this job date schedule
    */
    @Override
    public void setGroupId(long groupId) {
        _jobDateSchedule.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this job date schedule.
    *
    * @return the company ID of this job date schedule
    */
    @Override
    public long getCompanyId() {
        return _jobDateSchedule.getCompanyId();
    }

    /**
    * Sets the company ID of this job date schedule.
    *
    * @param companyId the company ID of this job date schedule
    */
    @Override
    public void setCompanyId(long companyId) {
        _jobDateSchedule.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this job date schedule.
    *
    * @return the user ID of this job date schedule
    */
    @Override
    public long getUserId() {
        return _jobDateSchedule.getUserId();
    }

    /**
    * Sets the user ID of this job date schedule.
    *
    * @param userId the user ID of this job date schedule
    */
    @Override
    public void setUserId(long userId) {
        _jobDateSchedule.setUserId(userId);
    }

    /**
    * Returns the user uuid of this job date schedule.
    *
    * @return the user uuid of this job date schedule
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobDateSchedule.getUserUuid();
    }

    /**
    * Sets the user uuid of this job date schedule.
    *
    * @param userUuid the user uuid of this job date schedule
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _jobDateSchedule.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this job date schedule.
    *
    * @return the user name of this job date schedule
    */
    @Override
    public java.lang.String getUserName() {
        return _jobDateSchedule.getUserName();
    }

    /**
    * Sets the user name of this job date schedule.
    *
    * @param userName the user name of this job date schedule
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _jobDateSchedule.setUserName(userName);
    }

    /**
    * Returns the create date of this job date schedule.
    *
    * @return the create date of this job date schedule
    */
    @Override
    public java.util.Date getCreateDate() {
        return _jobDateSchedule.getCreateDate();
    }

    /**
    * Sets the create date of this job date schedule.
    *
    * @param createDate the create date of this job date schedule
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _jobDateSchedule.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this job date schedule.
    *
    * @return the modified date of this job date schedule
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _jobDateSchedule.getModifiedDate();
    }

    /**
    * Sets the modified date of this job date schedule.
    *
    * @param modifiedDate the modified date of this job date schedule
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _jobDateSchedule.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the schedule name of this job date schedule.
    *
    * @return the schedule name of this job date schedule
    */
    @Override
    public java.lang.String getScheduleName() {
        return _jobDateSchedule.getScheduleName();
    }

    /**
    * Sets the schedule name of this job date schedule.
    *
    * @param scheduleName the schedule name of this job date schedule
    */
    @Override
    public void setScheduleName(java.lang.String scheduleName) {
        _jobDateSchedule.setScheduleName(scheduleName);
    }

    /**
    * Returns the chron expression of this job date schedule.
    *
    * @return the chron expression of this job date schedule
    */
    @Override
    public java.lang.String getChronExpression() {
        return _jobDateSchedule.getChronExpression();
    }

    /**
    * Sets the chron expression of this job date schedule.
    *
    * @param chronExpression the chron expression of this job date schedule
    */
    @Override
    public void setChronExpression(java.lang.String chronExpression) {
        _jobDateSchedule.setChronExpression(chronExpression);
    }

    /**
    * Returns the params of this job date schedule.
    *
    * @return the params of this job date schedule
    */
    @Override
    public java.lang.String getParams() {
        return _jobDateSchedule.getParams();
    }

    /**
    * Sets the params of this job date schedule.
    *
    * @param params the params of this job date schedule
    */
    @Override
    public void setParams(java.lang.String params) {
        _jobDateSchedule.setParams(params);
    }

    /**
    * Returns the jar name of this job date schedule.
    *
    * @return the jar name of this job date schedule
    */
    @Override
    public java.lang.String getJarName() {
        return _jobDateSchedule.getJarName();
    }

    /**
    * Sets the jar name of this job date schedule.
    *
    * @param jarName the jar name of this job date schedule
    */
    @Override
    public void setJarName(java.lang.String jarName) {
        _jobDateSchedule.setJarName(jarName);
    }

    /**
    * Returns the main class of this job date schedule.
    *
    * @return the main class of this job date schedule
    */
    @Override
    public java.lang.String getMainClass() {
        return _jobDateSchedule.getMainClass();
    }

    /**
    * Sets the main class of this job date schedule.
    *
    * @param mainClass the main class of this job date schedule
    */
    @Override
    public void setMainClass(java.lang.String mainClass) {
        _jobDateSchedule.setMainClass(mainClass);
    }

    /**
    * Returns the active of this job date schedule.
    *
    * @return the active of this job date schedule
    */
    @Override
    public java.lang.Boolean getActive() {
        return _jobDateSchedule.getActive();
    }

    /**
    * Sets the active of this job date schedule.
    *
    * @param active the active of this job date schedule
    */
    @Override
    public void setActive(java.lang.Boolean active) {
        _jobDateSchedule.setActive(active);
    }

    @Override
    public boolean isNew() {
        return _jobDateSchedule.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _jobDateSchedule.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _jobDateSchedule.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _jobDateSchedule.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _jobDateSchedule.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _jobDateSchedule.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _jobDateSchedule.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _jobDateSchedule.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _jobDateSchedule.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _jobDateSchedule.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _jobDateSchedule.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new JobDateScheduleWrapper((JobDateSchedule) _jobDateSchedule.clone());
    }

    @Override
    public int compareTo(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jobDateSchedule) {
        return _jobDateSchedule.compareTo(jobDateSchedule);
    }

    @Override
    public int hashCode() {
        return _jobDateSchedule.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.acsoftware.apachesparkmanager.model.JobDateSchedule> toCacheModel() {
        return _jobDateSchedule.toCacheModel();
    }

    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule toEscapedModel() {
        return new JobDateScheduleWrapper(_jobDateSchedule.toEscapedModel());
    }

    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule toUnescapedModel() {
        return new JobDateScheduleWrapper(_jobDateSchedule.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _jobDateSchedule.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _jobDateSchedule.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _jobDateSchedule.persist();
    }

    @Override
    public java.util.HashMap<java.lang.String, java.lang.String> getParamsMap() {
        return _jobDateSchedule.getParamsMap();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof JobDateScheduleWrapper)) {
            return false;
        }

        JobDateScheduleWrapper jobDateScheduleWrapper = (JobDateScheduleWrapper) obj;

        if (Validator.equals(_jobDateSchedule,
                    jobDateScheduleWrapper._jobDateSchedule)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public JobDateSchedule getWrappedJobDateSchedule() {
        return _jobDateSchedule;
    }

    @Override
    public JobDateSchedule getWrappedModel() {
        return _jobDateSchedule;
    }

    @Override
    public void resetOriginalValues() {
        _jobDateSchedule.resetOriginalValues();
    }
}
