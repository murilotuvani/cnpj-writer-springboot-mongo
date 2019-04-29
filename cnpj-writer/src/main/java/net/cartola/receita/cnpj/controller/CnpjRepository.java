package net.cartola.receita.cnpj.controller;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.cartola.receita.cnpj.model.Cnpj;

public interface CnpjRepository extends MongoRepository<Cnpj, String> {
	
	public Cnpj findByFirstName(String firstName);
    public List<Cnpj> findByLastName(String lastName);


}
