package chencj.cc.oa.dao.impl;

import chencj.cc.oa.dao.TopicDao;
import chencj.cc.oa.dao.base.impl.BaseDaoImpl;
import chencj.cc.oa.entity.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CHENCJ
 * @create 2018-11-19-16:04-2018/11/19-
 * OA_SSH
 */
@Repository
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {
    @Override
    public Topic findByForumManageId(Long forumManageId) {
        String hql ="from Topic where forumManageId = ?";
        List<Topic> list = (List<Topic>) getHibernateTemplate().find(hql, forumManageId);
        if(list!=null&&list.size()>0)return list.get(0);
        return null;
    }
}
