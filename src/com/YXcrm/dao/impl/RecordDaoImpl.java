package com.YXcrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.YXcrm.dao.RecordDao;
import com.YXcrm.model.Record;
import com.YXcrm.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-26 下午6:27:53
 * 类说明
 */

public class RecordDaoImpl implements RecordDao{
  
  private Connection connection;
  boolean daoFlag = false;

  public RecordDaoImpl() {
      System.out.println("connection对象在RecordDaoImpl中连接");
  }

  @Override
  public boolean insert(Record record) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null;
    connection = DBUtility.open();

    try {
        preparedStatement = connection
                .prepareStatement("insert into t_record (yxstuUuid,recordDate,remarkText,uuid) values (?,?,?,?)");
        preparedStatement.setString(1, record.getYxstuUuid());
        preparedStatement.setString(2, record.getRecordDate());
        preparedStatement.setString(3, record.getRemarkText());
        preparedStatement.setString(4, record.getUuid());
        preparedStatement.executeUpdate();
        System.out.println("^^在执行RecordDaoImpl中的添加insert");
        daoFlag = true;
        return daoFlag;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        System.out.println("^^在执行RecordDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
        e.printStackTrace();
        daoFlag = false;
        return daoFlag;
    } finally {
        ResultSet rs = null;
        DBUtility.close(rs, preparedStatement, connection);
    }
  }//end method

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_record WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行recordDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行recordDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接  
  }//end method

  @Override
  public boolean update(Record record) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("UPDATE t_record SET recordDate = ?,remarkText = ?  WHERE uuid = ? ");
      // Parameters start with 1
       
       preparedStatement.setString(1, record.getRecordDate());
       preparedStatement.setString(2, record.getRemarkText());
       preparedStatement.setString(3, record.getUuid());
       
       preparedStatement.executeUpdate();

      System.out.println("^^在执行recordDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行recordDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
    
  }//end method update

  @Override
  public ArrayList<Record> getListByYxUuid(String yxstuUuid) {
    // TODO Auto-generated method stub
    ArrayList<Record> recordList = new ArrayList<Record>();
    Statement statement = null;
    ResultSet rs = null;
    connection = DBUtility.open();
    try {
        statement = connection.createStatement();
        rs = statement.executeQuery("select * from t_record where yxstuUuid='"+yxstuUuid+"'");
        while (rs.next()) {
            Record record = new Record();
            record.setUuid(rs.getString("uuid"));
            record.setYxstuUuid(rs.getString("yxstuUuid"));
            record.setRecordDate(rs.getString("recordDate"));
            record.setRemarkText(rs.getString("remarkText"));
            recordList.add(record);
        }
        return recordList;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("RecordDaoImpl的查询跟踪记录表列表失败");
        Record record = new Record();
        record.setYxstuUuid("RecordDaoImpl查询失败返回的uuid");
        ArrayList<Record> listRecord = new ArrayList<Record>();
        listRecord.add(record);
        return listRecord;
    } finally {
        DBUtility.close(rs, statement, connection);
    }
  }//emd method

}//end class
