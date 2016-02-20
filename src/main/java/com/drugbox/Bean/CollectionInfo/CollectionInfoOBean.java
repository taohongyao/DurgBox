package com.drugbox.Bean.CollectionInfo;

import com.drugbox.Bean.MedicineInfo.MedicineInfoOBean;
import com.drugbox.Bean.UserInfo.UserInfoOBean;
import com.drugbox.Entity.MedicineInfo;
import com.drugbox.Entity.UserInfo;

import java.sql.Timestamp;

/**
 * Created by 44247 on 2016/2/20 0020.
 */
public class CollectionInfoOBean {
    private int collectionId;
    private MedicineInfoOBean medicineInfo;
    private String collectionTime;

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }



    public MedicineInfoOBean getMedicineInfo() {
        return medicineInfo;
    }

    public void setMedicineInfo(MedicineInfoOBean medicineInfo) {
        this.medicineInfo = medicineInfo;
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }
}
