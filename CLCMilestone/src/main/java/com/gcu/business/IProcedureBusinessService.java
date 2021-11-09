package com.gcu.business;

import java.util.List;

import com.gcu.model.ProcedureModel;

public interface IProcedureBusinessService 
{
	public ProcedureModel getById(int Id);
	public List<ProcedureModel> getProcedures();
	public List<ProcedureModel> searchProcedures(String searchTerm);
	public int addOne(ProcedureModel newProcedure);
	public boolean deleteOne(long id);
	public ProcedureModel updateOne(long idToUpdate, ProcedureModel updateProcedure);
	public void init();
	public void destroy();
}
