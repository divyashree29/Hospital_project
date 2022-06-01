package com.ty.hospital.service;

import com.ty.hospital.dto.Address;

public interface AddressService {

	public Address saveAddress(Address address);
	public boolean deleteAddressById(int id);
	public Address updateAddressById(int id,Address address);
	public Address getAddressById(int id);
	
	
	
}
