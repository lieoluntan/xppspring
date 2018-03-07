package com.YXcrm.query.service.impl;

import java.util.ArrayList;

import com.YXcrm.dao.EmployeeDao;
import com.YXcrm.dao.impl.EmployeeDaoImpl;
import com.YXcrm.model.Employee;
import com.YXcrm.model.YXstudent;
import com.YXcrm.query.dao.MyYXstudentDao;
import com.YXcrm.query.dao.impl.MyYXstudentDaoImpl;
import com.YXcrm.query.service.MyYXstudentService;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2018-2-23 下午4:44:10 类说明
 */

public class MyYXstudentServiceImpl implements MyYXstudentService {
  
  private EmployeeDao  employeeDao = new EmployeeDaoImpl();
  private MyYXstudentDao MyYXstudentDao = new MyYXstudentDaoImpl();

  @Override
  public ArrayList<YXstudent> getListByEmpUuid(String empUuid) {
    // TODO Auto-generated method stub
    if (empUuid != null && empUuid != "") {
      ArrayList<YXstudent> yxList = MyYXstudentDao.getListByEmpUuid(empUuid);
      for (int i = 0; i < yxList.size(); i++) {
        Employee employee = employeeDao.getByUuid(empUuid);
        yxList.get(i).setEmpName(employee.getName());
      }
      return yxList;
    } else {
      System.out.println("MyDitchServiceImpl getListByEmpUuid方法中的empUuid为空，或格式不正确，请联系管理员");
      return new ArrayList<YXstudent>();
    }
  }// end method

}// end class
