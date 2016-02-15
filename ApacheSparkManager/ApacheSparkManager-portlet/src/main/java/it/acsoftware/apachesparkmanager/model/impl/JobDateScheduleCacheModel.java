package it.acsoftware.apachesparkmanager.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobDateSchedule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see JobDateSchedule
 * @generated
 */
public class JobDateScheduleCacheModel implements CacheModel<JobDateSchedule>,
    Externalizable {
    public long jobDateScheduleId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String scheduleName;
    public String chronExpression;
    public String params;
    public String jarName;
    public String mainClass;
    public Boolean active;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{jobDateScheduleId=");
        sb.append(jobDateScheduleId);
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
        sb.append(", scheduleName=");
        sb.append(scheduleName);
        sb.append(", chronExpression=");
        sb.append(chronExpression);
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
    public JobDateSchedule toEntityModel() {
        JobDateScheduleImpl jobDateScheduleImpl = new JobDateScheduleImpl();

        jobDateScheduleImpl.setJobDateScheduleId(jobDateScheduleId);
        jobDateScheduleImpl.setGroupId(groupId);
        jobDateScheduleImpl.setCompanyId(companyId);
        jobDateScheduleImpl.setUserId(userId);

        if (userName == null) {
            jobDateScheduleImpl.setUserName(StringPool.BLANK);
        } else {
            jobDateScheduleImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            jobDateScheduleImpl.setCreateDate(null);
        } else {
            jobDateScheduleImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            jobDateScheduleImpl.setModifiedDate(null);
        } else {
            jobDateScheduleImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (scheduleName == null) {
            jobDateScheduleImpl.setScheduleName(StringPool.BLANK);
        } else {
            jobDateScheduleImpl.setScheduleName(scheduleName);
        }

        if (chronExpression == null) {
            jobDateScheduleImpl.setChronExpression(StringPool.BLANK);
        } else {
            jobDateScheduleImpl.setChronExpression(chronExpression);
        }

        if (params == null) {
            jobDateScheduleImpl.setParams(StringPool.BLANK);
        } else {
            jobDateScheduleImpl.setParams(params);
        }

        if (jarName == null) {
            jobDateScheduleImpl.setJarName(StringPool.BLANK);
        } else {
            jobDateScheduleImpl.setJarName(jarName);
        }

        if (mainClass == null) {
            jobDateScheduleImpl.setMainClass(StringPool.BLANK);
        } else {
            jobDateScheduleImpl.setMainClass(mainClass);
        }

        jobDateScheduleImpl.setActive(active);

        jobDateScheduleImpl.resetOriginalValues();

        return jobDateScheduleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        jobDateScheduleId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        scheduleName = objectInput.readUTF();
        chronExpression = objectInput.readUTF();
        params = objectInput.readUTF();
        jarName = objectInput.readUTF();
        mainClass = objectInput.readUTF();
        active = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(jobDateScheduleId);
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

        if (scheduleName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(scheduleName);
        }

        if (chronExpression == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(chronExpression);
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
