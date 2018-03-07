package com.YXcrm.query.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YXcrm.model.BackResult;
import com.YXcrm.model.Record;
import com.YXcrm.query.service.QuePageRecordService;
import com.YXcrm.query.service.impl.QuePageRecordServiceImpl;
import com.YXcrm.service.RecordService;
import com.YXcrm.service.impl.RecordServiceImpl;
import com.YXcrm.utility.T_DataControl;
import com.google.gson.Gson;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-27 上午10:19:25
 * 类说明
 */

public class QuePageRecordController extends HttpServlet{
  
  QuePageRecordService quePageRecordService=new QuePageRecordServiceImpl();
  RecordService recordService = new RecordServiceImpl();
  BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
  
  protected void doGet(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {

      this.doPost(request, response);
  }
  
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      request.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      
      String qqiu = request.getParameter("qqiu");
      if(qqiu.equals("pageByYXstuUid")){
          T_DataControl t_data = new T_DataControl();
          String str = t_data.getRequestPayload(request);
          Record record = new Record();
          if(str != null && str != "" && str.length() != 0){
              Map<String, Object> map = t_data.JsonStrToMap(str);
              String yxstuUuid=(String) map.get("yxstuUuid");
              int currentPage=Integer.valueOf((String) map.get("currentPage")).intValue();
              int maxResult=Integer.valueOf((String) map.get("maxResult")).intValue();
              ArrayList<Record> recList=quePageRecordService.getPageByYxUuid(yxstuUuid, currentPage, maxResult);
              int sum=recordService.getListByYxUuid(yxstuUuid).size();
//              int sum = 10;//自己测试
              
              if(sum%maxResult==0){
                  backResult.setMessage("数据库总共页数:"+sum/maxResult);
              }else{
                backResult.setMessage("数据库总共页数:"+(sum/maxResult+1));
              }
              backResult.setQingqiu(""+sum+"");
              backResult.setData(recList);
          }else{
              System.out.println("前台传入数据为空，请联前台传入post请求体数系管理员！");
              backResult.setMessage("数据库总共页数:0页");
              backResult.setQingqiu("数据总条数:0条");
              ArrayList<String> strList=new ArrayList<String>();
              strList.add("您请求的数据为空!");
              backResult.setData(strList);
          }
      }else{
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

}//end class
