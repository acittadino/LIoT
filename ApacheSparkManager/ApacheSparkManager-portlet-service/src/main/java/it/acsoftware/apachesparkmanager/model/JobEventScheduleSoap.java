package it.acsoftware.apachesparkmanager.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.acsoftware.apachesparkmanager.service.http.JobEventScheduleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.apachesparkmanager.service.http.JobEventScheduleServiceSoap
 * @generated
 */
public class JobEventScheduleSoap implements Serializable {
    private long _jobEventScheduleId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _eventName;
    private String _params;
    private String _jarName;
    private String _mainClass;
    private Boolean _active;

    public JobEventScheduleSoap() {
    }

    public static JobEventScheduleSoap toSoapModel(JobEventSchedule model) {
        JobEventScheduleSoap soapModel = new JobEventScheduleSoap();

        soapModel.setJobEventScheduleId(model.getJobEventScheduleId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setEventName(model.getEventName());
        soapModel.setParams(model.getParams());
        soapModel.setJarName(model.getJarName());
        soapModel.setMainClass(model.getMainClass());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static JobEventScheduleSoap[] toSoapModels(JobEventSchedule[] models) {
        JobEventScheduleSoap[] soapModels = new JobEventScheduleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static JobEventScheduleSoap[][] toSoapModels(
        JobEventSchedule[][] models) {
        JobEventScheduleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new JobEventScheduleSoap[models.length][models[0].length];
        } else {
            soapModels = new JobEventScheduleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static JobEventScheduleSoap[] toSoapModels(
        List<JobEventSchedule> models) {
        List<JobEventScheduleSoap> soapModels = new ArrayList<JobEventScheduleSoap>(models.size());

        for (JobEventSchedule model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new JobEventScheduleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _jobEventScheduleId;
    }

    public void setPrimaryKey(long pk) {
        setJobEventScheduleId(pk);
    }

    public long getJobEventScheduleId() {
        return _jobEventScheduleId;
    }

    public void setJobEventScheduleId(long jobEventScheduleId) {
        _jobEventScheduleId = jobEventScheduleId;
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

    public String getEventName() {
        return _eventName;
    }

    public void setEventName(String eventName) {
        _eventName = eventName;
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
