package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dto.MedOrder;

public interface MedOrderService {

	public MedOrder saveMedOrder(MedOrder medorder);
	public MedOrder getOrder(int id);
	public List<MedOrder> getAllMedOrder(int id);
	public MedOrder updateMedOrder(int id,MedOrder medorder1);
	public boolean deleteMedOrder(int id);
}
