Este é um projeto simples com Java 17 e Spring Boot, com o objetivo de identificar meus conhecimentos quanto às tecnologias utilizadas.

## Requisitos:

Esse projeto é capaz de:

- [x]  Criar uma pessoa
- [x]  Editar uma pessoa
- [x]  Consultar uma pessoa
- [x]  Listar pessoas
- [x]  Criar endereço para pessoa
- [x]  Listar endereços da pessoa
- [x]  Poder informar qual endereço é o principal da pessoa

## Teste você também:

**POST:** [http://localhost:8080/person](http://localhost:8080/person)

```json
{
	"name":"Yolanda Ferreira de Souza",
	"dateBirth": "10/11/2002",
	"address":{ 
		"street": "Antônio Hélio Bandini",
		"zip": "13199000",
		"number": "10",
		"city": "Monte Mor",
		"mainAddress": false
	}
}
```

**PUT**: [http://localhost:8080/person](http://localhost:8080/person)

```json
{
	"id": 1,
	"name":"Yolanda Ferreira"
}
```

**GET**: [http://localhost:8080/person/1](http://localhost:8080/person/1)

**GET**: [http://localhost:8080/person/](http://localhost:8080/person/1)

**POST**: [http://localhost:8080/address](http://localhost:8080/address)

```json
{
		"street": "Sirilo Augusto de Santana",
		"zip": "13199000",
		"number": "70",
		"city": "Monte Mor",
		"mainAddress": true,
		"personId": 1
}
```

**GET**: [http://localhost:8080/address/2](http://localhost:8080/address/2)