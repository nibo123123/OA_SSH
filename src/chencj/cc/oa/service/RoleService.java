package chencj.cc.oa.service;

import java.util.List;

import chencj.cc.oa.entity.Role;
import chencj.cc.oa.service.base.BaseService;

public interface RoleService extends BaseService<Role>{

	List<Role> findAllByIds(String[] role_ids);
	List<Role> findAllByIds(long[] role_ids);
}
