package chencj.cc.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import chencj.cc.oa.dao.UserDao;
import chencj.cc.oa.dao.base.impl.BaseDaoImpl;
import chencj.cc.oa.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User findByLoginName(String login_name) {
		String hql = "from User where loginName = ?";
		List<User> list = (List<User>) getHibernateTemplate().find(hql, login_name);
		if(list!=null&&list.size()>0)return list.get(0);
		return null;
	}

}
