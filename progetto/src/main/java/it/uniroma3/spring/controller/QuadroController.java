package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.QuadroService;


@Controller
public class QuadroController  {
	
    @Autowired
    private QuadroService quadroservice; 

    @GetMapping("/customer")
    public String showForm(Quadro quadro) {
        return "form";
    }

    @PostMapping("/customer")
    public String checkCustomerInfo(@Valid @ModelAttribute Quadro quadro, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
        	model.addAttribute(quadro);
            quadroservice.add(quadro); 
        }
        return "results";
    }
}
