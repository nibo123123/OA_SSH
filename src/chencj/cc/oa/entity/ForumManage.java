package chencj.cc.oa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CHENCJ
 * @create 2018-11-19-10:02-2018/11/19-
 * OA_SSH
 */

public class ForumManage implements Serializable{

    private Long id;
    private String name;
    private String description;
    private long position;

    private Long topicCount =0l;
    private Long articleCount = 0l;
    private Set<Topic> topics= new HashSet<>();
    private Topic lastTopic;

    public Long getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(Long topicCount) {
        this.topicCount = topicCount;
    }

    public Long getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Long articleCount) {
        this.articleCount = articleCount;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public Topic getLastTopic() {
        return lastTopic;
    }

    public void setLastTopic(Topic lastTopic) {
        this.lastTopic = lastTopic;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ForumManage(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ForumManage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public ForumManage() {
    }
}

