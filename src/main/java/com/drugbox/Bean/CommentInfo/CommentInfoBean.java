package com.drugbox.Bean.CommentInfo;

/**
 * Created by 44247 on 2016/2/19 0019.
 */
public class CommentInfoBean {
    private int commentId;
    private String commentContent;
    private Integer commentZan;
    private String userName;
    private int communicationId;

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
}
