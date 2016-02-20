package com.drugbox.Bean.CommentInfo;

import com.drugbox.Bean.UserInfo.UserInfoOBean;
import com.drugbox.Entity.UserInfo;

/**
 * Created by 44247 on 2016/2/19 0019.
 */
public class CommentInfoOBean {
    private int commentId;
    private String commentContent;
    private Integer commentZan;
    private String userName;
    private int communicationId;
    private String commentTime;
    private UserInfoOBean userInfo;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentZan() {
        return commentZan;
    }

    public void setCommentZan(Integer commentZan) {
        this.commentZan = commentZan;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(int communicationId) {
        this.communicationId = communicationId;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public UserInfoOBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoOBean userInfo) {
        this.userInfo = userInfo;
    }
}
