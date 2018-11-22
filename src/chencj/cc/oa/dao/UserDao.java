package chencj.cc.oa.dao;

import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.User;

public interface UserDao extends BaseDao<User>{

	User findByLoginName(String login_name);

}
