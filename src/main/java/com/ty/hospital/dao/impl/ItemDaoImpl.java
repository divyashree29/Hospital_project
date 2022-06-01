package com.ty.hospital.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.Item;


public class ItemDaoImpl implements ItemDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Item saveItem(Item item) {
		
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();

		return item;
	}

	public Item getItemById(int id) {
		Query query = entityManager.createQuery("SELECT u FROM Item u WHERE u.id = ?1" );
		query.setParameter(1,id);
		List<Item> Items = query.getResultList();
		Item item = null;
		if(Items.size()>0) {
			for(Item Item1: Items) {
				item = Item1;
				}
			return item;
			}
		     else {
			return null;
		}
		
	}

	public Item updateItemById(int id,Item items) {
	    Item item = entityManager.find(Item.class, id);
		item.setId(items.getId());
		item.setItemName(items.getItemName());
		item.setQuantity(items.getQuantity());
		item.setCost(items.getCost());
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
		return item;
		
	}

	public List<Item> getAllItemByItemId(int id) {
      Query query = entityManager.createQuery("SELECT u FROM Item u");
		return query.getResultList();
		
	}

	public boolean deleteItemById(int id) {
		Item item = entityManager.find(Item.class, id);
		if(item != null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
			}
		
	}

	public List<Item> getAllItemByMedOrderId(int id) {
		Query query = entityManager.createQuery("SELECT u FROM Medorder u");
		return query.getResultList();
	
	}



}
