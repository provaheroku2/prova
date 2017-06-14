package it.uniroma3.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.service.QuadroService;




@Controller
public class GalleriaController  {

	@Autowired
	private QuadroService quadroservice; 



	@GetMapping("/galleriacompleta")
	public String mostraQuadri(Model model) {
		model.addAttribute("quadri",quadroservice.findAll());
		return "MostraQuadri";
	}
	
	@RequestMapping(value="/galleriaQuadro", method=RequestMethod.GET)
    public String dettagliQuadro(@RequestParam("id") Long id ,Model model){
		model.addAttribute("quadro", quadroservice.findbyId(id));
		return "resultQuadro";
	}

}
