package edu.tongji.amazing.service;


import edu.tongji.amazing.model.CarOwner;

public interface ICarOwnerService {
	// 登录的时候查看是否有此用户
	public boolean checkUser(String phone,String password);

	// 增加用户
	public void addUser(CarOwner user);

	// 更新用户信息
	public void updateUser(CarOwner user);

	// 挂失用户
	public boolean RvokeAccount(long identity);

	// 恢复用户身份
	public boolean ResumeAccount(long identity);

	// 根据身份证查找用户
	public CarOwner getUserbyIndentity(String identity);
	
	
}
