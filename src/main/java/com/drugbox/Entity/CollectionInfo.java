package com.drugbox.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 44247 on 2016/2/20 0020.
 */
@Entity
public class CollectionInfo {
    private int collectionId;
    private UserInfo userInfo;
    private MedicineInfo medicineInfo;
    private Timestamp collectionTime;

    @Id
    @Column(name = "Collection_ID")
    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    @Basic
    @Column(name = "Collection_Time")
    public Timestamp getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Timestamp collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionInfo that = (CollectionInfo) o;

        if (collectionId != that.collectionId) return false;
        if (collectionTime != null ? !collectionTime.equals(that.collectionTime) : that.collectionTime != null)
            return false;

        return true;
    }
    @ManyToOne
    @JoinColumn(name="User_Name")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    @ManyToOne
    @JoinColumn(name="Medicine_ID")
    public MedicineInfo getMedicineInfo() {
        return medicineInfo;
    }

    public void setMedicineInfo(MedicineInfo medicineInfo) {
        this.medicineInfo = medicineInfo;
    }

    @Override
    public int hashCode() {
        int result = collectionId;
        result = 31 * result + (collectionTime != null ? collectionTime.hashCode() : 0);
        return result;
    }
}
