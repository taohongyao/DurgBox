package com.drugbox.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Entity
public class MedicineuseInfo {
    private int medicineUseId;
    private Date medicineTime;
    private Byte medicineIsnowused;
    private Byte medicineIscollect;
    private String medicineReviews;

    @Id
    @Column(name = "Medicine_Use_ID")
    public int getMedicineUseId() {
        return medicineUseId;
    }

    public void setMedicineUseId(int medicineUseId) {
        this.medicineUseId = medicineUseId;
    }

    @Basic
    @Column(name = "Medicine_Time")
    public Date getMedicineTime() {
        return medicineTime;
    }

    public void setMedicineTime(Date medicineTime) {
        this.medicineTime = medicineTime;
    }

    @Basic
    @Column(name = "Medicine_Isnowused")
    public Byte getMedicineIsnowused() {
        return medicineIsnowused;
    }

    public void setMedicineIsnowused(Byte medicineIsnowused) {
        this.medicineIsnowused = medicineIsnowused;
    }

    @Basic
    @Column(name = "Medicine_Iscollect")
    public Byte getMedicineIscollect() {
        return medicineIscollect;
    }

    public void setMedicineIscollect(Byte medicineIscollect) {
        this.medicineIscollect = medicineIscollect;
    }

    @Basic
    @Column(name = "Medicine_Reviews")
    public String getMedicineReviews() {
        return medicineReviews;
    }

    public void setMedicineReviews(String medicineReviews) {
        this.medicineReviews = medicineReviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicineuseInfo that = (MedicineuseInfo) o;

        if (medicineUseId != that.medicineUseId) return false;
        if (medicineTime != null ? !medicineTime.equals(that.medicineTime) : that.medicineTime != null) return false;
        if (medicineIsnowused != null ? !medicineIsnowused.equals(that.medicineIsnowused) : that.medicineIsnowused != null)
            return false;
        if (medicineIscollect != null ? !medicineIscollect.equals(that.medicineIscollect) : that.medicineIscollect != null)
            return false;
        if (medicineReviews != null ? !medicineReviews.equals(that.medicineReviews) : that.medicineReviews != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medicineUseId;
        result = 31 * result + (medicineTime != null ? medicineTime.hashCode() : 0);
        result = 31 * result + (medicineIsnowused != null ? medicineIsnowused.hashCode() : 0);
        result = 31 * result + (medicineIscollect != null ? medicineIscollect.hashCode() : 0);
        result = 31 * result + (medicineReviews != null ? medicineReviews.hashCode() : 0);
        return result;
    }
}
