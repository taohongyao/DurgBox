package com.drugbox.Bean.CommunicationInfo;

import com.drugbox.Bean.IBeanOperation;

import java.util.List;

/**
 * Created by 44247 on 2016/2/22 0022.
 */
public class CommunicationIBean extends IBeanOperation{
    private String communicateTopic;
    private String communitcateContent;
    private List<String> pictureList;

    public String getCommunicateTopic() {
        return communicateTopic;
    }

    public void setCommunicateTopic(String communicateTopic) {
        this.communicateTopic = communicateTopic;
    }

    public String getCommunitcateContent() {
        return communitcateContent;
    }

    public void setCommunitcateList(String communitcateContent) {
        this.communitcateContent = communitcateContent;
    }

    public List<String> getPictureAttached() {
        return pictureList;
    }

    public void setPictureList(List<String> pictureList) {
        this.pictureList = pictureList;
    }
}
