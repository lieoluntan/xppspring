package com.YXcrm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.YXcrm.dao.EmployeeDao;
import com.YXcrm.dao.impl.EmployeeDaoImpl;
import com.YXcrm.model.Employee;
import com.YXcrm.query.nameQuery.dao.NameReEmpDao;
import com.YXcrm.query.nameQuery.dao.impl.NameReEmpDaoImpl;
import com.YXcrm.service.EmployeeService;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-13 下午4:50:04 类说明
 */

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private NameReEmpDao nameReEmpDao = new NameReEmpDaoImpl();
	Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	@Override
	public String insert(Employee employee) {
		// TODO Auto-generated method stub
		String flag = this.getStuByName1(employee);
		if (flag.equals("yes")) {

			return flag;

		} else {
			employee.setUuid(null);

			employee.setUuid(UUID.randomUUID().toString());
			System.out.println("^^在EmployeeServiceImpl收到数据 ："
					+ employee.toString() + "收到结束!");
			boolean daoFlag = employeeDao.insert(employee);
			if (daoFlag) {
				return employee.getUuid();
			} else {
				logger.error("插入不成功,dao层执行有出错地方,请联系管理员");
				return "插入不成功,dao层执行有出错地方,请联系管理员";
			}

		}

	}

	@Override
	public String delete(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			boolean daoFlag = employeeDao.delete(uuid);

			if (daoFlag) {
				return uuid;
			} else {
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "EmployeeServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}

	}// end method delete

	@Override
	public String update(Employee employee) {
		// TODO Auto-generated method stub
		String flag = this.getStuByName1(employee);
		if (flag.equals("yes")) {

			return flag;

		} else {
			String uuid = employee.getUuid();
			if (uuid != null && uuid != "") {

				boolean daoFlag = employeeDao.update(employee);

				if (daoFlag) {
					return uuid;
				} else {
					logger.error("修改不成功,dao层执行有出错地方,请联系管理员");
					return "修改不成功,dao层执行有出错地方,请联系管理员";
				}
			} else {
				String msg = "EmployeeServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
				System.out.println(msg);
				return msg;
			}

		}

	}// end method update

	@Override
	public Employee getByUuid(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			Employee employee = employeeDao.getByUuid(uuid);
			return employee;
		} else {
			System.out
					.println("ContractServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
			Employee employeeX = new Employee();
			return employeeX;
		}
	}// end method getByUuid

	@Override
	public ArrayList<Employee> getList() {
		// TODO Auto-generated method stub
		ArrayList<Employee> employeeList = employeeDao.getList();

		return employeeList;
	}// end method getList()

	@Override
	public ArrayList<Employee> getclaTeaList() {
		// TODO Auto-generated method stub
		ArrayList<Employee> employeeList = employeeDao.getclaTeaList();

		return employeeList;
	}// end method getList()

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
			//编辑验证重名要过滤掉自己本身的名字
			String s2Uuid = student2.getUuid();
			boolean flagSelf = s2Uuid.equals(employee.getUuid());
			boolean flagNotSelf = !flagSelf;
			if(flagNotSelf){//编辑验证重名要过滤

			if (student2.getUuid() != null) {
				flag = "yes";

				return flag;
			}
		 }//end if(flagNotSelf)

		}
		flag = "no";

		return flag;
	}

	@Override
	public String getonoff(Employee employee) {
		// TODO Auto-generated method stub
		String uuid = employee.getUuid();
		if(uuid!=null&&uuid!="")
	    {
		  String oAc = employee.getOpenAndclose();
	      boolean daoFlag = employeeDao.updateOnOff(uuid,oAc);
	      
	        if(daoFlag)
	        {
	        return "操作成功";
	        }else{
	        	logger.error("操作不成功,dao层执行有出错地方,请联系管理员");
	          return "操作失败,dao层执行有出错地方,请联系管理员";
	        }
	    }else{
	      String msg="ClassRoomServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
	      System.out.println(msg);
	      return msg;
	    }
	}//end method

}// end class
