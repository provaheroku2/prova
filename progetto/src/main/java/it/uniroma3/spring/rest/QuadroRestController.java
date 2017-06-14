package it.uniroma3.spring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.QuadroService;

@RestController
public class QuadroRestController {
//
		@Autowired
		QuadroService quadroService;
		
	    @RequestMapping("/rest/customer/{id}")
	    public Quadro getQuadro(@PathVariable Long id) {
	        return quadroService.findbyId(id);
	    }
	}