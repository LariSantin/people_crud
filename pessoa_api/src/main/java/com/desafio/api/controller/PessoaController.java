package com.desafio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.api.dto.PessoaDTO;
import com.desafio.api.entity.Pessoa;
import com.desafio.api.service.PessoaService;
import com.desafio.api.validation.ValidadorPessoa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
@Api(value = "API Rest Cadastro de Pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@ApiOperation(value = "Retorna a lista de pessoas cadastradas.")
	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> getPessoas() {
        return pessoaService.getPessoas();
    }
	
	@ApiOperation(value = "Cadastra uma pessoa.")
	@RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    public Pessoa save(@RequestBody(required= true) PessoaDTO pessoa) throws Exception
    {
		ValidadorPessoa validador = new ValidadorPessoa();
		validador.validarCPFduplicado(pessoa.getCpf());
		validador.validarCamposObrigatorios(pessoa);
		
        return pessoaService.save(pessoa);
    }
	

	@ApiOperation(value = "Atualiza o cadastro de uma pessoa.")
    @RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pessoa> update(@PathVariable(value = "id") long id, 
    								   @RequestBody Pessoa newPessoa)
    {
        return pessoaService.update(id, newPessoa);
    }

	@ApiOperation(value = "Deleta o cadastro de uma pessoa.")
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id)
    {
		return pessoaService.delete(id);
    }

	@ApiOperation(value = "Retorna url github.")
	@RequestMapping(value = "/source", method = RequestMethod.GET)
    public String getSource() {
        return "https://github.com/LariSantin/pessoa_crud";
    }

}