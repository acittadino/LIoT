package it.acsoftware.apachesparkmanager.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.acsoftware.apachesparkmanager.model.JobEventSchedule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobEventSchedule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see JobEventSchedule
 * @generated
 */
public class JobEventScheduleCacheModel implements CacheModel<JobEventSchedule>,
    Externalizable {
    public long jobEventScheduleId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String eventName;
    public String params;
    public String jarName;
    public String mainClass;
    public Boolean active;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{jobEventScheduleId=");
        sb.append(jobEventScheduleId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", eventName=");
        sb.append(eventName);
        sb.append(", params=");
        sb.append(params);
        sb.append(", jarName=");
        sb.append(jarName);
        sb.append(", mainClass=");
        sb.append(mainClass);
        sb.append(", active=");
        sb.append(active);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public JobEventSchedule toEntityModel() {
        JobEventScheduleImpl jobEventScheduleImpl = new JobEventScheduleImpl();

        jobEventScheduleImpl.setJobEventScheduleId(jobEventScheduleId);
        jobEventScheduleImpl.setGroupId(groupId);
        jobEventScheduleImpl.setCompanyId(companyId);
        jobEventScheduleImpl.setUserId(userId);

        if (userName == null) {
            jobEventScheduleImpl.setUserName(StringPool.BLANK);
        } else {
            jobEventScheduleImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            jobEventScheduleImpl.setCreateDate(null);
        } else {
            jobEventScheduleImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            jobEventScheduleImpl.setModifiedDate(null);
        } else {
            jobEventScheduleImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (eventName == null) {
            jobEventScheduleImpl.setEventName(StringPool.BLANK);
        } else {
            jobEventScheduleImpl.setEventName(eventName);
        }

        if (params == null) {
            jobEventScheduleImpl.setParams(StringPool.BLANK);
        } else {
            jobEventScheduleImpl.setParams(params);
        }

        if (jarName == null) {
            jobEventScheduleImpl.setJarName(StringPool.BLANK);
        } else {
            jobEventScheduleImpl.setJarName(jarName);
        }

        if (mainClass == null) {
            jobEventScheduleImpl.setMainClass(StringPool.BLANK);
        } else {
            jobEventScheduleImpl.setMainClass(mainClass);
        }

        jobEventScheduleImpl.setActive(active);

        jobEventScheduleImpl.resetOriginalValues();

        return jobEventScheduleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        jobEventScheduleId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        eventName = objectInput.readUTF();
        params = objectInput.readUTF();
        jarName = objectInput.readUTF();
        mainClass = objectInput.readUTF();
        active = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(jobEventScheduleId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (eventName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(eventName);
        }

        if (params == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(params);
        }

        if (jarName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(jarName);
        }

        if (mainClass == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mainClass);
        }

        objectOutput.writeBoolean(active);
    }
}
