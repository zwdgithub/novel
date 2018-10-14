package com.company.project.model;

import javax.persistence.*;

@Table(name = "jieqi_article_chapter")
public class JieqiArticleChapter {
    @Id
    private Integer chapterid;

    private Short siteid;

    private Integer articleid;

    private String articlename;

    private Integer volumeid;

    private Integer posterid;

    private String poster;

    private Integer postdate;

    private Integer lastupdate;

    private String chaptername;

    private Short chapterorder;

    private Integer size;

    private Integer saleprice;

    private Integer salenum;

    private Integer totalcost;

    private Boolean isvip;

    private Boolean chaptertype;

    private Boolean power;

    private Boolean display;

    private String attachment;

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
     * @return volumeid
     */
    public Integer getVolumeid() {
        return volumeid;
    }

    /**
     * @param volumeid
     */
    public void setVolumeid(Integer volumeid) {
        this.volumeid = volumeid;
    }

    /**
     * @return posterid
     */
    public Integer getPosterid() {
        return posterid;
    }

    /**
     * @param posterid
     */
    public void setPosterid(Integer posterid) {
        this.posterid = posterid;
    }

    /**
     * @return poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster
     */
    public void setPoster(String poster) {
        this.poster = poster;
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
     * @return lastupdate
     */
    public Integer getLastupdate() {
        return lastupdate;
    }

    /**
     * @param lastupdate
     */
    public void setLastupdate(Integer lastupdate) {
        this.lastupdate = lastupdate;
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
     * @return size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return saleprice
     */
    public Integer getSaleprice() {
        return saleprice;
    }

    /**
     * @param saleprice
     */
    public void setSaleprice(Integer saleprice) {
        this.saleprice = saleprice;
    }

    /**
     * @return salenum
     */
    public Integer getSalenum() {
        return salenum;
    }

    /**
     * @param salenum
     */
    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }

    /**
     * @return totalcost
     */
    public Integer getTotalcost() {
        return totalcost;
    }

    /**
     * @param totalcost
     */
    public void setTotalcost(Integer totalcost) {
        this.totalcost = totalcost;
    }

    /**
     * @return isvip
     */
    public Boolean getIsvip() {
        return isvip;
    }

    /**
     * @param isvip
     */
    public void setIsvip(Boolean isvip) {
        this.isvip = isvip;
    }

    /**
     * @return chaptertype
     */
    public Boolean getChaptertype() {
        return chaptertype;
    }

    /**
     * @param chaptertype
     */
    public void setChaptertype(Boolean chaptertype) {
        this.chaptertype = chaptertype;
    }

    /**
     * @return power
     */
    public Boolean getPower() {
        return power;
    }

    /**
     * @param power
     */
    public void setPower(Boolean power) {
        this.power = power;
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
     * @return attachment
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     * @param attachment
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}