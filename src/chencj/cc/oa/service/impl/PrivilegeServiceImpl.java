package chencj.cc.oa.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chencj.cc.oa.dao.PrivilegeDao;
import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Privilege;
import chencj.cc.oa.service.PrivilegeService;
import chencj.cc.oa.service.base.impl.BaseServiceImpl;
@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{

	@Autowired
	private PrivilegeDao privilegeDao;
	@Override
	public BaseDao<Privilege> getBaseDao() {
		// TODO Auto-generated method stub
		return privilegeDao;
	}
	@Override
	public List<Privilege> findTop() {
		// TODO Auto-generated method stub
		return privilegeDao.findTop();
	}
	@Override
	public List<Privilege> findByIds(long[] privilegeIds) {
		// TODO Auto-generated method stub
		return (List<Privilege>) privilegeDao.findByIds(privilegeIds);
	}

}
