package it.uniroma3.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.QuadroService;




@Controller
public class GalleriaController  {
	
    @Autowired
    private QuadroService quadroservice; 
    
   

    @GetMapping("/galleria")
    public String mostraQuadri(Model model) {
    	List<Quadro> quadri = (List<Quadro>) quadroservice.findAll();
    	model.addAttribute(quadri);
        return "MostraQuadri";
    }

}
