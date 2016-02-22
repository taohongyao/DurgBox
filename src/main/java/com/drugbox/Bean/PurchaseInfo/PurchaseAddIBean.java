package com.drugbox.Bean.PurchaseInfo;

import com.drugbox.Bean.IBeanOperation;

/**
 * Created by 44247 on 2016/2/22 0022.
 */
public class PurchaseAddIBean extends IBeanOperation{
    private String medicineId;
    private int purchaseNum;

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public int getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(int purchaseNum) {
        this.purchaseNum = purchaseNum;
    }
}
