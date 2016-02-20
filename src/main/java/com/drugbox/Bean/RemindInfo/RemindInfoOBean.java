package com.drugbox.Bean.RemindInfo;

import com.drugbox.Bean.MedicineInfo.MedicineInfoOBean;

import java.sql.Timestamp;

/**
 * Created by 44247 on 2016/2/20 0020.
 */
public class RemindInfoOBean {
    private int Remind_ID;
    private MedicineInfoOBean medicineInfo;
    private Timestamp remindTime;

    public int getRemind_ID() {
        return Remind_ID;
    }

    public void setRemind_ID(int remind_ID) {
        Remind_ID = remind_ID;
    }

    public MedicineInfoOBean getMedicineInfo() {
        return medicineInfo;
    }

    public void setMedicineInfo(MedicineInfoOBean medicineInfo) {
        this.medicineInfo = medicineInfo;
    }

    public Timestamp getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Timestamp remindTime) {
        this.remindTime = remindTime;
    }
}
