package com.drugbox.Bean;

/**
 * Created by 44247 on 2016/2/18 0018.
 */
public class BeanBase {
    String code;
    String message;
    Object contents;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }

    public void setInfo(String code,String message){
        this.message = message;
        this.code = code;
    }
}
