package com.ty.hospital.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;

public class BranchDaoImpl implements BranchDao{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Branch saveBranch(Branch branch) {
		
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		
		return branch;
	}
	
	public Branch getBranchById(int id) {
		Query query = entityManager.createQuery("SELECT u FROM Branch u WHERE u.id = ?1" );
		query.setParameter(1,id);
		List<Branch> Branches = query.getResultList();
		Branch Branch = null;
		if(Branches.size()>0) {
			for(Branch Branch1: Branches) {
				Branch = Branch1;
				}
			return Branch;
			}
		     else {
			return null;
		}
		
	}
	
	public Branch getBranchByName(String name) {
		Query query = entityManager.createQuery("SELECT u FROM Branch u WHERE u.name = ?1" );
		query.setParameter(1,name);
		List<Branch> Branches = query.getResultList();
		Branch Branch = null;
		if(Branches.size()>0) {
			for(Branch Branch1: Branches) {
				Branch = Branch1;
				}
			return Branch;
			}
		     else {
			return null;
		     }
	}
	
	public boolean deleteBranchById(int id, Hospital hospital) {
		Branch branch = entityManager.find(Branch.class, id);
		if(branch != null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		
	}
    public Branch updateBranchById(int id, Branch branch) {
		
    	Branch branch1 = entityManager.find(Branch.class, id);
		branch1.setId(branch.getId());
		branch1.setName(branch.getName());
		branch1.setEmail(branch.getEmail());
		branch1.setPhone(branch.getPhone());
		branch1.setAddress(branch.getAddress());
		branch1.setEncounter(branch.getEncounter());;
		entityTransaction.begin();
		entityManager.merge(branch1);
		entityTransaction.commit();
		return branch1;
    }
    

     public List<Branch> getAllBranches() {
		Query query = entityManager.createQuery("SELECT u FROM Branch u");
		List<Branch> branchs = query.getResultList();
		if(branchs.size()>0) {
		return branchs;
	}
		else {
			return null;
		}
	}
    
   
	}
	
	

	

	

	

	



