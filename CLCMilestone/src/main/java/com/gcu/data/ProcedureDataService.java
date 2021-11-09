package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gcu.model.ProcedureMapper;
import com.gcu.model.ProcedureModel;

@Service
public class ProcedureDataService implements IProcedureDataAccess<ProcedureModel>
{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public ProcedureDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ProcedureModel getById(int Id) {
		ProcedureModel result = jdbcTemplate.queryForObject(
				"SELECT * FROM procedure WHERE Id = ?",
				new ProcedureMapper(),
				new Object[] {Id});
		return result;
	}

	@Override
	public List<ProcedureModel> getProcedures() {
		return jdbcTemplate.query(
				"SELECT * FROM procedure", 
				new ProcedureMapper());
	}

	@Override
	public List<ProcedureModel> searchProcedures(String searchTerm) {
		return jdbcTemplate.query(
				"SELECT * FROM procedure WHERE ProcedureName LIKE ?",
				new ProcedureMapper(),
				new Object[] {"%" + searchTerm + "%"});
	}

	@Override
	public int addOne(ProcedureModel newProcedure) {
		return jdbcTemplate.update(
				"INSERT INTO procedure (ProcedureName, RiskFactor, SpecialtyArea, Description, Price, Photo) VALUES (?, ?, ?, ?, ?, ?)",
				newProcedure.getProcedureName(),
				newProcedure.getRiskFactor(),
				newProcedure.getSpecialtyArea(),
				newProcedure.getDescription(),
				newProcedure.getPrice(),
				newProcedure.getPhoto());
	}

	@Override
	public boolean deleteOne(long id) {
		int updateResult = jdbcTemplate.update(
				"DELETE FROM procedure WHERE Id = ?",
				new Object[] {id});
		return (updateResult > 0);
	}

	@Override
	public ProcedureModel updateOne(long idToUpdate, ProcedureModel updateProcedure) {
		int result = jdbcTemplate.update(
				"UPDATE procedure SET ProcedureName = ?, RiskFactor = ?, SpecialtyArea = ?, Description = ?, Price = ?, Photo = ? WHERE ID = ?",
				updateProcedure.getProcedureName(),
				updateProcedure.getRiskFactor(),
				updateProcedure.getSpecialtyArea(),
				updateProcedure.getDescription(),
				updateProcedure.getPrice(),
				updateProcedure.getPhoto(),
				idToUpdate);
		if (result > 0)
		{
			return updateProcedure;
		}
		else
		{
			return null;
		}
	}
}
