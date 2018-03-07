package com.YXcrm.query.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.YXcrm.controller.YXstudentController;
import com.YXcrm.model.BackResult;
import com.YXcrm.model.YXstudent;
import com.YXcrm.query.service.MyYXstudentService;
import com.YXcrm.query.service.impl.MyYXstudentServiceImpl;
import com.YXcrm.utility.M_msg;
import com.google.gson.Gson;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2018-2-23 下午4:31:25 类说明
 */

public class MyYXstudentController extends HttpServlet {

  MyYXstudentService myYXstudentService = new MyYXstudentServiceImpl();
  BackResult backResult = new BackResult("信息值：默认", "请求值：默认", null);
  public M_msg m_msg = new M_msg();
  Logger logger = Logger.getLogger(YXstudentController.class);

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.doPost(request, response);
  }// end doGet

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String qqiu = request.getParameter("qqiu");
    String empUuid = request.getParameter("empUuid");
    if(qqiu.equals("test")){
      backResult.setMessage("信息值：测试成功");
      backResult.setQingqiu("test查询列表");
    }
    if (qqiu.equals("list") && empUuid != null && empUuid != "") {
      ArrayList<YXstudent> resultList = myYXstudentService.getListByEmpUuid(empUuid);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("list查询列表");
      backResult.setData(resultList);
    } else {
      System.out.println("前台传入数据为空，请联系前台传入get请求体！");
      backResult.setMessage("信息值：失败");
      backResult.setQingqiu("list查询列表");
      backResult.setData(new ArrayList<String>());
    }
    Gson gson = new Gson();

    String back = gson.toJson(backResult);
    System.out.println("最后back值是：" + back);

    out.write(back);
    out.flush();
    out.close();
  }// end method doPost 主入口

}// end class
