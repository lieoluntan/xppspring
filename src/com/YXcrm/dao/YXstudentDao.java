package com.YXcrm.dao;

import java.util.ArrayList;
import java.util.List;

import com.YXcrm.model.YXstudent;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-22 下午6:09:34
 * 类说明
 */

public interface YXstudentDao {
  
  public boolean insert(YXstudent yxstudent);

  public ArrayList<YXstudent> getList();

  public boolean delete(String uuid);

  public boolean update(YXstudent yxstudent);

  public boolean updateOnOff(String uuid, String oAc);

  public YXstudent getByUuid(String yxstuUuid);
  
  /**
   * 查询学号最大信息
   */
  public int findMaxIdShow();
  /**
   * 查询新增StudentID是否重复
   */
  public YXstudent findId(int id);
  /**
   * 单独修改studentID
   */
  public boolean updateStuId(int StuId,String uuid); 

}
