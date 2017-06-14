package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Customer;
import it.uniroma3.spring.model.Quadro;

public interface QuadroRepository extends CrudRepository<Quadro, Long> {

    List<Quadro> findByTitolo(String titolo);

    List<Quadro> findByAnnoRealizzazione(Integer annoRealizzazione);
    
    List<Quadro> findByTecnica(String tecnica);
    
}