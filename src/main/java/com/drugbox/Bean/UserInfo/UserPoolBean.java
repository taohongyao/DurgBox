package com.drugbox.Bean.UserInfo;

/**
 * Created by 44247 on 2016/2/18 0018.
 */
public class UserPoolBean {
    String account;
    String sessionID;
    long vaild;

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setVaild(long vaild) {
        this.vaild = vaild;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSessionID() {
        return sessionID;
    }

    public long getVaild() {
        return vaild;
    }
}
