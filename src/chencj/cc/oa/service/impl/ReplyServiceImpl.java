package chencj.cc.oa.service.impl;

import chencj.cc.oa.dao.ReplyDao;
import chencj.cc.oa.dao.base.BaseDao;
import chencj.cc.oa.entity.Reply;
import chencj.cc.oa.service.ReplyService;
import chencj.cc.oa.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CHENCJ
 * @create 2018-11-21-16:20-2018/11/21-
 * OA_SSH
 */
@Service
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements ReplyService {
    @Autowired
    private ReplyDao replyDao;

    @Override

    public BaseDao<Reply> getBaseDao() {
        return replyDao;
    }
}
