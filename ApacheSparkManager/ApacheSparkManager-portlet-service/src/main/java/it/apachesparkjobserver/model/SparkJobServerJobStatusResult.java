package it.apachesparkjobserver.model;

import java.util.List;

public class SparkJobServerJobStatusResult {
	private String message;
	private String errorClass;
	private String cause;
	private String causingClass;
	private List<String> stack;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorClass() {
		return errorClass;
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
	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}
	public List<String> getStack() {
		return stack;
	}
	public void setStack(List<String> stack) {
		this.stack = stack;
	}

	
}
