package chencj.cc.oa.service.impl;

import chencj.cc.oa.dao.ForumManageDao;
import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.ForumManage;
import chencj.cc.oa.service.ForumManageService;
import chencj.cc.oa.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CHENCJ
 * @create 2018-11-19-10:24-2018/11/19-
 * OA_SSH
 */
@Service
public class ForumManageServiceImpl extends BaseServiceImpl<ForumManage> implements ForumManageService {
    @Autowired
    private ForumManageDao forumManageDao;

    @Override
    public BaseDao<ForumManage> getBaseDao() {
        return forumManageDao;
    }

    @Override
    public ForumManage findByPosition(long position) {
        return forumManageDao.findByPosition(position);
    }

    @Override
    public void moveDown(Long id) {
       // ForumManage forumManage = forumManageDao.findOne(id);
        forumManageDao.moveDown(id);




    }
}
