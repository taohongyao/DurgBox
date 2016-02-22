package com.drugbox.Bean.UserInfo;

import com.drugbox.Bean.IBeanOperation;

/**
 * Created by 44247 on 2016/2/22 0022.
 */
public class UpPwdIBean extends IBeanOperation {
    private String oldPassword;
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
