package chencj.cc.oa.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chencj.cc.oa.dao.DepartmentDao;
import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Department;
import chencj.cc.oa.service.DepartmentService;
import chencj.cc.oa.service.base.impl.BaseServiceImpl;
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public BaseDao<Department> getBaseDao() {
		// TODO Auto-generated method stub
		return departmentDao;
	}
	@Override
	public Department findParent(long departmentParentId) {
		Department department = departmentDao.findParent(departmentParentId);
		
		return department;
	}
	@Override
	public List<Department> findTop() {
		// TODO Auto-generated method stub
		return departmentDao.findTop();
	}
	@Override
	public List<Department> findSon(Serializable id) {
		// TODO Auto-generated method stub
		return departmentDao.findSon(id);
	}
}
