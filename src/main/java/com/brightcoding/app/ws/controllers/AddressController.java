package com.brightcoding.app.ws.controllers;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightcoding.app.ws.requests.AddressRequest;
import com.brightcoding.app.ws.responses.AddressResponse;
import com.brightcoding.app.ws.services.AddressService;
import com.brightcoding.app.ws.shared.dto.AddressDto;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	AddressService addressService;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AddressResponse> getOneAddresse(@PathVariable(name = "id") String addressId) {
		AddressDto addressDto = addressService.getAddress(addressId);

		ModelMapper modelMapper = new ModelMapper();
		AddressResponse addressResponse = modelMapper.map(addressDto, AddressResponse.class);
		return new ResponseEntity<AddressResponse>(addressResponse, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<AddressResponse>> getAddresses(Principal principal) {
		List<AddressDto> addresses = addressService.getAllAddresses(principal.getName());
		Type listType = new TypeToken<List<AddressDto>>() {
		}.getType();
		List<AddressResponse> addressesResponse = new ModelMapper().map(addresses, listType);
		return new ResponseEntity<List<AddressResponse>>(addressesResponse, HttpStatus.OK);

	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AddressResponse> storeAddresse(@RequestBody AddressRequest addressRequest,
			Principal principal) {

		ModelMapper modelMapper = new ModelMapper();

		AddressDto addressDto = modelMapper.map(addressRequest, AddressDto.class);
		AddressDto createAddress = addressService.createAddress(addressDto, principal.getName());

		AddressResponse newAddress = modelMapper.map(createAddress, AddressResponse.class);

		return new ResponseEntity<AddressResponse>(newAddress, HttpStatus.CREATED);

	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AddressResponse> updateAddresse(@PathVariable(name = "id") String addressId,
			@RequestBody AddressRequest addressRequest) {

		ModelMapper modelMapper = new ModelMapper();
		AddressDto addressDto = modelMapper.map(addressRequest, AddressDto.class);

		AddressDto updateAddresse = addressService.updateAddress(addressId, addressDto);

		AddressResponse addressResponse = modelMapper.map(updateAddresse, AddressResponse.class);
		return new ResponseEntity<>(addressResponse, HttpStatus.ACCEPTED);

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteAddresse(@PathVariable(name="id") String addressId) {
		addressService.deleteAddress(addressId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
