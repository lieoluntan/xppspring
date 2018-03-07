/**
 * 
 */
package com.YXcrm.service;

import java.util.ArrayList;
import java.util.Map;

import com.YXcrm.model.Record;
import com.YXcrm.model.YXstudent;
import com.YXcrm.utility.M_msg;

/**
 * @author LiuXin
 *@date 2018-1-30 下午4:36:03
 *@version 跟踪记录表service
 */
public interface RecordService {
	String insert(Record record);
	
	String delete(String uuid);

  M_msg getMsg();

  String update(Record record);

  ArrayList<Record> getListByYxUuid(String yxstuUuid);
	
	
}
