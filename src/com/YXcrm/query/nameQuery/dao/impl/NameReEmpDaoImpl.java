package com.YXcrm.query.nameQuery.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.YXcrm.model.Employee;
import com.YXcrm.query.nameQuery.dao.NameReEmpDao;
import com.YXcrm.utility.DBUtility;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午4:43:11
 * 
 */
public class NameReEmpDaoImpl implements NameReEmpDao {
	private Connection connection;

	@Override
	public List<Employee> getStuByName(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_employee WHERE name ='"
							+ employee.getName() + "'");
			while (rs.next()) {
				Employee s = new Employee();
				s.setUuid(rs.getString("uuid"));
				empList.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return empList;
	}

}
