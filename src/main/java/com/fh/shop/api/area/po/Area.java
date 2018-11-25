/** 
 * <pre>项目名称:shop_admin 
 * 文件名称:Area.java 
 * 包名:com.fh.shop.admin.po.area 
 * 创建日期:2018年10月8日下午8:38:33 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.area.po;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop_admin    
 * 类名称：Area    
 * 类描述：    
 * 创建人：顾帅 848999416@.com    
 * 创建时间：2018年10月8日 下午8:38:33    
 * 修改人：顾帅 848999416@.com      
 * 修改时间：2018年10月8日 下午8:38:33    
 * 修改备注：       
 * @version </pre>    
 */
public class Area implements Serializable{

	private static final long serialVersionUID = -5883879769595824974L;
   private Integer areaId;
   private Integer fatherId;
   private String areaName;
public Integer getAreaId() {
	return areaId;
}
public void setAreaId(Integer areaId) {
	this.areaId = areaId;
}
public Integer getFatherId() {
	return fatherId;
}
public void setFatherId(Integer fatherId) {
	this.fatherId = fatherId;
}
public String getAreaName() {
	return areaName;
}
public void setAreaName(String areaName) {
	this.areaName = areaName;
}
   
}
