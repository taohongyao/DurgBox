package com.drugbox.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Entity
public class CommentInfo {
    private int commentId;
    private String commentContent;
    private Integer commentZan;
    private CommunicationInfo communicationInfo;
    private UserInfo userInfo;
    private Timestamp commentTime;
    @Id
    @Column(name = "Comment_ID")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "Comment_Content")
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "Comment_Zan")
    public Integer getCommentZan() {
        return commentZan;
    }

    public void setCommentZan(Integer commentZan) {
        this.commentZan = commentZan;
    }


    @ManyToOne
    @JoinColumn(name="Communicate_ID")
    public CommunicationInfo getCommunicationInfo() {
        return communicationInfo;
    }

    public void setCommunicationInfo(CommunicationInfo communicationInfo) {
        this.communicationInfo = communicationInfo;
    }

    @ManyToOne
    @JoinColumn(name="User_Name")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    @Basic
    @Column(name = "Comment_Time")
    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentInfo that = (CommentInfo) o;

        if (commentId != that.commentId) return false;
        if (commentContent != null ? !commentContent.equals(that.commentContent) : that.commentContent != null)
            return false;
        if (commentZan != null ? !commentZan.equals(that.commentZan) : that.commentZan != null) return false;
        if (communicationInfo != null ? !communicationInfo.equals(that.communicationInfo) : that.communicationInfo != null) return false;
        if (userInfo != null ? !userInfo.equals(that.userInfo) : that.userInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + (commentZan != null ? commentZan.hashCode() : 0);
        result = 31 * result + (communicationInfo != null ? communicationInfo.hashCode() : 0);
        result = 31 * result + (userInfo != null ? userInfo.hashCode() : 0);

        return result;
    }
}
