/**
 * 
 */
package com.YXcrm.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.YXcrm.dao.DweixinDao;
import com.YXcrm.dao.EmployeeDao;
import com.YXcrm.dao.YXstudentDao;
import com.YXcrm.dao.impl.DweixinDaoImpl;
import com.YXcrm.dao.impl.EmployeeDaoImpl;
import com.YXcrm.dao.impl.YXstudentDaoImpl;
import com.YXcrm.model.Dweixin;
import com.YXcrm.model.Employee;
import com.YXcrm.model.YXstudent;
import com.YXcrm.service.DweixinService;


/**
 * @author LiuXin
 *@date 2018-2-8 下午4:42:06
 *@version 
 */
public class DweixinServiceImpl implements DweixinService {
    private YXstudentDao yxstudentDao = new YXstudentDaoImpl();
	private DweixinDao dweixinDao=new DweixinDaoImpl();
	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	/* 
	 * @param
	 * @return
	 */
	@Override
	public String insert(Dweixin dweixin) {
		// TODO Auto-generated method stub
		dweixin.setUuid(UUID.randomUUID().toString());
		System.out.println("^^在DweixinServiceImpl收到数据 ：" + dweixin.toString()
				+ "收到结束!");
		boolean daoFlag = dweixinDao.insert(dweixin);
		if (daoFlag) {
			return dweixin.getUuid();
		} else {
			return "插入不成功,dao层执行有出错地方,请联系管理员";
		}
	}
	/* 
	 * @param
	 * @return
	 */
	@Override
	public String delete(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			boolean daoFlag = dweixinDao.delete(uuid);
			if (daoFlag) {
				return uuid;
			} else {
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "DweixinServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}
	/* 
	 * @param
	 * @return
	 */
	@Override
	public String deleteByYXstuUid(String yxstuUuid) {
		// TODO Auto-generated method stub
		if (yxstuUuid != null && yxstuUuid != "") {
//			int num=dweixinDao.getListByDitchUuid(ditchUuid).size();
			boolean daoFlag = dweixinDao.deleteByYXstuUuid(yxstuUuid);
			if (daoFlag) {
				return yxstuUuid + "意向新生删除";
			} else {
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "DweixinServiceImpl deleteByDitchUuid方法中的yxstuUuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}
	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dweixin> getList() {
		// TODO Auto-generated method stub
//		ArrayList<Dweixin> list=dweixinDao.getList();
//		for (int i = 0; i < list.size(); i++) {
//			String ditchUuid=list.get(i).getDitchUuid();
//			String ditchName=ditchDao.getByUuid(ditchUuid).getName();
//			Employee employee=employeeDao.getByUuid(list.get(i).getEmpDitUuid());
//			list.get(i).setEmpDitName(employee.getName());
//			list.get(i).setDitchName(ditchName);
//		}
//		return list;
	    return null;
	}//end method
	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dweixin> getListByDitchUuid(String ditchUuid) {
		// TODO Auto-generated method stub
//		if (ditchUuid != null && ditchUuid != "") {
//			ArrayList<Dweixin> dweixinList =dweixinDao.getListByDitchUuid(ditchUuid);
//			for (int i = 0; i < dweixinList.size(); i++) {
//				Ditch ditch = ditchDao.getByUuid(dweixinList.get(i).getDitchUuid());
//				Employee employee=employeeDao.getByUuid(dweixinList.get(i).getEmpDitUuid());
//				dweixinList.get(i).setEmpDitName(employee.getName());
//				dweixinList.get(i).setDitchName(ditch.getName());
//			}
//			return dweixinList;
//		} else {
//			System.out
//					.println("DweixinServiceImpl getListByDitchUuid方法中的ditchUuid为空，或格式不正确，请联系管理员");
//			return new ArrayList<Dweixin>();
//		}
	    return null;
	}//end method
	/* 
	 * @param
	 * @return
	 */
	@Override
	public ArrayList<Dweixin> getListByWeixinNO(String weixinNO) {
		// TODO Auto-generated method stub
		if (weixinNO != null && weixinNO != "") {
			ArrayList<Dweixin> dweixinList =dweixinDao.getListByWeixinNO(weixinNO);
			for (int i = 0; i < dweixinList.size(); i++) {
			    YXstudent yxstu = yxstudentDao.getByUuid(dweixinList.get(i).getYxstuUuid());
				Employee employee=employeeDao.getByUuid(dweixinList.get(i).getEmpDitUuid());
				dweixinList.get(i).setEmpDitName(employee.getName());
				dweixinList.get(i).setYxstuName(yxstu.getName());
			}
			return dweixinList;
		} else {
			System.out
					.println("DweixinServiceImpl getListByWeixinNO方法中的weixinNO为空，或格式不正确，请联系管理员");
			return new ArrayList<Dweixin>();
		}
	}//emd method

}//end class
