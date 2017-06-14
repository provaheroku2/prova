package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Customer;
import it.uniroma3.spring.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository; 

    public Iterable<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Transactional
    public void add(final Customer customer) {
        this.customerRepository.save(customer);
    }

	public Customer findbyId(Long id) {
		return this.customerRepository.findOne(id);
	}

}
