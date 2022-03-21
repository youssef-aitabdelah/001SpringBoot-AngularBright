package com.brightcoding.app.ws.shared.dto;

public class ContactDto {
	
	private long id;
	private String contactId;
	private String mobile;
	private String skype;
	private UserDto user;
	public long getId() {
		return id;
	}
	public String getContactId() {
		return contactId;
	}
	public String getMobile() {
		return mobile;
	}
	public String getSkype() {
		return skype;
	}
	public UserDto getUser() {
		return user;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	

}
