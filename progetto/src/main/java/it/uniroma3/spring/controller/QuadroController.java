package it.uniroma3.spring.controller;

import java.util.List;

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
import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.QuadroService;


@Controller
public class QuadroController  {

	@Autowired
	private QuadroService quadroservice; 
	@Autowired
	private AutoreService autoreservice;


	@GetMapping("/gestioneQuadri")
	public String mostraQuadri(Model model) {
		model.addAttribute("quadri",quadroservice.findAll());
		return "GestioneQuadri";
	}

	@RequestMapping(value="/eliminaquadro", method = RequestMethod.GET)
	public String eliminaQuadro(@RequestParam("id") Long id, Model model) {
		Quadro quadro= quadroservice.findbyId(id);
		quadroservice.elimina(quadro);
		model.addAttribute("quadri",quadroservice.findAll());
		return "GestioneQuadri";
	}
	
	@RequestMapping(value="/modificaquadro", method = RequestMethod.GET)
	public String modificaQuadro(@RequestParam("id") Long id, Model model) {
		Quadro quadro= quadroservice.findbyId(id);
		model.addAttribute("quadro",quadro);
		model.addAttribute("autori", autoreservice.findAll());
		quadroservice.elimina(quadro);
		return "Quadroform";
	}

	@RequestMapping(value="/mostraQuadro", method=RequestMethod.GET)
	public String dettagliQuadro(@RequestParam("id") Long id ,Model model){
		model.addAttribute("quadro", quadroservice.findbyId(id));
		return "resultQuadro";
	}

	@GetMapping("/quadro")
    public String showForm(Quadro quadro, Model model, Autore autore) {

        List<Autore> autori =(List<Autore>)autoreservice.findAll();

        if (autori.size()==0){
            model.addAttribute("NoAutori","Non ci sono autori nel database, inseriscine uno");
            return "Autoreform";
        }
        else {
            model.addAttribute("autori", autori);
            return "Quadroform";
        }


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
			if(quadroValidator.validate(quadro,model)){
				quadroservice.add(quadro);
				return "resultQuadro";
			}
			else{
				model.addAttribute("autori",autoreservice.findAll());
				return "Quadroform";}
			
	}
	}






}
