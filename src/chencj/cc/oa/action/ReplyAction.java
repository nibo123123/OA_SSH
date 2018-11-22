package chencj.cc.oa.action;

import chencj.cc.oa.action.base.impl.BaseActionImpl;
import chencj.cc.oa.entity.Reply;
import chencj.cc.oa.entity.Topic;
import chencj.cc.oa.service.ReplyService;
import chencj.cc.oa.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author CHENCJ
 * @create 2018-11-21-16:22-2018/11/21-
 * OA_SSH
 */
@Controller
@Scope("prototype")
public class ReplyAction extends BaseActionImpl<Reply>{
    @Autowired
    private ReplyService replyService;
    @Autowired
    private TopicService topicService;

    private Long topicId;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String addUI(){
        Topic topic = topicService.findOne(topicId);
        getValueStack().push(topic);
        return "add";
    }
    public String add(){

        return "toShow";
    }
}
