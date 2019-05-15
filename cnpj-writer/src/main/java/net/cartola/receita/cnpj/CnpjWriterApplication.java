package net.cartola.receita.cnpj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.cartola.receita.cnpj.model.CnaeSecundaria;
import net.cartola.receita.cnpj.model.Cnpj;
import net.cartola.receita.cnpj.model.Socio;
import net.cartola.receita.cnpj.repository.CnpjRepository;

@SpringBootApplication
public class CnpjWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnpjWriterApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(CnpjRepository cnpjRepository) {

		return args -> {
			long CNPJ = 99999999000199L;
			Cnpj encontrado = cnpjRepository.findByCnpj(CNPJ);
			if (encontrado == null) {
				encontrado = new Cnpj();
				encontrado.setCnpj(CNPJ);
				encontrado.setCnae(1);
				encontrado.setRazaoSocial("Minha Empresa S/A");
				encontrado.setNomeFantasia("Empresa Cool.com");
				encontrado.setBairro("Paraíso");
				encontrado.setMunicipio("São Paulo");
				encontrado.setUf("SP");
				encontrado.setCorreioEletronico("cool@cool.com");
				
				Socio socio = new Socio();
				socio.setNome("José Maria");
				socio.setCpfCnpjSocio("1");
				encontrado.addSocio(socio);
				
				socio = new Socio();
				socio.setNome("Maria José");
				socio.setCpfCnpjSocio("2");
				encontrado.addSocio(socio);
				
				CnaeSecundaria cs = new CnaeSecundaria();
				cs.setCnaeSecundaria(9832);
				encontrado.addCnaeSecundaria(cs);
				
				cnpjRepository.save(encontrado);
			} else {
				System.out.println(encontrado);
        	}
        	
        };
	}

}
