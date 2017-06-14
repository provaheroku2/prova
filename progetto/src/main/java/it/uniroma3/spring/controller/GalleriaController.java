package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class GalleriaController  {
	
    @Autowired
    
   

    @GetMapping("/galleria")
    public String showForm() {
        return "Quadroform";
    }

}
