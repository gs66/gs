/** 
 * <pre>项目名称:shop_admin 
 * 文件名称:WebContext.java 
 * 包名:com.fh.shop.admin.util 
 * 创建日期:2018年10月17日下午6:58:05 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.util;

import javax.servlet.http.HttpServletRequest;

/** 
 * <pre>项目名称：shop_admin    
 * 类名称：WebContext    
 * 类描述：    
 * 创建人：顾帅 848999416@.com    
 * 创建时间：2018年10月17日 下午6:58:05    
 * 修改人：顾帅 848999416@.com      
 * 修改时间：2018年10月17日 下午6:58:05    
 * 修改备注：       
 * @version </pre>    
 */
public class WebContext {
   public static ThreadLocal<HttpServletRequest> requestLocal=new ThreadLocal();
   
   public static void setRequset(HttpServletRequest request){
	   requestLocal.set(request);
   }
   
   public static HttpServletRequest getRequest(){
	   return requestLocal.get();
   }
   
   public static void remove(){
	   requestLocal.remove();
   }
}
