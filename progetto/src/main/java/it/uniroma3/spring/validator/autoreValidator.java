package it.uniroma3.spring.validator;

import java.time.LocalDate;

import org.springframework.ui.Model;

import it.uniroma3.spring.model.Autore;

public class autoreValidator {

	public static boolean validate(Autore autore, Model model){
		boolean verifica = true;
		int annoAttuale = LocalDate.now().getYear();
		if(autore.getAnnoNascita() > autore.getAnnoMorte()){
			verifica = false;
			model.addAttribute("conflittoNascita", "*L'anno di nascita deve essere minore o uguale a quello di morte.");
			model.addAttribute("conflittoMorte", "*L'anno di morte deve essere maggiore o uguale a quello di morte.");

		}
		if(autore.getAnnoNascita()>annoAttuale){
			verifica = false;
			model.addAttribute("erroreNascita","*L'anno di nascita deve precedere quello attuale.");
		}
		if(autore.getAnnoMorte()>annoAttuale){
			model.addAttribute("erroreMorte","*L'anno di morte deve precedere quello attuale.");
			verifica = false;
		}
		return verifica;
	}
}
