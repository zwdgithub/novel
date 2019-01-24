package com.company.project.model;

import javax.persistence.*;

@Table(name = "jieqi_system_users")
public class JieqiSystemUsers {
    @Id
    private Integer uid;

    private Short siteid;

    private String uname;

    private String name;

    private String pass;

    private Integer groupid;

    private Long regdate;

    private String initial;

    private Boolean sex;

    private String email;

    private String url;

    private Integer avatar;

    private Byte workid;

    private String qq;

    private String icq;

    private String msn;

    private String mobile;

    private Integer lastlogin;

    private Boolean showsign;

    private Boolean viewemail;

    private Boolean notifymode;

    private Boolean adminemail;

    private Integer monthscore;

    private Integer weekscore;

    private Integer dayscore;

    private Integer lastscore;

    private Integer experience;

    private Integer score;

    private Integer egold;

    private Integer esilver;

    private Integer credit;

    private Integer goodnum;

    private Integer badnum;

    private Boolean isvip;

    private Integer overtime;

    private Boolean state;

    private String sign;

    private String intro;

    private String setting;

    private String badges;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
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
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return groupid
     */
    public Integer getGroupid() {
        return groupid;
    }

    /**
     * @param groupid
     */
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    /**
     * @return regdate
     */
    public Long getRegdate() {
        return regdate;
    }

    /**
     * @param regdate
     */
    public void setRegdate(Long regdate) {
        this.regdate = regdate;
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
     * @return sex
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return avatar
     */
    public Integer getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    /**
     * @return workid
     */
    public Byte getWorkid() {
        return workid;
    }

    /**
     * @param workid
     */
    public void setWorkid(Byte workid) {
        this.workid = workid;
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return icq
     */
    public String getIcq() {
        return icq;
    }

    /**
     * @param icq
     */
    public void setIcq(String icq) {
        this.icq = icq;
    }

    /**
     * @return msn
     */
    public String getMsn() {
        return msn;
    }

    /**
     * @param msn
     */
    public void setMsn(String msn) {
        this.msn = msn;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return lastlogin
     */
    public Integer getLastlogin() {
        return lastlogin;
    }

    /**
     * @param lastlogin
     */
    public void setLastlogin(Integer lastlogin) {
        this.lastlogin = lastlogin;
    }

    /**
     * @return showsign
     */
    public Boolean getShowsign() {
        return showsign;
    }

    /**
     * @param showsign
     */
    public void setShowsign(Boolean showsign) {
        this.showsign = showsign;
    }

    /**
     * @return viewemail
     */
    public Boolean getViewemail() {
        return viewemail;
    }

    /**
     * @param viewemail
     */
    public void setViewemail(Boolean viewemail) {
        this.viewemail = viewemail;
    }

    /**
     * @return notifymode
     */
    public Boolean getNotifymode() {
        return notifymode;
    }

    /**
     * @param notifymode
     */
    public void setNotifymode(Boolean notifymode) {
        this.notifymode = notifymode;
    }

    /**
     * @return adminemail
     */
    public Boolean getAdminemail() {
        return adminemail;
    }

    /**
     * @param adminemail
     */
    public void setAdminemail(Boolean adminemail) {
        this.adminemail = adminemail;
    }

    /**
     * @return monthscore
     */
    public Integer getMonthscore() {
        return monthscore;
    }

    /**
     * @param monthscore
     */
    public void setMonthscore(Integer monthscore) {
        this.monthscore = monthscore;
    }

    /**
     * @return weekscore
     */
    public Integer getWeekscore() {
        return weekscore;
    }

    /**
     * @param weekscore
     */
    public void setWeekscore(Integer weekscore) {
        this.weekscore = weekscore;
    }

    /**
     * @return dayscore
     */
    public Integer getDayscore() {
        return dayscore;
    }

    /**
     * @param dayscore
     */
    public void setDayscore(Integer dayscore) {
        this.dayscore = dayscore;
    }

    /**
     * @return lastscore
     */
    public Integer getLastscore() {
        return lastscore;
    }

    /**
     * @param lastscore
     */
    public void setLastscore(Integer lastscore) {
        this.lastscore = lastscore;
    }

    /**
     * @return experience
     */
    public Integer getExperience() {
        return experience;
    }

    /**
     * @param experience
     */
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return egold
     */
    public Integer getEgold() {
        return egold;
    }

    /**
     * @param egold
     */
    public void setEgold(Integer egold) {
        this.egold = egold;
    }

    /**
     * @return esilver
     */
    public Integer getEsilver() {
        return esilver;
    }

    /**
     * @param esilver
     */
    public void setEsilver(Integer esilver) {
        this.esilver = esilver;
    }

    /**
     * @return credit
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * @param credit
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
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
     * @return overtime
     */
    public Integer getOvertime() {
        return overtime;
    }

    /**
     * @param overtime
     */
    public void setOvertime(Integer overtime) {
        this.overtime = overtime;
    }

    /**
     * @return state
     */
    public Boolean getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * @return sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     */
    public void setSign(String sign) {
        this.sign = sign;
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

    /**
     * @return badges
     */
    public String getBadges() {
        return badges;
    }

    /**
     * @param badges
     */
    public void setBadges(String badges) {
        this.badges = badges;
    }
}