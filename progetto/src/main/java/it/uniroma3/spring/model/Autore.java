package it.uniroma3.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=1)
	private String nome;
	@NotNull
	@Size(min=1)
	private String cognome;
	@NotNull
	@Size(min=1)
	private String nazionalita;
	@NotNull
	@Min(0)
	private Integer annoNascita;
	@NotNull
	@Max(2017)
	private Integer annoMorte; 
	@OneToMany(mappedBy="autore", cascade = CascadeType.REMOVE)
	private List<Quadro> quadri;

	
	protected Autore(){
		this.quadri = new ArrayList<>();
	}
	
	public Autore(String nome, String cognome, String nazionalita, Integer nascita, Integer morte){
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
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
		this.nome = (nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase());
	}

	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = (cognome.substring(0,1).toUpperCase() + cognome.substring(1).toLowerCase());;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = (nazionalita.substring(0,1).toUpperCase() + nazionalita.substring(1).toLowerCase());;
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