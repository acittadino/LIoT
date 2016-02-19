package it.acsoftware.brokerportlet.broker;

import java.util.HashMap;


public interface BrokerService {
	
	public long getBrokerId();
	
	public void startService();

	public void stopService();

	public boolean isRunning();
	
	public void send(byte[] message,HashMap<String,String>params);

}
