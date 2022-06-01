package com.ty.hospital.service;

import com.ty.hospital.dto.Hospital;

public interface HospitalService {

	public Hospital saveHospital(Hospital hospital);
	public Hospital getHospitalById(int id);
	public Hospital updateHospitalById(int id,Hospital hospital);
	public boolean deleteHospitalById(int id);
	
}
