package net.cartola.receita.cnpj.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.cartola.receita.cnpj.model.Cnpj;
import net.cartola.receita.cnpj.repository.CnpjRepository;

@RestController
@RequestMapping("/api/cnpj")
public class CnpjRestController {

	private static final Logger LOG = LoggerFactory.getLogger(CnpjRestController.class);

	@Autowired
	CnpjRepository cnpjRepository;

	@GetMapping("/{cnpj}")
	public ResponseEntity<Cnpj> getByCnpj(@PathParam("cnpj") Long cnpj) {
		Cnpj cnpjEncontrado = cnpjRepository.findByCnpj(cnpj);
		if (cnpjEncontrado != null) {
			LOG.info("Para a pesquisa {0}, retornado : {1}", cnpj, cnpjEncontrado);
			return new ResponseEntity<Cnpj>(cnpjEncontrado, HttpStatus.OK);
		} else {
			LOG.info("Para a pesquisa {0}, nao foi encontrado registro");
			return new ResponseEntity<Cnpj>(HttpStatus.NOT_FOUND);
		}

	}
}
