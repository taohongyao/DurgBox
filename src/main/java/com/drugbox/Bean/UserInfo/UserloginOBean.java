package com.drugbox.Bean.UserInfo;

/**
 * Created by 44247 on 2016/2/18 0018.
 */
public class UserloginOBean {
    String sessionID;
    public UserloginOBean() {
    }
    public UserloginOBean(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
