package chencj.cc.oa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author CHENCJ
 * @create 2018-11-19-14:07-2018/11/19-
 * OA_SSH
 */
public class Reply extends Article implements Serializable{

    private Topic topic;
    private int deletes;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getDeletes() {
        return deletes;
    }

    public void setDeletes(int deletes) {
        this.deletes = deletes;
    }
}
