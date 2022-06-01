package com.ty.hospital.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.MedOrderDao;
import com.ty.hospital.dto.MedOrder;
import com.ty.hospital.dto.MedOrder;
import com.ty.hospital.dto.MedOrder;

public class MedOrderDaoImpl implements MedOrderDao{

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public MedOrder saveMedOrder(MedOrder medOrder) {
		
		entityTransaction.begin();
		entityManager.persist(medOrder);
		entityTransaction.commit();
		
		return medOrder;
	}

	public MedOrder updateMedOrder(int id,MedOrder medOrder1) {
		MedOrder medOrder = entityManager.find(MedOrder.class, id);
		medOrder.setId(medOrder1.getId());
		medOrder.setDoctorname(medOrder1.getDoctorname());
		medOrder.setOrderDate(medOrder.getOrderDate());
		medOrder.setEncounter(medOrder.getEncounter());
		medOrder.setItems(medOrder.getItems());
		entityTransaction.begin();
		entityManager.merge(medOrder);
		entityTransaction.commit();
		return medOrder;
	}
	public boolean deleteMedOrder(int id) {
		MedOrder medOrder = entityManager.find(MedOrder.class, id);
		if(medOrder != null) {
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		
	}

	public MedOrder getOrder(int id) {
		return entityManager.find(MedOrder.class, id);
		
	}

	public List<MedOrder> getAllMedOrder(int id) {
	Query query = entityManager.createQuery("SELECT u FROM Medorder u");
		return query.getResultList();
	}

	
}
