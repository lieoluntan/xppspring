package com.YXcrm.dao;

import java.util.ArrayList;

import com.YXcrm.model.Record;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-26 下午6:27:14
 * 类说明
 */

public interface RecordDao {

  boolean insert(Record record);

  boolean delete(String uuid);

  boolean update(Record record);

  ArrayList<Record> getListByYxUuid(String yxstuUuid);

}//end interface
