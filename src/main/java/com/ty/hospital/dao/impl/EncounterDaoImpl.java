package com.ty.hospital.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Person;

public class EncounterDaoImpl implements EncounterDao{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Encounter saveEncounter(Encounter encounter) {
		
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
		
		return encounter;
	}
	
	public Encounter getEncounterById(int id) {
		return entityManager.find(Encounter.class, id);
		}
	
	public boolean deleteEncounterById(int id) {
		Encounter encounter = entityManager.find(Encounter.class, id);
		if(encounter != null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		}
   

	public List<Encounter> getAllEncounterByPersonalId(int person_id) {
		Person person =	entityManager.find(Person.class,person_id);
		return person.getEncounter();
		
	}

	public Encounter updateEncounterById(int id,Encounter encounter1) {
		Encounter encounter = entityManager.find(Encounter.class, id);
		encounter.setId(encounter1.getId());
		encounter.setDateOfJoin(encounter1.getDateOfJoin());
		encounter.setDischarge(encounter1.getDischarge());
		encounter.setReason(encounter1.getReason());
	    encounter.setBranch(encounter1.getBranch());
	    encounter.setPerson(encounter1.getPerson());
	    encounter.setOrder(encounter1.getOrder());
	    encounter.setObservation(encounter1.getObservation());
	    entityTransaction.begin();
		entityManager.merge(encounter);
		entityTransaction.commit();
		return encounter1;
		
	}

	
}
