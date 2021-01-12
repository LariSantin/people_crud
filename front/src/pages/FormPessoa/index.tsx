import React, { useEffect, useState, useRef, useCallback } from 'react';
import { FormHandles } from '@unform/core';
import { Form } from '@unform/web';
import { parseISO } from 'date-fns';

import api from '../../services/api';

import { Container, Content, Background, Title } from './styles';
import Input from '../../components/input';

interface Pessoa {
  nome: string;
  sexo: string;
  email: string;
  dataNascimento: Date;
  naturalidade: string;
  nacionalidade: string;
  cpf: string;
}

const FormPessoa: React.FC = () => {
  const formRef = useRef<FormHandles>(null);

  const [pessoa, setPessoa] = useState<Pessoa | null>(null);

  useEffect(() => {
    async function loadData(): Promise<void> {
      // api.get(`/pessoa`).then((response) => {
      //   setPessoa(response.data);
      // });
    
    }
    loadData();
  }, );

  const salvar = useCallback(async (data: Pessoa) => {  
    data.dataNascimento = new Date(data.dataNascimento);

    const response = await api.post(`/pessoa`, data);
    
    if(response.data){
      alert("Pessoa inserida com sucesso!");
    }
  },[]);

  return (
    <>
    <Container>
      <Content>
      <Title>Cadastro de Pessoas</Title>
  
          <Form ref={formRef} onSubmit={salvar}>   
            <label>Nome</label>        
            <Input
                name="nome"
                type="text"
                placeholder="Insira o nome"
              />

            <label>Sexo</label>
            <Input
                name="sexo"
                type="text"
                placeholder="Insira o sexo"
              />
            
            <label>E-mail</label>
             <Input
                name="email"
                type="email"
                placeholder="Insira o e-mail"
              />

            <label>Data de Nascimento</label>
             <Input
                name="dataNascimento"
                type="date"
                placeholder="Insira a data de nascimento"
              />
              
              <label>Naturalidade</label>
              <Input
                name="naturalidade"
                type="text"
                placeholder="Insira a naturalidade"
              />

              <label>Nacionalidade</label>
              <Input
                name="nacionalidade"
                type="text"
                placeholder="Insira a nacionalidade"
              />

              <label>CPF</label>
              <Input
                name="cpf"
                type="text"
                placeholder="Insira o cpf"
              />

            <button type="submit">Salvar</button>
          </Form>
      </Content>
      <Background />
    </Container>
    </>
  )
};

export default FormPessoa;