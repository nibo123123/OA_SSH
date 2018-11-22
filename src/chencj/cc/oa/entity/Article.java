package chencj.cc.oa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author CHENCJ
 * @create 2018-11-19-14:16-2018/11/19-
 * OA_SSH
 */
public class Article implements Serializable {
    private Long id;
    private String content;
    private Date postTime;
    private User author;
    private String ipAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
