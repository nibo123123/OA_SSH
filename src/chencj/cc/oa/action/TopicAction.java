package chencj.cc.oa.action;

import chencj.cc.oa.action.base.impl.BaseActionImpl;
import chencj.cc.oa.entity.ForumManage;
import chencj.cc.oa.entity.Topic;
import chencj.cc.oa.entity.User;
import chencj.cc.oa.service.ForumManageService;
import chencj.cc.oa.service.ReplyService;
import chencj.cc.oa.service.TopicService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

/**
 * @author CHENCJ
 * @create 2018-11-19-15:53-2018/11/19-
 * OA_SSH
 */
@Controller
@Scope("prototype")
public class TopicAction extends BaseActionImpl<Topic> {

    @Autowired
    private TopicService topicService;
    @Autowired
    private ForumManageService forumManageService;
    @Autowired
    private ReplyService replyService;


    private Long forumManageId;

    public Long getForumManageId() {
        return forumManageId;
    }

    public void setForumManageId(Long forumManageId) {
        this.forumManageId = forumManageId;
    }

    public String addUI(){
        //Topic topic = topicService.findByForumManageId(forumManageId);
        ForumManage forumManage = forumManageService.findOne(forumManageId);
        getValueStack().push(forumManage);
        return "add";
    }
    public String add(){
        //只有 title content forumManageId 剩下自己补全
        ForumManage forumManage = forumManageService.findOne(forumManageId);
        Topic topic = getModel()
                ;
        try {
            forumManage.setTopicCount(forumManage.getTopicCount()+1);
            topic.setForum(forumManage);
            topic.setType(0);//type 新手帖 精华帖 等等
            topic.setAuthor((User) ServletActionContext.getRequest().getSession().getAttribute("loginUser"));
            topic.setPostTime(new Date());

            topic.setIpAddress(InetAddress.getLocalHost().getHostAddress());
        }catch (Exception e){
            e.printStackTrace();
        }
        topicService.save(getModel());
        return "show";
    }
    public String show(){
        Long id = getModel().getId();
        Topic topic = topicService.findOne(id);
        getValueStack().push(topic);
        List list = replyService.findAll();
        getValueStack().set("recordList",list);
        return "show";
    }
}
