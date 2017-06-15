package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.repository.QuadroRepository;


@Service
public class QuadroService {

    @Autowired
    private QuadroRepository quadroRepository; 

    public Iterable<Quadro> findAll() {
        return this.quadroRepository.findAll();
    }

    @Transactional
    public void add(final Quadro quadro) {
        this.quadroRepository.save(quadro);
    }

	public Quadro findbyId(Long id) {
		return this.quadroRepository.findOne(id);
	}
	
	public void elimina(Quadro quadro){
		quadroRepository.delete(quadro);
	}
	
	public List<Quadro> findByAnnoRealizzazione(Integer anno){
		return this.quadroRepository.findByAnnoRealizzazione(anno);
	}
	

}
