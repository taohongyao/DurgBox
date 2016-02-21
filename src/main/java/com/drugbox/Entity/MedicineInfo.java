package com.drugbox.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 44247 on 2016/2/17 0017.
 */
@Entity
public class MedicineInfo {
    private String medicineId;
    private String medicineName;
    private String medicineProduct;
    private String medicinePicture;
    private String medicineSympton;
    private String medicineSize;
    private String medicineConsume;
    private String medicineQRcode;

    public MedicineInfo() {
    }

    public MedicineInfo(String medicineId) {
        this.medicineId = medicineId;
    }

    @Id
    @Column(name = "Medicine_ID")
    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    @Basic
    @Column(name = "Medicine_Name")
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Basic
    @Column(name = "Medicine_Product")
    public String getMedicineProduct() {
        return medicineProduct;
    }

    public void setMedicineProduct(String medicineProduct) {
        this.medicineProduct = medicineProduct;
    }

    @Basic
    @Column(name = "Medicine_Picture")
    public String getMedicinePicture() {
        return medicinePicture;
    }

    public void setMedicinePicture(String medicinePicture) {
        this.medicinePicture = medicinePicture;
    }

    @Basic
    @Column(name = "Medicine_Sympton")
    public String getMedicineSympton() {
        return medicineSympton;
    }

    public void setMedicineSympton(String medicineSympton) {
        this.medicineSympton = medicineSympton;
    }

    @Basic
    @Column(name = "Medicine_Size")
    public String getMedicineSize() {
        return medicineSize;
    }

    public void setMedicineSize(String medicineSize) {
        this.medicineSize = medicineSize;
    }

    @Basic
    @Column(name = "Medicine_Consume")
    public String getMedicineConsume() {
        return medicineConsume;
    }

    public void setMedicineConsume(String medicineConsume) {
        this.medicineConsume = medicineConsume;
    }

    @Basic
    @Column(name = "Medicine_QRcode")
    public String getMedicineQRcode() {
        return medicineQRcode;
    }

    public void setMedicineQRcode(String medicineQRcode) {
        this.medicineQRcode = medicineQRcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicineInfo that = (MedicineInfo) o;

        if (medicineId != null ? !medicineId.equals(that.medicineId) : that.medicineId != null) return false;
        if (medicineName != null ? !medicineName.equals(that.medicineName) : that.medicineName != null) return false;
        if (medicineProduct != null ? !medicineProduct.equals(that.medicineProduct) : that.medicineProduct != null)
            return false;
        if (medicinePicture != null ? !medicinePicture.equals(that.medicinePicture) : that.medicinePicture != null)
            return false;
        if (medicineSympton != null ? !medicineSympton.equals(that.medicineSympton) : that.medicineSympton != null)
            return false;
        if (medicineSize != null ? !medicineSize.equals(that.medicineSize) : that.medicineSize != null) return false;
        if (medicineConsume != null ? !medicineConsume.equals(that.medicineConsume) : that.medicineConsume != null)
            return false;
        if (medicineQRcode != null ? !medicineQRcode.equals(that.medicineQRcode) : that.medicineQRcode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medicineId != null ? medicineId.hashCode() : 0;
        result = 31 * result + (medicineName != null ? medicineName.hashCode() : 0);
        result = 31 * result + (medicineProduct != null ? medicineProduct.hashCode() : 0);
        result = 31 * result + (medicinePicture != null ? medicinePicture.hashCode() : 0);
        result = 31 * result + (medicineSympton != null ? medicineSympton.hashCode() : 0);
        result = 31 * result + (medicineSize != null ? medicineSize.hashCode() : 0);
        result = 31 * result + (medicineConsume != null ? medicineConsume.hashCode() : 0);
        result = 31 * result + (medicineQRcode != null ? medicineQRcode.hashCode() : 0);
        return result;
    }
}
