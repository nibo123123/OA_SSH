package chencj.cc.oa.dao.impl;


import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import chencj.cc.oa.dao.DepartmentDao;
import chencj.cc.oa.dao.base.impl.BaseDaoImpl;
import chencj.cc.oa.entity.Department;
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

	@Override
	public List<Department> findTop() {
		String hql = "from Department where departmentParentId is null";
		return (List<Department>) getHibernateTemplate().find(hql);
	}

	@Override
	public List<Department> findSon(Serializable departmentId) {
		String hql = "from Department where departmentParentId = ?";
		return (List<Department>) getHibernateTemplate().find(hql, departmentId);
	}

	@Override
	public Department findParent(long departmentParentId) {
		String hql = "from Department where departmentId = ?";
		return (Department) getHibernateTemplate().find(hql, departmentParentId).get(0);
		
	}

}
