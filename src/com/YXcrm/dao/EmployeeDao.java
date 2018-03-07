package com.YXcrm.dao;

import java.util.ArrayList;

import com.YXcrm.model.Employee;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-13 下午4:57:46
 * 类说明
 */

public interface EmployeeDao {
  
  public boolean insert(Employee employee);

  public boolean delete(String uuid);

  public boolean update(Employee employee);

  public Employee getByUuid(String uuid);

  public ArrayList<Employee> getList();

  public ArrayList<Employee> getclaTeaList();

public boolean updateOnOff(String uuid, String oAc);

}
