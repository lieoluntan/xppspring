package com.YXcrm.query.service.impl;

import java.util.ArrayList;

import com.YXcrm.dao.YXstudentDao;
import com.YXcrm.dao.impl.YXstudentDaoImpl;
import com.YXcrm.model.Record;
import com.YXcrm.model.YXstudent;
import com.YXcrm.query.dao.QuePageRecordDao;
import com.YXcrm.query.dao.impl.QuePageRecordDaoImpl;
import com.YXcrm.query.service.QuePageRecordService;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-27 上午10:55:08
 * 类说明
 */

public class QuePageRecordServiceImpl implements QuePageRecordService{
  
  QuePageRecordDao quePageRecordDao = new QuePageRecordDaoImpl();
  YXstudentDao yxstuDao = new YXstudentDaoImpl();

  @Override
  public ArrayList<Record> getPageByYxUuid(String yxUuid, int currentPage, int maxResult) {
    // TODO Auto-generated method stub
    if (yxUuid != null && yxUuid != "" && currentPage > 0
        && maxResult > 0) {
    ArrayList<Record> recordcList = quePageRecordDao.getPageByYxUuid(yxUuid,
            currentPage, maxResult);
    YXstudent yxstudent = yxstuDao.getByUuid(yxUuid);
    String yxName = yxstudent.getName();
    for (int i = 0; i < recordcList.size(); i++) {
      recordcList.get(i).setYxstuName(yxName);
    }
    return recordcList;
} else {
    ArrayList<Record> list = new ArrayList<Record>();
    Record record = new Record();
    record.setUuid("传入数据有问题,请检查");
    list.add(record);
    System.out
            .println("QuePageRecordServiceImpl中的getPageByDitchUuid方法传入的数据有问题,请联系管理员");
    return list;
}
  }//end method

}//end class
