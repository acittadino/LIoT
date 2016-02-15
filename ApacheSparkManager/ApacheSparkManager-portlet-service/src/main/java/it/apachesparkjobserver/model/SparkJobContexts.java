package it.apachesparkjobserver.model;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class SparkJobContexts {
	private List<String> contexts;

	public SparkJobContexts(List<String> contexts){
		this.contexts = contexts;
	}
	
	public List<String> getContexts() {
		return contexts;
	}

	public void setContexts(List<String> contexts) {
		this.contexts = contexts;
	}
	
	public static SparkJobContexts getObject(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<String> response = mapper.readValue(json,
					new TypeReference<List<String>>() {
			});

			return new SparkJobContexts(response);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
