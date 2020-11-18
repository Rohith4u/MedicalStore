package com.cg.healthassist.Pharmacy.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "medicals")
public class MedicalStore{
	

/** The MedicalStore class provides methods provide getters and setters for required entity
 * 
 * @author Rohith
 * @version 2.0
 * 
 */

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "medicine_id")
	private Integer medicineId;
	
	@Column(name = "medicine_name" ,nullable = false)
	private String medicineName;
	
	@Column(name = "medicine_dose" ,nullable = false)
	private Integer medicineDose;
	
	@Column(name = "medicine_cost" ,nullable = false)
	private double medicineCost;
	
	@Column(name = "expire_date" ,nullable = false)
	private String expireDate;
	
	public MedicalStore() {
	}

	public MedicalStore(int medicineId, String medicineName, int medicineDose, double medicineCost,
			String expireDate) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineDose = medicineDose;
		this.medicineCost = medicineCost;
		this.expireDate = expireDate;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Integer getMedicineDose() {
		return medicineDose;
	}

	public void setMedicineDose(Integer medicineDose) {
		this.medicineDose = medicineDose;
	}

	public double getMedicineCost() {
		return medicineCost;
	}

	public void setMedicineCost(double medicineCost) {
		this.medicineCost = medicineCost;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "MedicalStore [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineDose="
				+ medicineDose + ", medicineCost=" + medicineCost + ", expireDate=" + expireDate + "]";
	}
	
	
	
	
}
