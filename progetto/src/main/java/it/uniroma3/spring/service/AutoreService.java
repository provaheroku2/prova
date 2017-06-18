package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.repository.AutoreRepository;


@Service
public class AutoreService {
	@Autowired
	private AutoreRepository autoreRepository; 

	public Iterable<Autore> findAll() {
		return this.autoreRepository.findAll();
	}

	@Transactional
	public void add(final Autore autore) {
		this.autoreRepository.save(autore);
	}

	public Autore findbyId(Long id) {
		return this.autoreRepository.findOne(id);
	}

	public void elimina(Autore autore){
		autoreRepository.delete(autore);
	}

	public List<Autore> fingByCognome(String cognome){
		return this.autoreRepository.findByCognome(cognome);			
	}
	
	public List<Autore> fingByNazionalita(String nazionalita){
		return this.autoreRepository.findByNazionalita(nazionalita);			
	}
	

}
