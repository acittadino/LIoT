package it.acsoftware.brokerportlet.broker;

public enum BrokerMessageListenerType {
	RUNTIME_CLASS ("runtimeClass"),
	MESSAGE_BUS ("messageBus");
	
	private BrokerMessageListenerType(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	private String type;
}
