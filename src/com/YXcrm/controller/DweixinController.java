/**
 * 
 */
package com.YXcrm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YXcrm.model.BackResult;
import com.YXcrm.model.Dweixin;
import com.YXcrm.service.DweixinService;
import com.YXcrm.service.impl.DweixinServiceImpl;
import com.YXcrm.utility.T_DataControl;
import com.YXcrm.utility.T_DataMap2Bean;
import com.google.gson.Gson;

/**
 * @author LiuXin
 * @date 2018-2-8 下午4:45:25
 * @version
 */
public class DweixinController extends HttpServlet {
	private static final long serialVersionUID = -1060747765670586355L;
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	DweixinService dweixinService = new DweixinServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String qqiu = request.getParameter("qqiu");
		if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete")
				|| qqiu.equals("deleteByYXstuUid")
				|| qqiu.equals("listByDitchUid")
				|| qqiu.equals("listByweixinNO")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Dweixin weixin = new Dweixin();
			if (str != null && str != "" && str.length() != 0) {
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				weixin = t_map2bean.MapToDweixin(map);
			} else {
				System.out.println("前台传入数据为空，请联前台传入post请求体数系管理员！");
			}
			qqiuchocie(qqiu, weixin);
		} else if (qqiu.equals("list")) {
//			ArrayList<Dweixin> resultList = dweixinService.getList();
//			backResult.setMessage("信息值：成功");
//			backResult.setQingqiu("list查询列表");
//			backResult.setData(resultList);

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
	}

	private void qqiuchocie(String qqiu, Dweixin weixin) {
	    boolean test = false;
		boolean add = false;
		boolean delete = false;
		boolean deleteByYXstuUid = false;
		boolean listByDitchUid = false;
		boolean listByweixinNO = false;

		test = qqiu.equals("test");
		add = qqiu.equals("add");
		delete = qqiu.equals("delete");
		deleteByYXstuUid = qqiu.equals("deleteByYXstuUid");
		listByDitchUid = qqiu.equals("listByDitchUid");
		listByweixinNO = qqiu.equals("listByweixinNO");

		if (test) {
          backResult.setMessage("信息值,测试成功");
          backResult.setQingqiu("test新增");
          ArrayList<String> resultList = new ArrayList<String>();
          resultList.add("内容值,测试成功1");
          resultList.add("内容值,测试成功2");
          resultList.add("内容值,测试成功3DweixinController");
          backResult.setData(resultList);
        }
		if (add) {
			String result = dweixinService.insert(weixin);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("add新增");
			backResult.setData(resultList);
		}
		if (delete) {
//			String result = dweixinService.delete(weixin.getUuid());
//			System.out.println("删除功能传进来的uuid================="
//					+ weixin.getUuid());
//			ArrayList<String> resultList = new ArrayList<String>();
//			resultList.add(result);
//			backResult.setMessage("信息值：成功");
//			backResult.setQingqiu("delete删除" + weixin.getUuid());
//			backResult.setData(resultList);
		}
		if (deleteByYXstuUid) {
//			ArrayList<Dweixin> dlist = dweixinService.getListByDitchUuid(weixin
//					.getDitchUuid());
//			backResult.setQingqiu(weixin.getDitchUuid() + "渠道delete删除"
//					+ dlist.size() + "条");
			String result = dweixinService.deleteByYXstuUid(weixin
					.getYxstuUuid());
			System.out.println("删除功能传进来的uuid================="
					+ weixin.getYxstuUuid());
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");

			backResult.setData(resultList);
		}
		if (listByDitchUid) {
//			ArrayList<Dweixin> resultList = dweixinService
//					.getListByDitchUuid(weixin.getDitchUuid());
//			backResult.setMessage("信息值：成功");
//			backResult.setQingqiu("list查询列表");
//			backResult.setData(resultList);
		}
		if (listByweixinNO) {
			ArrayList<Dweixin> resultList = dweixinService
					.getListByWeixinNO(weixin.getWeixinNO());
			if (resultList.size() != 0) {
				backResult.setMessage("查询完成：存在微信" + weixin.getWeixinNO());
				backResult.setQingqiu("list查询列表");
				backResult.setData(resultList);
			} else {
				backResult
						.setMessage("查询完成:" + weixin.getWeixinNO() + "---不存在");
				backResult.setQingqiu("list查询列表");
				backResult.setData(resultList);
			}
		}
	}//end method qqiuchoice
}//end class
