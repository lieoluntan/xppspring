/**
 * 
 */
package com.YXcrm.dao;

import java.util.ArrayList;

import com.YXcrm.model.Dphone;
import com.YXcrm.model.Record;

/**
 * @author LiuXin
 * @date 2018-2-8 下午2:23:05
 * @version 手机号码dao
 */
public interface DphoneDao {

	// 新增
	public boolean insert(Dphone dphone);

	// 删除
	public boolean delete(String uuid);

	// 根据ditchUuid删除
	public boolean deleteByYXstuUid(String YXstuUid);

	// 列表查询
	public ArrayList<Dphone> getList();

	// 根据ditchUuid查询
	public ArrayList<Dphone> getListByDitchUuid(String ditchUuid);
	
	//根据phoneNO查询
	public ArrayList<Dphone> getListByPhoneNO(String phoneNO);
}
