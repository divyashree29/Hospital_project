package com.ty.hospital.serviceImpl;

import com.ty.hospital.dao.impl.AddressDaoImpl;
import com.ty.hospital.dto.Address;
import com.ty.hospital.service.AddressService;

public class AddressServiceImpl implements AddressService{
	AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
	
	public Address saveAddress(Address address) {
		return addressDaoImpl.saveAddress(address);
	}

	public boolean deleteAddressById(int id) {
		return addressDaoImpl.deleteAddressById(id);
	}

	public Address updateAddressById(int id, Address address) {
		return addressDaoImpl.updateAddressById(id, address);
	}

	public Address getAddressById(int id) {
		return addressDaoImpl.getAddressById(id);
	}

}
