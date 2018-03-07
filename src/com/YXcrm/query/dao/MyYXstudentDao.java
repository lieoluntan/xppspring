package com.YXcrm.query.dao;

import java.util.ArrayList;

import com.YXcrm.model.YXstudent;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-23 下午4:55:00
 * 类说明
 */

public interface MyYXstudentDao {

  ArrayList<YXstudent> getListByEmpUuid(String empUuid);

}//end interface
