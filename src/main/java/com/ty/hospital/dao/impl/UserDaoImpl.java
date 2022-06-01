
package com.ty.hospital.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.UserDao;
import com.ty.hospital.dto.User;

public class UserDaoImpl implements UserDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public User saveUser(User user) {
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		return user;
	}
	
    public User updateUser(int User_id, User user) {
		
		User user1 = entityManager.find(User.class, User_id);
		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setPhone(user.getPhone());
		user1.setRole(user.getRole());
		entityTransaction.begin();
		entityManager.merge(user1);
		entityTransaction.commit();
		return user1;
	}
    
    public boolean deleteUser(int User_id) {
		User user = entityManager.find(User.class, User_id);
		if(user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		}
    
    public User getUserById(int User_id) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = ?1" );
		query.setParameter(1,User_id);
		List<User> users = query.getResultList();
		User user = null;
		if(users.size()>0) {
			for(User user1: users) {
				user = user1;
				}
			return user;
			}
		     else {
			return null;
		}
		
	}

    public User getUserByRole(String role) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.role = ?1" );
		query.setParameter(1,role);
		List<User> users = query.getResultList();
		User user = null;
		if(users.size()>0) {
			for(User user1: users) {
				user = user1;
				}
			return user;
			}
		    else {
		    return null;
	}
}
    
    public User getUserByPhone(long phone) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.phone = ?1" );
		query.setParameter(1,phone);
		List<User> users = query.getResultList();
		User user = null;
		if(users.size()>0) {
			for(User user1: users) {
				user = user1;
				}
			return user;
			}
		    else {
		    return null;
	}
}
	public User validateUser(String email,String password) {
	
		Query query = entityManager.createQuery("SELECT u FROM u WHERE u.email=?1 AND u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<User> users = query.getResultList();
		User user1 = null;
		for(User user : users) {
			user1 = user;
		}
		if(user1 != null) {
			return user1;
		}
		else {
			return null;
		}
	}

	public List<User> getAllUsers() {
		Query query = entityManager.createQuery("SELECT u FROM USER u");
		List<User> users = query.getResultList();
		if(users.size()>0) {
		return users;
	}
		else {
			return null;
		}
	}



}



