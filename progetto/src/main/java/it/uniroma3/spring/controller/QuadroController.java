package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Customer;
import it.uniroma3.spring.service.CustomerService;


@Controller
public class QuadroController  {
	
    @Autowired
    private QuadroService customerservice; 

    @GetMapping("/customer")
    public String showForm(Customer customer) {
        return "form";
    }

    @PostMapping("/customer")
    public String checkCustomerInfo(@Valid @ModelAttribute Customer customer, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
        	model.addAttribute(customer);
            customerservice.add(customer); 
        }
        return "results";
    }
}
