package com.YXcrm.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.YXcrm.dao.RecordDao;
import com.YXcrm.dao.YXstudentDao;
import com.YXcrm.dao.impl.RecordDaoImpl;
import com.YXcrm.dao.impl.YXstudentDaoImpl;
import com.YXcrm.model.Record;
import com.YXcrm.model.YXstudent;
import com.YXcrm.service.RecordService;
import com.YXcrm.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-26 下午5:40:56
 * 类说明
 */
@Service("recordServiceImpl")
public class RecordServiceImpl implements RecordService{
  @Resource(name="recordDaoImpl")
  private RecordDao recordDao;
  private YXstudentDao yxstudentDao = new YXstudentDaoImpl();
  public M_msg m_msg = new M_msg();
  Logger logger = Logger.getLogger(RecordServiceImpl.class);
  
  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

  @Override
  public String insert(Record record) {
    // TODO Auto-generated method stub
    YXstudent yxstu = yxstudentDao.getByUuid(record.getYxstuUuid());
    if (yxstu.getUuid() != null && yxstu.getUuid() != "") {
        record.setUuid(UUID.randomUUID().toString());
        System.out.println("^^在RecordServiceImpl收到数据 ：" + record.toString()
                + "收到结束!");
        boolean daoFlag = recordDao.insert(record);
        if (daoFlag) {
            return record.getUuid();
        } else {
            logger.error("插入不成功,dao层执行有出错地方,请联系管理员");
            m_msg.setAddMsg("插入不成功,dao层执行有出错地方,请联系管理员recordServiceImpl");
            return "插入不成功,dao层执行有出错地方,请联系管理员";
        }
    } else {
        m_msg.setAddMsg("该意向学员不存在");
        return "该意向学员不存在";
    }
  }//end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if (uuid != null && uuid != "") {
      boolean daoFlag = recordDao.delete(uuid);

      if (daoFlag) {
          return uuid;
      } else {
          logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
          return "删除不成功,dao层执行有出错地方,请联系管理员";
      }
  } else {
      String msg = "recordDao delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
  }//end method

  @Override
  public String update(Record record) {
    // TODO Auto-generated method stub
    String uuid = record.getUuid();
    if (uuid != null && uuid != "") {

        boolean daoFlag = recordDao.update(record);

        if (daoFlag) {
            return uuid;
        } else {
            logger.error("修改不成功,dao层执行有出错地方,请联系管理员");
            m_msg.setEditMsg("修改不成功,dao层执行有出错地方,请联系管理员");
            return "修改不成功,dao层执行有出错地方,请联系管理员recordServiceImpl";
        }
    } else {
        String msg = "recordServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
        System.out.println(msg);
        return msg;
    }
  }//end method

  @Override
  public ArrayList<Record> getListByYxUuid(String yxstuUuid) {
    // TODO Auto-generated method stub
    if (yxstuUuid != null && yxstuUuid != "") {
      ArrayList<Record> recList =recordDao.getListByYxUuid(yxstuUuid) ;
      YXstudent yxstudent = yxstudentDao.getByUuid(yxstuUuid);
      String yxName = yxstudent.getName();
      for (int i = 0; i < recList.size(); i++) {
          recList.get(i).setYxstuName(yxName);
      }
      return recList;
  } else {
      System.out
              .println("RecordServiceImpl getListByYxUuid方法中的ditchUuid为空，或格式不正确，请联系管理员");
      return new ArrayList<Record>();
  }
  }//end method

}//end class
