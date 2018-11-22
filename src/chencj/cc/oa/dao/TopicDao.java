package chencj.cc.oa.dao;

import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Topic;

/**
 * @author CHENCJ
 * @create 2018-11-19-16:03-2018/11/19-
 * OA_SSH
 */
public interface TopicDao extends BaseDao<Topic> {
    Topic findByForumManageId(Long forumManageId);
}
