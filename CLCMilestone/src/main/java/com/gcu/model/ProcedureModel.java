package com.gcu.model;

public class ProcedureModel 
{
	long id = 0;
	String procedureName = "";
	String riskFactor = "";
	String specialtyArea = "";
	String description = "";
	float price = 0;
	String photo = "";
	
	@Override
	public String toString()
	{
		return "ProductModel [procedureName=" + procedureName + ", riskFactor=" + riskFactor + ", specialtyArea=" + specialtyArea + ", description=" + description + ", price=" + price + "]";
	}

	public ProcedureModel(long id, String procedureName, String riskFactor, String specialtyArea, String description, float price,
			String photo)
	{
		this.id = id;
		this.procedureName = procedureName;
		this.riskFactor = riskFactor;
		this.specialtyArea = specialtyArea;
		this.description = description;
		this.price = price;
		this.photo = photo;
	}
	
	public ProcedureModel()
	{
		
	}

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
