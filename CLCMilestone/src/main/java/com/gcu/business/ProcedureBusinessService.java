package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.IProcedureDataAccess;
import com.gcu.data.ProcedureDataService;
import com.gcu.data.ProcedureDataServiceForRepository;
import com.gcu.model.ProcedureEntity;
import com.gcu.model.ProcedureModel;

@Service
public class ProcedureBusinessService implements IProcedureBusinessService 
{
	@Autowired
	ProcedureDataServiceForRepository service;

	@Override
	public ProcedureModel getById(int Id) 
	{
		ProcedureEntity result = service.getById(Id);
        ProcedureModel order = new ProcedureModel(
                result.getId(),
                result.getProcedureName(),
                result.getRiskFactor(),
                result.getSpecialtyArea(),
                result.getDescription(),
                result.getPrice(),
                result.getPhoto()
                );
        return order;
	}

	@Override
	public List<ProcedureModel> getProcedures() 
	{
		// Fetch the list of entities
        List<ProcedureEntity> proceduresE = service.getProcedures();
        // Create an empty list of orders
        List<ProcedureModel> procedures = new ArrayList<ProcedureModel>();
        // For each entity in the list, create a new order and add to orders
        for (ProcedureEntity entity: proceduresE)
        {
            procedures.add(
                    // Translate from Entity to Order Model
                    new ProcedureModel(
                    		entity.getId(),
                    		entity.getProcedureName(),
                    		entity.getRiskFactor(),
                    		entity.getSpecialtyArea(),
                    		entity.getDescription(),
                    		entity.getPrice(),
                    		entity.getPhoto())
                    );
        }
        return procedures;
	}

	@Override
	public List<ProcedureModel> searchProcedures(String searchTerm) 
	{
		List<ProcedureEntity> proceduresE = service.searchProcedures(searchTerm);
        List<ProcedureModel> procedures = new ArrayList<ProcedureModel>();
        for (ProcedureEntity entity: proceduresE)
        {
        	procedures.add(
                    // Translate from Entity to Order Model
                    new ProcedureModel(
                    		entity.getId(),
                    		entity.getProcedureName(),
                    		entity.getRiskFactor(),
                    		entity.getSpecialtyArea(),
                    		entity.getDescription(),
                    		entity.getPrice(),
                    		entity.getPhoto())
                    );
        }
        return procedures;
	}

	@Override
	public int addOne(ProcedureModel newProcedure) 
	{
		ProcedureEntity entity = new ProcedureEntity(
				newProcedure.getId(),
				newProcedure.getProcedureName(),
				newProcedure.getRiskFactor(),
				newProcedure.getSpecialtyArea(),
				newProcedure.getDescription(),
				newProcedure.getPrice(),
				newProcedure.getPhoto()
                );
        return service.addOne(entity);
	}

	@Override
	public boolean deleteOne(long id) 
	{
		return service.deleteOne(id);
	}

	@Override
	public ProcedureModel updateOne(long idToUpdate, ProcedureModel updateProcedure)
	{
		ProcedureEntity entity = new ProcedureEntity(
				updateProcedure.getId(),
				updateProcedure.getProcedureName(),
				updateProcedure.getRiskFactor(),
				updateProcedure.getSpecialtyArea(),
				updateProcedure.getDescription(),
				updateProcedure.getPrice(),
				updateProcedure.getPhoto()
                );
        ProcedureEntity result = service.updateOne(idToUpdate, entity);
        
        ProcedureModel updated = new ProcedureModel(
        		result.getId(),
                result.getProcedureName(),
                result.getRiskFactor(),
                result.getSpecialtyArea(),
                result.getDescription(),
                result.getPrice(),
                result.getPhoto()
                );
        return updated;
	}

	@Override
	public void init() 
	{
		System.out.println("Init method of OrderBusinessService was just called");
	}

	@Override
	public void destroy() 
	{
		System.out.println("Destroy method of OrderBusinessService was just called");
	}

}
