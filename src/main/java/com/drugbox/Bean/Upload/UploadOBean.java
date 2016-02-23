package com.drugbox.Bean.Upload;

/**
 * Created by 44247 on 2016/2/23 0023.
 */
public class UploadOBean {
    private String fileSubPath;

    public UploadOBean(String fileSubPath) {
        this.fileSubPath = fileSubPath;
    }

    public String getFileSubPath() {
        return fileSubPath;
    }

    public void setFileSubPath(String fileSubPath) {
        this.fileSubPath = fileSubPath;
    }
}
