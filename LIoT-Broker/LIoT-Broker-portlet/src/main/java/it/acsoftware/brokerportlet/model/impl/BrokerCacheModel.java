package it.acsoftware.brokerportlet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.acsoftware.brokerportlet.model.Broker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Broker in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Broker
 * @generated
 */
public class BrokerCacheModel implements CacheModel<Broker>, Externalizable {
    public long brokerId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String protocol;
    public String url;
    public String port;
    public String description;
    public String type;
    public String connectionUsername;
    public String connectionPassword;
    public String topics;
    public String customProps;
    public Boolean sslEnabled;
    public String sslSecret;
    public String sslCertificateUUid;
    public Boolean startAtStartup;
    public String mqttClientId;
    public int mqttQos;
    public Boolean mqttCleanSession;
    public String kafkaZookeeperHost;
    public int kafkaThreadsPerTopic;
    public String kafkaGroupId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(55);

        sb.append("{brokerId=");
        sb.append(brokerId);
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
        sb.append(", protocol=");
        sb.append(protocol);
        sb.append(", url=");
        sb.append(url);
        sb.append(", port=");
        sb.append(port);
        sb.append(", description=");
        sb.append(description);
        sb.append(", type=");
        sb.append(type);
        sb.append(", connectionUsername=");
        sb.append(connectionUsername);
        sb.append(", connectionPassword=");
        sb.append(connectionPassword);
        sb.append(", topics=");
        sb.append(topics);
        sb.append(", customProps=");
        sb.append(customProps);
        sb.append(", sslEnabled=");
        sb.append(sslEnabled);
        sb.append(", sslSecret=");
        sb.append(sslSecret);
        sb.append(", sslCertificateUUid=");
        sb.append(sslCertificateUUid);
        sb.append(", startAtStartup=");
        sb.append(startAtStartup);
        sb.append(", mqttClientId=");
        sb.append(mqttClientId);
        sb.append(", mqttQos=");
        sb.append(mqttQos);
        sb.append(", mqttCleanSession=");
        sb.append(mqttCleanSession);
        sb.append(", kafkaZookeeperHost=");
        sb.append(kafkaZookeeperHost);
        sb.append(", kafkaThreadsPerTopic=");
        sb.append(kafkaThreadsPerTopic);
        sb.append(", kafkaGroupId=");
        sb.append(kafkaGroupId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Broker toEntityModel() {
        BrokerImpl brokerImpl = new BrokerImpl();

        brokerImpl.setBrokerId(brokerId);
        brokerImpl.setGroupId(groupId);
        brokerImpl.setCompanyId(companyId);
        brokerImpl.setUserId(userId);

        if (userName == null) {
            brokerImpl.setUserName(StringPool.BLANK);
        } else {
            brokerImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            brokerImpl.setCreateDate(null);
        } else {
            brokerImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            brokerImpl.setModifiedDate(null);
        } else {
            brokerImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            brokerImpl.setName(StringPool.BLANK);
        } else {
            brokerImpl.setName(name);
        }

        if (protocol == null) {
            brokerImpl.setProtocol(StringPool.BLANK);
        } else {
            brokerImpl.setProtocol(protocol);
        }

        if (url == null) {
            brokerImpl.setUrl(StringPool.BLANK);
        } else {
            brokerImpl.setUrl(url);
        }

        if (port == null) {
            brokerImpl.setPort(StringPool.BLANK);
        } else {
            brokerImpl.setPort(port);
        }

        if (description == null) {
            brokerImpl.setDescription(StringPool.BLANK);
        } else {
            brokerImpl.setDescription(description);
        }

        if (type == null) {
            brokerImpl.setType(StringPool.BLANK);
        } else {
            brokerImpl.setType(type);
        }

        if (connectionUsername == null) {
            brokerImpl.setConnectionUsername(StringPool.BLANK);
        } else {
            brokerImpl.setConnectionUsername(connectionUsername);
        }

        if (connectionPassword == null) {
            brokerImpl.setConnectionPassword(StringPool.BLANK);
        } else {
            brokerImpl.setConnectionPassword(connectionPassword);
        }

        if (topics == null) {
            brokerImpl.setTopics(StringPool.BLANK);
        } else {
            brokerImpl.setTopics(topics);
        }

        if (customProps == null) {
            brokerImpl.setCustomProps(StringPool.BLANK);
        } else {
            brokerImpl.setCustomProps(customProps);
        }

        brokerImpl.setSslEnabled(sslEnabled);

        if (sslSecret == null) {
            brokerImpl.setSslSecret(StringPool.BLANK);
        } else {
            brokerImpl.setSslSecret(sslSecret);
        }

        if (sslCertificateUUid == null) {
            brokerImpl.setSslCertificateUUid(StringPool.BLANK);
        } else {
            brokerImpl.setSslCertificateUUid(sslCertificateUUid);
        }

        brokerImpl.setStartAtStartup(startAtStartup);

        if (mqttClientId == null) {
            brokerImpl.setMqttClientId(StringPool.BLANK);
        } else {
            brokerImpl.setMqttClientId(mqttClientId);
        }

        brokerImpl.setMqttQos(mqttQos);
        brokerImpl.setMqttCleanSession(mqttCleanSession);

        if (kafkaZookeeperHost == null) {
            brokerImpl.setKafkaZookeeperHost(StringPool.BLANK);
        } else {
            brokerImpl.setKafkaZookeeperHost(kafkaZookeeperHost);
        }

        brokerImpl.setKafkaThreadsPerTopic(kafkaThreadsPerTopic);

        if (kafkaGroupId == null) {
            brokerImpl.setKafkaGroupId(StringPool.BLANK);
        } else {
            brokerImpl.setKafkaGroupId(kafkaGroupId);
        }

        brokerImpl.resetOriginalValues();

        return brokerImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        brokerId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        protocol = objectInput.readUTF();
        url = objectInput.readUTF();
        port = objectInput.readUTF();
        description = objectInput.readUTF();
        type = objectInput.readUTF();
        connectionUsername = objectInput.readUTF();
        connectionPassword = objectInput.readUTF();
        topics = objectInput.readUTF();
        customProps = objectInput.readUTF();
        sslEnabled = objectInput.readBoolean();
        sslSecret = objectInput.readUTF();
        sslCertificateUUid = objectInput.readUTF();
        startAtStartup = objectInput.readBoolean();
        mqttClientId = objectInput.readUTF();
        mqttQos = objectInput.readInt();
        mqttCleanSession = objectInput.readBoolean();
        kafkaZookeeperHost = objectInput.readUTF();
        kafkaThreadsPerTopic = objectInput.readInt();
        kafkaGroupId = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(brokerId);
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

        if (protocol == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(protocol);
        }

        if (url == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(url);
        }

        if (port == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(port);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (type == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(type);
        }

        if (connectionUsername == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(connectionUsername);
        }

        if (connectionPassword == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(connectionPassword);
        }

        if (topics == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(topics);
        }

        if (customProps == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(customProps);
        }

        objectOutput.writeBoolean(sslEnabled);

        if (sslSecret == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sslSecret);
        }

        if (sslCertificateUUid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sslCertificateUUid);
        }

        objectOutput.writeBoolean(startAtStartup);

        if (mqttClientId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mqttClientId);
        }

        objectOutput.writeInt(mqttQos);
        objectOutput.writeBoolean(mqttCleanSession);

        if (kafkaZookeeperHost == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kafkaZookeeperHost);
        }

        objectOutput.writeInt(kafkaThreadsPerTopic);

        if (kafkaGroupId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kafkaGroupId);
        }
    }
}
