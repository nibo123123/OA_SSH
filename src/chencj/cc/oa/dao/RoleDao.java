package chencj.cc.oa.dao;

import java.util.List;

import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Role;

public interface RoleDao extends BaseDao<Role>{

	List<Role> findAllByIds(long[] roleIds);

}
