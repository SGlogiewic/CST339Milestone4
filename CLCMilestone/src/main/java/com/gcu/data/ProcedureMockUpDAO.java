package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcu.model.ProcedureModel;

@Repository
public class ProcedureMockUpDAO implements IProcedureDataAccess<ProcedureModel> 
{
	private List<ProcedureModel> procedures = new ArrayList<ProcedureModel>();

	public ProcedureMockUpDAO()
	{
		procedures = new ArrayList<ProcedureModel>();
		
		procedures.add(new ProcedureModel(1, "Appendectomy", "3-4", "General Surgery", "Antibiotics are given before an appendectomy to fight possible peritonitis, or infection of the abdominal cavity's lining. General anesthesia is given, and the appendix is removed through a short incision in the right lower quadrant of the abdomen. If you have peritonitis, the abdomen is also drained of pus. Within 12 hours of surgery, you are likely to be up and moving around. You can usually return to normal activities in two or three weeks. If surgery is done with a laparoscope (a thin telescope-like instrument for viewing inside the abdomen), three to four smaller incisions are made. With this procedure, recovery is faster.", 33000.00f, "appendix.png"));
		procedures.add(new ProcedureModel(2, "C-Section", "5-6", "Obstetrician-Gynecologists", "The doctor will place a screen across your waist, so you won’t be able to see the surgery as it happens. They’ll make one cut in your belly, then another one in your uterus. You won’t feel them because of the anesthesia.", 22646.00f, "csection.png"));
		procedures.add(new ProcedureModel(3, "Heart Bypass Surgery", "7-8","Cardiovascular Surgery", "Heart bypass surgery is when a surgeon takes blood vessels from another part of your body to go around, or bypass, a blocked artery. The result is that more blood and oxygen can flow to your heart again.", 70000.00f, "heartbypass.png"));
	}
	
	@Override
	public ProcedureModel getById(int Id) 
	{
		return procedures.stream()
				.filter(procedures -> procedures.getId() == Id)
				.findFirst()
				.get();
	}

	@Override
	public List<ProcedureModel> getProcedures() 
	{
		return procedures;
	}

	@Override
	public List<ProcedureModel> searchProcedures(String searchTerm) 
	{
		// Standard Loop
				List<ProcedureModel> foundItems = new ArrayList<ProcedureModel>();
				for (int i = 0; i < procedures.size(); i++)
				{
					if (procedures.get(i).getProcedureName().toLowerCase().contains(searchTerm.toLowerCase()))
					{
						foundItems.add(procedures.get(i));
					}
				}
				
				System.out.println("I searched for " + searchTerm + " and found " + foundItems.size() + " items.");
				return foundItems;
	}

	@Override
	public int addOne(ProcedureModel newProcedure) 
	{
		boolean success = procedures.add(newProcedure);
		
		// For testing, print status to console
		System.out.println("I added one item. Now there are " + procedures.size() + " items in the list");
		if (success)
		{
			return 1;
		}
		return 0;
	}

	@Override
	public boolean deleteOne(long id) 
	{
		procedures.removeIf(procedures -> procedures.getId() == id);
		
		// For testing, print status to console
		System.out.println("I removed one item. Now there are " + procedures.size() + " items in the list");
		
		return true;
	}

	@Override
	public ProcedureModel updateOne(long idToUpdate, ProcedureModel updateProcedure) 
	{
		// Find matching order
		procedures.stream().forEach(procedures -> {
			if (procedures.getId() == idToUpdate)
			{
				procedures.setProcedureName(updateProcedure.getProcedureName());
				procedures.setRiskFactor(updateProcedure.getRiskFactor());
				procedures.setSpecialtyArea(updateProcedure.getSpecialtyArea());
				procedures.setDescription(updateProcedure.getDescription());
				procedures.setPrice(updateProcedure.getPrice());
				procedures.setPhoto(updateProcedure.getPhoto());
				System.out.println("Updated Order " + updateProcedure);
			}
		});
				
		// For testing
		System.out.println("You asked me to update procedure id number " + idToUpdate + ". The updated order is " + updateProcedure.toString());
				
		// If no order matches the given idToUpdate, return Null
		System.out.println("I tried to find procedure id number " + idToUpdate + " but couldn't find one that matches");
		return null;
	}

}
