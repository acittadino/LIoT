package it.apachesparkjobserver.model;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class SparkJobServerJobStatus implements Comparable<SparkJobServerJobStatus>{
	private String duration;
	private String classPath;
	private String startTime;
	private String context;
	private String status;
	private String cause;
	private String causingClass;
	private String jobId;
	
	private SparkJobServerJobStatusResult result;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public SparkJobServerJobStatusResult getResult() {
		return result;
	}

	public void setResult(SparkJobServerJobStatusResult result) {
		this.result = result;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
	public String getCausingClass() {
		return causingClass;
	}

	public void setCausingClass(String causingClass) {
		this.causingClass = causingClass;
	}
	
	

	@Override
	public int compareTo(SparkJobServerJobStatus o) {
		if(this.getStartTime() != null && o.getStartTime() != null)
			return o.getStartTime().compareTo(this.getStartTime());
		return 0;
	}

	public static List<SparkJobServerJobStatus> getObject(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<SparkJobServerJobStatus> response = mapper.readValue(json,
					new TypeReference<List<SparkJobServerJobStatus>>() {
					});
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
