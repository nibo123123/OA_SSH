package chencj.cc.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;



import chencj.cc.oa.dao.base.BaseDao;



public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	private Class clazz;
	/**
	 * 通过构造器获取clazz的类型运行使其的
	 */
	public BaseDaoImpl(){
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] typeArguments = parameterizedType.getActualTypeArguments();
		clazz = (Class) typeArguments[0];
		
		
		
	}
	
	
	/**
	 * 从spring容器里拿出sessionFactory设置到hibernate框架中
	 * @param sessionFactory
	 */
	@Resource(name="sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
		
	}
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}

	@Override
	public T findOne(Serializable id) {
		// TODO Auto-generated method stub
		String hql = "from "+clazz.getSimpleName()+"  where id = ?";
		List list = this.getHibernateTemplate().find(hql,id);
		if (list!=null&&list.size()>0) {
			return (T) list.get(0);
		}
		return null;
	}

	@Override
	public List findAll() {
		String hql = "from "+clazz.getSimpleName();
		
		return this.getHibernateTemplate().find(hql);
	}

}
