package com.YXcrm.query.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-1-30 下午7:18:43
 * 类说明
 * 分页查询跟踪记录表
 */

public class QuePageRecord {
  
  private String ditchUuid;//渠道uuid
  private String currentPage;//当前页码
  private String maxResult;//每页最大条数
  
  public QuePageRecord() {
    super();
  }

  public QuePageRecord(String ditchUuid, String currentPage, String maxResult) {
    super();
    this.ditchUuid = ditchUuid;
    this.currentPage = currentPage;
    this.maxResult = maxResult;
  }
  
  

  @Override
  public String toString() {
    return "QuePageRecord 分页查询Bean[ditchUuid=" + ditchUuid + ", currentPage=" + currentPage
        + ", maxResult=" + maxResult + "]";
  }

  public String getDitchUuid() {
    return ditchUuid;
  }

  public void setDitchUuid(String ditchUuid) {
    this.ditchUuid = ditchUuid;
  }

  public String getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(String currentPage) {
    this.currentPage = currentPage;
  }

  public String getMaxResult() {
    return maxResult;
  }

  public void setMaxResult(String maxResult) {
    this.maxResult = maxResult;
  }
  
  

}//end class
