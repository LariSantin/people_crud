package com.desafio.api.testes;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.api.dto.PessoaDTO;
import com.desafio.api.service.PessoaService;

@SpringBootTest
class PessoaTests {
	 
	@Autowired
	private PessoaService pessoaService;
	
	
	@Test
	public void naoDeveLancarExcecaoAoInserir() {
		PessoaDTO pessoa1 = new PessoaDTO();
		pessoa1.setCpf("111.111.111-22");
		pessoa1.setNome("teste");
		pessoa1.setEmail("teste@teste.com");
		
		pessoaService.save(pessoa1);
		
		int size = pessoaService.getPessoas().size();
		
		//assertEquals(1, size);
			
	}
	

}
