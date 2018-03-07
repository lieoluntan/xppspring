/**
 * 
 */
package com.YXcrm.query.service;

import java.util.ArrayList;

import com.YXcrm.model.Record;

/**
 * @author LiuXin
 *@date 2018-1-31 下午3:41:25
 *@version 跟踪记录表分页查询
 */
public interface QuePageRecordService {
	ArrayList<Record> getPageByYxUuid(String yxUuid,
			int currentPage, int maxResult);
}
