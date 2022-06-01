package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dto.Observation;

public interface ObservationService {

	public Observation saveobservation(Observation observation);
	public Observation getObservationByI(int id);
	public boolean removeObservation(int id);
	public List<Observation> getAllObservation(int id);
}
