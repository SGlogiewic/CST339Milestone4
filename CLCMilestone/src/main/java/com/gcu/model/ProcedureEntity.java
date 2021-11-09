package com.gcu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("procedure")
public class ProcedureEntity 
{
	@Id
	@Column("Id")
	long id;
	
	@Column("ProcedureName")
	String procedureName = "";
	
	@Column("RiskFactor")
	String riskFactor = "";
	
	@Column("SpecialtyArea")
	String specialtyArea = "";
	
	@Column("Description")
	String description = "";
	
	@Column("Price")
	float price = 0;
	
	@Column("Photo")
	String photo = "";

	public ProcedureEntity(long id, String procedureName, String riskFactor, String specialtyArea, String description,
			float price, String photo)
	{
		this.id = id;
		this.procedureName = procedureName;
		this.riskFactor = riskFactor;
		this.specialtyArea = specialtyArea;
		this.description = description;
		this.price = price;
		this.photo = photo;
	}
	
	public ProcedureEntity() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(String riskFactor) {
		this.riskFactor = riskFactor;
	}

	public String getSpecialtyArea() {
		return specialtyArea;
	}

	public void setSpecialtyArea(String specialtyArea) {
		this.specialtyArea = specialtyArea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
