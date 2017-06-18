package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.service.AutoreService;

@Controller
public class AutoreController {

	@Autowired
    private AutoreService autoreservice; 
	 
	@RequestMapping(value="/eliminaautore", method = RequestMethod.GET)
	public String eliminaAutore(@RequestParam("id") Long id, Model model) {
		Autore autore= autoreservice.findbyId(id);
		autoreservice.elimina(autore);
		model.addAttribute("autori",autoreservice.findAll());
		return "EliminaAutori";
	}
	
	@GetMapping("/gestioneEliminaAutore")
	public String mostraAutori(Model model) {
		model.addAttribute("autori",autoreservice.findAll());
		return "EliminaAutori";
	}
	
	@RequestMapping(value="/mostraAutore", method=RequestMethod.GET)
	public String dettagliQuadro(@RequestParam("id") Long id ,Model model){
		model.addAttribute("autore", autoreservice.findbyId(id));
		return "resultAutore";
	}
	
	@GetMapping("/autore")
	    public String showForm(Autore autore) {
	        return "Autoreform";
	    }

	    @PostMapping("/autore")
	    public String checkQuadroInfo(@Valid @ModelAttribute Autore autore, 
	    									BindingResult bindingResult, Model model) {
	    	
	        if (bindingResult.hasErrors()) {
	            return "Autoreform";
	        }
	        else {
	        	model.addAttribute(autore);
	            autoreservice.add(autore); 
	        }
	        return "resultAutore";
	    }
}
