package com.db.dao;

import java.util.ArrayList;

import com.db.model.Department;

public interface DepartmentDao extends UniversalDao {

	Department findDeptById(int dept_id);

	ArrayList<Department> getInfor(String flag, int pagenum, int pagesize, String dept_text, String dept_type);

	int getDeptCount(String flag);

	Department findDeptByName(String dept_name);

 

}
