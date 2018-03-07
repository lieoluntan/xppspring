/**
 * 
 */
package com.YXcrm.service;

import java.util.ArrayList;

import com.YXcrm.model.Dphone;
import com.YXcrm.model.Record;

/**
 * @author LiuXin
 * @date 2018-2-8 下午2:35:52
 * @version
 */
public interface DphoneService {
	String insert(Dphone dphone);

	String delete(String uuid);

	String deleteByYXstuUid(String YXstuUid);

	ArrayList<Dphone> getList();
	
	ArrayList<Dphone> getListByDitchUuid(String ditchUuid);
	
	ArrayList<Dphone> getListByPhoneNO(String phoneNO);
}
