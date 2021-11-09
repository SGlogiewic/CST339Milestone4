package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.IProcedureBusinessService;
import com.gcu.model.ProcedureModel;
import com.gcu.model.SearchProcedureModel;

@Controller
@RequestMapping("/procedure")
public class ProcedureController 
{
	@Autowired
	IProcedureBusinessService procedureService;
	
	@GetMapping("/all")
    public String showAllOrders(Model model)
    {
        List<ProcedureModel> procedures = procedureService.getProcedures();
        model.addAttribute("title", "Show all procedures");
        model.addAttribute("searchModel", new SearchProcedureModel());
        model.addAttribute("procedure", procedures);
        return "procedure";
    }
	
	@GetMapping("/addNewForm")
	public String displayAddNewForm(Model model)
	{
		model.addAttribute("title", "Add new procedure");
		model.addAttribute("procedureModel", new ProcedureModel());
		return "procedureAddNewForm";
	}
	
	@PostMapping("/addNew") 
    // process a request from the AddOrderForm.  Add a new order to the database.  Show all orders.
    public String addProcedure(@Valid ProcedureModel newProcedure, BindingResult bindingResult, Model model) 
    {
        // add the new order
        procedureService.addOne(newProcedure);
        // get updated list of all the orders
        
        List<ProcedureModel> procedures = procedureService.getProcedures(); 
        
        // display all orders
        model.addAttribute("procedure", procedures); 
        model.addAttribute("searchModel", new SearchProcedureModel()); 
        return "procedure";
    } 
}
