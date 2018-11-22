package chencj.cc.oa.service.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public T findOne(Serializable id);
	public List findAll();
}
