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




import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.QuadroService;


@Controller
public class QuadroController  {

	@Autowired
	private QuadroService quadroservice; 
	@Autowired
	private AutoreService autoreservice;


	@GetMapping("/gestioneEliminaQuadro")
	public String mostraQuadri(Model model) {
		model.addAttribute("quadri",quadroservice.findAll());
		return "EliminaQuadri";
	}

	@RequestMapping(value="/eliminaquadro", method = RequestMethod.GET)
	public String eliminaQuadro(@RequestParam("id") Long id, Model model) {
		Quadro quadro= quadroservice.findbyId(id);
		quadroservice.elimina(quadro);
		model.addAttribute("quadri",quadroservice.findAll());
		return "EliminaQuadri";
	}

	@RequestMapping(value="/mostraQuadro", method=RequestMethod.GET)
	public String dettagliQuadro(@RequestParam("id") Long id ,Model model){
		model.addAttribute("quadro", quadroservice.findbyId(id));
		return "resultQuadro";
	}

	@GetMapping("/quadro")
	public String showForm(Quadro quadro, Model model) {
		model.addAttribute("autori",autoreservice.findAll());
		return "Quadroform";
	}


	@PostMapping("/quadro")
	public String checkQuadroInfo(@Valid @ModelAttribute Quadro quadro, 
			BindingResult bindingResult, Model model, @RequestParam("autoreId") Long id ) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("autori",autoreservice.findAll());
			return "Quadroform";
		}
		else {
			model.addAttribute(quadro);
			quadro.setAutore(autoreservice.findbyId(id));
			quadroservice.add(quadro); 
		}
		return "resultQuadro";
	}






}
