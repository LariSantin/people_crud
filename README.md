# API de cadastro de pessoas

API criada utilizando Spring boot e banco de dados postgres.

- Requisições

URL:  http://localhost:8081/api

```
POST - /pessoa = cadastrar uma nova pessoa

exemplo JSON requisição:
{
	"nome": "Larissa",
	"sexo": "feminino",
	"email": "lari@email.com",
	"dataNascimento": "2003-02-22T18:52:02.763+00:00",
	"naturalidade": "cascavel",
	"nacionalidade": "brasil",
	"cpf": "11111111111"
	
}

```

```
GET - /pessoa = lista de pessoas cadastradas
```

```
PUT - /pessoa/{id} = update cadastro pessoa

exemplo JSON requisição:
{
	"nome": "Larissa S",
	"sexo": "feminino",
	"email": "lari@email.com",
	"dataNascimento": "2003-02-22T18:52:02.763+00:00",
	"naturalidade": "cascavel",
	"nacionalidade": "brasil",
	"cpf": "11111111111"
	
}

```

```
DELETE - /pessoa/{1} = excluir cadastro de pessoa
```

Front-end
- Form criado para inserir pessoa utilizando ReactJS.
