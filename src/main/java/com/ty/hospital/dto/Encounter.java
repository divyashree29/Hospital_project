package com.ty.hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Encounter {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reason;
	private String dateOfJoin;
	private String discharge;
	@OneToMany
	List<Observation> observation;
	
	public List<Observation> getObservation() {
		return observation;
	}
	public void setObservation(List<Observation> observation) {
		this.observation = observation;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public MedOrder getOrder() {
		return order;
	}
	public void setOrder(MedOrder order) {
		this.order = order;
	}
	@OneToOne
	Person person;
	@ManyToOne
	Branch branch;
	@OneToMany
	MedOrder order;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public String getDischarge() {
		return discharge;
	}
	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}
	
	
	
}
