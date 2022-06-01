package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Observation;

public interface ObservationDao {

	public Observation saveobservation(Observation observation);
	public Observation getObservationByI(int id);
	public boolean removeObservation(int id);
	public List<Observation> getAllObservation(int id);
}
