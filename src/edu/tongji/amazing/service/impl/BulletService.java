package edu.tongji.amazing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.AdvertisementDao;
import edu.tongji.amazing.dao.impl.BulletDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.service.IBulletService;

@Service("bulletservice")
public class BulletService implements IBulletService {
	
	
	@Resource(name="bulletdao")
	private BulletDao bulletdao;
	
	
	//根据某一个id获得具体的弹幕内容
	@Override
	public Bullet getBullet(String id){
		return bulletdao.QueryById(id);
	}
	
	//返回一个用户的所有弹幕
	@Override
	public List<Bullet> getAllBullet(String userId){
		return bulletdao.QueryByPhone(userId);
	}
	
	//增加新的弹幕
	@Override
	public boolean addBullet(Bullet bullet){
		if(bullet.getColor().equals("")||bullet.getContent().equals("")||bullet.getId().equals("")
				||bullet.getPhone().equals("")||bullet.getSize().equals("")||bullet.getColor().equals("")
				||bullet.getTime().equals("")||bullet.getTitle().equals("")){
			return false;
		}
		return bulletdao.Insert(bullet);
	}

	@Override
	public boolean clearShortCut(String phone, String key) {
		// TODO Auto-generated method stub
		if(phone.equals("")||key.equals("")){
			return false;
		}
		return bulletdao.clearShortCut(phone, key);
	}

	@Override
	public boolean addShortCut(String id, String key) {
		// TODO Auto-generated method stub
		return bulletdao.setShortCut(id, key);
	}

	@Override
	public int Getnumbers(String phone) {
		// TODO Auto-generated method stub
		return bulletdao.GetNumbers(phone);
	}

	@Override
	public Bullet GetLast(String phone) {
		// TODO Auto-generated method stub
		return bulletdao.GetLast(phone);
	}

	@Override
	public String CheckShortCut(String phone, String key) {
		// TODO Auto-generated method stub
		return bulletdao.CheckShortCut(phone, key);
	}

	@Override
	public boolean updateBullet(Bullet bullet) {
		// TODO Auto-generated method stub
		if(bullet.getColor().equals("")||bullet.getContent().equals("")||bullet.getId().equals("")
				||bullet.getPhone().equals("")||bullet.getSize().equals("")||bullet.getColor().equals("")
				||bullet.getTime().equals("")||bullet.getTitle().equals("")){
			return false;
		}
		return bulletdao.Update(bullet);
	}

	@Override
	public boolean DeleteBullet(String id) {
		// TODO Auto-generated method stub
		return bulletdao.DeleteViaId(id);
	}

	@Override
	public Bullet GetBarrageByKey(String phone, String key) {
		// TODO Auto-generated method stub
		return bulletdao.GetBarrageByKey(phone, key);
	}
}
