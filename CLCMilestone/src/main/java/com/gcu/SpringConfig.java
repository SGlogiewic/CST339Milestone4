package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.IProcedureBusinessService;
import com.gcu.business.ISecurityService;
import com.gcu.business.ProcedureBusinessService;
import com.gcu.business.Validation;

@Configuration
public class SpringConfig 
{
	@Bean(name="securityService")
	public ISecurityService getSecurityService()
	{
		return new Validation();
	}
	
//	@Bean(name="procedureBusinessService", initMethod="init", destroyMethod="destroy")
//	public IProcedureBusinessService getProcedureBusiness()
//	{
//		return new ProcedureBusinessService();
//	}
}
