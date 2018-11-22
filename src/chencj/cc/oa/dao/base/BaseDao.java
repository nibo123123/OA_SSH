package chencj.cc.oa.dao.base;

import java.io.Serializable;
import java.util.List;



public interface BaseDao<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public T findOne(Serializable id);
	public List findAll();

}
