package com.drugbox.Bean.CommunicationInfo;

/**
 * Created by 44247 on 2016/2/19 0019.
 */
public class CommunicationBean {
    private int communicateId;
    private String communicateTopic;
    private String pictureAttached;
    private Integer communicateZhuan;
    private String communicateTime;

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
}
