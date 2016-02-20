package com.drugbox.Bean.PurchaseInfo;

import com.drugbox.Bean.IBeanOperation;

/**
 * Created by 44247 on 2016/2/20 0020.
 */
public class PurchaseInfoIBean extends IBeanOperation {
    private  int start;
    private int capacity;
    private int page;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
