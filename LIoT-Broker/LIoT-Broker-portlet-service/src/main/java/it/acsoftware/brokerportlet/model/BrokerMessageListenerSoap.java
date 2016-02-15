package it.acsoftware.brokerportlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrokerMessageListenerSoap implements Serializable {
    private long _brokerMessageListenerId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private long _brokerId;
    private String _topics;
    private String _type;
    private String _messageBusDestination;

    public BrokerMessageListenerSoap() {
    }

    public static BrokerMessageListenerSoap toSoapModel(
        BrokerMessageListener model) {
        BrokerMessageListenerSoap soapModel = new BrokerMessageListenerSoap();

        soapModel.setBrokerMessageListenerId(model.getBrokerMessageListenerId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setBrokerId(model.getBrokerId());
        soapModel.setTopics(model.getTopics());
        soapModel.setType(model.getType());
        soapModel.setMessageBusDestination(model.getMessageBusDestination());

        return soapModel;
    }

    public static BrokerMessageListenerSoap[] toSoapModels(
        BrokerMessageListener[] models) {
        BrokerMessageListenerSoap[] soapModels = new BrokerMessageListenerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BrokerMessageListenerSoap[][] toSoapModels(
        BrokerMessageListener[][] models) {
        BrokerMessageListenerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BrokerMessageListenerSoap[models.length][models[0].length];
        } else {
            soapModels = new BrokerMessageListenerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BrokerMessageListenerSoap[] toSoapModels(
        List<BrokerMessageListener> models) {
        List<BrokerMessageListenerSoap> soapModels = new ArrayList<BrokerMessageListenerSoap>(models.size());

        for (BrokerMessageListener model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BrokerMessageListenerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _brokerMessageListenerId;
    }

    public void setPrimaryKey(long pk) {
        setBrokerMessageListenerId(pk);
    }

    public long getBrokerMessageListenerId() {
        return _brokerMessageListenerId;
    }

    public void setBrokerMessageListenerId(long brokerMessageListenerId) {
        _brokerMessageListenerId = brokerMessageListenerId;
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

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getBrokerId() {
        return _brokerId;
    }

    public void setBrokerId(long brokerId) {
        _brokerId = brokerId;
    }

    public String getTopics() {
        return _topics;
    }

    public void setTopics(String topics) {
        _topics = topics;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public String getMessageBusDestination() {
        return _messageBusDestination;
    }

    public void setMessageBusDestination(String messageBusDestination) {
        _messageBusDestination = messageBusDestination;
    }
}
