package chencj.cc.oa.service;

import chencj.cc.oa.entity.Topic;
import chencj.cc.oa.service.base.BaseService;

/**
 * @author CHENCJ
 * @create 2018-11-19-18:13-2018/11/19-
 * OA_SSH
 */
public interface TopicService extends BaseService<Topic> {
    Topic findByForumManageId(Long forumManageId);
}
