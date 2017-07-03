package com.customermanagement.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Parameter;

import com.customermanagement.entity.PageBean;
import com.customermanagement.entity.User;
import com.customermanagement.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user=new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private int currPage=1;;
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String login(){
		System.out.println("Action");
		User existUser=userService.login(user);
		if(existUser==null){
			this.addActionError("用户名或密码错误");
			return "login";
		}else{
			ActionContext.getContext().getSession().put("user", existUser);
			if(existUser.getIsAdmin()){
				return "adminIndex";
			}
			else{
				return "userIndex";
			}
		}
	}
	
	public String add(){
		return  "insert";
	}
	
	public String addCustomer(){
		user.setPassword("123456");
		user.setIsAdmin(false);
		boolean flag=userService.addCustomer(user);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter printWriter = null;
		try {
			printWriter=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(flag){
//			printWriter.write("<script>alert('数据插入成功');</script>");
//		}
//		else{
//			printWriter.print("<script>alert('数据插入失败!');</script>");
//		}
		return "adminIndex";
	}
	
	public String delete(){
		User deleteUser=userService.findById(user.getUid());
		if(deleteUser!=null){
			userService.delete(deleteUser);
		}
		return "adminIndex";
	}
	
	public String edit(){
		user=userService.findById(user.getUid());
		return "edit";
	}
	
	public String update(){
		System.out.println();
		userService.update(user);
		return "adminIndex";
	}

	public String findAll(){
		PageBean<User> pageBean=userService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "userList";
	}
	
}
