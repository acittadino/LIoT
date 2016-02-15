package it.apachesparkjobserver.model;

import java.util.HashMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class SparkJobServerJars {
	private HashMap<String, String> jars;

	public SparkJobServerJars(HashMap<String, String> jars) {
		this.jars = jars;
	}

	public HashMap<String, String> getJars() {
		return jars;
	}

	public void setJars(HashMap<String, String> jars) {
		this.jars = jars;
	}

	public static SparkJobServerJars getObject(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			HashMap<String, String> response = mapper.readValue(json,
					new TypeReference<HashMap<String, String>>() {
			});

			return new SparkJobServerJars(response);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
