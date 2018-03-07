package com.YXcrm.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.YXcrm.model.YXstudent;
import com.YXcrm.query.dao.MyYXstudentDao;
import com.YXcrm.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-23 下午4:55:28
 * 类说明
 */

public class MyYXstudentDaoImpl implements MyYXstudentDao{
  
  private Connection connection;

  public MyYXstudentDaoImpl() {
      System.out.println("connection对象在MyDitchDaoImpl中连接");
  }

  @Override
  public ArrayList<YXstudent> getListByEmpUuid(String empUuid) {
    // TODO Auto-generated method stub
    ArrayList<YXstudent> yxstuList = new ArrayList<YXstudent>();
    Statement statement = null;
    ResultSet rs = null;
    connection = DBUtility.open();
    try {
        statement = connection.createStatement();
        rs = statement
                .executeQuery("select * from t_yxstudent where empUuid='"
                        + empUuid + "'");
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
//          yxstudent.setEmpName(rs.getString("empName"));//这里查负责人名字是从serviceImpl里面查
          
          yxstuList.add(yxstudent);
        }
        return yxstuList;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("EmployeeDaoImpl的getList查询失败");
      YXstudent X = new YXstudent();
      X.setUuid("EmployeeDaoImpl的getList失败返回的uuid");
      ArrayList<YXstudent> XList = new ArrayList<YXstudent>();
      XList.add(X);
      return XList;
    } finally {
        DBUtility.close(rs, statement, connection);
    }
  }//end method

}//end class
