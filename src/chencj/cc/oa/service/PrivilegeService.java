package chencj.cc.oa.service;

import java.util.List;
import java.util.Set;

import chencj.cc.oa.entity.Privilege;
import chencj.cc.oa.service.base.BaseService;

public interface PrivilegeService extends BaseService<Privilege>{

	List<Privilege> findTop();

	List<Privilege> findByIds(long[] privilegeIds);

}
