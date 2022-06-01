package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dto.Encounter;

public interface EncounterService {

	public Encounter saveEncounter(Encounter encounter);
	public List<Encounter> getAllEncounterByPersonalId(int person_id);
	public Encounter getEncounterById(int id);
	public boolean deleteEncounterById(int id);
	public Encounter updateEncounterById(int id,Encounter encounter);
}
