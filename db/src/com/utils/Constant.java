package com.utils;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.TreeMap;



public class Constant {
	
	public static String CACHE_PENDINGREQ_TIPS;
	public static int PENDINGDEPOSITCOUNT;
	public static int PENDINGWITHDRAWLCOUNT;
	public static int PENDINGPROMOTIONCOUNT;
	public static int PENDINGOTHERCOUNT;
	public static String PROJECTPATH;
	
	public static String GAME_PROPERTIES="game.properties";
	public static String INIT_PROPERTIES="init.properties";
	public static String IPCONF_PROPERTIES="ipconf.properties";
	public static String SMS_PROPERTIES="smsconfig.properties";
	
	public static String DB_DES_KEY="zfmnllf";
	
	public static final Object DEPOSIT_LOCKER=new Object();
	public static final Object PROMOTION_LOCKER=new Object();
	public static final Object MODIFYCREDIT_LOCKER=new Object();
	
//	public static String PREFIXLOGINNAME="P";
//	
//	public static String PRODUCTCODE="A";
	public static String DEPOSIT_PREFIX="01";
	public static String WITHDRAWL_PREFIX="02";
	public static String MODIFYBANK_PREFIX="03";
	public static String PROMOTION_PREFIX="04";
	public static String MODIFYPHONE_PREFIX="05";
	public static String MODIFYCUSLEVEL_PREFIX="06";
	public static String TRANSFER_PREFIX="07";
	public static String REFEREEPROMOTION_PREFIX="08";
	public static String MODIFYPOINTS_PREFIX="09";
	public static String INTERNALTRANSFER_PREFIX="10";
	public static String GROUPON_PREFIX="11";
	public static String ONLINEPAY_PREFIX="12";
	public static String COMMISSION_PREFIX="13";
	public static String JACKPOT_PREFIX="14";
	public static String GAMETRANSFER_PREFIX="15";
	public static String MODIFYCREDIT_PREFIX="16";
	public static String MODIFYPARENT_PREFIX="17";
	
	public static TreeMap<String,String> BankMap=new TreeMap<String,String>();
	static {
		BankMap.put("ICBC", "中国工商银行");
		BankMap.put("ABOC", "中国农业银行");
		BankMap.put("CMB", "招商银行");
		BankMap.put("CCBC", "中国建设银行");
		BankMap.put("CMBC", "中国民生银行");
		BankMap.put("BOC", "中国银行");
		BankMap.put("BCM", "交通银行");
		BankMap.put("IBC", "兴业银行");
		BankMap.put("HXB", "华夏银行");
		BankMap.put("SPDB", "浦发银行");
		BankMap.put("CEB", "光大银行");
		BankMap.put("SZPAB", "平安银行");
		BankMap.put("CITIC", "中信银行");
		BankMap.put("GDB","广东发展银行");
		BankMap.put("PSBC", "中国邮政储蓄银行");
	}
	
	public static TreeMap<String,String> ROLESEARCHTIMEMap=new TreeMap<String,String>();
	static {	
		ROLESEARCHTIMEMap.put("ROLE_0", "");
		ROLESEARCHTIMEMap.put("ROLE_CEO", "");	
		ROLESEARCHTIMEMap.put("ROLE_GM", "120");
		ROLESEARCHTIMEMap.put("ROLE_CS_SUPERVISOR", "90");
		ROLESEARCHTIMEMap.put("ROLE_CS_TEAMLEADER", "30");
		ROLESEARCHTIMEMap.put("ROLE_CS_MEMBER", "7");
		ROLESEARCHTIMEMap.put("ROLE_FIN_SUPERVISOR", "90");
		ROLESEARCHTIMEMap.put("ROLE_FIN_TEAMLEADER", "15");
		ROLESEARCHTIMEMap.put("ROLE_FIN_MEMBER", "15");
		ROLESEARCHTIMEMap.put("ROLE_FIN_FUNDADMIN", "30");
		ROLESEARCHTIMEMap.put("ROLE_RPT_LICENSE", "");
		ROLESEARCHTIMEMap.put("ROLE_MKT_SUPERVISOR", "90");
		ROLESEARCHTIMEMap.put("ROLE_MKT_TEAMLEADER", "15");
		ROLESEARCHTIMEMap.put("ROLE_MKT_MEMBER", "7");		
		ROLESEARCHTIMEMap.put("ROLE_MKT_QMEMBER", "30");	
		ROLESEARCHTIMEMap.put("ROLE_QA_SUPERVISOR", "90");
		ROLESEARCHTIMEMap.put("ROLE_QA_TEAMLEADER", "30");
		ROLESEARCHTIMEMap.put("ROLE_QA_MEMBER", "7");			
	}		
	
	public static TreeMap<String,String> ROLEMINDATEMap=new TreeMap<String,String>();
	static {	
		ROLEMINDATEMap.put("ROLE_CEO", "2013-02-01");
		ROLEMINDATEMap.put("ROLE_RPT_LICENSE", "2014-08-01");
	}
	
	public static TreeMap<String,String> BANKACCOUNTTYPEMap=new TreeMap<String,String>();
	static {
		BANKACCOUNTTYPEMap.put("借记卡", "借记卡");
		BANKACCOUNTTYPEMap.put("存折", "存折");
		BANKACCOUNTTYPEMap.put("信用卡", "信用卡");
		BANKACCOUNTTYPEMap.put("其他", "其他");
	}
	
	public static TreeMap<String,String> BANKACCOUNTCARDTYPEMap=new TreeMap<String,String>();
	static {
		BANKACCOUNTCARDTYPEMap.put("0", "其他用途卡");
		BANKACCOUNTCARDTYPEMap.put("1", "收款卡");
		BANKACCOUNTCARDTYPEMap.put("2", "中转卡");
		BANKACCOUNTCARDTYPEMap.put("3", "储款卡");		
	}	

	public static TreeMap<String,String> PROMOTIONMap=new TreeMap<String,String>();
	static {
		PROMOTIONMap.put("KHYH", "开户优惠(1st Promo)");
		PROMOTIONMap.put("XMYH", "洗码优惠(rakeback)");
		PROMOTIONMap.put("CKYH", "存款优惠");
		PROMOTIONMap.put("TKYH", "推广优惠");
		PROMOTIONMap.put("SRLJYH", "生日礼金优惠");
		PROMOTIONMap.put("FHLJ", "复活礼金(rebonus)");
		PROMOTIONMap.put("CCCS", "次次存送10%优惠");
		PROMOTIONMap.put("QQJJ", "全勤奖金");
		PROMOTIONMap.put("QQJJSLJ", "全勤奖加送礼金");
//		PROMOTIONMap.put("QTYH", "其他优惠");
		PROMOTIONMap.put("SCTKYH", "市场优惠(MKT Promo)");
		PROMOTIONMap.put("YLMYH", "跃龙门优惠");
		PROMOTIONMap.put("ZSCYH", "周首存100%优惠");
		PROMOTIONMap.put("VIPMZCS100", "VIP每周优惠100%");
		PROMOTIONMap.put("QDLJYH", "签到礼金优惠");
		PROMOTIONMap.put("BBS20", "存款笔笔送-20%");
		PROMOTIONMap.put("VIPMYMFCM", "VIP每月免费筹码");
		PROMOTIONMap.put("BBQBJJ", "百倍千倍奖金");
		PROMOTIONMap.put("MZLJYH", "每周礼金");
		PROMOTIONMap.put("TS100YH", "每日优惠-⁠特色100%");
		PROMOTIONMap.put("ZRSCYH", "⁠真人首存");
		PROMOTIONMap.put("VIPMZCSYH", "VIP每周存送");
		PROMOTIONMap.put("VIPMYCSYH", "VIP每月存送");
		PROMOTIONMap.put("VIPXMYH", "VIP洗码优惠(rakeback)");
		PROMOTIONMap.put("TYYH100", "体育优惠100%");
		PROMOTIONMap.put("WY7TLYH", "每日存送50%");
		PROMOTIONMap.put("WYH50", "周末存送50%");
		PROMOTIONMap.put("MRSCYH30", "每日存送30%");
		PROMOTIONMap.put("JBLTYYH", "特邀优惠");
		PROMOTIONMap.put("ZNLJYH", "周年礼金");
		PROMOTIONMap.put("JJLJYH", "晋级礼金");
		PROMOTIONMap.put("WJDCLJ", "问卷调查礼金");
		PROMOTIONMap.put("EWJLYH", "额外奖励");
		PROMOTIONMap.put("C3S1YH", "存三送一");
		PROMOTIONMap.put("LFMRYH", "每日优惠");
		PROMOTIONMap.put("LFMRFHYH", "每日优惠--复活礼金");
		PROMOTIONMap.put("JBLMR58CJ", "每日优惠--58彩金");
		PROMOTIONMap.put("DLCS200YH", "代理存送200%");
		PROMOTIONMap.put("VIPCKZS", "存5送1优惠");
		PROMOTIONMap.put("ZMDPSYH", "周末大派送");
		PROMOTIONMap.put("NCWSYH", "⁠你存我送");
		PROMOTIONMap.put("JBLXSYH", "限时优惠");
		PROMOTIONMap.put("TYHLXJ", "体育现金返利");
		PROMOTIONMap.put("JBLXS100YH", "限时100%");
		PROMOTIONMap.put("JBLXS300YH", "限时300%");
		PROMOTIONMap.put("TYCLYH", "体育串联优惠");
		PROMOTIONMap.put("JDFJYH", "绝地反击");
		PROMOTIONMap.put("FX28YH", "分享-28");
		PROMOTIONMap.put("ZRCGYH", "真人闯关");
		PROMOTIONMap.put("TYCS10YH", "体育存送-⁠10%");
		PROMOTIONMap.put("WYH50", "周末每日存送50%");
		PROMOTIONMap.put("LFNQHB28", "8年庆红包28元");
		/*PROMOTIONMap.put("CJ28", "双旦-28彩金");
		PROMOTIONMap.put("CJ68", "双旦-68彩金");
		PROMOTIONMap.put("CJ88", "双旦-88彩金");
		PROMOTIONMap.put("LFCJ58", "双旦-58彩金");*/
//		PROMOTIONMap.put("REDPACKET", "金猴年-新春红包");
//		PROMOTIONMap.put("XNGXFCYH", "恭喜发财");
//		PROMOTIONMap.put("LFC5S1YH", "存5送1优惠");
		/*PROMOTIONMap.put("SDCS", "双旦-存送50%优惠券");
		PROMOTIONMap.put("SDZS", "双旦-存款赠送100%优惠券");
		PROMOTIONMap.put("SDFHLJ", "双旦-复活礼金优惠券");
		PROMOTIONMap.put("SDXMFB", "双旦-洗码洗码优惠券");
		PROMOTIONMap.put("LFSDCS30", "双旦-存款赠送30%优惠券");
		PROMOTIONMap.put("SDNONE", "双旦-空蛋");*/
	}	
	
	public static LinkedHashMap<String,String> CUSLEVELMap=new LinkedHashMap<String,String>();
	static {
		CUSLEVELMap.put("-1", "黑名单");
		CUSLEVELMap.put("0", "星级0");
		CUSLEVELMap.put("1", "星级1");
		CUSLEVELMap.put("2", "星级2");
		CUSLEVELMap.put("3", "星级3");
		CUSLEVELMap.put("4", "星级4");
		CUSLEVELMap.put("5", "星级5");
		CUSLEVELMap.put("6", "星级6");
		CUSLEVELMap.put("7", "星级7");
		CUSLEVELMap.put("8", "星级8");
		CUSLEVELMap.put("9", "星级9");
		CUSLEVELMap.put("10", "星级10");
		CUSLEVELMap.put("11", "星级11");
		CUSLEVELMap.put("12", "星级12");
		CUSLEVELMap.put("13", "星级13");
		CUSLEVELMap.put("14", "星级14");
		CUSLEVELMap.put("15", "星级15");
		CUSLEVELMap.put("16", "星级16");
		CUSLEVELMap.put("17", "星级17");
		CUSLEVELMap.put("18", "星级18");
		CUSLEVELMap.put("19", "星级19");
		CUSLEVELMap.put("20", "星级20");
		CUSLEVELMap.put("21", "星级21");
		CUSLEVELMap.put("22", "星级22");
		CUSLEVELMap.put("23", "星级23");
		CUSLEVELMap.put("24", "星级24");
		CUSLEVELMap.put("25", "星级25");
	}	
	
	public static String POINTS_LOGS_TYPE_LOGIN="login";
	public static String POINTS_LOGS_TYPE_DEPOSIT="deposit";
	public static String POINTS_LOGS_TYPE_MODIFY="modify";
	public static String POINTS_LOGS_TYPE_EXCHANGE="exchange";
	
	public static TreeMap<String,String> POINTSTYPEMap=new TreeMap<String,String>();
	static {
		POINTSTYPEMap.put(POINTS_LOGS_TYPE_LOGIN, "报到");
		POINTSTYPEMap.put(POINTS_LOGS_TYPE_DEPOSIT, "存款");
		POINTSTYPEMap.put(POINTS_LOGS_TYPE_MODIFY, "修改积分");
		POINTSTYPEMap.put(POINTS_LOGS_TYPE_EXCHANGE, "兑换");
	}	
	
	public static synchronized String getPno(String pno_prefix,String pno_suffix){
		StringBuffer sb=new StringBuffer();
		sb.append(InitData.productcode);
		sb.append(pno_prefix);
		//日期时间
		sb.append(DateUtil.getDateFormat(new java.util.Date(),"yyMMddHHmmss"));
//		//两位随机数
//		Random ran2=new Random();
//		int ranInt=ran2.nextInt(100);
//		if (ranInt<10)
//			ranInt+=10;
//		sb.append(String.valueOf(ranInt));
		sb.append(pno_suffix);
		return sb.toString();
	}
	
	public static synchronized String getPno(String pno_prefix){
		StringBuffer sb=new StringBuffer();
		sb.append(InitData.productcode);
		sb.append(pno_prefix);
		//日期时间
		sb.append(DateUtil.getDateFormat(new java.util.Date(),"yyMMddHHmmss"));
		//两位随机数
		Random ran2=new Random();
		int ranInt=ran2.nextInt(100);
		if (ranInt<10)
			ranInt+=10;
		sb.append(String.valueOf(ranInt));
		return sb.toString();
	}
	
//	public static TreeMap<String,String> ONLINEPAYTYPEMap=new TreeMap<String,String>();
//	static {
//		ONLINEPAYTYPEMap.put("ips", "环讯ips");
//		ONLINEPAYTYPEMap.put("ecpss", "汇潮ecpss");
//	}	
}
