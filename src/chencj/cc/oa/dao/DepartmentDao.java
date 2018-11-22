package chencj.cc.oa.dao;

import java.io.Serializable;
import java.util.List;

import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Department;

public interface DepartmentDao extends BaseDao<Department>{

	List<Department> findTop();

	List<Department> findSon(Serializable serializable);

	Department findParent(long departmentParentId);

}
