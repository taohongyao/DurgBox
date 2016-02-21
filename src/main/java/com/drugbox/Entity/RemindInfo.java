package com.drugbox.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 44247 on 2016/2/20 0020.
 */
@Entity
public class RemindInfo {
    private int remindId;
    private UserInfo userInfo;
    private MedicineInfo medicineInfo;
    private Timestamp remindTime;

    @Id
    @Column(name = "Remind_ID")
    public int getRemindId() {
        return remindId;
    }

    public void setRemindId(int remindId) {
        this.remindId = remindId;
    }

    @Basic
    @Column(name = "Remind_Time")
    public Timestamp getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Timestamp remindTime) {
        this.remindTime = remindTime;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemindInfo that = (RemindInfo) o;

        if (remindId != that.remindId) return false;
        if (remindTime != null ? !remindTime.equals(that.remindTime) : that.remindTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = remindId;
        result = 31 * result + (remindTime != null ? remindTime.hashCode() : 0);
        return result;
    }
}
