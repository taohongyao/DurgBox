package com.drugbox.Bean;

/**
 * Created by 44247 on 2016/2/18 0018.
 */
public class OperationBean {
    String account;
    String sessionID;
    Object contents;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }
}
