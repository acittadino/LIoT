package it.acsoftware.brokerportlet.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BrokerMessageListenerClp extends BaseModelImpl<BrokerMessageListener>
    implements BrokerMessageListener {
    private long _brokerMessageListenerId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private long _brokerId;
    private String _topics;
    private String _type;
    private String _messageBusDestination;
    private BaseModel<?> _brokerMessageListenerRemoteModel;
    private Class<?> _clpSerializerClass = it.acsoftware.brokerportlet.service.ClpSerializer.class;

    public BrokerMessageListenerClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return BrokerMessageListener.class;
    }

    @Override
    public String getModelClassName() {
        return BrokerMessageListener.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _brokerMessageListenerId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setBrokerMessageListenerId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _brokerMessageListenerId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("brokerMessageListenerId", getBrokerMessageListenerId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("brokerId", getBrokerId());
        attributes.put("topics", getTopics());
        attributes.put("type", getType());
        attributes.put("messageBusDestination", getMessageBusDestination());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long brokerMessageListenerId = (Long) attributes.get(
                "brokerMessageListenerId");

        if (brokerMessageListenerId != null) {
            setBrokerMessageListenerId(brokerMessageListenerId);
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

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long brokerId = (Long) attributes.get("brokerId");

        if (brokerId != null) {
            setBrokerId(brokerId);
        }

        String topics = (String) attributes.get("topics");

        if (topics != null) {
            setTopics(topics);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String messageBusDestination = (String) attributes.get(
                "messageBusDestination");

        if (messageBusDestination != null) {
            setMessageBusDestination(messageBusDestination);
        }
    }

    @Override
    public long getBrokerMessageListenerId() {
        return _brokerMessageListenerId;
    }

    @Override
    public void setBrokerMessageListenerId(long brokerMessageListenerId) {
        _brokerMessageListenerId = brokerMessageListenerId;

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setBrokerMessageListenerId",
                        long.class);

                method.invoke(_brokerMessageListenerRemoteModel,
                    brokerMessageListenerId);
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

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_brokerMessageListenerRemoteModel, groupId);
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

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_brokerMessageListenerRemoteModel, companyId);
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

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_brokerMessageListenerRemoteModel, userId);
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

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_brokerMessageListenerRemoteModel, userName);
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

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_brokerMessageListenerRemoteModel, createDate);
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

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_brokerMessageListenerRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_brokerMessageListenerRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_brokerMessageListenerRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getBrokerId() {
        return _brokerId;
    }

    @Override
    public void setBrokerId(long brokerId) {
        _brokerId = brokerId;

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setBrokerId", long.class);

                method.invoke(_brokerMessageListenerRemoteModel, brokerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTopics() {
        return _topics;
    }

    @Override
    public void setTopics(String topics) {
        _topics = topics;

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setTopics", String.class);

                method.invoke(_brokerMessageListenerRemoteModel, topics);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public void setType(String type) {
        _type = type;

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setType", String.class);

                method.invoke(_brokerMessageListenerRemoteModel, type);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMessageBusDestination() {
        return _messageBusDestination;
    }

    @Override
    public void setMessageBusDestination(String messageBusDestination) {
        _messageBusDestination = messageBusDestination;

        if (_brokerMessageListenerRemoteModel != null) {
            try {
                Class<?> clazz = _brokerMessageListenerRemoteModel.getClass();

                Method method = clazz.getMethod("setMessageBusDestination",
                        String.class);

                method.invoke(_brokerMessageListenerRemoteModel,
                    messageBusDestination);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getBrokerMessageListenerRemoteModel() {
        return _brokerMessageListenerRemoteModel;
    }

    public void setBrokerMessageListenerRemoteModel(
        BaseModel<?> brokerMessageListenerRemoteModel) {
        _brokerMessageListenerRemoteModel = brokerMessageListenerRemoteModel;
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

        Class<?> remoteModelClass = _brokerMessageListenerRemoteModel.getClass();

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

        Object returnValue = method.invoke(_brokerMessageListenerRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BrokerMessageListenerLocalServiceUtil.addBrokerMessageListener(this);
        } else {
            BrokerMessageListenerLocalServiceUtil.updateBrokerMessageListener(this);
        }
    }

    @Override
    public BrokerMessageListener toEscapedModel() {
        return (BrokerMessageListener) ProxyUtil.newProxyInstance(BrokerMessageListener.class.getClassLoader(),
            new Class[] { BrokerMessageListener.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BrokerMessageListenerClp clone = new BrokerMessageListenerClp();

        clone.setBrokerMessageListenerId(getBrokerMessageListenerId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setBrokerId(getBrokerId());
        clone.setTopics(getTopics());
        clone.setType(getType());
        clone.setMessageBusDestination(getMessageBusDestination());

        return clone;
    }

    @Override
    public int compareTo(BrokerMessageListener brokerMessageListener) {
        long primaryKey = brokerMessageListener.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BrokerMessageListenerClp)) {
            return false;
        }

        BrokerMessageListenerClp brokerMessageListener = (BrokerMessageListenerClp) obj;

        long primaryKey = brokerMessageListener.getPrimaryKey();

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
        StringBundler sb = new StringBundler(27);

        sb.append("{brokerMessageListenerId=");
        sb.append(getBrokerMessageListenerId());
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
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", brokerId=");
        sb.append(getBrokerId());
        sb.append(", topics=");
        sb.append(getTopics());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", messageBusDestination=");
        sb.append(getMessageBusDestination());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("it.acsoftware.brokerportlet.model.BrokerMessageListener");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>brokerMessageListenerId</column-name><column-value><![CDATA[");
        sb.append(getBrokerMessageListenerId());
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
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>brokerId</column-name><column-value><![CDATA[");
        sb.append(getBrokerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>topics</column-name><column-value><![CDATA[");
        sb.append(getTopics());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageBusDestination</column-name><column-value><![CDATA[");
        sb.append(getMessageBusDestination());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
