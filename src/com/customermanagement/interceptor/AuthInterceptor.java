package com.customermanagement.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AuthInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        System.out.println("session="+session);
        if (session.get("user") != null) {
            String result = invocation.invoke();
            return result;
        } else {
            return "login";
        }
	}

}
