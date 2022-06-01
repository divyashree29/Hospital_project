package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;

public interface BranchDao {

	public Branch saveBranch(Branch branch);
	public Branch getBranchById(int id);
	public Branch getBranchByName(String name);
	public boolean deleteBranchById(int id, Hospital hospital);
	public Branch updateBranchById(int id,Branch branch);
	public List<Branch> getAllBranches();
	
}
