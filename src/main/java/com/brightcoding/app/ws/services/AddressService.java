package com.brightcoding.app.ws.services;

import java.util.List;

import com.brightcoding.app.ws.shared.dto.AddressDto;

public interface AddressService {
	
	List<AddressDto> getAllAddresses(String email);
	
	AddressDto createAddress(AddressDto addressDto, String email);
	
	AddressDto getAddress(String addressId);
	
	AddressDto updateAddress(String addressId, AddressDto addressDto);
	
	void deleteAddress(String addressId);

}
