package com.YXcrm.query.service;

import java.util.ArrayList;

import com.YXcrm.model.YXstudent;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-23 下午4:43:26
 * 类说明
 */

public interface MyYXstudentService {

  ArrayList<YXstudent> getListByEmpUuid(String empUuid);

}//end interface
