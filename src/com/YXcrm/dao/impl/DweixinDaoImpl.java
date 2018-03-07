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

import com.YXcrm.dao.DweixinDao;
import com.YXcrm.model.Dphone;
import com.YXcrm.model.Dweixin;
import com.YXcrm.utility.DBUtility;

/**
 * @author LiuXin
 * @date 2018-2-8 下午4:34:11
 * @version
 */
public class DweixinDaoImpl implements DweixinDao {
	private Connection connection;
	boolean daoFlag = false;

	public DweixinDaoImpl() {
		System.out.println("connection对象在DweixinDaoImpl连接!");
	}

	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public boolean insert(Dweixin dweixin) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		connection = DBUtility.open();
		try {
			preparedStatement = connection
					.prepareStatement("insert into t_dweixin(weixinNO,yxstuUuid,empDitUuid,uuid) values(?,?,?,?)");
			preparedStatement.setString(1, dweixin.getWeixinNO());
			preparedStatement.setString(2, dweixin.getYxstuUuid());
			preparedStatement.setString(3, dweixin.getEmpDitUuid());
			preparedStatement.setString(4, dweixin.getUuid());
			preparedStatement.executeUpdate();
			System.out.println("^^在执行DweixinDaoImpl中的添加insert");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("^^在执行DweixinDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
			e.printStackTrace();
			daoFlag = false;
			return daoFlag;

		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}
	}//end method 

	/* 
	 * @param
	 * @return
	 */
	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		PreparedStatement PSdelete = null;
		connection = DBUtility.open();

		try {
			PSdelete = connection
					.prepareStatement("delete from t_dweixin where uuid='"
							+ uuid + "'");
			PSdelete.executeUpdate();
			System.out.println("^^在执行DweixinDaoImpl中的删除delete");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("^^在执行DweixinDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, PSdelete, connection);
		}
	}

	/* 
	 * @param
	 * @return
	 */
	@Override
	public boolean deleteByYXstuUuid(String yxstuUuid) {
		// TODO Auto-generated method stub
		PreparedStatement PSdelete = null;
		connection = DBUtility.open();

		try {
			PSdelete = connection
					.prepareStatement("delete from t_dweixin where yxstuUuid='"
							+ yxstuUuid + "'");
			PSdelete.executeUpdate();
			System.out.println("^^在执行DweixinDaoImpl中的删除deleteByYXstuUuid");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("^^在执行DweixinDaoImpl中deleteByYXstuUuid,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, PSdelete, connection);
		}
	}

	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dweixin> getList() {
		// TODO Auto-generated method stub
		ArrayList<Dweixin> dweixinList = new ArrayList<Dweixin>();
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_dweixin");
			while (rs.next()) {
				Dweixin dweixin = new Dweixin();
				dweixin.setUuid(rs.getString("uuid"));
				dweixin.setWeixinNO(rs.getString("weixinNO"));
//				dweixin.setDitchUuid(rs.getString("ditchUuid"));
				dweixin.setEmpDitUuid(rs.getString("empDitUuid"));
				dweixinList.add(dweixin);
			}
			return dweixinList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DweixinDaoImpl的查询列表失败");
			Dweixin dweixin = new Dweixin();
			dweixin.setUuid("DweixinDaoImpl查询失败返回的uuid");
			ArrayList<Dweixin> listDweixin = new ArrayList<Dweixin>();
			listDweixin.add(dweixin);
			return listDweixin;
		} finally {
			DBUtility.close(rs, statement, connection);
		}
	}

	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dweixin> getListByDitchUuid(String ditchUuid) {
		// TODO Auto-generated method stub
		ArrayList<Dweixin> dweixinList = new ArrayList<Dweixin>();
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_dweixin where ditchUuid='"+ditchUuid+"'");
			while (rs.next()) {
				Dweixin dweixin = new Dweixin();
				dweixin.setUuid(rs.getString("uuid"));
				dweixin.setWeixinNO(rs.getString("weixinNO"));
//				dweixin.setDitchUuid(rs.getString("ditchUuid"));
				dweixin.setEmpDitUuid(rs.getString("empDitUuid"));
				dweixinList.add(dweixin);
			}
			return dweixinList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DweixinDaoImpl的根据ditchUuid查询列表失败");
			Dweixin dweixin = new Dweixin();
//			dweixin.setDitchUuid("DweixinDaoImpl查询失败返回的ditchUuid");
			ArrayList<Dweixin> listDweixin = new ArrayList<Dweixin>();
			listDweixin.add(dweixin);
			return listDweixin;
		} finally {
			DBUtility.close(rs, statement, connection);
		}
	}

	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dweixin> getListByWeixinNO(String weixinNO) {
		// TODO Auto-generated method stub
		ArrayList<Dweixin> dweixinList = new ArrayList<Dweixin>();
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_dweixin where weixinNO='"+weixinNO+"'");
			while (rs.next()) {
				Dweixin dweixin = new Dweixin();
				dweixin.setUuid(rs.getString("uuid"));
				dweixin.setWeixinNO(rs.getString("weixinNO"));
				dweixin.setYxstuUuid(rs.getString("yxstuUuid"));
				dweixin.setEmpDitUuid(rs.getString("empDitUuid"));
				dweixinList.add(dweixin);
			}
			return dweixinList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DweixinDaoImpl的根据weixinNO查询列表失败");
			Dweixin dweixin = new Dweixin();
			dweixin.setWeixinNO("DweixinDaoImpl查询失败返回的weixinNO");
			ArrayList<Dweixin> listDweixin = new ArrayList<Dweixin>();
			listDweixin.add(dweixin);
			return listDweixin;
		} finally {
			DBUtility.close(rs, statement, connection);
		}
	}
}
