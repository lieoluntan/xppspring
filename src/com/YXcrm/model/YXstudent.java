package com.YXcrm.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-22 下午4:38:51
 * 类说明
 */

public class YXstudent {
  private String uuid;
  private String createDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;
  
  private String name;//姓名
  private String sex;//性别
  private String phone;//学生手机号
  private String grade;//年级 
  private String school;//就读学校
  private String weixin;//微信    
  
  private String parentRela;//家长关系
  private String parentName;//家长姓名
  private String parentPhone;//家长电话
  private String parentWeixin;//家长微信 
  
  private String parentRela2;//家长关系2
  private String parentName2;//家长姓名2
  private String parentPhone2;//家长电话2
  private String parentWeixin2;//家长微信2 
  
  private String empUuid;//负责人
  private String rank;//意向等级(ABC)
  private String source;//来源
  private String courseYX;//课程意向
  
  private String openAndclose;//开关
  private String empName;//负责人名称
  private int    studentID;//学生学号

  public YXstudent() {
    super();
  }

  public YXstudent(String uuid, String name, String sex, String phone, String grade, String school,
      String weixin, String parentRela, String parentName, String parentPhone, String parentWeixin,
      String parentRela2, String parentName2, String parentPhone2, String parentWeixin2,
      String empUuid, String rank, String source, String courseYX) {
    super();
    this.uuid = uuid;
    this.name = name;
    this.sex = sex;
    this.phone = phone;
    this.grade = grade;
    this.school = school;
    this.weixin = weixin;
    this.parentRela = parentRela;
    this.parentName = parentName;
    this.parentPhone = parentPhone;
    this.parentWeixin = parentWeixin;
    this.parentRela2 = parentRela2;
    this.parentName2 = parentName2;
    this.parentPhone2 = parentPhone2;
    this.parentWeixin2 = parentWeixin2;
    this.empUuid = empUuid;
    this.rank = rank;
    this.source = source;
    this.courseYX = courseYX;
  }

  @Override
  public String toString() {
    return "YXstudent 意向学员[uuid=" + uuid + ", createDate=" + createDate + ", modifyDate=" + modifyDate
        + ", createPeople=" + createPeople + ", modifyPeople=" + modifyPeople + ", name=" + name
        + ", sex=" + sex + ", phone=" + phone + ", grade=" + grade + ", school=" + school
        + ", weixin=" + weixin + ", parentRela=" + parentRela + ", parentName=" + parentName
        + ", parentPhone=" + parentPhone + ", parentWeixin=" + parentWeixin + ", parentRela2="
        + parentRela2 + ", parentName2=" + parentName2 + ", parentPhone2=" + parentPhone2
        + ", parentWeixin2=" + parentWeixin2 + ", empUuid=" + empUuid + ", rank=" + rank
        + ", source=" + source + ", courseYX=" + courseYX + ", openAndclose=" + openAndclose
        + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
        + super.toString() + "]结束";
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(String modifyDate) {
    this.modifyDate = modifyDate;
  }

  public String getCreatePeople() {
    return createPeople;
  }

  public void setCreatePeople(String createPeople) {
    this.createPeople = createPeople;
  }

  public String getModifyPeople() {
    return modifyPeople;
  }

  public void setModifyPeople(String modifyPeople) {
    this.modifyPeople = modifyPeople;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getWeixin() {
    return weixin;
  }

  public void setWeixin(String weixin) {
    this.weixin = weixin;
  }

  public String getParentRela() {
    return parentRela;
  }

  public void setParentRela(String parentRela) {
    this.parentRela = parentRela;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getParentPhone() {
    return parentPhone;
  }

  public void setParentPhone(String parentPhone) {
    this.parentPhone = parentPhone;
  }

  public String getParentWeixin() {
    return parentWeixin;
  }

  public void setParentWeixin(String parentWeixin) {
    this.parentWeixin = parentWeixin;
  }

  public String getParentRela2() {
    return parentRela2;
  }

  public void setParentRela2(String parentRela2) {
    this.parentRela2 = parentRela2;
  }

  public String getParentName2() {
    return parentName2;
  }

  public void setParentName2(String parentName2) {
    this.parentName2 = parentName2;
  }

  public String getParentPhone2() {
    return parentPhone2;
  }

  public void setParentPhone2(String parentPhone2) {
    this.parentPhone2 = parentPhone2;
  }

  public String getParentWeixin2() {
    return parentWeixin2;
  }

  public void setParentWeixin2(String parentWeixin2) {
    this.parentWeixin2 = parentWeixin2;
  }

  public String getEmpUuid() {
    return empUuid;
  }

  public void setEmpUuid(String empUuid) {
    this.empUuid = empUuid;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getCourseYX() {
    return courseYX;
  }

  public void setCourseYX(String courseYX) {
    this.courseYX = courseYX;
  }

  public String getOpenAndclose() {
    return openAndclose;
  }

  public void setOpenAndclose(String openAndclose) {
    this.openAndclose = openAndclose;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public int getStudentID() {
    return studentID;
  }

  public void setStudentID(int studentID) {
    this.studentID = studentID;
  }
  
  
  
  
  
  

}//end class
