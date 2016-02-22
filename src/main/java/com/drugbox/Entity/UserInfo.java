package com.drugbox.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Entity
public class UserInfo {
    private String userName;
    private String userPassword;
    private String userVirtualName;
    private String userPicture;
    private Integer userAge;
    private String userPossition;
    private Date userRegisterTime;
    private Date userLastModify;
    public UserInfo(String userName){
        this.userName=userName;
    }

    public UserInfo(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public UserInfo(){

    }
    @Id
    @Column(name = "User_Name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "User_Password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "User_Virtual_Name")
    public String getUserVirtualName() {
        return userVirtualName;
    }

    public void setUserVirtualName(String userVirtualName) {
        this.userVirtualName = userVirtualName;
    }

    @Basic
    @Column(name = "User_Picture")
    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    @Basic
    @Column(name = "User_Age")
    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "User_Possition")
    public String getUserPossition() {
        return userPossition;
    }

    public void setUserPossition(String userPossition) {
        this.userPossition = userPossition;
    }

    @Basic
    @Column(name = "User_Register_Time")
    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    @Basic
    @Column(name = "User_Last_Modify")
    public Date getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(Date userLastModify) {
        this.userLastModify = userLastModify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (userName != null ? !userName.equals(userInfo.userName) : userInfo.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(userInfo.userPassword) : userInfo.userPassword != null)
            return false;
        if (userVirtualName != null ? !userVirtualName.equals(userInfo.userVirtualName) : userInfo.userVirtualName != null)
            return false;
        if (userPicture != null ? !userPicture.equals(userInfo.userPicture) : userInfo.userPicture != null)
            return false;
        if (userAge != null ? !userAge.equals(userInfo.userAge) : userInfo.userAge != null) return false;
        if (userPossition != null ? !userPossition.equals(userInfo.userPossition) : userInfo.userPossition != null)
            return false;
        if (userRegisterTime != null ? !userRegisterTime.equals(userInfo.userRegisterTime) : userInfo.userRegisterTime != null)
            return false;
        if (userLastModify != null ? !userLastModify.equals(userInfo.userLastModify) : userInfo.userLastModify != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userVirtualName != null ? userVirtualName.hashCode() : 0);
        result = 31 * result + (userPicture != null ? userPicture.hashCode() : 0);
        result = 31 * result + (userAge != null ? userAge.hashCode() : 0);
        result = 31 * result + (userPossition != null ? userPossition.hashCode() : 0);
        result = 31 * result + (userRegisterTime != null ? userRegisterTime.hashCode() : 0);
        result = 31 * result + (userLastModify != null ? userLastModify.hashCode() : 0);
        return result;
    }
}
