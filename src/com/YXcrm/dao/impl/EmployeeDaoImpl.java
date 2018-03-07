package com.YXcrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.YXcrm.dao.EmployeeDao;
import com.YXcrm.model.Employee;
import com.YXcrm.utility.DBUtility;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-13 下午4:59:08 类说明
 */

public class EmployeeDaoImpl implements EmployeeDao {

  private Connection connection;
  boolean daoFlag = false;

  public EmployeeDaoImpl() {
//    connection = DBUtility.open();
    System.out.println("connection对象在EmployeeDaoImpl连接!");
  }

  @Override
  public boolean insert(Employee employee) {
    
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("insert into t_employee(uuid,name,empNum,phone,depart,job,remark,claTeacher,sex,org,workDate,fullhalf,jobRemark,openAndclose) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, employee.getUuid());
      preparedStatement.setString(2, employee.getName());
      preparedStatement.setString(3, employee.getEmpNum());
      preparedStatement.setString(4, employee.getPhone());
      preparedStatement.setString(5, employee.getDepart());
      preparedStatement.setString(6, employee.getJob());
      preparedStatement.setString(7, employee.getRemark());
      preparedStatement.setString(8, employee.getClaTeacher());
      
      preparedStatement.setString(9, employee.getSex());
      preparedStatement.setString(10, employee.getOrg());
      preparedStatement.setString(11, employee.getWorkDate());
      preparedStatement.setString(12, employee.getFullhalf());
      preparedStatement.setString(13, employee.getJobRemark());
      preparedStatement.setString(14, "open");//新增统一为打开open
      preparedStatement.executeUpdate();

      System.out.println("^^在执行EmployeeDaoImpl中的insert添加");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行EmployeeDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method insert

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_employee WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行EmployeeDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行EmployeeDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method delete

  @Override
  public boolean update(Employee employee) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("UPDATE t_employee SET name = ?, empNum = ?,phone = ?, depart = ?, job = ?, remark = ?,claTeacher = ?,sex = ?,org = ?,workDate = ?,fullhalf = ?,jobRemark = ?  WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, employee.getName());
      preparedStatement.setString(2, employee.getEmpNum());
      preparedStatement.setString(3, employee.getPhone());
      preparedStatement.setString(4, employee.getDepart());
      preparedStatement.setString(5, employee.getJob());
      preparedStatement.setString(6, employee.getRemark());
      
      preparedStatement.setString(7, employee.getClaTeacher());
      preparedStatement.setString(8, employee.getSex());
      preparedStatement.setString(9, employee.getOrg());
      preparedStatement.setString(10, employee.getWorkDate());
      preparedStatement.setString(11, employee.getFullhalf());
      preparedStatement.setString(12, employee.getJobRemark());
      
      preparedStatement.setString(13, employee.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行EmployeeDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行EmployeeDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method update

  @Override
  public Employee getByUuid(String uuid) {
    // TODO Auto-generated method stub
    Employee employeeResult = new Employee();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_employee WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          Employee employee = new Employee();
          employee.setUuid(rs.getString("uuid"));
          employee.setName(rs.getString("name"));
          employee.setEmpNum(rs.getString("empNum"));             
          employee.setPhone(rs.getString("phone"));
          employee.setDepart(rs.getString("depart"));
          employee.setJob(rs.getString("job"));
          employee.setRemark(rs.getString("remark"));
          
          employeeResult=employee;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ClaDaoImpl的getByUuid查询失败");
        Employee employeeX = new Employee();
        employeeX.setUuid("ClaDaoImpl失败返回的uuid");
        return employeeX;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接  

    return employeeResult;
  }// end method getByUuid

  @Override
  public ArrayList<Employee> getList() {
    // TODO Auto-generated method stub
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_employee");
        while (rs.next()) {
          Employee employee = new Employee();
          employee.setUuid(rs.getString("uuid"));
          employee.setName(rs.getString("name"));
          employee.setEmpNum(rs.getString("empNum"));             
          employee.setPhone(rs.getString("phone"));
          employee.setDepart(rs.getString("depart"));
          employee.setJob(rs.getString("job"));
          employee.setRemark(rs.getString("remark"));
          
          employee.setClaTeacher(rs.getString("claTeacher"));
          employee.setSex(rs.getString("sex"));
          employee.setOrg(rs.getString("org"));
          employee.setWorkDate(rs.getString("workDate"));
          employee.setFullhalf(rs.getString("fullhalf"));
          employee.setJobRemark(rs.getString("jobRemark"));
          employee.setOpenAndclose(rs.getString("openAndclose"));
          
          employeeList.add(employee);
        }
        
        return employeeList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("EmployeeDaoImpl的getList查询失败");
        Employee employeeX = new Employee();
        employeeX.setUuid("EmployeeDaoImpl的getList失败返回的uuid");
        ArrayList<Employee> employeeListX = new ArrayList<Employee>();
        employeeListX.add(employeeX);
        return employeeListX;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接

    
  }//emd method getList

  @Override
  public ArrayList<Employee> getclaTeaList() {
    // TODO Auto-generated method stub
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_employee WHERE claTeacher = 'true' ");
        while (rs.next()) {
          Employee employee = new Employee();
          employee.setUuid(rs.getString("uuid"));
          employee.setName(rs.getString("name"));
          employee.setEmpNum(rs.getString("empNum"));             
          employee.setPhone(rs.getString("phone"));
          employee.setDepart(rs.getString("depart"));
          employee.setJob(rs.getString("job"));
          employee.setRemark(rs.getString("remark"));
          
          employeeList.add(employee);
        }
        
        return employeeList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("EmployeeDaoImpl的getList查询失败");
        Employee employeeX = new Employee();
        employeeX.setUuid("EmployeeDaoImpl的getList失败返回的uuid");
        ArrayList<Employee> employeeListX = new ArrayList<Employee>();
        employeeListX.add(employeeX);
        return employeeListX;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接

    
  }//emd method getclaTeaList

@Override
public boolean updateOnOff(String uuid, String oAc) {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("UPDATE t_employee SET openAndclose = ?  WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, oAc);
      preparedStatement.setString(2, uuid);
      preparedStatement.executeUpdate();

      System.out.println("^^在执行ClassRoomDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行ClassRoomDaoImpl中updateOnOff,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接 
}//end method

}//end class
