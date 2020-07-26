package com.kamal.Personal.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.kamal.Personal.service.BellService;

@RestController
@RequestMapping("/server/order")
public class BellApplicationController {

	@Autowired
	private BellService service;
	
	@GetMapping
	public Integer createOrder(HttpServletRequest request, HttpServletResponse response) {
		
		int countA = Integer.parseInt(request.getParameter("Aquantity"));
		int countB = Integer.parseInt(request.getParameter("Bquantity"));
		validateOrder(countA, countB);
		
		return service.submitOrder(countA, countB);
	}

	private void validateOrder(int countA, int countB) {

		if(countA == 0 && countB == 0)
		{
			throw new RestClientException("You must select at least 1 server to create the order");
		}
		else if(countA + countB > 2)
		{
			throw new RestClientException("You cannot select more than 2 servers in a single order");
		}
	}
}
