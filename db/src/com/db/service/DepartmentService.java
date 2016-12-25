package com.db.service;

import com.db.model.Department;
import com.utils.Page;

public interface DepartmentService extends UniversalService  {

	Department findDeptById(int dept_id);

	Page getDept(String string, int pagenum, int pagesize, String dept_text, String dept_type);

	Department findDeptByName(String dept_name);
 
}
