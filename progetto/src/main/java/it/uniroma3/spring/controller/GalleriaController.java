package it.uniroma3.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import it.uniroma3.spring.service.QuadroService;




@Controller
public class GalleriaController  {
	
    @Autowired
    private QuadroService quadroservice; 
    

    @GetMapping("/galleria")
    public String mostraQuadri(Model model) {
    	model.addAttribute(quadroservice.findAll());
        return "MostraQuadri";
    }

}
