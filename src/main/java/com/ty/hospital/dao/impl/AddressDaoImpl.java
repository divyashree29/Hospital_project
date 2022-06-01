package com.ty.hospital.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.AddressDao;
import com.ty.hospital.dto.Address;



public class AddressDaoImpl implements AddressDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Address saveAddress(Address address) {
		
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
		
		return address;
	}
	
    public Address getAddressById(int id) {
    	return entityManager.find(Address.class, id);
    }
    public Address updateAddressById(int id, Address Address) {
		
		Address address1 = entityManager.find(Address.class, id);
		address1.setId(Address.getId());
	    address1.setBranch(Address.getBranch());
		address1.setCountry(Address.getCountry());
		address1.setState(Address.getState());
		address1.setStreet(Address.getStreet());
		address1.setPin(Address.getPin());
		
		entityTransaction.begin();
		entityManager.merge(address1);
		entityTransaction.commit();
		return address1;
	}
  
	public boolean deleteAddressById(int id) {
		Address address = entityManager.find(Address.class, id);
		if(address != null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		}
    
}

