package com.customermanagement.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.customermanagement.dao.UserDao;
import com.customermanagement.entity.PageBean;
import com.customermanagement.entity.User;

@Transactional
public class UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		System.out.println("Service");
		User existUser=userDao.findUserByUsernameAndPassword(user);
		return existUser;
	}

	public boolean addCustomer(User user) {
		boolean flag=userDao.addCustomer(user);
		return flag;
	}
	
	public void delete(User user){
		userDao.delete(user);
	}

	public PageBean<User> findByPage(int currPage){
		
		PageBean<User> pageBean=new PageBean<User>();
		pageBean.setCurrPage(currPage);
		int pageSize=10;
		pageBean.setPageSize(pageSize);
		int totalCount=userDao.getUserCount();
		pageBean.setTotalCount(totalCount);
		int num=(int) Math.ceil((double)totalCount/pageSize);
		pageBean.setTotalPage(num);
		int begin=(currPage-1)*pageSize;
		List<User> list=userDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public User findById(int uid) {
		User user=userDao.findById(uid);
		return user;
	}

	public boolean update(User user) {
		boolean flag=userDao.update(user);
		return flag;
	}
	
	
}
