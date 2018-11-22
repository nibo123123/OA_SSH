package chencj.cc.oa.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import chencj.cc.oa.action.base.impl.BaseActionImpl;
import chencj.cc.oa.entity.Department;
import chencj.cc.oa.service.DepartmentService;
import chencj.cc.oa.utils.IdGenUtils;
import chencj.cc.oa.utils.TreeDepartmentUtils;

@Controller
public class DepartmentAction extends BaseActionImpl<Department>{

	@Autowired
	private DepartmentService departmentService;
	
	
	public String list(){
		List<Department> list = null;
		
		if((getDepartmentParentId())==0)
			list = departmentService.findTop();
		else {
			list = departmentService.findSon(getDepartmentParentId());
			Department dept = departmentService.findParent(getDepartmentParentId());
			
			//dept.setDe_children(new HashSet<>(list));
			getValueStack().set("dept", dept);
		}
		
		getValueStack().set("list", list);
		return "list";
		
	}
	
	public String addUI(){
		List<Department> list = null;
		
		//list = departmentService.findAll();
		list = departmentService.findTop();
		list  = TreeDepartmentUtils.getShowTree(list);
		getValueStack().set("departmentList", list);
		
		return "save";
	}
	
	private long departmentParentId;
	
	public long getDepartmentParentId() {
		return departmentParentId;
	}

	public void setDepartmentParentId(String departmentParentId) {
		if(StringUtils.isNotBlank(departmentParentId))
			this.departmentParentId = Long.parseLong(departmentParentId);
		else
			this.departmentParentId = 0l;
	}

	public String add(){
		Department department = getModel();
		//补全其他属性
		
		if(departmentParentId==0){
			departmentService.save(getModel());
		}else{
			Department parent = departmentService.findParent(getDepartmentParentId());
			department.setDe_parent(parent);
			departmentService.save(department);
		}
			
		return "toList";
	}
	
	public String editUI(){
		List<Department> list = null;
		
		Department department = departmentService.findOne(getModel().getDe_id());
		list = TreeDepartmentUtils.getShowTree(departmentService.findAll());
		getValueStack().set("departmentList", list);
		getValueStack().push( department);
		return "edit";
	}
	
	public String edit(){
		Department department = getModel();
		Department one = departmentService.findOne(department.getDe_id());
		getValueStack().push(one);
		
		return "toList";
	}
	
	public String delete(){
		Department department = departmentService.findOne(getModel().getDe_id());
		departmentService.delete(department);
		
		return "toList";
	}
}
