package com.candidate.dto;

import java.util.*;

public class CsvImport {

	private int successCount;
	private int failedCount;
	private List<String> errors;
	
	public CsvImport() {
		
	}
	
	public  CsvImport(int successCount, int failedCount, List<String> errors) {
		this.successCount=successCount;
		this.failedCount=failedCount;
		this.errors=errors;
		
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	
	
}
