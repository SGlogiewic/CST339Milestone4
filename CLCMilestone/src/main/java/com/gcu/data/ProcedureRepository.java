package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gcu.model.ProcedureEntity;

@Repository
public interface ProcedureRepository extends CrudRepository<ProcedureEntity, Long>
{
	List<ProcedureEntity> findByProcedureNameContainingIgnoreCase(String searchTerm);
}
