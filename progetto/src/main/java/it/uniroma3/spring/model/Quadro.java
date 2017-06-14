package it.uniroma3.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Quadro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=1)
	private String titolo;
	@NotNull
	@Size(min=1)
	private Integer annoRealizzazione;
	@NotNull
	@Size(min=1)
	private String tecnica;
	@NotNull
	@Size(min=1)
	private Double lunghezza;
	@NotNull
	@Size(min=1)
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