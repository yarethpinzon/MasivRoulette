package com.example.demo.model;

public class credentials {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public credentials(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public credentials() {
		
	}
}
