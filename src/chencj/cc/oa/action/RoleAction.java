package chencj.cc.oa.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import chencj.cc.oa.action.base.impl.BaseActionImpl;
import chencj.cc.oa.entity.Privilege;
import chencj.cc.oa.entity.Role;
import chencj.cc.oa.service.PrivilegeService;
import chencj.cc.oa.service.RoleService;
@Controller
public class RoleAction extends BaseActionImpl<Role>{

	@Autowired
	private RoleService roleService;
	@Autowired
	private PrivilegeService privilegeService;
	
	private String[] privilegeIds;
	
	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public String list(){
		List<Role> list = roleService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	
	public String addUI(){
		return "add";
	}
	
	public String add(){
		roleService.save(getModel());
		return "toList";
	}
	public String delete(){
		Role role = roleService.findOne(getModel().getRole_id());
		roleService.delete(role);
		return "toList";
	}
	public String editUI(){
		Role _role = roleService.findOne(getModel().getRole_id());
		getValueStack().push(_role);
		return "edit";
	}
	public String edit(){
		Role _role = roleService.findOne(getModel().getRole_id());
		_role.setRole_description(getModel().getRole_description());
		_role.setRole_name(getModel().getRole_name());
		roleService.update(_role);
		return "toList";
	}
	
	public String setPrivilegeUI(){
		List<Privilege> list = privilegeService.findTop();
		Role role = roleService.findOne(getModel().getRole_id());
		Set<Privilege> privileges = role.getPrivileges();
		if(privileges!=null&&privileges.size()>0){
			int c=0;
			privilegeIds = new String[privileges.size()];
			
			for (Privilege privilege : privileges) {
				privilegeIds[c++] = privilege.getPriId()+"";
			}
		}
		getValueStack().push(role);
		getValueStack().set("privilegeList", list);
		return "setPrivilege";
	}
	
	public String setPrivilege(){
		Role role = roleService.findOne(getModel().getRole_id());
		Set<Privilege> privileges = role.getPrivileges();
		if(privileges!=null&&privileges.size()>0){
			privileges=null;
			role.setPrivileges(privileges);

		}
		int len=0,c=0;
		for (String s : privilegeIds) {
			if(!s.trim().equals(""))len++;
		}
		
		long[] ls = new long[len];
		for (String s : privilegeIds) {
			if(!s.trim().equals(""))ls[c++]=Long.parseLong(s);
		}
		List<Privilege> list = privilegeService.findByIds(ls);
		role.setPrivileges(new HashSet<>(list));
		roleService.update(role);
		return "toList";
	}
}
