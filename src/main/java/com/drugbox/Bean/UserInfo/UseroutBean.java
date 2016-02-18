package com.drugbox.Bean.UserInfo;

/**
 * Created by 44247 on 2016/2/18 0018.
 */
public class UseroutBean {
    String sessionID;
    public UseroutBean() {
    }
    public UseroutBean(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
