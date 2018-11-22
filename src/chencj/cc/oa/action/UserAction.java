package chencj.cc.oa.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import chencj.cc.oa.action.base.impl.BaseActionImpl;
import chencj.cc.oa.entity.Department;
import chencj.cc.oa.entity.Role;
import chencj.cc.oa.entity.User;
import chencj.cc.oa.service.DepartmentService;
import chencj.cc.oa.service.RoleService;
import chencj.cc.oa.service.UserService;
import chencj.cc.oa.utils.TreeDepartmentUtils;

@Controller
@Scope("prototype")
public class UserAction extends BaseActionImpl<User>{
		
	@Resource
	private UserService userService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private RoleService roleService;
	
	
	public String list(){
		List<User> list = userService.findAll();
		getValueStack().set("recordList", list);
		
		return "list";
	}
	
	public String addUI(){
		List<Department> list = departmentService.findTop();
		List<Department> tree = TreeDepartmentUtils.getShowTree(list);
		getValueStack().set("treeList", tree);
		List<Role> list2 = roleService.findAll();
		getValueStack().set("roleList", list2);
		return "add";
	}
	
	private String departmentId;
	private long[] roleIds;
	
	
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(long[] roleIds) {
		this.roleIds = roleIds;
	}

	public String add(){
		Department department = departmentService.findOne(Long.parseLong(departmentId));
		getModel().setDepartment(department);
		
		List<Role> roles = roleService.findAllByIds(roleIds);
		getModel().setRoles(new HashSet<>(roles));
		getModel().setPassword("1234");
		userService.save(getModel());
		return "toList";
	}
	
	public String delete(){
		User user = userService.findOne(getModel().getUser_id());
		userService.delete(user);
		return "toList";
	}
	
	
	public String editUI(){
		User _user = userService.findOne(getModel().getUser_id());
		getValueStack().push(_user);
		List<Department> list = departmentService.findTop();
		List<Department> tree = TreeDepartmentUtils.getShowTree(list);
		getValueStack().set("treeList", tree);
		List<Role> list2 = roleService.findAll();
		getValueStack().set("roleList", list2);
		if(_user.getDepartment()!=null)
			departmentId=_user.getDepartment().getDe_id()+"";
		Set<Role> roles = _user.getRoles();
		roleIds=new long[roles.size()];
		if(_user.getRoles()!=null&&_user.getRoles().size()>0){
			int c=0;
			for (Role role : roles) {
				roleIds[c]=role.getRole_id();
				c++;
			}
		}
		return "edit";
	}
	
	
	public String edit(){
		User user = userService.findOne(getModel().getUser_id());
		if(departmentId!=null){
			Department department = departmentService.findOne(Long.parseLong(departmentId));
			user.setDepartment(department);
		}else {
			user.setDepartment(null);
		}
		//user.setRoles(null);
		if(roleIds!=null){
			List<Role> roles = roleService.findAllByIds(roleIds);
			user.setRoles(new HashSet<>(roles));
		}//getModel().setPassword("1234");
		else {
			user.setRoles(null);
		}
		userService.update(user);
		return "toList";
	}

	public String findByLoginName(){
		String login_name = getModel().getLogin_name();
		User _user = userService.findByLoginName(login_name);
		if(_user!=null){
			
			try {
				PrintWriter writer = ServletActionContext.getResponse().getWriter();
				writer.print("0");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	public String intiPassword(){
		User user = userService.findOne(getModel().getUser_id());
		user.setPassword("1234");
		userService.update(user);
		return "toList";
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
	
	
	public String login(){
		//getModel()进行非空校验 前端 后端 都可以
		if(getModel().getLogin_name().trim().equals("")){
			addFieldError("username_error", "用户名不能为空");
			return "login";
		}
		if(getModel().getPassword().trim().equals("")){
			addFieldError("psw_error", "<font color='red'>用户名不能为空</font>");
			return "login";
		}
		User user = userService.findByLoginName(getModel().getLogin_name());
		if(user==null){
			//携带者错误信息 传递到页面
			addActionError("用户名不存在");
			return "login";
		}
		
		else if(user.getPassword().equals(getModel().getPassword())){
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			return "index";
		}
		else {
			addActionError("密码错误");
			return "login";
		}
	}
	
}
