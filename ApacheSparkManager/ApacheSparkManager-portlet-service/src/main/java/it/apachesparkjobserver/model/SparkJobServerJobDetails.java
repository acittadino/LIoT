package it.apachesparkjobserver.model;

import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class SparkJobServerJobDetails {
	private String status;
	private HashMap<String, String> result;
	@JsonProperty("ERROR")
	private SparkJobServerJobStatusResult error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HashMap<String, String> getResult() {
		return result;
	}

	public void setResult(HashMap<String, String> result) {
		this.result = result;
	}

	public SparkJobServerJobStatusResult getError() {
		return error;
	}

	public void setError(SparkJobServerJobStatusResult error) {
		this.error = error;
	}

	public static SparkJobServerJobDetails getObject(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			SparkJobServerJobDetails response = mapper.readValue(json,
					new TypeReference<SparkJobServerJobDetails>() {
					});
			return response;
		} catch (Exception e) {
			try {
				JSONObject obj = JSONFactoryUtil.createJSONObject(json);
				SparkJobServerJobDetails response = new SparkJobServerJobDetails();
				response.setStatus(obj.getString("status"));
				response.setResult(new HashMap<String, String>());
				response.getResult().put("Error", obj.getString("result"));
				return response;
			} catch (Exception e1) {
			}

			return null;
		}
	}
}
