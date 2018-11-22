package chencj.cc.oa.service;

import chencj.cc.oa.entity.ForumManage;
import chencj.cc.oa.service.base.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @author CHENCJ
 * @create 2018-11-19-10:20-2018/11/19-
 * OA_SSH
 */
public interface ForumManageService extends BaseService<ForumManage>{
    public void save(ForumManage t);
    public void delete(ForumManage t);
    public void update(ForumManage t);
    public ForumManage findOne(Serializable id);
    public List findAll();
    public ForumManage findByPosition(long position);

    void moveDown(Long id);
}
