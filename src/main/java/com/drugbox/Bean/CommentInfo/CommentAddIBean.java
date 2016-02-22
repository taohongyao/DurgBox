package com.drugbox.Bean.CommentInfo;

import com.drugbox.Bean.IBeanOperation;

/**
 * Created by 44247 on 2016/2/22 0022.
 */
public class CommentAddIBean extends IBeanOperation {
    private  int communicateId;
    private String commentContent;

    public int getCommunicateId() {
        return communicateId;
    }

    public void setCommunicateId(int communicateId) {
        this.communicateId = communicateId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
