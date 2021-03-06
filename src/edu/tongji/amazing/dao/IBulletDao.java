package edu.tongji.amazing.dao;

import java.util.List;

import edu.tongji.amazing.model.Bullet;

/*
 * 弹幕类的操作
 */
public interface IBulletDao {

	//设置弹幕的快捷键
	public boolean setShortCut(String id,String key);
	
	//清空对应弹幕的key
	public boolean clearShortCut(String phone,String key);
	
    //查看当前快捷键是否有了设置
	public String CheckShortCut(String phone,String key);
	
	//通过快捷键查找弹幕
	public Bullet GetBarrageByKey(String phone,String key);
}
