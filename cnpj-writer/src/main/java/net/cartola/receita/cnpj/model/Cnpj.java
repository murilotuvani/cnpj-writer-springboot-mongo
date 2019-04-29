package net.cartola.receita.cnpj.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Cnpj implements Serializable {

	private static final long serialVersionUID = 2186005634847048460L;
	
	@Id
    public String id;
	

}
