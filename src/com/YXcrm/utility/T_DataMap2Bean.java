package com.YXcrm.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import com.YXcrm.model.Department;
import com.YXcrm.model.Dphone;
import com.YXcrm.model.Dweixin;
import com.YXcrm.model.Employee;
import com.YXcrm.model.Record;
import com.YXcrm.model.YXstudent;
import com.YXcrm.system.model.Resource;
import com.YXcrm.system.model.Role;
import com.YXcrm.system.model.RoleResource;
import com.YXcrm.system.model.UserPK;
import com.YXcrm.system.model.UserPK_Role;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午1:42:03 类说明
 */

public class T_DataMap2Bean {

	public Department MapToDepartment(Map<String, Object> map) {
		String name = (String) map.get("name");
		String remark = (String) map.get("remark");
		String createDate = (String) map.get("createDate");
		String modifyDate = (String) map.get("modifyDate");
		String createPeople = (String) map.get("createPeople");
		String modifyPeople = (String) map.get("modifyPeople");
		String openAndclose = (String) map.get("modifyPeople");
		String uuid = (String) map.get("uuid");
		Department department = new Department(uuid, name, remark);
		return department;

	}
	
	public Dweixin MapToDweixin(Map<String, Object> map){
		String weixinNO = (String) map.get("weixinNO");
		String yxstuUuid = (String) map.get("yxstuUuid");
		String empDitUuid = (String) map.get("empDitUuid");
		String uuid = (String) map.get("uuid");
		String yxstuName = (String) map.get("yxstuName");
		String empDitName = (String) map.get("empDitName");
		String checkResult = (String) map.get("checkResult");
		Dweixin weixin=new Dweixin(uuid,  weixinNO,  yxstuUuid,
			       empDitUuid,  yxstuName,  empDitName,  checkResult);
		return weixin;
	}
	
	public Dphone MapToDphone(Map<String, Object> map){
		String phoneNO = (String) map.get("phoneNO");
		String yxstuUuid = (String) map.get("yxstuUuid");

		String empDitUuid = (String) map.get("empDitUuid");
		String uuid = (String) map.get("uuid");
		String yxstuName = (String) map.get("yxstuName");
		String empDitName = (String) map.get("empDitName");
		String checkResult = (String) map.get("checkResult");
		Dphone dphone=new Dphone(uuid,phoneNO,yxstuUuid,empDitUuid,
		    yxstuName,empDitName,checkResult);
		return dphone;
	}


	public Role MapToRole(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		Role role = new Role(uuid, name, null, null, null, null, null, null);
		return role;
	}
	
	public Record MapToRecord(Map<String, Object> map){
		String uuid=(String) map.get("uuid");
		String yxstuUuid=(String) map.get("yxstuUuid");
		String recordDate=(String) map.get("recordDate");
		String remarkText=(String) map.get("remarkText");
		Record record=new Record( uuid,  yxstuUuid,  recordDate,  remarkText);
		return record;
	}

	public Employee MapToEmp(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");
		String name = (String) map.get("name");
		String empNum = (String) map.get("empNum");
		String phone = (String) map.get("phone");
		String depart = (String) map.get("depart");
		String job = (String) map.get("job");
		String permissionTempl = (String) map.get("permissionTempl");
		String remark = (String) map.get("remark");

		String claTeacher = (String) map.get("claTeacher");// 11月15新增字段
		String sex = (String) map.get("sex");
		String org = (String) map.get("org");
		String workDate = (String) map.get("workDate");
		String fullhalf = (String) map.get("fullhalf");
		String jobRemark = (String) map.get("jobRemark");
		String openAndclose = (String) map.get("openAndclose");// 改变开关状态才用到，新增和编辑没有值

		Employee emp = new Employee(uuid, name, empNum, phone, depart, job,
				permissionTempl, remark);
		emp.setClaTeacher(claTeacher);// 11月15新增字段
		emp.setSex(sex);
		emp.setOrg(org);
		emp.setWorkDate(workDate);
		emp.setFullhalf(fullhalf);
		emp.setJobRemark(jobRemark);
		emp.setOpenAndclose(openAndclose);

		return emp;
	}// end method MapToEmp

	public UserPK MapToUserPK(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String uLogUser = (String) map.get("uLogUser");
		String uPassWord = (String) map.get("uPassWord");
		String uName = (String) map.get("uName");
		String empUuid = (String) map.get("empUuid");
		List<String> roleList = (List<String>) map.get("roleList");
		UserPK userPK = new UserPK(uuid, uLogUser, uPassWord, uName, roleList,
				empUuid);
		return userPK;
	}// end method MapToEmp

	public Role MapToUserRole(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String modifyDate = (String) map.get("modifyDate");
		String createPeople = (String) map.get("createPeople");
		String modifyPeople = (String) map.get("modifyDate");
		String createDate = (String) map.get("createDate");
		String remark = (String) map.get("remark");
		List<String> rsList = (List<String>) map.get("rsList");
		Role role = new Role(uuid, name, modifyDate, createPeople,
				modifyPeople, createDate, remark, rsList);
		return role;
	}

	public Resource MapToResource(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		// String campus = (String) map.get("campus");
		// String remark = (String) map.get("remark");

		// ClassRoom classRoom = new ClassRoom(uuid, name, campus, remark);

		Resource resource = new Resource(uuid, name, null, null, null, null,
				null);
		return resource;
	}// end method MapToEmp

	public RoleResource MapToRoleResource(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String roleid = (String) map.get("roleid");
		String resourceid = (String) map.get("resourceid");

		RoleResource resource = new RoleResource(uuid, roleid, resourceid);
		return resource;
	}

	public Employee MapToEmp1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");
		String name = (String) map.get("name");
		String empNum = (String) map.get("empNum");
		String phone = (String) map.get("phone");
		String depart = (String) map.get("depart");
		String job = (String) map.get("job");
		String permissionTempl = (String) map.get("permissionTempl");
		String remark = (String) map.get("remark");

		String claTeacher = (String) map.get("claTeacher");// 11月15新增字段
		String sex = (String) map.get("sex");
		String org = (String) map.get("org");
		String workDate = (String) map.get("workDate");
		String fullhalf = (String) map.get("fullhalf");
		String jobRemark = (String) map.get("jobRemark");

		Employee emp = new Employee(uuid, name, empNum, phone, depart, job,
				permissionTempl, remark);
		emp.setClaTeacher(claTeacher);// 11月15新增字段
		emp.setSex(sex);
		emp.setOrg(org);
		emp.setWorkDate(workDate);
		emp.setFullhalf(fullhalf);
		emp.setJobRemark(jobRemark);

		return emp;
	}// end method MapToEmp

	public UserPK_Role MapToUserPK_Role(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String userPkid = (String) map.get("userPkid");
		String roleid = (String) map.get("roleid");

		UserPK_Role userPK_role = new UserPK_Role(uuid, userPkid, roleid);
		return userPK_role;
	}// end method

  public YXstudent MapToYXstudent(Map<String, Object> map) {
    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String name = (String) map.get("name");
    String sex = (String) map.get("sex");
    String phone = (String) map.get("phone");
    String grade = (String) map.get("grade");
    String school = (String) map.get("school");
    String weixin = (String) map.get("weixin");
    
    String parentRela = (String) map.get("parentRela");
    String parentName = (String) map.get("parentName");
    String parentPhone = (String) map.get("parentPhone");
    String parentWeixin = (String) map.get("parentWeixin");
    
    String parentRela2 = (String) map.get("parentRela2");
    String parentName2 = (String) map.get("parentName2");
    String parentPhone2 = (String) map.get("parentPhone2");
    String parentWeixin2 = (String) map.get("parentWeixin2");
    
    String empUuid = (String) map.get("empUuid");
    String rank = (String) map.get("rank");
    String source = (String) map.get("source");
    String courseYX = (String) map.get("courseYX");
    
    String openAndclose = (String) map.get("openAndclose");
    String id = (String)map.get("studentID");
    Integer studentID=Integer.parseInt(id);
    
    YXstudent yxstudent = new YXstudent(uuid, name, sex, phone, grade, school, weixin, parentRela, parentName, parentPhone, parentWeixin, 
        parentRela2, parentName2, parentPhone2, parentWeixin2, empUuid, rank, source, courseYX);
    yxstudent.setStudentID(studentID);
    yxstudent.setOpenAndclose(openAndclose);//存入前端传来的开关
    
    return yxstudent;
  }//end method

}// end class T_DataMap2Bean
