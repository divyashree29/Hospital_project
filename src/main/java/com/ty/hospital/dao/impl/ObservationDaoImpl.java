package com.ty.hospital.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.ObservationDao;
import com.ty.hospital.dto.Observation;
import com.ty.hospital.dto.Observation;

public class ObservationDaoImpl implements ObservationDao{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Observation saveobservation(Observation observation) {
		entityTransaction.begin();
		entityManager.persist(observation);
		entityTransaction.commit();

		return observation;
		
	}

	public Observation getObservationByI(int id) {
		Query query = entityManager.createQuery("SELECT u FROM Observation u WHERE u.id = ?1" );
		query.setParameter(1,id);
		List<Observation> observations = query.getResultList();
		Observation Observation = null;
		if(observations.size()>0) {
			for(Observation Observation1: observations) {
				Observation = Observation1;
				}
			return Observation;
			}
		     else {
			return null;
		}
		
	}
	
	public boolean removeObservation(int id) {
		Observation observation = entityManager.find(Observation.class, id);
		if(observation != null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		
	}

	public List<Observation> getAllObservation(int id) {
		Query query = entityManager.createQuery("SELECT u FROM Observation u");
		return query.getResultList();

	}
 
}
