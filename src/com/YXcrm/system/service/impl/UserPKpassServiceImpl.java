package com.YXcrm.system.service.impl;

import com.YXcrm.system.dao.UserPKpassDao;
import com.YXcrm.system.dao.impl.UserPKpassDaoImpl;
import com.YXcrm.system.model.UserPK;
import com.YXcrm.system.service.UserPKpassService;
/*
 * 
 * @author 刘鑫
 * @date  ‎2018‎年‎1‎月‎24‎日‎ ‎17‎:‎08‎:‎38
 */
public class UserPKpassServiceImpl implements UserPKpassService {
	UserPKpassDao upd=new UserPKpassDaoImpl();
	
	@Override
	public boolean updatePassword(UserPK userPK) {
		// TODO Auto-generated method stub
		
		return upd.updateUserPassword(userPK);
	}

}
