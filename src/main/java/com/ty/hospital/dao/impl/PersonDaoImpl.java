package com.ty.hospital.dao.impl;
import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class PersonDaoImpl implements PersonDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Person savePerson(Person person) {
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		return person;
	}

	public boolean deletePersonById(int id) {
		Person person = entityManager.find(Person.class, id);
		if(person != null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		}

		

	public Person updatePerson(int id,Person persons) {
		Person person = entityManager.find(Person.class, id);
		person.setId(persons.getId());
		person.setName(persons.getName()); 
		person.setDob(persons.getDob());
		person.setAge(persons.getAge());
		person.setAddress(persons.getAddress());
		person.setEmail(persons.getEmail());
		person.setPhno(persons.getPhno());
		person.setGender(persons.getGender());
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
		return person;
	}

	public Person getPersonById(int id) {
		return entityManager.find(Person.class, id);
		
	}

	public List<Person> getAllPerson() {
		Query query = entityManager.createQuery("SELECT u FROM Person u");
		return query.getResultList();
		
	}

}
