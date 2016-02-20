package com.drugbox.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by 44247 on 2016/2/20 0020.
 */
@Entity
public class PurchaseInfo {
    private int purchaseId;
    private Timestamp purchaseTime;
    private Integer purchaseNum;

    @Id
    @Column(name = "Purchase_ID")
    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Basic
    @Column(name = "Purchase_Time")
    public Timestamp getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Timestamp purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Basic
    @Column(name = "Purchase_Num")
    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseInfo that = (PurchaseInfo) o;

        if (purchaseId != that.purchaseId) return false;
        if (purchaseTime != null ? !purchaseTime.equals(that.purchaseTime) : that.purchaseTime != null) return false;
        if (purchaseNum != null ? !purchaseNum.equals(that.purchaseNum) : that.purchaseNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purchaseId;
        result = 31 * result + (purchaseTime != null ? purchaseTime.hashCode() : 0);
        result = 31 * result + (purchaseNum != null ? purchaseNum.hashCode() : 0);
        return result;
    }
}
