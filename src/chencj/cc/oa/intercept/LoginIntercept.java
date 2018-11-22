package chencj.cc.oa.intercept;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import chencj.cc.oa.entity.User;

public class LoginIntercept  extends MethodFilterInterceptor{

	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionProxy proxy = invocation.getProxy();
		
		String actionName = proxy.getActionName();
		//System.out.println(actionName);
		//System.out.println(namespace);
		if(actionName.substring(actionName.lastIndexOf("_")+1).equals("login")){
			return invocation.invoke();
		}
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		
		
		if(user==null)return "login";
		return invocation.invoke();
	}

}
