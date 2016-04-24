package edu.tongji.amazing.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdvertiserService;
import edu.tongji.amazing.tool.Defined;
@Controller("advertiserAction")
public class AdvertiserAction extends ActionSupport{

	@Resource(name = "advertiserservice")
	private IAdvertiserService service;
	
	@Resource(name = "defined")
	private Defined defined;
	
	private HashMap<String, Object> data;
	
	@Resource(name = "advertiser")
	private Advertiser advertiser;
	
//	新的广告商注册
	private String phone;
	private String username;
	private String realname;
	private String identity;
	private String password;
	private String licence;
	@Resource(name="user")
	private User user;
	
	public String AddnewAdvertiser() throws Exception{
		
		data = new HashMap<String,Object>();
		
		user.setBalace(0.0f);
		user.setCredit(0.0f);
		user.setIdentity(identity);
		user.setPassword(password);
		user.setPhone(phone);
		user.setRealname(realname);
		user.setUsername(username);
		user.setUserclass("2");
		user.setStatus("0");
		advertiser.setLicence(licence);
		advertiser.setPhone(phone);
		advertiser.setUser(user);
		if(service.addAdvertise(advertiser)){
			return "success";
		}
		return "fail";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	
	
	
	
	
	
	
	
}