package com.ty.hospital.dao;

import com.ty.hospital.dto.Address;

public interface AddressDao {

	public Address saveAddress(Address address);
	public boolean deleteAddressById(int id);
	public Address updateAddressById(int id,Address address);
	public Address getAddressById(int id);
	
	
	
}
