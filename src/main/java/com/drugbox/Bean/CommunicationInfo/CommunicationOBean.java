package com.drugbox.Bean.CommunicationInfo;

import com.drugbox.Bean.UserInfo.UserInfoOBean;

/**
 * Created by 44247 on 2016/2/19 0019.
 */
public class CommunicationOBean {
    private int communicateId;
    private String communicateTopic;
    private String pictureAttached;
    private Integer communicateZhuan;
    private String communicateTime;
    private UserInfoOBean userInfo;
    public int getCommunicateId() {
        return communicateId;
    }

    public void setCommunicateId(int communicateId) {
        this.communicateId = communicateId;
    }

    public String getCommunicateTopic() {
        return communicateTopic;
    }

    public void setCommunicateTopic(String communicateTopic) {
        this.communicateTopic = communicateTopic;
    }

    public String getPictureAttached() {
        return pictureAttached;
    }

    public void setPictureAttached(String pictureAttached) {
        this.pictureAttached = pictureAttached;
    }

    public Integer getCommunicateZhuan() {
        return communicateZhuan;
    }

    public void setCommunicateZhuan(Integer communicateZhuan) {
        this.communicateZhuan = communicateZhuan;
    }

    public String getCommunicateTime() {
        return communicateTime;
    }

    public void setCommunicateTime(String communicateTime) {
        this.communicateTime = communicateTime;
    }

    public UserInfoOBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoOBean userInfo) {
        this.userInfo = userInfo;
    }
}
