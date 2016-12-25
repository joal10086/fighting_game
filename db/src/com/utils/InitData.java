package com.utils;



public class InitData {
	//由 spring 使用 init.properties 的数据进行注入
	public static String loginnameminlen;
	public static String loginnamemaxlen;
	
	public static String productname;
	public static String depositperponit;
	public static String partnerprefixloginname;
	public static String autotransfer;
	public static String autogeneratecommission;
	public static String phoneuidprefix;
	public static Object productcode;

	static{
		PropertiesUtil pu=new PropertiesUtil(Constant.INIT_PROPERTIES);
		
		InitData.loginnameminlen = pu.getvalue("initdata.loginname.minlen");
		InitData.loginnamemaxlen = pu.getvalue("initdata.loginname.maxlen");
		InitData.productcode = pu.getvalue("initdata.loginname.maxlen");
		
	}
}
