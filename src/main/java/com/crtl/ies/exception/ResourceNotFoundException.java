package com.crtl.ies.exception;


public class ResourceNotFoundException extends RuntimeException{
		
	private String fieldName;
	private String fieldTitle;
	private String fieldInfo;
	
	
	public ResourceNotFoundException(String fieldName, String fieldTitle, String fieldInfo) {
		super(String.format("%s is not found with %s : %s",fieldName,fieldTitle,fieldInfo));
		this.setFieldName(fieldName);
		this.setFieldTitle(fieldTitle);
		this.setFieldInfo(fieldInfo);
	}
	
	
	public ResourceNotFoundException(String msg) {
		super(String.format("%s",msg));
		this.setFieldName(msg);
		
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getFieldTitle() {
		return fieldTitle;
	}


	public void setFieldTitle(String fieldTitle) {
		this.fieldTitle = fieldTitle;
	}


	public String getFieldInfo() {
		return fieldInfo;
	}


	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	
	
	
	
}
