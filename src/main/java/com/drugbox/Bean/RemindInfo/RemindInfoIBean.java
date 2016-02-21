package com.drugbox.Bean.RemindInfo;

import com.drugbox.Bean.IBeanOperation;

import java.util.List;

/**
 * Created by 44247 on 2016/2/21 0021.
 */
public class RemindInfoIBean extends IBeanOperation{
    List<RemindInfoIIBean> list;

    public List<RemindInfoIIBean> getList() {
        return list;
    }

    public void setList(List<RemindInfoIIBean> list) {
        this.list = list;
    }
}
