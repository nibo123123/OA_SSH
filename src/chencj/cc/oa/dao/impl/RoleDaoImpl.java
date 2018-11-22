package chencj.cc.oa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import chencj.cc.oa.dao.RoleDao;
import chencj.cc.oa.dao.base.impl.BaseDaoImpl;
import chencj.cc.oa.entity.Role;
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Override
	public List<Role> findAllByIds(long[] roleIds) {
		List<Role> list = new ArrayList<>();
		for (long roleId : roleIds) {
			list.add(findById(roleId));
		}
		return list;
	}

	private Role findById(Long roleId) {
		String hql = "from Role where roleId = ?";
		List<Role> list = (List<Role>) getHibernateTemplate().find(hql,roleId);
		if(list!=null&&list.size()>0)return list.get(0);
		return null;
	}

}
