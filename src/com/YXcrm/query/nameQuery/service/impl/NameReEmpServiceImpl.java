package com.YXcrm.query.nameQuery.service.impl;

import java.util.List;

import com.YXcrm.model.Employee;
import com.YXcrm.query.nameQuery.dao.NameReEmpDao;
import com.YXcrm.query.nameQuery.dao.impl.NameReEmpDaoImpl;
import com.YXcrm.query.nameQuery.service.NameReEmpService;
/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午4:44:26
 *
 */
public class NameReEmpServiceImpl implements NameReEmpService {
private NameReEmpDao nameReEmpDao=new NameReEmpDaoImpl();
@SuppressWarnings("unused")
@Override
public String getStuByName(Employee employee) {
	// TODO Auto-generated method stub
	String flag = "";

	List<Employee> stuList = nameReEmpDao.getStuByName(employee);
	for (Employee student2 : stuList) {

		if (student2.getUuid() != null) {
			flag = "（有重名）" + employee.getName();

			return flag;
		}

	}
	flag = "（无重名）" + employee.getName();

	return flag;
}

@Override
public String getStuByName1(Employee employee) {
	// TODO Auto-generated method stub
	String flag = "";

	List<Employee> stuList = nameReEmpDao.getStuByName(employee);
	for (Employee student2 : stuList) {

		if (student2.getUuid() != null) {
			flag = "yes";

			return flag;
		}

	}
	flag = "no";

	return flag;
}
	
	
}
