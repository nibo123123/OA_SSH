package chencj.cc.oa.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import chencj.cc.oa.entity.Privilege;
import chencj.cc.oa.entity.Role;
import chencj.cc.oa.entity.User;
import chencj.cc.oa.service.PrivilegeService;

@Controller
public class HomeAction {

	public String index(){
		return "index";
	}
	
	public String left(){
//		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
//		Set<Role> roles = user.getRoles();
//		List<Privilege> list = new ArrayList<>();
//		for (Role role : roles) {
//			Set<Privilege> privileges = role.getPrivileges();
//			for (Privilege privilege : privileges) {
//				list.add(privilege);
//			}
//		}
		//List<Privilege> topList = (List<Privilege>) ServletActionContext.getServletContext().getAttribute("privilegeList");
	//	ServletActionContext.getServletContext().setAttribute("privilegeList",list);
		
		return "left";
	}
	public String right(){
		return "right";
	}
	public String top(){
		return "top";
	}
	public String bottom(){
		return "bottom";
	}
}
