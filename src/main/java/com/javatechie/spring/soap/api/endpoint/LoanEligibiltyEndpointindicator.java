package com.javatechie.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import com.javatechie.spring.soap.api.service.LoanEligibilityService;
@Endpoint
public class LoanEligibiltyEndpointindicator {

	@Autowired
	LoanEligibilityService service;
	
	private static final String NAMESPACE="http://www.javatechie.com/spring/soap/api/loanEligibility";
	
	@ResponsePayload
	@PayloadRoot(namespace=NAMESPACE,localPart="CustomerRequest")
	public Acknowledgement LoanEligibiltyEndpointIndicator(@RequestPayload CustomerRequest request) 
	{
		
		return service.checkEligibity(request);
		
		
	}

}
