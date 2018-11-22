package chencj.cc.oa.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import chencj.cc.oa.dao.PrivilegeDao;
import chencj.cc.oa.dao.base.impl.BaseDaoImpl;
import chencj.cc.oa.entity.Privilege;
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	@Override
	public List<Privilege> findTop() {
		String hql = "from Privilege where priParentId is null";
		return (List<Privilege>) getHibernateTemplate().find(hql);

	}

	@Override
	public Collection<Privilege> findByIds(long[] privilegeIds) {
		List<Privilege> list = new ArrayList<>();
		for (long l : privilegeIds) {
			Privilege privilege = findOne(l);
			list.add(privilege);
		}
		return list;
	}

}
