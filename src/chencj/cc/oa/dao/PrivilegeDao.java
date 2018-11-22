package chencj.cc.oa.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{

	List<Privilege> findTop();

	Collection<Privilege> findByIds(long[] privilegeIds);

}
