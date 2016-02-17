package com.drugbox.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Entity
public class CommunicationInfo {
    private int communicateId;
    private String communicateTopic;
    private String communitcateContent;
    private String pictureAttached;
    private Integer communicateZhuan;

    @Id
    @Column(name = "Communicate_ID")
    public int getCommunicateId() {
        return communicateId;
    }

    public void setCommunicateId(int communicateId) {
        this.communicateId = communicateId;
    }

    @Basic
    @Column(name = "Communicate_Topic")
    public String getCommunicateTopic() {
        return communicateTopic;
    }

    public void setCommunicateTopic(String communicateTopic) {
        this.communicateTopic = communicateTopic;
    }

    @Basic
    @Column(name = "Communitcate_Content")
    public String getCommunitcateContent() {
        return communitcateContent;
    }

    public void setCommunitcateContent(String communitcateContent) {
        this.communitcateContent = communitcateContent;
    }

    @Basic
    @Column(name = "Picture_Attached")
    public String getPictureAttached() {
        return pictureAttached;
    }

    public void setPictureAttached(String pictureAttached) {
        this.pictureAttached = pictureAttached;
    }

    @Basic
    @Column(name = "Communicate_Zhuan")
    public Integer getCommunicateZhuan() {
        return communicateZhuan;
    }

    public void setCommunicateZhuan(Integer communicateZhuan) {
        this.communicateZhuan = communicateZhuan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommunicationInfo that = (CommunicationInfo) o;

        if (communicateId != that.communicateId) return false;
        if (communicateTopic != null ? !communicateTopic.equals(that.communicateTopic) : that.communicateTopic != null)
            return false;
        if (communitcateContent != null ? !communitcateContent.equals(that.communitcateContent) : that.communitcateContent != null)
            return false;
        if (pictureAttached != null ? !pictureAttached.equals(that.pictureAttached) : that.pictureAttached != null)
            return false;
        if (communicateZhuan != null ? !communicateZhuan.equals(that.communicateZhuan) : that.communicateZhuan != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = communicateId;
        result = 31 * result + (communicateTopic != null ? communicateTopic.hashCode() : 0);
        result = 31 * result + (communitcateContent != null ? communitcateContent.hashCode() : 0);
        result = 31 * result + (pictureAttached != null ? pictureAttached.hashCode() : 0);
        result = 31 * result + (communicateZhuan != null ? communicateZhuan.hashCode() : 0);
        return result;
    }
}
