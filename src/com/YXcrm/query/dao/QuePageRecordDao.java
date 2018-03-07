/**
 * 
 */
package com.YXcrm.query.dao;

import java.util.ArrayList;

import com.YXcrm.model.Record;

/**
 * @author LiuXin
 *@date 2018-1-31 下午2:44:55
 *@version 跟踪记录表分页查询
 */
public interface QuePageRecordDao {
	//分页查询
	public ArrayList<Record> getPageByYxUuid(String ditchUuid,int currentPage,int maxResult);
}
