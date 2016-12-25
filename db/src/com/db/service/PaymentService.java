package com.db.service;

import com.db.model.Payment;
import com.utils.Page;

public interface PaymentService extends UniversalService  {

	Payment getPaymentById(int parseInt, String string);

	Page getPaymentList(String string, int pagenum, int pagesize, String i_text, String i_type);
 
}
