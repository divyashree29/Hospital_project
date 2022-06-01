package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dto.Person;

public interface PersonService {

	public Person savePerson(Person person);
	public boolean deletePersonById(int id);
	public Person updatePerson(int id,Person person);
	public Person getPersonById(int id);
	public List<Person> getAllPerson();
}
