package com.desafio.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.api.entity.Pessoa;
import com.desafio.api.repository.PessoaRepository;

@RestController
@RequestMapping(value="/api")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }
	
	@RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    public Pessoa save(@RequestBody Pessoa pessoa)
    {
		pessoa.setDataCadastro(new Date());
		
        return pessoaRepository.save(pessoa);
    }
	

    @RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pessoa> update(@PathVariable(value = "id") long id, 
    								   @RequestBody Pessoa newPessoa)
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

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id)
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