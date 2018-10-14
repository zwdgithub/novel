package com.company.project.model;

import javax.persistence.*;

@Table(name = "jieqi_article_bookcase")
public class JieqiArticleBookcase {
    @Id
    private Integer caseid;

    private Integer articleid;

    private String articlename;

    private Short classid;

    private Integer userid;

    private String username;

    private Integer chapterid;

    private String chaptername;

    private Short chapterorder;

    private Integer joindate;

    private Integer lastvisit;

    private Boolean flag;

    /**
     * @return caseid
     */
    public Integer getCaseid() {
        return caseid;
    }

    /**
     * @param caseid
     */
    public void setCaseid(Integer caseid) {
        this.caseid = caseid;
    }

    /**
     * @return articleid
     */
    public Integer getArticleid() {
        return articleid;
    }

    /**
     * @param articleid
     */
    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    /**
     * @return articlename
     */
    public String getArticlename() {
        return articlename;
    }

    /**
     * @param articlename
     */
    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    /**
     * @return classid
     */
    public Short getClassid() {
        return classid;
    }

    /**
     * @param classid
     */
    public void setClassid(Short classid) {
        this.classid = classid;
    }

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return chapterid
     */
    public Integer getChapterid() {
        return chapterid;
    }

    /**
     * @param chapterid
     */
    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    /**
     * @return chaptername
     */
    public String getChaptername() {
        return chaptername;
    }

    /**
     * @param chaptername
     */
    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    /**
     * @return chapterorder
     */
    public Short getChapterorder() {
        return chapterorder;
    }

    /**
     * @param chapterorder
     */
    public void setChapterorder(Short chapterorder) {
        this.chapterorder = chapterorder;
    }

    /**
     * @return joindate
     */
    public Integer getJoindate() {
        return joindate;
    }

    /**
     * @param joindate
     */
    public void setJoindate(Integer joindate) {
        this.joindate = joindate;
    }

    /**
     * @return lastvisit
     */
    public Integer getLastvisit() {
        return lastvisit;
    }

    /**
     * @param lastvisit
     */
    public void setLastvisit(Integer lastvisit) {
        this.lastvisit = lastvisit;
    }

    /**
     * @return flag
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}