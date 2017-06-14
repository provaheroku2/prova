package it.uniroma3.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AmministratoreController  {

   

    @GetMapping("/pannello")
    public String mostraComandi() {
        return "pannelloDiControllo";
    }

}