package chencj.cc.oa.service;

import java.io.Serializable;
import java.util.List;

import chencj.cc.oa.entity.Department;
import chencj.cc.oa.service.base.BaseService;

public interface DepartmentService extends BaseService<Department>{

	public Department findParent(long departmentParentId);
	public List<Department> findTop();
	public List<Department> findSon(Serializable id);
}
