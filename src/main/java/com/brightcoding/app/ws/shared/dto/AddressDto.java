package com.brightcoding.app.ws.shared.dto;

public class AddressDto {

	private long id;
	private String addressId;
	private String city;
	private String country;
	private String street;
	private String postal;
	private String type;
	private UserDto user;
	public long getId() {
		return id;
	}
	public String getAddressId() {
		return addressId;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public String getStreet() {
		return street;
	}
	public String getPostal() {
		return postal;
	}
	public String getType() {
		return type;
	}
	public UserDto getUser() {
		return user;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}

	

}
