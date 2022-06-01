package com.ty.hospital.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Hospital;

public class HospitalDaoImpl implements HospitalDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Hospital saveHospital(Hospital hospital) {
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		
		return hospital;
	}
	
    public Hospital getHospitalById(int id) {
    	return entityManager.find(Hospital.class, id);
    }
    public Hospital updateHospitalById(int id, Hospital hospital) {
		
		Hospital hospital1 = entityManager.find(Hospital.class, id);
		hospital1.setId(hospital.getId());
		hospital1.setName(hospital1.getName());
		hospital1.setBranch(hospital1.getBranch());
		hospital1.setWebsite(hospital1.getWebsite());
		entityTransaction.begin();
		entityManager.merge(hospital1);
		entityTransaction.commit();
		return hospital1;
	}
  
	public boolean deleteHospitalById(int id) {
		Hospital hospital = entityManager.find(Hospital.class, id);
		if(hospital != null) {
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		}
    
}
