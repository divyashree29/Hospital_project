package com.ty.hospital.serviceImpl;

import java.util.List;

import com.ty.hospital.dao.impl.BranchDaoImpl;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.service.BranchService;

public class BranchServiceImpl implements BranchService {

	public Branch saveBranch(Branch branch) {
		return  branchDaoImpl.saveBranch(branch);
	}

	public Branch getBranchById(int id) {
		return branchDaoImpl.getBranchById(id);
	}

	public Branch getBranchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteBranchById(int id, Hospital hospital) {
		return branchDaoImpl.deleteBranchById(id);
		
	}

	public Branch updateBranchById(int id, Branch branch) {
		return branchDaoImpl.updateBranchById(id, branch);
		
	}

	public List<Branch> getAllBranches() {
		
		return null;
	}

}
