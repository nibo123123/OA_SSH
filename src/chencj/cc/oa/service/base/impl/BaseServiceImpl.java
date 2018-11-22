package chencj.cc.oa.service.base.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.service.base.BaseService;

@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T>{

	public abstract BaseDao<T> getBaseDao();
	
	
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getBaseDao().save(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		getBaseDao().delete(t);
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getBaseDao().update(t);
	}

	@Override
	public T findOne(Serializable id) {
		// TODO Auto-generated method stub
		return getBaseDao().findOne(id);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return getBaseDao().findAll();
	}
	
}
