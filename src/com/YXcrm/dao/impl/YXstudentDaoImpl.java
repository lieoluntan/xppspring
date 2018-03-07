package com.YXcrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.YXcrm.dao.YXstudentDao;
import com.YXcrm.model.Employee;
import com.YXcrm.model.YXstudent;
import com.YXcrm.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-22 下午6:11:18
 * 类说明
 */

public class YXstudentDaoImpl implements YXstudentDao{
  
  private Connection connection;
  boolean daoFlag = false;

  public YXstudentDaoImpl() {
//    connection = DBUtility.open();
    System.out.println("connection对象在EmployeeDaoImpl连接!");
  }
  
  @Override
  public boolean insert(YXstudent yxstudent) {
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("insert into t_yxstudent(uuid,name,sex,phone,grade,school,weixin,parentRela,parentName,parentPhone,parentWeixin,parentRela2,parentName2,parentPhone2,parentWeixin2,empUuid,rank,source,courseYX,openAndclose,studentID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, yxstudent.getUuid());
      preparedStatement.setString(2, yxstudent.getName());
      preparedStatement.setString(3, yxstudent.getSex());
      preparedStatement.setString(4, yxstudent.getPhone());
      preparedStatement.setString(5, yxstudent.getGrade());
      preparedStatement.setString(6, yxstudent.getSchool());
      preparedStatement.setString(7, yxstudent.getWeixin());
      
      preparedStatement.setString(8, yxstudent.getParentRela());
      preparedStatement.setString(9, yxstudent.getParentName());
      preparedStatement.setString(10, yxstudent.getParentPhone());
      preparedStatement.setString(11, yxstudent.getParentWeixin());
      
      preparedStatement.setString(12,yxstudent.getParentRela2());
      preparedStatement.setString(13, yxstudent.getParentName2());
      preparedStatement.setString(14,yxstudent.getParentPhone2());
      preparedStatement.setString(15, yxstudent.getParentWeixin2());
      
      preparedStatement.setString(16, yxstudent.getEmpUuid());
      preparedStatement.setString(17, yxstudent.getRank());
      preparedStatement.setString(18, yxstudent.getSource());
      preparedStatement.setString(19, yxstudent.getCourseYX());
      preparedStatement.setInt(21, yxstudent.getStudentID());
      preparedStatement.setString(20, "open");//新增统一为打开open
      preparedStatement.executeUpdate();

      System.out.println("^^在执行EmployeeDaoImpl中的insert添加");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行YXstudentDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method insert

  @Override
  public ArrayList<YXstudent> getList() {
 // TODO Auto-generated method stub
    ArrayList<YXstudent> yxstuList = new ArrayList<YXstudent>();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("SELECT t_yxstudent.* FROM t_employee,t_yxstudent WHERE t_yxstudent.empUuid=t_employee.uuid;");
        while (rs.next()) {
          YXstudent yxstudent = new YXstudent();
          yxstudent.setUuid(rs.getString("uuid"));
          yxstudent.setName(rs.getString("name"));
          yxstudent.setSex(rs.getString("sex"));
          yxstudent.setPhone(rs.getString("phone"));
          yxstudent.setGrade(rs.getString("grade"));
          yxstudent.setSchool(rs.getString("school"));
          yxstudent.setWeixin(rs.getString("weixin"));
          
          yxstudent.setParentRela(rs.getString("parentRela"));
          yxstudent.setParentName(rs.getString("parentName"));
          yxstudent.setParentPhone(rs.getString("parentPhone"));
          yxstudent.setParentWeixin(rs.getString("parentWeixin"));

          yxstudent.setParentRela2(rs.getString("parentRela2"));
          yxstudent.setParentName2(rs.getString("parentName2"));
          yxstudent.setParentPhone2(rs.getString("parentPhone2"));
          yxstudent.setParentWeixin2(rs.getString("parentWeixin2"));

          yxstudent.setEmpUuid(rs.getString("empUuid"));
          yxstudent.setRank(rs.getString("rank"));
          yxstudent.setSource(rs.getString("source"));
          yxstudent.setCourseYX(rs.getString("courseYX"));
          
          yxstudent.setOpenAndclose(rs.getString("openAndclose"));
          yxstudent.setEmpName(rs.getString("empName"));
          
          yxstuList.add(yxstudent);
        }
        
        return yxstuList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("getList查询失败");
        YXstudent X = new YXstudent();
        X.setUuid("EmployeeDaoImpl的getList失败返回的uuid");
        ArrayList<YXstudent> XList = new ArrayList<YXstudent>();
        XList.add(X);
        return XList;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接
    
  }//end method

  @Override
  public boolean delete(String uuid) {
 // TODO Auto-generated method stub
    PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_yxstudent WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行yxstudentDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行yxstudentDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接  
  }//end method

  @Override
  public boolean update(YXstudent yxstudent) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("UPDATE t_yxstudent SET name = ?, sex = ?,phone = ?, grade = ?, school = ?, weixin = ?,parentRela = ?,parentName = ?,parentPhone = ?,parentWeixin = ?,parentRela2 = ?,parentName2 = ?, parentPhone2 = ?, parentWeixin2 = ?, empUuid = ?, rank = ?, source = ?, courseYX = ?  WHERE uuid = ? ");
      // Parameters start with 1
       
       preparedStatement.setString(1, yxstudent.getName());
       preparedStatement.setString(2, yxstudent.getSex());
       preparedStatement.setString(3, yxstudent.getPhone());
       preparedStatement.setString(4, yxstudent.getGrade());
       preparedStatement.setString(5, yxstudent.getSchool());
       preparedStatement.setString(6, yxstudent.getWeixin());
       
       preparedStatement.setString(7, yxstudent.getParentRela());
       preparedStatement.setString(8, yxstudent.getParentName());
       preparedStatement.setString(9, yxstudent.getParentPhone());
       preparedStatement.setString(10, yxstudent.getParentWeixin());
       
       preparedStatement.setString(11,yxstudent.getParentRela2());
       preparedStatement.setString(12, yxstudent.getParentName2());
       preparedStatement.setString(13,yxstudent.getParentPhone2());
       preparedStatement.setString(14, yxstudent.getParentWeixin2());
       
       preparedStatement.setString(15, yxstudent.getEmpUuid());
       preparedStatement.setString(16, yxstudent.getRank());
       preparedStatement.setString(17, yxstudent.getSource());
       preparedStatement.setString(18, yxstudent.getCourseYX());
       
       preparedStatement.setString(19, yxstudent.getUuid());
       
      preparedStatement.executeUpdate();

      System.out.println("^^在执行yxstudentDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行yxstudentDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
    
  }//end method update

  @Override
  public boolean updateOnOff(String uuid, String oAc) {
 // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("UPDATE t_yxstudent SET openAndclose = ?  WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, oAc);
      preparedStatement.setString(2, uuid);
      preparedStatement.executeUpdate();

      System.out.println("^^在执行ClassRoomDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行yxstudentDaoImpl中updateOnOff,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接 
  }//end method

  @Override
  public YXstudent getByUuid(String uuid) {
    // TODO Auto-generated method stub
    YXstudent yxstudentResult = new YXstudent();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_yxstudent WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          YXstudent yxstudent = new YXstudent();
          yxstudent.setUuid(rs.getString("uuid"));
          yxstudent.setName(rs.getString("name"));
          yxstudent.setSex(rs.getString("sex"));
          yxstudent.setPhone(rs.getString("phone"));
          yxstudent.setGrade(rs.getString("grade"));
          yxstudent.setSchool(rs.getString("school"));
          yxstudent.setWeixin(rs.getString("weixin"));
          
          yxstudent.setParentRela(rs.getString("parentRela"));
          yxstudent.setParentName(rs.getString("parentName"));
          yxstudent.setParentPhone(rs.getString("parentPhone"));
          yxstudent.setParentWeixin(rs.getString("parentWeixin"));

          yxstudent.setParentRela2(rs.getString("parentRela2"));
          yxstudent.setParentName2(rs.getString("parentName2"));
          yxstudent.setParentPhone2(rs.getString("parentPhone2"));
          yxstudent.setParentWeixin2(rs.getString("parentWeixin2"));

          yxstudent.setEmpUuid(rs.getString("empUuid"));
          yxstudent.setRank(rs.getString("rank"));
          yxstudent.setSource(rs.getString("source"));
          yxstudent.setCourseYX(rs.getString("courseYX"));
          
          yxstudent.setOpenAndclose(rs.getString("openAndclose"));
          
          yxstudentResult=yxstudent;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("YXstudentDaoImpl的getByUuid查询失败");
        YXstudent X = new YXstudent();
        X.setUuid("YXstudentDaoImpl的getList失败返回的uuid");
        return X;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接  

    System.out.println("dao返回的yxstudent根据getbyuuid"+yxstudentResult);
    return yxstudentResult;
  }// end method getByUuid

@Override
public int findMaxIdShow() {
	// TODO Auto-generated method stub
	 ArrayList<YXstudent> yxstuList = new ArrayList<YXstudent>();
	    Statement statement = null;//finally关闭数据库连接  
	    ResultSet rs = null;//关闭数据库连接get和getlist会用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	         statement = connection.createStatement();
	         rs = statement.executeQuery("SELECT t_employee.name AS empName,t_yxstudent.* FROM t_employee,t_yxstudent ORDER BY studentID DESC LIMIT 0,1");
	        while (rs.next()) {
	          YXstudent yxstudent = new YXstudent();
	          yxstudent.setStudentID(rs.getInt("studentID"));
	          yxstuList.add(yxstudent);
	        }
	        
	        return yxstuList.get(0).getStudentID();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("getList查询失败");
	        YXstudent X = new YXstudent();
	        X.setUuid("YXstudentDaoImpl的findIdShow查询失败");
	        ArrayList<YXstudent> XList = new ArrayList<YXstudent>();
	        XList.add(X);
	        return XList.get(0).getStudentID();
	    }finally{   
	      DBUtility.close(rs, statement, connection);   
	     }//finally关闭jdbc与数据库连接
}

@Override
public YXstudent findId(int id) {
	// TODO Auto-generated method stub
	YXstudent yxstudentResult = new YXstudent();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_yxstudent where studentID="+id+"");
        while (rs.next()) {
          YXstudent yxstudent = new YXstudent();
          yxstudent.setStudentID(rs.getInt("studentID"));
          yxstudentResult=yxstudent;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("YXstudentDaoImpl的findId查询失败");
        YXstudent X = new YXstudent();
        X.setUuid("YXstudentDaoImpl的findId失败返回的uuid");
        return X;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接  

    System.out.println("dao返回的yxstudent根据getbyuuid"+yxstudentResult);
    return yxstudentResult;
}

@Override
public boolean updateStuId(int StuId,String uuid) {
	// TODO Auto-generated method stub
	 PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	       preparedStatement = connection
	          .prepareStatement("UPDATE t_yxstudent SET studentID = ?  WHERE uuid = ? ");
	      // Parameters start with 1
	      preparedStatement.setInt(1, StuId);
	      preparedStatement.setString(2, uuid);
	      preparedStatement.executeUpdate();

	      System.out.println("^^在执行YXstudentDaoImpl中的修改updateStuId");
	      daoFlag = true;
	      return daoFlag;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      System.out.println("^^在执行YXstudentDaoImpl中updateStuId,出现sql语法执行错误，请联系管理员!");
	      daoFlag = false;
	      return daoFlag;
	    }finally{
	      ResultSet rs = null; 
	      DBUtility.close(rs, preparedStatement, connection);   
	     }//finally关闭jdbc与数据库连接 
}
  

}//end class
