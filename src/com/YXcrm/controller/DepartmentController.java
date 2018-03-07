package com.YXcrm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.YXcrm.model.BackResult;
import com.YXcrm.model.Department;
import com.YXcrm.service.DepartmentService;
import com.YXcrm.service.impl.DepartmentServiceImpl;
import com.YXcrm.utility.T_DataControl;
import com.YXcrm.utility.T_DataMap2Bean;
import com.google.gson.Gson;

/*
 * @author 刘鑫
 * @date 2018-1-29 14:19
 */
public class DepartmentController extends HttpServlet  implements Controller{
	private static final long serialVersionUID = -1060747765670586355L;
	
	Logger logger = Logger.getLogger(DepartmentController.class);

	DepartmentService departmentService = new DepartmentServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String qqiu = request.getParameter("qqiu");

		if (qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
				|| qqiu.equals("getOne") || qqiu.equals("on_off")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Department department = new Department();
			if (str != null && str != "" && str.length() != 0) {
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				department = t_map2bean.MapToDepartment(map);
				department.setOpenAndclose((String) map.get("openAndclose"));
			} else {
				System.out.println("前台传入数据为空，请联前台传入post请求体数系管理员！");
			}
			qqiuchocie(qqiu, department);
		} else if (qqiu.equals("list")) {
			ArrayList<Department> resultList = departmentService.getList();
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("list查询列表");
			backResult.setData(resultList);
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

	private void qqiuchocie(String qqiu, Department department) {
		boolean add = false;
		boolean delete = false;
		boolean edit = false;
		boolean getOne = false;
		boolean on_off = false;

		add = qqiu.equals("add");
		delete = qqiu.equals("delete");
		edit = qqiu.equals("edit");
		getOne = qqiu.equals("getOne");
		on_off = qqiu.equals("on_off");

		if (add) {
			String result = departmentService.insert(department);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage(result == "yes" ? "(已存在重复名字)"
					+ department.getName() : "新增成功");
			backResult.setQingqiu(result == "yes" ? "yes" : "no");
			backResult.setData(resultList);
		}
		if (delete) {
			String result = departmentService.delete(department.getUuid());
			System.out.println("删除功能传进来的uuid================="
					+ department.getUuid());
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("delete删除" + department.getUuid());
			backResult.setData(resultList);
		}
		if (edit) {
			String result = departmentService.update(department);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage(result == "yes" ? "(已存在重复名字)"
					+ department.getName() : "修改成功");
			backResult.setQingqiu(result == "yes" ? "yes" : "no");
			backResult.setData(resultList);
		}
		if (getOne) {
			Department result = departmentService.getByUuid(department
					.getUuid());
			ArrayList<Department> resultList = new ArrayList<Department>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("getOne查询单条记录");
			backResult.setData(resultList);
		}
		if (on_off) {
			String oAc = department.getOpenAndclose() + "";
			String flagQqiu = "初始值";
			String result = "初始值";
			if (oAc.equals("open") || oAc.equals("close")) {
				if (oAc.equals("open")) {
					flagQqiu = "on";
				}
				if (oAc.equals("close")) {
					flagQqiu = "off";
				}
				result = departmentService.getonoff(department);
			} else {
				flagQqiu = "err";
				result = "操作失败：开关参数不规范" + "(" + oAc + "),联系前端开发";
				logger.error("操作失败：开关参数不规范" + "(" + oAc + "),联系前端开发");
			}
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage(result);
			backResult.setQingqiu(flagQqiu);
			backResult.setData(resultList);
		}
	}

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String qqiu = request.getParameter("qqiu");

    if (qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
            || qqiu.equals("getOne") || qqiu.equals("on_off")) {
        T_DataControl t_data = new T_DataControl();
        String str = t_data.getRequestPayload(request);
        Department department = new Department();
        if (str != null && str != "" && str.length() != 0) {
            Map<String, Object> map = t_data.JsonStrToMap(str);
            T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
            department = t_map2bean.MapToDepartment(map);
            department.setOpenAndclose((String) map.get("openAndclose"));
        } else {
            System.out.println("前台传入数据为空，请联前台传入post请求体数系管理员！");
        }
        qqiuchocie(qqiu, department);
    } else if (qqiu.equals("list")) {
        ArrayList<Department> resultList = departmentService.getList();
        backResult.setMessage("信息值：成功");
        backResult.setQingqiu("list查询列表");
        backResult.setData(resultList);
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
    
//    return null;
    ModelAndView mview = new ModelAndView(back);
//    ModelAndView view = new ModelAndView("path:ok"); 
    return mview;
//    String viewName = getViewNameForRequest(request);
//    return new ModelAndView(viewName, RequestContextUtils.getInputFlashMap(request));
//    return new ResponseEntity<String>(back,HttpStatus.OK);
  }//end method ModelAndView
}//end class
