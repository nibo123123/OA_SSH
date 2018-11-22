package chencj.cc.oa.dao;

import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.ForumManage;

/**
 * @author CHENCJ
 * @create 2018-11-19-10:22-2018/11/19-
 * OA_SSH
 */
public interface ForumManageDao extends BaseDao<ForumManage> {
    public ForumManage findByPosition(long position);

    void moveDown(Long id);
}
