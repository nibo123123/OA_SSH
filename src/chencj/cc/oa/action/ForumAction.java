package chencj.cc.oa.action;

import chencj.cc.oa.action.base.impl.BaseActionImpl;
import chencj.cc.oa.entity.ForumManage;
import chencj.cc.oa.service.ForumManageService;
import chencj.cc.oa.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author CHENCJ
 * @create 2018-11-19-9:55-2018/11/19-
 * OA_SSH
 */
@Controller
@Scope("prototype")
public class ForumAction extends BaseActionImpl<ForumManage>{

    @Autowired
    private ForumManageService forumManageService;
    @Autowired
    private TopicService topicService;


    public String list(){
        //TODO添加list放入到栈中
        List list =
                forumManageService.findAll();
        getValueStack().set("recordList",list);
        return "list";
    }

    public String show(){
        ForumManage forumManage = forumManageService.findOne(getModel().getId());
        getValueStack().push(forumManage);
        List list = topicService.findAll();
        getValueStack().set("recordList",list);
        return "show";
    }

    public String addUI(){
        return "save";

    }
    public String add(){
        //TODO 执行保存
        return "toList";
    }

}
