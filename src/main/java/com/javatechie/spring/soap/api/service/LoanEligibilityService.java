package com.javatechie.spring.soap.api.service;

import org.springframework.stereotype.Service;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {

	public LoanEligibilityService() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Acknowledgement checkEligibity(CustomerRequest request) 
	{
		Acknowledgement ack = new Acknowledgement();
		if(! (request.getAge()>28 && request.getAge()<60) )
		{
			ack.setApprovedAmount(0);
			ack.setIsEligible(false);
			ack.getCriteriaMismatch().add("Age is not satisfied");
			
		}
		if(! (request.getCibilScore() >80) )
		{
			ack.setApprovedAmount(0);
			ack.setIsEligible(false);
			ack.getCriteriaMismatch().add("Cibil Score is not satisfied");
			
			//return ack;
			
		}
	    
		if(ack.getCriteriaMismatch().isEmpty())
		{
			ack.setApprovedAmount(5000);
			ack.setIsEligible(true);
			return ack;
		}
		else 
		{
			ack.setApprovedAmount(0);
			ack.setIsEligible(false);
			return ack;
		}
		
		
		
		
	}

}
