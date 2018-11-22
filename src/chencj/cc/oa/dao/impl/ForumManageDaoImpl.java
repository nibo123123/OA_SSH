package chencj.cc.oa.dao.impl;

import chencj.cc.oa.dao.ForumManageDao;
import chencj.cc.oa.dao.base.impl.BaseDaoImpl;
import chencj.cc.oa.entity.ForumManage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CHENCJ
 * @create 2018-11-19-10:23-2018/11/19-
 * OA_SSH
 */
@Repository
public class ForumManageDaoImpl extends BaseDaoImpl<ForumManage> implements ForumManageDao {
    @Override
    public void save(ForumManage forumManage) {
        super.save(forumManage);
        forumManage.setPosition(forumManage.getId());
    }

    @Override
    public List findAll() {
        String hql ="from ForumManage order by position asc";
        List<ForumManage> list = (List<ForumManage>) getHibernateTemplate().find(hql);

        return list;
    }

    @Override
    public ForumManage findByPosition(long position) {
        String hql="from FroumManage where position = ?";
        List<ForumManage> list = (List<ForumManage>) getHibernateTemplate().find(hql, position);
        if(list!=null&&list.size()>0)return list.get(0);
        return null;
    }

    @Override
    public void moveDown(Long id) {
        ForumManage forumManage1 = findOne(id);

        String hql="FROM ForumManage where position>? ORDER BY position ASC";
        Session session =
        getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query =null ;
        try {
            query = session.createQuery(hql);
            query.setParameter(0, forumManage1.getPosition());
            query.setFirstResult(0);
            query.setMaxResults(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        //List<ForumManage> list = (List<ForumManage>) getHibernateTemplate().find(hql,id);
        List<ForumManage> list = query.list();
        ForumManage forumManage = null;
        if(list!=null&&list.size()>0)  forumManage = list.get(0);
        //TODO 交换两个position
        long temp = forumManage.getPosition();
        long position = forumManage1.getPosition();
        forumManage.setPosition(position);

        forumManage1.setPosition(temp);
       // update(forumManage);
       // update(forumManage1);


    }
}
