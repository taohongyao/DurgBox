package com.drugbox.Bean.CollectionInfo;

import com.drugbox.Bean.IBeanOperation;

/**
 * Created by 44247 on 2016/2/22 0022.
 */
public class CollectionInfoIBean extends IBeanOperation {
    private String  medicineId;

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }
}
