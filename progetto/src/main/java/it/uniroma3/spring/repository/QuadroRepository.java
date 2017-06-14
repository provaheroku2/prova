package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Customer;
import it.uniroma3.spring.model.Quadro;

public interface QuadroRepository extends CrudRepository<Quadro, Long> {

    List<Quadro> findByLastName(String lastName);

    List<Quadro> findByFirstName(String lastName);
    
    List<Quadro> findByAge(Integer age);
    
}