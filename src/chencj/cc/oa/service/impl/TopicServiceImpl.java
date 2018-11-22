package chencj.cc.oa.service.impl;

import chencj.cc.oa.dao.TopicDao;
import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Topic;
import chencj.cc.oa.entity.User;
import chencj.cc.oa.service.TopicService;
import chencj.cc.oa.service.base.impl.BaseServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.Date;

/**
 * @author CHENCJ
 * @create 2018-11-19-18:13-2018/11/19-
 * OA_SSH
 */
@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements TopicService {
    @Autowired
    private TopicDao topicDao;


    @Override
    public BaseDao<Topic> getBaseDao() {
        return topicDao;
    }

    @Override
    public Topic findByForumManageId(Long forumManageId) {
        return topicDao.findByForumManageId(forumManageId);
    }
}
