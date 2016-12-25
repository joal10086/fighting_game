package com.db.service;

import com.db.model.Item;
import com.utils.Page;

public interface ReportService extends UniversalService  {

	Page resourceAvailableList(String string, int pagenum, int pagesize, String i_text, String i_type);

	Page resourceWithPaymentList(String string, int pagenum, int pagesize, String i_text, String i_type);

	 

 
}
