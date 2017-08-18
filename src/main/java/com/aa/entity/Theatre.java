package com.aa.entity;

public class Theatre {
	private int id;
	private int screens;
	
	
	public Theatre() {}
	public Theatre( String name, int screens, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public int getScreens() {
		return screens;
	}
	public void setScreens(int screens) {
		this.screens = screens;
	}
	private String name;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
