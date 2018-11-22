package chencj.cc.oa.action;

import chencj.cc.oa.action.base.impl.BaseActionImpl;
import chencj.cc.oa.entity.ForumManage;
import chencj.cc.oa.service.ForumManageService;
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
public class ForumManageAction extends BaseActionImpl<ForumManage>{

    @Autowired
    private ForumManageService forumManageService;

    public String list(){
        //TODO 从数据库查找数据 加入栈中进行数据显示
        List<ForumManage> list = forumManageService.findAll();
        getValueStack().set("recordList",list);
        return "list";
    }

    public String addUI(){

        return "save";
    }

    public String add(){
        //TODO 从页面获取要封装的对象，保存到数据库，
        // 并跳转到list的页面 需要重定向
        // 也要先去判断提交的表单项是否为空
        forumManageService.save(getModel());
        return "toList";
    }

    public String delete(){
        ForumManage forumManage = forumManageService.findOne(getModel().getId());
        forumManageService.delete(forumManage);
        return "toList";
    }

    public String editUI(){
        ForumManage forumManage = forumManageService.findOne(getModel().getId());
        getValueStack().push(forumManage);
        return "save";
    }
    public String edit(){
        ForumManage forumManage = forumManageService.findOne(getModel().getId());
        forumManage.setDescription(getModel().getDescription());
        forumManage.setName(getModel().getName());
        forumManageService.update(forumManage);
        return "toList";
    }

    public String moveUp(){
        List<ForumManage> list = forumManageService.findAll();
        ForumManage forumManage = forumManageService.findOne(getModel().getId());
        int upIndex=0;
        for (int i = 0; i < list.size(); i++) {
            if(forumManage.equals(list.get(i))){
                upIndex=i-1;

                break;
            }
        }
        long upPosition = list.get(upIndex).getPosition();
        list.get(upIndex).setPosition(forumManage.getPosition());
        forumManage.setPosition(upPosition);
        forumManageService.update(list.get(upIndex));
        forumManageService.update(forumManage);
        return "toList";
    }

    public String moveDown(){

        forumManageService.moveDown(getModel().getId());
        return "toList";
    }

}
