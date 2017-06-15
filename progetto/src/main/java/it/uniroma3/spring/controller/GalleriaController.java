package it.uniroma3.spring.controller;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.QuadroService;




@Controller
public class GalleriaController  {

	@Autowired
	private QuadroService quadroservice; 
	@Autowired
	private AutoreService autoreservice; 

	@GetMapping("/ricercaQuadriAutore")
    public String ricercaQuadriPerAutore(@RequestParam("cognome") String cognome, Model model){
    		List<Quadro> quadri = quadroservice.findByAutore(cognome);
    		model.addAttribute("quadri",quadri);
    		return "quadriFiltrati";
   }
	
	@GetMapping("/galleriaautori")
	public String galleriaAutori(Model model) {
		model.addAttribute("autori",autoreservice.findAll());
		return "MostraAutori";
	}
	
	@GetMapping("/mostraAutori")
	public String mostraAutori(Model model) {
		model.addAttribute("autori",autoreservice.findAll());
		return "MostraAutoriQuadri";
	}
	
	@GetMapping("/mostraTecniche")
	public String mostraTecniche(Model model){
		Iterable<Quadro> quadri = quadroservice.findAll();
		Set<String> tecniche= new TreeSet<>();
		for(Quadro quadro:quadri){
			tecniche.add(quadro.getTecnica());
		}
		model.addAttribute("tecniche", tecniche);
		return "mostraTecnicheQuadri";
		
	}

	
	@GetMapping("/ricercaQuadriTecnica")
    public String ricercaTecnica(@RequestParam("tecnica") String tecnica, Model model){
        List<Quadro> quadri = quadroservice.findByTecnica(tecnica);
        model.addAttribute("quadri",quadri);
        return "quadriFiltrati";
    }
	
	@GetMapping("/mostraAnni")
	public String mostraAnni(Model model){
		Iterable<Quadro> quadri = quadroservice.findAll();
		Set<Integer> anni= new TreeSet<>();
		for(Quadro quadro:quadri){
			anni.add(quadro.getAnnoRealizzazione());
		}
		model.addAttribute("anni", anni);
		return "mostraAnniDeiQuadri";
		
	}
	
	@GetMapping("/ricercaQuadriAnno")
    public String ricercaAnno(@RequestParam("anno") Integer anno, Model model){
        List<Quadro> quadri = quadroservice.findByAnnoRealizzazione(anno);
        model.addAttribute("quadri",quadri);
        return "quadriFiltrati";
    }
	
	
	
	@RequestMapping(value="/galleriaAutore", method=RequestMethod.GET)
    public String dettagliAutore(@RequestParam("id") Long id ,Model model){
		model.addAttribute("autore", autoreservice.findbyId(id));
		return "resultAutore";
	}

	@GetMapping("/galleriaquadri")
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
