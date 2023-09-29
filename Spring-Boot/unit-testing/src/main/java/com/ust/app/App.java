package com.ust.app;

public class App {
	AppService service;
	public boolean check(int n) {
		return service.checkEven(n);
	}
	public AppService getService() {
		return service;
	}
	public void setService(AppService service) {
		this.service = service;
	}
	public int findStringLength(String str) {
		return service.findStringLength(str);
	}
}
