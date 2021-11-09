package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProcedureMapper implements RowMapper<ProcedureModel>
{
	/* Match the property names in ProcedureModel w/ the column names in the database
	
	Class			Table
	Properties		Column Names
	========================
	id				Id
	procedureName	ProcedureName
	riskFactor		RiskFactor
	specialtyArea	SpecialtyArea
	description		Description
	price			Price
	photo			Photo
	
	*/
	
	public ProcedureModel mapRow(ResultSet resultSet, int i) throws SQLException
	{
		ProcedureModel procedure = new ProcedureModel(
				resultSet.getInt("Id"),
				resultSet.getString("ProcedureName"),
				resultSet.getString("RiskFactor"),
				resultSet.getString("SpecialtyArea"),
				resultSet.getString("Description"),
				resultSet.getFloat("Price"),
				resultSet.getString("Photo")
				);
		return procedure;
	}
}
