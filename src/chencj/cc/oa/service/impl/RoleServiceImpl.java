package chencj.cc.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chencj.cc.oa.dao.RoleDao;
import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Role;
import chencj.cc.oa.service.RoleService;
import chencj.cc.oa.service.base.impl.BaseServiceImpl;
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

	@Autowired
	private RoleDao roleDao;
	@Override
	public BaseDao<Role> getBaseDao() {
		// TODO Auto-generated method stub
		return roleDao;
	}
	@Override
	public List<Role> findAllByIds(String[] role_ids) {
		// TODO Auto-generated method stub
		long[] roleIds = new long[role_ids.length];
		
		for (int index=0;index<role_ids.length;index++) {
			roleIds[index] = Long.parseLong(role_ids[index].trim());
		}
		List<Role> list = roleDao.findAllByIds(roleIds);
		return list;
	}
	@Override
	public List<Role> findAllByIds(long[] role_ids) {
		// TODO Auto-generated method stub
		return roleDao.findAllByIds(role_ids);
	}

}
