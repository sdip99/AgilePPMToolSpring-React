package com.ppmt.exceptions;


public class ProjectIDExceptionResponse {

	private String projectIdentifier;
	
	public ProjectIDExceptionResponse(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	
}
