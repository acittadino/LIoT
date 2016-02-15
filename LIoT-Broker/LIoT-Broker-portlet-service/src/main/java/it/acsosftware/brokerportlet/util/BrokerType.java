package it.acsosftware.brokerportlet.util;

public enum BrokerType {
	MQTT("MQTT", "tcp"), KAFKA("KAFKA", "tcp");

	private BrokerType(String type, String protocol) {
		this.type = type;
		this.protocol = protocol;
	}

	public String getType() {
		return type;
	}

	public String getProtocol() {
		return protocol;
	}

	private String protocol;
	private String type;
}
