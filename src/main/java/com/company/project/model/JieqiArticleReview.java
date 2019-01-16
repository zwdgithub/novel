package com.company.project.model;

import javax.persistence.*;

@Table(name = "jieqi_article_review")
public class JieqiArticleReview {
    @Id
    private Integer reviewid;

    private Short siteid;

    private Integer postdate;

    private Integer articleid;

    private String articlename;

    private Integer userid;

    private String username;

    private String reviewtitle;

    private Boolean topflag;

    private Boolean goodflag;

    private Boolean display;

    private String reviewtext;

    /**
     * @return reviewid
     */
    public Integer getReviewid() {
        return reviewid;
    }

    /**
     * @param reviewid
     */
    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    /**
     * @return siteid
     */
    public Short getSiteid() {
        return siteid;
    }

    /**
     * @param siteid
     */
    public void setSiteid(Short siteid) {
        this.siteid = siteid;
    }

    /**
     * @return postdate
     */
    public Integer getPostdate() {
        return postdate;
    }

    /**
     * @param postdate
     */
    public void setPostdate(Integer postdate) {
        this.postdate = postdate;
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
     * @return reviewtitle
     */
    public String getReviewtitle() {
        return reviewtitle;
    }

    /**
     * @param reviewtitle
     */
    public void setReviewtitle(String reviewtitle) {
        this.reviewtitle = reviewtitle;
    }

    /**
     * @return topflag
     */
    public Boolean getTopflag() {
        return topflag;
    }

    /**
     * @param topflag
     */
    public void setTopflag(Boolean topflag) {
        this.topflag = topflag;
    }

    /**
     * @return goodflag
     */
    public Boolean getGoodflag() {
        return goodflag;
    }

    /**
     * @param goodflag
     */
    public void setGoodflag(Boolean goodflag) {
        this.goodflag = goodflag;
    }

    /**
     * @return display
     */
    public Boolean getDisplay() {
        return display;
    }

    /**
     * @param display
     */
    public void setDisplay(Boolean display) {
        this.display = display;
    }

    /**
     * @return reviewtext
     */
    public String getReviewtext() {
        return reviewtext;
    }

    /**
     * @param reviewtext
     */
    public void setReviewtext(String reviewtext) {
        this.reviewtext = reviewtext;
    }
}