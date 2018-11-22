package chencj.cc.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import chencj.cc.oa.dao.UserDao;
import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.User;
import chencj.cc.oa.service.UserService;
import chencj.cc.oa.service.base.impl.BaseServiceImpl;
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource()
	private UserDao userDao;
	@Override
	public BaseDao<User> getBaseDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
	@Override
	public User findByLoginName(String login_name) {
		
		return userDao.findByLoginName(login_name);
	}
	
}
