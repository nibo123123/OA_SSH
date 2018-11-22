package chencj.cc.oa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CHENCJ
 * @create 2018-11-19-13:59-2018/11/19-
 * OA_SSH
 */
public class Topic extends Article implements Serializable{

    private String title;
    private Date lastUpdateTime;
    private int type = 0;
    private ForumManage forum;
    private Set<Reply> replies = new HashSet<>();
    private int replyCount;
    private Reply lastReply;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ForumManage getForum() {
        return forum;
    }

    public void setForum(ForumManage forum) {
        this.forum = forum;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public Reply getLastReply() {
        return lastReply;
    }

    public void setLastReply(Reply lastReply) {
        this.lastReply = lastReply;
    }
}
