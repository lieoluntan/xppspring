/**
 * 
 */
package com.YXcrm.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.YXcrm.dao.DphoneDao;
import com.YXcrm.dao.EmployeeDao;
import com.YXcrm.dao.YXstudentDao;
import com.YXcrm.dao.impl.DphoneDaoImpl;
import com.YXcrm.dao.impl.EmployeeDaoImpl;
import com.YXcrm.dao.impl.YXstudentDaoImpl;
import com.YXcrm.model.Dphone;
import com.YXcrm.model.Employee;
import com.YXcrm.model.YXstudent;
import com.YXcrm.service.DphoneService;



/**
 * @author LiuXin
 * @date 2018-2-8 下午2:36:42
 * @version
 */
public class DphoneServiceImpl implements DphoneService {
	private DphoneDao dphoneDao = new DphoneDaoImpl();
	private YXstudentDao yxstudentDao = new YXstudentDaoImpl();
	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	
	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public String insert(Dphone dphone) {
		// TODO Auto-generated method stub
		dphone.setUuid(UUID.randomUUID().toString());
		System.out.println("^^在DphoneServiceImpl收到数据 ：" + dphone.toString()
				+ "收到结束!");
		boolean daoFlag = dphoneDao.insert(dphone);
		if (daoFlag) {
			return dphone.getUuid();
		} else {
			return "插入不成功,dao层执行有出错地方,请联系管理员";
		}
	}

	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public String delete(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			boolean daoFlag = dphoneDao.delete(uuid);
			if (daoFlag) {
				return uuid;
			} else {
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "DphoneServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}

	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public String deleteByYXstuUid(String YXstuUid) {
		// TODO Auto-generated method stub
		if (YXstuUid != null && YXstuUid != "") {
			boolean daoFlag = dphoneDao.deleteByYXstuUid(YXstuUid);
			if (daoFlag) {
				return YXstuUid;
			} else {
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "DphoneServiceImpl deleteByDitchUuid方法中的deleteByDitchUuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}//end method

	/*
	 * @param
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Dphone> getList() {
		// TODO Auto-generated method stub
//		ArrayList<Dphone> list=dphoneDao.getList();
//		for (int i = 0; i < list.size(); i++) {
//			String ditchUuid=list.get(i).getDitchUuid();
//			String ditchName=ditchDao.getByUuid(ditchUuid).getName();
//			Employee employee=employeeDao.getByUuid(list.get(i).getEmpDitUuid());
//			list.get(i).setEmpDitName(employee.getName());
//			list.get(i).setDitchName(ditchName);
//		}
//		return list;
	    return null;
	}

	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dphone> getListByDitchUuid(String ditchUuid) {
		// TODO Auto-generated method stub
//		if (ditchUuid != null && ditchUuid != "") {
//			ArrayList<Dphone> dphoneList =dphoneDao.getListByDitchUuid(ditchUuid);
//			for (int i = 0; i < dphoneList.size(); i++) {
//				Ditch ditch = ditchDao.getByUuid(dphoneList.get(i).getDitchUuid());
//				Employee employee=employeeDao.getByUuid(dphoneList.get(i).getEmpDitUuid());
//				dphoneList.get(i).setEmpDitName(employee.getName());
//				dphoneList.get(i).setDitchName(ditch.getName());
//			}
//			return dphoneList;
//		} else {
//			System.out
//					.println("DphoneServiceImpl getListByDitchUuid方法中的ditchUuid为空，或格式不正确，请联系管理员");
//			return new ArrayList<Dphone>();
//		}
	  return null;
	}//end method

	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dphone> getListByPhoneNO(String phoneNO) {
		// TODO Auto-generated method stub
		if (phoneNO != null && phoneNO != "") {
			ArrayList<Dphone> dphoneList =dphoneDao.getListByPhoneNO(phoneNO);
			for (int i = 0; i < dphoneList.size(); i++) {
				YXstudent yxstu = yxstudentDao.getByUuid(dphoneList.get(i).getYxstuUuid());
				Employee employee=employeeDao.getByUuid(dphoneList.get(i).getEmpDitUuid());
				dphoneList.get(i).setEmpDitName(employee.getName());
				dphoneList.get(i).setYxstuName(yxstu.getName());
			}
			return dphoneList;
		} else {
			System.out
					.println("DphoneServiceImpl getListByPhoneNO方法中的phoneNO为空，或格式不正确，请联系管理员");
			return new ArrayList<Dphone>();
		}
	  
	}//end method

}//end class
