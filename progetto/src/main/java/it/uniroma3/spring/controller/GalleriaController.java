package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.spring.model.Customer;
import it.uniroma3.spring.service.CustomerService;

@Controller
public class GalleriaController  {
	
    @Autowired
    private CustomerService customerservice; 

    @GetMapping("/galleria")
    public String showForm(Customer customer) {
        return "form";
    }

}
