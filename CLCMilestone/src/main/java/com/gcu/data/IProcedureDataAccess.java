package com.gcu.data;

import java.util.List;

import com.gcu.model.ProcedureModel;

public interface IProcedureDataAccess<T> 
{
	public T getById(int Id);
	public List<T> getProcedures();
	public List<T> searchProcedures(String searchTerm);
	public int addOne(T newProcedure);
	public boolean deleteOne(long id);
	public T updateOne(long idToUpdate, T updateProcedure);
}
