package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gcu.model.ProcedureEntity;

@Service
public class ProcedureDataServiceForRepository implements IProcedureDataAccess<ProcedureEntity>
{
	@Autowired
	private ProcedureRepository procedureRepository;
	@SuppressWarnings("unused")
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	// Non-Default Constructor
	public ProcedureDataServiceForRepository(ProcedureRepository procedureRepository, DataSource dataSource)
	{
		this.procedureRepository = procedureRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public ProcedureEntity getById(int Id) {
		return procedureRepository.findById((long) Id).orElse(null);
	}

	@Override
	public List<ProcedureEntity> getProcedures() {
		List<ProcedureEntity> procedures = (List<ProcedureEntity>) procedureRepository.findAll();
        return procedures;
	}

	@Override
	public List<ProcedureEntity> searchProcedures(String searchTerm) {
		 List<ProcedureEntity> result = procedureRepository.findByProcedureNameContainingIgnoreCase(searchTerm);
	     return result;
	}

	@Override
	public int addOne(ProcedureEntity newProcedure) {
		ProcedureEntity result = procedureRepository.save(newProcedure);
        if (result == null)
        {
            return 0;
        }
        return (int) result.getId();
	}

	@Override
	public boolean deleteOne(long id) {
		procedureRepository.deleteById(id);
        return true;
	}

	@Override
	public ProcedureEntity updateOne(long idToUpdate, ProcedureEntity updateProcedure) {
		ProcedureEntity result = procedureRepository.save(updateProcedure);
        return result;
	}

}
