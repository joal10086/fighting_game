package com.db.dao;

import java.util.ArrayList;

import com.db.model.Item;
import com.db.model.Payment;

public interface PaymentDao extends UniversalDao {

	Payment getPaymentById(int parseInt, String string);

	int getInforCount(String string);

	ArrayList<Payment> getInforList(String string, int pagenum, int pagesize, String i_text, String i_type);

 

}
