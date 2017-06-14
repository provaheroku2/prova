package it.uniroma3.spring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Customer;
import it.uniroma3.spring.service.CustomerService;

@RestController
public class CustomerRestController {

		@Autowired
		CustomerService customerService;
		
	    @RequestMapping("/rest/customer/{id}")
	    public Customer getCustomer(@PathVariable Long id) {
	        return customerService.findbyId(id);
	    }
	}