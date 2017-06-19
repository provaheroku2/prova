package it.uniroma3.spring.validator;

import java.time.LocalDate;

import org.springframework.ui.Model;

import it.uniroma3.spring.model.Quadro;

public class quadroValidator {

	public static boolean validate(Quadro quadro, Model model) {
		boolean verifica=true;
		int annoAttuale = LocalDate.now().getYear();
		if(quadro.getAnnoRealizzazione()> annoAttuale){
			verifica=false;
			model.addAttribute("erroreAnno", "*L'anno di realizzazione deve essere minore o uguale a quello attuale.");
		}
		else if(quadro.getAnnoRealizzazione()>quadro.getAutore().getAnnoMorte() ||
				quadro.getAnnoRealizzazione()<quadro.getAutore().getAnnoNascita()){
				verifica=false;
				model.addAttribute("conflittoAnno", "*L'anno di realizzazione deve essere "
				+ "compreso tra gli anni in cui ha vissuto il suo autore");
		}
		return verifica;
		
	}

}
