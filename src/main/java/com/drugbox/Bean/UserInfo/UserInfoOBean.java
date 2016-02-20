package com.drugbox.Bean.UserInfo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by 44247 on 2016/2/17 0017.
 */

public class UserInfoOBean {
    private String userName;
    private String userVirtualName;
    private String userPicture;
    private Integer userAge;
    private String userPossition;
    private Date userRegisterTime;
    private Date userLastModify;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserVirtualName() {
        return userVirtualName;
    }

    public void setUserVirtualName(String userVirtualName) {
        this.userVirtualName = userVirtualName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPossition() {
        return userPossition;
    }

    public void setUserPossition(String userPossition) {
        this.userPossition = userPossition;
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Date getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(Date userLastModify) {
        this.userLastModify = userLastModify;
    }


}
