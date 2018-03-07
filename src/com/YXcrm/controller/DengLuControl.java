package com.YXcrm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YXcrm.model.BackResult;
import com.YXcrm.system.model.UserPK;
import com.YXcrm.system.service.RoleResourceService;
import com.YXcrm.system.service.UserPKService;
import com.YXcrm.system.service.impl.RoleResourceServiceImpl;
import com.YXcrm.system.service.impl.UserPKServiceImpl;
import com.YXcrm.utility.M_msg;
import com.YXcrm.utility.T_DataControl;
import com.YXcrm.utility.T_DataMap2Bean;
import com.google.gson.Gson;


/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2018-02-05 下午17:35:17 类说明 用户登陆后得到角色和资源
 */

public class DengLuControl extends HttpServlet {
	private RoleResourceService roleResourceService = new RoleResourceServiceImpl();
	// DengLuService dengLuService = new DengLuServiceImpl();
	UserPKService userPKService = new UserPKServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	public M_msg m_msg = new M_msg();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}// end doGet

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO doPost
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 1 获取url问号后面的Query 参数
		String qqiu = request.getParameter("qqiu");

		if (qqiu.equals("test") || qqiu.equals("denglu")) {
			// 2 将前台json数据字符串转成实体对象
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			UserPK userPK = new UserPK();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				userPK = t_map2bean.MapToUserPK(map);
			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
			}

			// 3 执行qqiu里面的增或删或改或查 的操作
			qqiuChoice(qqiu, userPK, response, str);
		} else if (qqiu.equals("list")) {
			// TODO 待完成

		} else {
			System.out.println("qqiu请求参数  " + qqiu + "  不规范");
		}

		Gson gson = new Gson();
		// 4 执行完qqiuChoice里面操作后的全局返回值backResult对象,转成json格式
		String back = gson.toJson(backResult);
		System.out.println("最后back值是：" + back);
		// 5 将json格式的back传给前台
		out.write(back);
		out.flush();
		out.close();

	}// end method doPost 主入口

	private void qqiuChoice(String qqiu, UserPK userPK,
			HttpServletResponse response, String uuid) {
		// TODO Auto-generated method stub
		boolean test = false;
		boolean denglu = false;
		test = qqiu.equals("test");
		denglu = qqiu.equals("denglu");

		if (test) {
			backResult.setMessage("信息值,测试成功");
			backResult.setQingqiu("test新增");
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add("登录,测试成功1");
			resultList.add("登录,测试成功2");
			resultList.add("登录,测试成功3");
			backResult.setData(resultList);
		}
		if (denglu) {
			List list = new ArrayList();
			List rsList = new ArrayList();
			UserPK user = new UserPK();
			List<String> roleList = new ArrayList<String>();
			boolean flag = userPKService.judge(userPK);
			m_msg = userPKService.getMsg();
			backResult.setQingqiu("notyes");
			// 步骤一：判断
			if (flag) {

				user = userPKService.getUser(userPK.getuLogUser());// 先根据用户名查到用户对象
				roleList = userPKService.getRole(user.getUuid());// 角色id集合
				rsList = roleResourceService.getRsbyRoleid(roleList);

				user.setRoleList(roleList);
				user.setRsList(rsList);
				System.out.println("进入");
				String msg = "成功";
				System.out.println(msg);
				backResult.setQingqiu("登陆");
				ArrayList<Object> resultList = new ArrayList<Object>();
				resultList.add(flag);
				resultList.add(user);

				backResult.setMessage("信息值：" + m_msg.getGetOneMsg());
				backResult.setData(resultList);

			}// 用户名、密码正确
			else {
				list.add(flag);
				ArrayList<Object> resultList = new ArrayList<Object>();
				resultList = (ArrayList<Object>) list;

				String msg = "失败";
				System.out.println(msg);
				backResult.setMessage("信息值：" + m_msg.getGetOneMsg());
				backResult.setData(resultList);
				backResult.setQingqiu("登陆");
			}// 用户名、密码错误
				// 步骤二：赋值

		}// end denglu

	}// end method qqiuChoice

}// end class
