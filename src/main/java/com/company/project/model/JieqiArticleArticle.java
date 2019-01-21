package com.company.project.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jieqi_article_article")
public class JieqiArticleArticle {
    @Id
    private Integer articleid;

    private Short siteid;

    private Integer postdate;

    private Integer lastupdate;

    private String articlename;

    private String keywords;

    private String initial;

    private Integer authorid;

    private String author;

    private Integer posterid;

    private String poster;

    private Integer agentid;

    private String agent;

    private Integer sortid;

    private Short typeid;

    private Integer lastvolumeid;

    private String lastvolume;

    private Integer lastchapterid;

    private String lastchapter;

    private Short chapters;

    private Integer size;

    private Integer lastvisit;

    private Integer dayvisit;

    private Integer weekvisit;

    private Integer monthvisit;

    private Integer allvisit;

    private Integer lastvote;

    private Integer dayvote;

    private Integer weekvote;

    private Integer monthvote;

    private Integer allvote;

    private Integer vipvotetime;

    private Integer vipvotenow;

    private Integer vipvotepreview;

    private Integer goodnum;

    private Integer badnum;

    private Integer toptime;

    private Integer saleprice;

    private Integer salenum;

    private Integer totalcost;

    private Boolean articletype;

    private Boolean permission;

    private Boolean firstflag;

    private Boolean fullflag;

    private Boolean imgflag;

    private Boolean power;

    private Boolean display;

    private String intro;

    private String notice;

    private String setting;

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
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return initial
     */
    public String getInitial() {
        return initial;
    }

    /**
     * @param initial
     */
    public void setInitial(String initial) {
        this.initial = initial;
    }

    /**
     * @return authorid
     */
    public Integer getAuthorid() {
        return authorid;
    }

    /**
     * @param authorid
     */
    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
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
     * @return agentid
     */
    public Integer getAgentid() {
        return agentid;
    }

    /**
     * @param agentid
     */
    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    /**
     * @return agent
     */
    public String getAgent() {
        return agent;
    }

    /**
     * @param agent
     */
    public void setAgent(String agent) {
        this.agent = agent;
    }

    /**
     * @return sortid
     */
    public Integer getSortid() {
        return sortid;
    }

    /**
     * @param sortid
     */
    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    /**
     * @return typeid
     */
    public Short getTypeid() {
        return typeid;
    }

    /**
     * @param typeid
     */
    public void setTypeid(Short typeid) {
        this.typeid = typeid;
    }

    /**
     * @return lastvolumeid
     */
    public Integer getLastvolumeid() {
        return lastvolumeid;
    }

    /**
     * @param lastvolumeid
     */
    public void setLastvolumeid(Integer lastvolumeid) {
        this.lastvolumeid = lastvolumeid;
    }

    /**
     * @return lastvolume
     */
    public String getLastvolume() {
        return lastvolume;
    }

    /**
     * @param lastvolume
     */
    public void setLastvolume(String lastvolume) {
        this.lastvolume = lastvolume;
    }

    /**
     * @return lastchapterid
     */
    public Integer getLastchapterid() {
        return lastchapterid;
    }

    /**
     * @param lastchapterid
     */
    public void setLastchapterid(Integer lastchapterid) {
        this.lastchapterid = lastchapterid;
    }

    /**
     * @return lastchapter
     */
    public String getLastchapter() {
        return lastchapter;
    }

    /**
     * @param lastchapter
     */
    public void setLastchapter(String lastchapter) {
        this.lastchapter = lastchapter;
    }

    /**
     * @return chapters
     */
    public Short getChapters() {
        return chapters;
    }

    /**
     * @param chapters
     */
    public void setChapters(Short chapters) {
        this.chapters = chapters;
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
     * @return dayvisit
     */
    public Integer getDayvisit() {
        return dayvisit;
    }

    /**
     * @param dayvisit
     */
    public void setDayvisit(Integer dayvisit) {
        this.dayvisit = dayvisit;
    }

    /**
     * @return weekvisit
     */
    public Integer getWeekvisit() {
        return weekvisit;
    }

    /**
     * @param weekvisit
     */
    public void setWeekvisit(Integer weekvisit) {
        this.weekvisit = weekvisit;
    }

    /**
     * @return monthvisit
     */
    public Integer getMonthvisit() {
        return monthvisit;
    }

    /**
     * @param monthvisit
     */
    public void setMonthvisit(Integer monthvisit) {
        this.monthvisit = monthvisit;
    }

    /**
     * @return allvisit
     */
    public Integer getAllvisit() {
        return allvisit;
    }

    /**
     * @param allvisit
     */
    public void setAllvisit(Integer allvisit) {
        this.allvisit = allvisit;
    }

    /**
     * @return lastvote
     */
    public Integer getLastvote() {
        return lastvote;
    }

    /**
     * @param lastvote
     */
    public void setLastvote(Integer lastvote) {
        this.lastvote = lastvote;
    }

    /**
     * @return dayvote
     */
    public Integer getDayvote() {
        return dayvote;
    }

    /**
     * @param dayvote
     */
    public void setDayvote(Integer dayvote) {
        this.dayvote = dayvote;
    }

    /**
     * @return weekvote
     */
    public Integer getWeekvote() {
        return weekvote;
    }

    /**
     * @param weekvote
     */
    public void setWeekvote(Integer weekvote) {
        this.weekvote = weekvote;
    }

    /**
     * @return monthvote
     */
    public Integer getMonthvote() {
        return monthvote;
    }

    /**
     * @param monthvote
     */
    public void setMonthvote(Integer monthvote) {
        this.monthvote = monthvote;
    }

    /**
     * @return allvote
     */
    public Integer getAllvote() {
        return allvote;
    }

    /**
     * @param allvote
     */
    public void setAllvote(Integer allvote) {
        this.allvote = allvote;
    }

    /**
     * @return vipvotetime
     */
    public Integer getVipvotetime() {
        return vipvotetime;
    }

    /**
     * @param vipvotetime
     */
    public void setVipvotetime(Integer vipvotetime) {
        this.vipvotetime = vipvotetime;
    }

    /**
     * @return vipvotenow
     */
    public Integer getVipvotenow() {
        return vipvotenow;
    }

    /**
     * @param vipvotenow
     */
    public void setVipvotenow(Integer vipvotenow) {
        this.vipvotenow = vipvotenow;
    }

    /**
     * @return vipvotepreview
     */
    public Integer getVipvotepreview() {
        return vipvotepreview;
    }

    /**
     * @param vipvotepreview
     */
    public void setVipvotepreview(Integer vipvotepreview) {
        this.vipvotepreview = vipvotepreview;
    }

    /**
     * @return goodnum
     */
    public Integer getGoodnum() {
        return goodnum;
    }

    /**
     * @param goodnum
     */
    public void setGoodnum(Integer goodnum) {
        this.goodnum = goodnum;
    }

    /**
     * @return badnum
     */
    public Integer getBadnum() {
        return badnum;
    }

    /**
     * @param badnum
     */
    public void setBadnum(Integer badnum) {
        this.badnum = badnum;
    }

    /**
     * @return toptime
     */
    public Integer getToptime() {
        return toptime;
    }

    /**
     * @param toptime
     */
    public void setToptime(Integer toptime) {
        this.toptime = toptime;
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
     * @return articletype
     */
    public Boolean getArticletype() {
        return articletype;
    }

    /**
     * @param articletype
     */
    public void setArticletype(Boolean articletype) {
        this.articletype = articletype;
    }

    /**
     * @return permission
     */
    public Boolean getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    /**
     * @return firstflag
     */
    public Boolean getFirstflag() {
        return firstflag;
    }

    /**
     * @param firstflag
     */
    public void setFirstflag(Boolean firstflag) {
        this.firstflag = firstflag;
    }

    /**
     * @return fullflag
     */
    public Boolean getFullflag() {
        return fullflag;
    }

    /**
     * @param fullflag
     */
    public void setFullflag(Boolean fullflag) {
        this.fullflag = fullflag;
    }

    /**
     * @return imgflag
     */
    public Boolean getImgflag() {
        return imgflag;
    }

    /**
     * @param imgflag
     */
    public void setImgflag(Boolean imgflag) {
        this.imgflag = imgflag;
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
     * @return intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * @param intro
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * @return notice
     */
    public String getNotice() {
        return notice;
    }

    /**
     * @param notice
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * @return setting
     */
    public String getSetting() {
        return setting;
    }

    /**
     * @param setting
     */
    public void setSetting(String setting) {
        this.setting = setting;
    }
}