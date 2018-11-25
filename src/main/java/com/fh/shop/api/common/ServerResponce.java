/** 
 * <pre>项目名称:shop_admin 
 * 文件名称:ServerResponce.java 
 * 包名:com.fh.member.provider.common
 * 创建日期:2018年10月19日下午3:15:15 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.common;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop_admin    
 * 类名称：ServerResponce    
 * 类描述：    
 * 创建人：顾帅 848999416@.com    
 * 创建时间：2018年10月19日 下午3:15:15    
 * 修改人：顾帅 848999416@.com      
 * 修改时间：2018年10月19日 下午3:15:15    
 * 修改备注：       
 * @version </pre>    
 */
public class ServerResponce implements Serializable{

	private static final long serialVersionUID = 5351168074382286770L;

	private int code;
	
	private String msg;
	
	private Object data;

   private ServerResponce(int code,String msg,Object data){
	   this.code=code;
	   this.msg=msg;
	   this.data=data;
   }
	
   public static ServerResponce error(SystemEnum systemEnum){
	   return new ServerResponce(systemEnum.getCode(),systemEnum.getMsg(),null);
   }
   public static ServerResponce error(){
	   return new ServerResponce(SystemEnum.ERROR.getCode(),SystemEnum.ERROR.getMsg(),null);
   }
	public static ServerResponce error(int code,String msg){
		return new ServerResponce(code,msg,null);
	}
   public static ServerResponce success(Object data){
	   return new ServerResponce(SystemEnum.SUCCESS.getCode(),SystemEnum.SUCCESS.getMsg(),data);
   }
   public static ServerResponce success(){
	   return new ServerResponce(SystemEnum.SUCCESS.getCode(),SystemEnum.SUCCESS.getMsg(),null);
   }
   
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}
	
	
}
