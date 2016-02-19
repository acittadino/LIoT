package it.acsoftware.brokerportlet.broker;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BrokerServiceMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String topic;
	private Object data;
	private HashMap<String,Object> params;
	
	public BrokerServiceMessage(String topic, Object data) {
		super();
		this.topic = topic;
		this.data = data;
		this.params = new HashMap<>();
	}

	public String getTopic() {
		return topic;
	}

	public Object getData() {
		return data;
	}
	
	public Object getParam(String key){
		return params.get(key);
	}
	
	public void setParam(String name,Object value){
		params.put(name, value);
	}
	
	public Map<String,Object> getParams(){
		return Collections.unmodifiableMap(params);
	}
	
	
}
