/** 
 * <pre>项目名称:shop_admin 
 * 文件名称:SystemEnum.java 
 * 包名:com.fh.member.provider.common
 * 创建日期:2018年10月19日下午3:18:51 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.common;

/** 
 * <pre>项目名称：shop_admin    
 * 类名称：SystemEnum    
 * 类描述：    
 * 创建人：顾帅 848999416@.com    
 * 创建时间：2018年10月19日 下午3:18:51    
 * 修改人：顾帅 848999416@.com      
 * 修改时间：2018年10月19日 下午3:18:51    
 * 修改备注：       
 * @version </pre>    
 */
public enum SystemEnum {

	SUCCESS(200,"ok"),
	ERROR(-1,"error"),
	MOBILE_MISS(2000,"手机号为空"),
	CODE_MISS(2004,"验证码错误"),
	MOBILE_INVALID(2001,"手机号不合法"),
	USER_NAME(2003,"用户名存在"),
	USER_MISS(2005,"用户名为空"),
	HEADER_IS_MISS(10000,"头信息丢失"),
	TIMEOUT(10001,"请求超时"),
	APPKEY_IS_ERROR(10002,"appKey无效"),
	SIGN_IS_ERROR(10003,"签名无效"),
	NONCE_IS_ERROR(10004,"黑客攻击了"),
	RATE_LIMIT_ERROR(10005,"接口限流"),
	MOBILE_CODE(2002,"验证码过期");

	private int code;
	private String msg;
	
	private SystemEnum(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	
}
