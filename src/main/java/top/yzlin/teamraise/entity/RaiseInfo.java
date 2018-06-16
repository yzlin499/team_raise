package top.yzlin.teamraise.entity;

import com.alibaba.fastjson.annotation.JSONField;
import top.yzlin.teamraise.parse.AlreadyRaise;

import java.util.Date;

public class RaiseInfo {
    private int proID;
    private int memberID;
    private double goalMoney;
    private String title;
    private String url;
    private Date endTime;
    private String cover;
    private String introduce;
    private AlreadyRaise alreadyRaise;

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    @JSONField(name = "end_time",format = "yyyy-MM-dd hh:mm:ss")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @JSONField(name = "pro_id")
    public void setProID(int proID) {
        this.proID = proID;
    }

    @JSONField(name = "pc_cover")
    public void setCover(String cover) {
        this.cover = cover;
    }

    @JSONField(name = "goal")
    public void setGoalMoney(double goalMoney) {
        this.goalMoney = goalMoney;
    }

    @JSONField(name = "pro_name")
    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getCover() {
        return cover;
    }

    public String getIntroduce() {
        return introduce;
    }

    public double getGoalMoney() {
        return goalMoney;
    }

    public int getProID() {
        return proID;
    }

    public AlreadyRaise getAlreadyRaise() {
        return alreadyRaise;
    }

    public void setAlreadyRaise(AlreadyRaise alreadyRaise) {
        this.alreadyRaise = alreadyRaise;
    }

    public double getAlreadyRaiseMoney() {
        return alreadyRaise.getMoney(proID);
    }

    @Override
    public String toString() {
        return "RaiseInfo{" +
                "proID=" + proID +
                ", goalMoney=" + goalMoney +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", endTime=" + endTime +
                ", cover='" + cover + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
