package com.customermanagement.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.customermanagement.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class UserDao extends HibernateDaoSupport{

	public User findUserByUsernameAndPassword(User user) {
		System.out.println("Dao");
		String hql="from User where username=? and password=?";
		List<User> users=(List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}

	public boolean addCustomer(User user) {

		try{
			this.getHibernateTemplate().save(user);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据插入失败");
			return false;
		}
	}

	//获取用户总数
	public int getUserCount(){
		String hql="select count(*) from User where isAdmin=false";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//分页查询用户
	/**
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<User> findByPage(int begin,int pageSize){
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("isAdmin", false));
		List<User> users=(List<User>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return users;
	}

	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}

	public User findById(int uid) {
		User user=this.getHibernateTemplate().get(User.class, uid);
		return user;
	}

	public boolean update(User user) {
		
		try{
			this.getHibernateTemplate().update(user);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据更新失败");
			return false;
		}
		
	}
	
	
}
