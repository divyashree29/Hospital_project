package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Item;

public interface ItemDao {

	public Item saveItem(Item item);
	public Item getItemById(int id);
	public Item updateItemById(int id,Item item);
	public List<Item> getAllItemByMedOrderId(int id);
	public boolean deleteItemById(int id);
	
}
