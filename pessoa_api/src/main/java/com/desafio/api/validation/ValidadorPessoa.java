package com.desafio.api.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.desafio.api.dto.PessoaDTO;
import com.desafio.api.entity.Pessoa;
import com.desafio.api.service.PessoaService;

@RestControllerAdvice
public class ValidadorPessoa {
	
	@Autowired
	private PessoaService pessoaService;
	
	public void validarCPFduplicado(String cpf) throws Exception {

		if(cpf != null && !cpf.isEmpty()) {
			Optional<Pessoa> cpfDuplicado = 
					pessoaService.getPessoas().stream().filter(pessoa -> pessoa.getCpf().equals(cpf)).findAny();
			
			if(cpfDuplicado.isPresent()) {
				throw new Exception("CPF já está cadastrado.");
			}			
		}
	}
	
	public void validarCamposObrigatorios(PessoaDTO pessoa) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		if(pessoa.getDataNascimento() == null) {
			sb.append("Data de Nascimento é obrigatório.\n");
		} else if(pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			sb.append("Nome é obrigatório.\n");
		} else if(pessoa.getCpf() == null || pessoa.getCpf().isEmpty()) {
			sb.append("CPF é obrigatório.\n");
		}
		
		if(sb.length() > 0) {
			throw new Exception(sb.toString());
		}
	}
}