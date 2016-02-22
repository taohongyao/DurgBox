package com.drugbox.Bean.UserInfo;

import com.drugbox.Bean.IBeanOperation;

/**
 * Created by 44247 on 2016/2/22 0022.
 */
public class RegisterInfoIBean extends IBeanOperation{
    private String userVirtualName;
    private Integer userAge;
    private String userPossition;

    public String getUserVirtualName() {
        return userVirtualName;
    }

    public void setUserVirtualName(String userVirtualName) {
        this.userVirtualName = userVirtualName;
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
}
