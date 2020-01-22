package com.theatre.domain;

import com.theatre.controllerUI.ControllerUI;

public class TransferClass {
	private Object request;
	private Object response;
	private String message;
	private ConstUI constUI;
	private ConstBL constBL;
	
	public static TransferClass transferClass(Object object,ConstUI constUI, ConstBL constBL) {
		TransferClass transferClass = new TransferClass();
		transferClass.setRequest(object);
		transferClass.setConstUI(constUI);
		transferClass.setConstBL(constBL);
		ControllerUI.getInstance().execute(transferClass);
		
		
		return transferClass;
	}
	public Object getRequest() {
		return request;
	}
	public void setRequest(Object request) {
		this.request = request;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ConstUI getConstUI() {
		return constUI;
	}
	public void setConstUI(ConstUI constUI) {
		this.constUI = constUI;
	}
	public ConstBL getConstBL() {
		return constBL;
	}
	public void setConstBL(ConstBL constBL) {
		this.constBL = constBL;
	}
	
}
