package com.YXcrm.query.nameQuery.dao;

import java.util.List;

import com.YXcrm.model.Employee;


/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午4:42:26
 *
 */
public interface NameReEmpDao {
	public List<Employee> getStuByName(Employee employee);
}
