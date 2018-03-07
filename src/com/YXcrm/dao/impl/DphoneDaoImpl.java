/**
 * 
 */
package com.YXcrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.YXcrm.dao.DphoneDao;
import com.YXcrm.model.Dphone;
import com.YXcrm.model.Record;
import com.YXcrm.utility.DBUtility;

/**
 * @author LiuXin
 * @date 2018-2-8 下午2:28:39
 * @version
 */
public class DphoneDaoImpl implements DphoneDao {
	private Connection connection;
	boolean daoFlag = false;

	public DphoneDaoImpl() {
		System.out.println("connection对象在DphoneDaoImpl连接!");
	}

	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public boolean insert(Dphone dphone) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		connection = DBUtility.open();
		try {
			preparedStatement = connection
					.prepareStatement("insert into t_dphone(phoneNO,yxstuUuid,empDitUuid,uuid) values(?,?,?,?)");
			preparedStatement.setString(1, dphone.getPhoneNO());
			preparedStatement.setString(2, dphone.getYxstuUuid());
			preparedStatement.setString(3, dphone.getEmpDitUuid());
			preparedStatement.setString(4, dphone.getUuid());
			preparedStatement.executeUpdate();
			System.out.println("^^在执行DphoneDaoImpl中的添加insert");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("^^在执行DphoneDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
			e.printStackTrace();
			daoFlag = false;
			return daoFlag;

		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}
	}

	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		PreparedStatement PSdelete = null;
		connection = DBUtility.open();

		try {
			PSdelete = connection
					.prepareStatement("delete from t_dphone where uuid='"
							+ uuid + "'");
			PSdelete.executeUpdate();
			System.out.println("^^在执行DphoneDaoImpl中的删除delete");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("^^在执行DphoneDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, PSdelete, connection);
		}
	}

	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public boolean deleteByYXstuUid(String YXstuUid) {
		// TODO Auto-generated method stub
		PreparedStatement PSdelete = null;
		connection = DBUtility.open();

		try {
			PSdelete = connection
					.prepareStatement("delete from t_dphone where yxstuUuid='"
							+ YXstuUid + "'");
			PSdelete.executeUpdate();
			System.out.println("^^在执行DphoneDaoImpl中的删除deleteByDitchUuid");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("^^在执行DphoneDaoImpl中deleteByDitchUuid,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, PSdelete, connection);
		}
		//代码修改处
	}//end method

	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Dphone> getList() {
		// TODO Auto-generated method stub
		ArrayList<Dphone> dphoneList = new ArrayList<Dphone>();
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_dphone");
			while (rs.next()) {
				Dphone dphone = new Dphone();
				dphone.setUuid(rs.getString("uuid"));
				dphone.setPhoneNO(rs.getString("phoneNO"));
//				dphone.setDitchUuid(rs.getString("ditchUuid"));
				dphone.setEmpDitUuid(rs.getString("empDitUuid"));
				dphoneList.add(dphone);
			}
			return dphoneList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DphoneDaoImpl的查询列表失败");
			Dphone dphone = new Dphone();
			dphone.setUuid("DphoneDaoImpl查询失败返回的uuid");
			ArrayList<Dphone> listDphone = new ArrayList<Dphone>();
			listDphone.add(dphone);
			return listDphone;
		} finally {
			DBUtility.close(rs, statement, connection);
		}
	}

	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dphone> getListByDitchUuid(String ditchUuid) {
		// TODO Auto-generated method stub
		ArrayList<Dphone> dphoneList = new ArrayList<Dphone>();
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_dphone where ditchUuid='"+ditchUuid+"'");
			while (rs.next()) {
				Dphone dphone = new Dphone();
				dphone.setUuid(rs.getString("uuid"));
				dphone.setPhoneNO(rs.getString("phoneNO"));
//				dphone.setDitchUuid(rs.getString("ditchUuid"));
				dphone.setEmpDitUuid(rs.getString("empDitUuid"));
				dphoneList.add(dphone);
			}
			return dphoneList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DphoneDaoImpl的根据ditchUuid查询列表失败");
			Dphone dphone = new Dphone();
//			dphone.setDitchUuid("DphoneDaoImpl查询失败返回的ditchUuid");
			ArrayList<Dphone> listDphone = new ArrayList<Dphone>();
			listDphone.add(dphone);
			return listDphone;
		} finally {
			DBUtility.close(rs, statement, connection);
		}
	}

	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dphone> getListByPhoneNO(String phoneNO) {
		// TODO Auto-generated method stub
		ArrayList<Dphone> dphoneList = new ArrayList<Dphone>();
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_dphone where phoneNO='"+phoneNO+"'");
			while (rs.next()) {
				Dphone dphone = new Dphone();
				dphone.setUuid(rs.getString("uuid"));
				dphone.setPhoneNO(rs.getString("phoneNO"));
				dphone.setYxstuUuid(rs.getString("yxstuUuid"));
				dphone.setEmpDitUuid(rs.getString("empDitUuid"));
				dphoneList.add(dphone);
			}
			return dphoneList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DphoneDaoImpl的根据phoneNO查询列表失败");
			Dphone dphone = new Dphone();
			dphone.setPhoneNO("DphoneDaoImpl查询失败返回的phoneNO");
			ArrayList<Dphone> listDphone = new ArrayList<Dphone>();
			listDphone.add(dphone);
			return listDphone;
		} finally {
			DBUtility.close(rs, statement, connection);
		}
	}

}
