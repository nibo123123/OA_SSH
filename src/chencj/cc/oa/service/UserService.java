package chencj.cc.oa.service;

import chencj.cc.oa.entity.User;
import chencj.cc.oa.service.base.BaseService;

public interface UserService extends BaseService<User>{

	User findByLoginName(String login_name);
	
}
