package it.acsoftware.apachesparkmanager.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.acsoftware.apachesparkmanager.service.http.JobDateScheduleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.apachesparkmanager.service.http.JobDateScheduleServiceSoap
 * @generated
 */
public class JobDateScheduleSoap implements Serializable {
    private long _jobDateScheduleId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _scheduleName;
    private String _chronExpression;
    private String _params;
    private String _jarName;
    private String _mainClass;
    private Boolean _active;

    public JobDateScheduleSoap() {
    }

    public static JobDateScheduleSoap toSoapModel(JobDateSchedule model) {
        JobDateScheduleSoap soapModel = new JobDateScheduleSoap();

        soapModel.setJobDateScheduleId(model.getJobDateScheduleId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setScheduleName(model.getScheduleName());
        soapModel.setChronExpression(model.getChronExpression());
        soapModel.setParams(model.getParams());
        soapModel.setJarName(model.getJarName());
        soapModel.setMainClass(model.getMainClass());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static JobDateScheduleSoap[] toSoapModels(JobDateSchedule[] models) {
        JobDateScheduleSoap[] soapModels = new JobDateScheduleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static JobDateScheduleSoap[][] toSoapModels(
        JobDateSchedule[][] models) {
        JobDateScheduleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new JobDateScheduleSoap[models.length][models[0].length];
        } else {
            soapModels = new JobDateScheduleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static JobDateScheduleSoap[] toSoapModels(
        List<JobDateSchedule> models) {
        List<JobDateScheduleSoap> soapModels = new ArrayList<JobDateScheduleSoap>(models.size());

        for (JobDateSchedule model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new JobDateScheduleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _jobDateScheduleId;
    }

    public void setPrimaryKey(long pk) {
        setJobDateScheduleId(pk);
    }

    public long getJobDateScheduleId() {
        return _jobDateScheduleId;
    }

    public void setJobDateScheduleId(long jobDateScheduleId) {
        _jobDateScheduleId = jobDateScheduleId;
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

    public String getScheduleName() {
        return _scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        _scheduleName = scheduleName;
    }

    public String getChronExpression() {
        return _chronExpression;
    }

    public void setChronExpression(String chronExpression) {
        _chronExpression = chronExpression;
    }

    public String getParams() {
        return _params;
    }

    public void setParams(String params) {
        _params = params;
    }

    public String getJarName() {
        return _jarName;
    }

    public void setJarName(String jarName) {
        _jarName = jarName;
    }

    public String getMainClass() {
        return _mainClass;
    }

    public void setMainClass(String mainClass) {
        _mainClass = mainClass;
    }

    public Boolean getActive() {
        return _active;
    }

    public void setActive(Boolean active) {
        _active = active;
    }
}
