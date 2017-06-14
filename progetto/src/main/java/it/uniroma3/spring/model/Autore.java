package it.uniroma3.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String nazionalita;
	private Integer annoNascita;
	private Integer annoMorte; 
	@OneToMany(mappedBy="autore")
	private List<Quadro> quadri;

	
	protected Autore(){
		this.quadri = new ArrayList<>();
	}
	
	public Autore(String nome, String cognome, String nazionalità, Integer nascita, Integer morte){
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalità;
		this.annoNascita = nascita;
		this.annoMorte = morte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalità) {
		this.nazionalita = nazionalità;
	}
	public Integer getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(Integer annoNascita) {
		this.annoNascita = annoNascita;
	}
	public Integer getAnnoMorte() {
		return annoMorte;
	}
	public void setAnnoMorte(Integer annoMorte) {
		this.annoMorte = annoMorte;
	}

	public List<Quadro> getQuadri() {
		return quadri;
	}

	public void setQuadri(List<Quadro> quadri) {
		this.quadri = quadri;
	}
	
	public void setQuadro(Quadro quadro){
		this.quadri.add(quadro);
	}


}