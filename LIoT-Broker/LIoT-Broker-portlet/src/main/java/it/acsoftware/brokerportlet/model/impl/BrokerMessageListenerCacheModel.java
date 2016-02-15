package it.acsoftware.brokerportlet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.acsoftware.brokerportlet.model.BrokerMessageListener;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BrokerMessageListener in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BrokerMessageListener
 * @generated
 */
public class BrokerMessageListenerCacheModel implements CacheModel<BrokerMessageListener>,
    Externalizable {
    public long brokerMessageListenerId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public long brokerId;
    public String topics;
    public String type;
    public String messageBusDestination;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{brokerMessageListenerId=");
        sb.append(brokerMessageListenerId);
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
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", brokerId=");
        sb.append(brokerId);
        sb.append(", topics=");
        sb.append(topics);
        sb.append(", type=");
        sb.append(type);
        sb.append(", messageBusDestination=");
        sb.append(messageBusDestination);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public BrokerMessageListener toEntityModel() {
        BrokerMessageListenerImpl brokerMessageListenerImpl = new BrokerMessageListenerImpl();

        brokerMessageListenerImpl.setBrokerMessageListenerId(brokerMessageListenerId);
        brokerMessageListenerImpl.setGroupId(groupId);
        brokerMessageListenerImpl.setCompanyId(companyId);
        brokerMessageListenerImpl.setUserId(userId);

        if (userName == null) {
            brokerMessageListenerImpl.setUserName(StringPool.BLANK);
        } else {
            brokerMessageListenerImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            brokerMessageListenerImpl.setCreateDate(null);
        } else {
            brokerMessageListenerImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            brokerMessageListenerImpl.setModifiedDate(null);
        } else {
            brokerMessageListenerImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            brokerMessageListenerImpl.setName(StringPool.BLANK);
        } else {
            brokerMessageListenerImpl.setName(name);
        }

        if (description == null) {
            brokerMessageListenerImpl.setDescription(StringPool.BLANK);
        } else {
            brokerMessageListenerImpl.setDescription(description);
        }

        brokerMessageListenerImpl.setBrokerId(brokerId);

        if (topics == null) {
            brokerMessageListenerImpl.setTopics(StringPool.BLANK);
        } else {
            brokerMessageListenerImpl.setTopics(topics);
        }

        if (type == null) {
            brokerMessageListenerImpl.setType(StringPool.BLANK);
        } else {
            brokerMessageListenerImpl.setType(type);
        }

        if (messageBusDestination == null) {
            brokerMessageListenerImpl.setMessageBusDestination(StringPool.BLANK);
        } else {
            brokerMessageListenerImpl.setMessageBusDestination(messageBusDestination);
        }

        brokerMessageListenerImpl.resetOriginalValues();

        return brokerMessageListenerImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        brokerMessageListenerId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        brokerId = objectInput.readLong();
        topics = objectInput.readUTF();
        type = objectInput.readUTF();
        messageBusDestination = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(brokerMessageListenerId);
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

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(brokerId);

        if (topics == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(topics);
        }

        if (type == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(type);
        }

        if (messageBusDestination == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(messageBusDestination);
        }
    }
}
