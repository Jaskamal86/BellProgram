package com.kamal.Personal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.kamal.Personal.service.BellService;

@RestController
@RequestMapping("/server")
public class BellApplicationController {

	@Autowired
	private BellService service;

	@GetMapping("/order/{firstServer}/{secondServer}")
	public int createOrder(@PathVariable(name = "firstServer", required = true) String firstServer,
			@PathVariable(name = "secondServer", required = true) String secondServer) {
		
		validateOrder(firstServer, secondServer);
		
		return service.submitOrder(firstServer, secondServer);
	}

	private void validateOrder(String firstServer, String secondServer) {

		if(firstServer == null && secondServer == null)
		{
			throw new RestClientException("You must select at least 1 server to create the order");
		}
	}
}
