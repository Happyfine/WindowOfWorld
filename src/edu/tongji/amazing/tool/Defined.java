package edu.tongji.amazing.tool;

import org.springframework.stereotype.Component;

@Component("define")
public class Defined {

	public final String Error = "errCode";
	public final String apikey = "1d2113d4b2e5178c1d097916c5f691e8";
	public final String baseurl = "http://10.60.42.70:8080";
	public final String basepath = "D:\\Eclipse\\apache-tomcat\\webapps";
	public static String Baiduapk ="buPZFGnRf6EhZaEKHHdQswbMRMSqcGx5";
	public final int SUCCESS = 1;//成功
	public final int FAIL = 0; //失败
	public final int NOUSER = 101; //不存在用户
	public final int WrongPassword = 102; //密码错误
	public final int RrgisteredUSER = 104; //已经注册的用户
	public final int BARRAGEEXIST = 110;  //弹幕快捷键已经被使用
	public final int BARRAGENOEXIST = 111;  //弹幕快捷键没有被使用
	public final int[] adprice = {1,1,1,1,1,1,2,2,2,2,3,3,3,3,3,3,3,3,3,3,2,2,1,1};
}
