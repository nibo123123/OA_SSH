package chencj.cc.oa.utils;

import java.io.Serializable;

/**
 * @author CHENCJ
 * @create 2018-11-19-10:51-2018/11/19-
 * OA_SSH
 */
public class PageBean implements Serializable {

    private Long currentPage;
    private Long pageSize;
    private Long totalRecord;
    private Long totalPage;
    private String actionUrl;

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
}
