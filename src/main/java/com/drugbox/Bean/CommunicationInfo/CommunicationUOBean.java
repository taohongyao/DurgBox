package com.drugbox.Bean.CommunicationInfo;

import com.drugbox.Bean.UserInfo.UserInfoOBean;

import java.util.List;

/**
 * Created by 44247 on 2016/2/19 0019.
 */
public class CommunicationUOBean {
    private int communicateId;
    private String communicateTopic;
    private List<String> pictureList;
    private String communitcateContent;
    private Integer communicateZhuan;
    private String communicateTime;

    public String getCommunitcateContent() {
        return communitcateContent;
    }

    public void setCommunitcateContent(String communitcateContent) {
        this.communitcateContent = communitcateContent;
    }

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

    public List<String> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<String> pictureList) {
        this.pictureList = pictureList;
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


}
