package com.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OperationResult {

	private boolean result;

	public OperationResult() {}
	
	public OperationResult(boolean result) {
		this.result = result;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
