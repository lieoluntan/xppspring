package com.YXcrm.service;

import java.util.ArrayList;
import java.util.List;

import com.YXcrm.model.YXstudent;
import com.YXcrm.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-22 下午6:05:52
 * 类说明
 */

public interface YXstudentService {
  
  String insert(YXstudent yxstudent);

  M_msg getMsg();

  ArrayList<YXstudent> getList();

  String delete(String uuid);

  String update(YXstudent yxstudent);

  String getonoff(YXstudent yxstudent);
  
  /**
   * 查询学号最大信息
   */
  public int findMaxIdShow();

  /**
   * 单独修改studentID
   */
  public String updateStuId(int StuId,String uuid); 
}
