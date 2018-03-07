/**
 * 
 */
package com.YXcrm.dao;

import java.util.ArrayList;

import com.YXcrm.model.Dphone;
import com.YXcrm.model.Dweixin;

/**
 * @author LiuXin
 * @date 2018-2-8 下午4:32:42
 * @version
 */
public interface DweixinDao {
	// 新增
	public boolean insert(Dweixin dweixin);

	// 删除
	public boolean delete(String uuid);

	// 根据ditchUuid删除
	public boolean deleteByYXstuUuid(String yxstuUuid);

	// 列表查询
	public ArrayList<Dweixin> getList();

	// 根据ditchUuid查询
	public ArrayList<Dweixin> getListByDitchUuid(String ditchUuid);

	// 根据weixinNO查询
	public ArrayList<Dweixin> getListByWeixinNO(String weixinNO);
}
