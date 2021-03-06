package edu.tongji.amazing.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.AdministratorDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.Finance;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdministratorService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.ComparaFinance;
@Service("administratorservice")
public class AdministratorService implements IAdministratorService{

	@Resource
	private AdministratorDao dao;
	@Override
	public boolean addAdministrator(User user) {
		// TODO Auto-generated method stub
		return dao.Insert(user);
	}
	@Override
	public int getalladvertisements() throws Exception {
		// TODO Auto-generated method stub
		return dao.getalladvertisements();
	}
	@Override
	public int getallusers() throws Exception {
		// TODO Auto-generated method stub
		return dao.getallusers();
	}
	@Override
	public int unexamineUsers() throws Exception {
		// TODO Auto-generated method stub
		return dao.unexamineUsers();
	}
	@Override
	public int unexamineAdvertisements() throws Exception {
		// TODO Auto-generated method stub
		return dao.unexamineAdvertisement();
	}
	@Override
	public List<User> getShowUsers() throws Exception {
		// TODO Auto-generated method stub
		return dao.getShowUsers();
	}
	@Override
	public List<Advertisement> getShowAdvertisements() throws Exception {
		// TODO Auto-generated method stub
		return dao.getShowAdvertisement();
	}
	@Override
	public List<Balance> getShowBalance() throws Exception {
		// TODO Auto-generated method stub
		return dao.getShowBalance();
	}
	@Override
	public boolean login(String phone, String password) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(phone, password);
	}
	@Override
	public User getAdministratorinfo(String phone) throws Exception {
		// TODO Auto-generated method stub
		return dao.getUserbyPhone(phone);
	}
	@Override
	public void changeAdvertisementStatus(String id, String status) throws Exception {
		// TODO Auto-generated method stub
		dao.changeAdvertisementStatus(id, status);
	}
	@Resource
	private ICarOwnerService icar;
	@Override
	public boolean changeUserStatus(String phone, String status) throws Exception {
		// TODO Auto-generated method stub
		if(icar.IsUserExist(phone)==null){
			return false;
		}
		if(!status.equals("1")&&!status.equals("0")&&!status.equals("-1")){
			return false;
		}
		return dao.changeUserStatus(phone, status);
	}
	@Override
	public List<Finance> wholefinace() throws Exception {
		// TODO Auto-generated method stub
		List<Finance> list =  dao.wholefinace();
		ComparaFinance comparator = new ComparaFinance();
		Collections.sort(list,comparator);
		return list;
	}
	@Override
	public List<User> UserTable(int pagenum) throws Exception {
		// TODO Auto-generated method stub
		return dao.UserTable(pagenum);
	}
	@Override
	public List<Advertisement> AdvertisementTable(int pagenum) throws Exception {
		// TODO Auto-generated method stub
		return dao.AdvertisementTable(pagenum);
	}
	@Override
	public List<Balance> BalanceTable(int pagenum) throws Exception {
		// TODO Auto-generated method stub
		return dao.BalanceTable(pagenum);
	}
	@Override
	public String GetUsernameByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		return dao.GetUsernameByPhone(phone);
	}
	
	

}
