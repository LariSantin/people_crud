package com.desafio.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.api.dto.PessoaDTO;
import com.desafio.api.entity.Pessoa;
import com.desafio.api.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }
	
    public Pessoa save(PessoaDTO pessoaDTO)
    {
    	Pessoa pessoa = new Pessoa();
    	
    	pessoa.setNome(pessoaDTO.getNome());
    	pessoa.setSexo(pessoaDTO.getSexo());
    	pessoa.setEmail(pessoaDTO.getEmail());
    	pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
    	pessoa.setNaturalidade(pessoaDTO.getNaturalidade());
    	pessoa.setNacionalidade(pessoaDTO.getNacionalidade());
    	pessoa.setCpf(pessoaDTO.getCpf());
    	pessoa.setDataAtualizacao(new Date());
		pessoa.setDataCadastro(new Date());
		
        return pessoaRepository.save(pessoa);
    }
	

    public ResponseEntity<Pessoa> update(long id, Pessoa newPessoa)
    {
        Optional<Pessoa> oldPessoa = pessoaRepository.findById(id);
        
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            
            pessoa.setNome(newPessoa.getNome());
            pessoa.setSexo(newPessoa.getSexo());
            pessoa.setEmail(newPessoa.getEmail());
            pessoa.setDataNascimento(newPessoa.getDataNascimento());
            pessoa.setNaturalidade(newPessoa.getNaturalidade());
            pessoa.setNacionalidade(newPessoa.getNacionalidade());
            pessoa.setCpf(newPessoa.getCpf());
            pessoa.setDataAtualizacao(new Date());
            
            pessoaRepository.save(pessoa);
            
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> delete(long id)
    {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        
        if(pessoa.isPresent()){
            pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}