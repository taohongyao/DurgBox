package com.drugbox.Bean.PurchaseInfo;

import com.drugbox.Bean.MedicineInfo.MedicineInfoOBean;
import com.drugbox.Bean.UserInfo.UserInfoOBean;
import com.drugbox.Entity.MedicineInfo;
import com.drugbox.Entity.UserInfo;

import java.sql.Timestamp;

/**
 * Created by 44247 on 2016/2/20 0020.
 */
public class PurchaseInfoOBean {
    private int purchaseId;
    private MedicineInfoOBean medicineInfo;
    private Timestamp purchaseTime;
    private Integer purchaseNum;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public MedicineInfoOBean getMedicineInfo() {
        return medicineInfo;
    }

    public void setMedicineInfo(MedicineInfoOBean medicineInfo) {
        this.medicineInfo = medicineInfo;
    }

    public Timestamp getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Timestamp purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }
}
