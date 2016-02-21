package com.drugbox.Bean.RemindInfo;

import com.drugbox.Bean.MedicineInfo.MedicineInfoOBean;

import java.sql.Timestamp;

/**
 * Created by 44247 on 2016/2/22 0022.
 */
public class RemindInfoIIBean {
    private String  medicineId;
    private Timestamp remindTime;

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public Timestamp getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Timestamp remindTime) {
        this.remindTime = remindTime;
    }
}
