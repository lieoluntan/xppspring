package com.YXcrm.query.nameQuery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.YXcrm.model.BackResult;
import com.YXcrm.model.Employee;
import com.YXcrm.query.nameQuery.service.NameReEmpService;
import com.YXcrm.query.nameQuery.service.impl.NameReEmpServiceImpl;
import com.YXcrm.utility.M_msg;
import com.YXcrm.utility.T_DataControl;
import com.YXcrm.utility.T_DataMap2Bean;

public class NameReEmpController extends HttpServlet {
private NameReEmpService nameReEmpService=new NameReEmpServiceImpl();
BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
public M_msg m_msg = new M_msg();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String qqiu = request.getParameter("qqiu");
		if (qqiu.equals("query")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Employee employee=new Employee();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				employee = t_map2bean.MapToEmp1(map);
			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
			}

			// 3 执行qqiu里面的增或删或改或查 的操作
			qqiuChoice(qqiu, employee);

		}
		Gson gson = new Gson();
		// 4 执行完qqiuChoice里面操作后的全局返回值backResult对象,转成json格式
		String back = gson.toJson(backResult);
		System.out.println("最后back值是：" + back);
		// 5 将json格式的back传给前台
		out.write(back);
		out.flush();
		out.close();
	}

	private void qqiuChoice(String qqiu, Employee employee) {
		// TODO Auto-generated method stub
		boolean test = false;

		test = qqiu.equals("query");

		if (test) {
			String flag = nameReEmpService.getStuByName(employee);// 得到名字是否已存在
			String flag1 = nameReEmpService.getStuByName1(employee);// 得到yes/no
			backResult.setMessage(flag);
			backResult.setQingqiu(flag1);

		}
	}
}
