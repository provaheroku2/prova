package it.uniroma3.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Quadro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private String titolo;
	private Integer annoRealizzazione;
	private String tecnica;
	private Double lunghezza;
	private Double altezza;
	@ManyToOne
	private Autore autore;
	
	protected Quadro(){
		
	}
	
	public Quadro(String titolo, Integer annoRealizzazione, String tecnica, Double lunghezza, Double altezza){
		this.titolo = titolo;
		this.annoRealizzazione = annoRealizzazione;
		this.tecnica = tecnica;
		this.lunghezza = lunghezza;
		this.altezza = altezza;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Integer getAnnoRealizzazione() {
		return annoRealizzazione;
	}
	public void setAnnoRealizzazione(Integer anno) {
		this.annoRealizzazione = anno;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public Double getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(Double lunghezza) {
		this.lunghezza = lunghezza;
	}
	public Double getAltezza() {
		return altezza;
	}
	public void setAltezza(Double altezza) {
		this.altezza = altezza;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
}