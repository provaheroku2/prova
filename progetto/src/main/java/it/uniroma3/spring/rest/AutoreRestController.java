package it.uniroma3.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.service.AutoreService;


@RestController
public class AutoreRestController {

	@Autowired
	AutoreService autoreService;

	@RequestMapping("/rest/autore/{id}")
	public Autore getAutore(@PathVariable Long id) {
		return autoreService.findbyId(id);
	}
}

