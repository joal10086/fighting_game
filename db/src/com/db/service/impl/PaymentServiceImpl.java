package com.db.service.impl;

import java.util.ArrayList;

import com.db.dao.PaymentDao;
import com.db.model.Item;
import com.db.model.Payment;
import com.db.service.PaymentService;
import com.utils.Page;

public class PaymentServiceImpl extends UniversalServiceImpl implements PaymentService {
	private PaymentDao paymentDao;
	
	
	public PaymentDao getPaymentDao(){
		return this.paymentDao;
	}
	
	public void setPaymentDao(PaymentDao paymentDao){
		this.paymentDao= paymentDao;
	}

	@Override
	public Payment getPaymentById(int parseInt, String string) {
		return paymentDao.getPaymentById(parseInt,string);
	}

	@Override
	public Page getPaymentList(String string, int pagenum, int pagesize, String i_text, String i_type) {
		ArrayList<Payment> list = paymentDao.getInforList(string, pagenum, pagesize,i_text,i_type);
		int rows=paymentDao.getInforCount(string);
		Page page=new Page(list,pagenum,rows,pagesize);
		return page;
	}
}
