package chencj.cc.oa.action.base.impl;

import java.lang.reflect.ParameterizedType;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import chencj.cc.oa.action.base.BaseAction;

public class BaseActionImpl<T> extends ActionSupport implements BaseAction<T>{

	private Class clazz;
	private T t;
	public BaseActionImpl(){
		clazz = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			t = (T) clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取值站
	 * 进行页面后台 数据交互
	 * @return
	 */
	public ValueStack getValueStack(){
		return ActionContext.getContext().getValueStack();
	}
	
	public ActionContext getActionContext(){
		return ActionContext.getContext();
	}
	
	public ServletActionContext getServletActionContext(){
		return (ServletActionContext) getActionContext();
	}
	@Override
	public T getModel() {
		
		return t;
	}

}
