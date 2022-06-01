package com.ty.hospital.dao;

import com.ty.hospital.dto.Hospital;

public interface HospitalDao {

	public Hospital saveHospital(Hospital hospital);
	public Hospital getHospitalById(int id);
	public Hospital updateHospitalById(int id,Hospital hospital);
	public boolean deleteHospitalById(int id);
	
}
