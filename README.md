Este é um projeto simples com Java 17 e Spring Boot, com o objetivo de identificar meus conhecimentos quanto às tecnologias utilizadas.

## Perguntas:
1.	Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?
    
- Os principais critérios de software avaliados são usabilidade, confiabilidade, funcionalidade e manutenibilidade.
Sempre implemento os princípios de Clean Code e Design Patterns, além disso dependendo da complexidade do projeto aplico a Test-driven development utilizando JUnit e  Mockito para melhorar a produtividade, garantindo que o sistema cumpra os requisitos e um código objetivo.

2.	Em qual etapa da implementação você considera a qualidade de software?
      
- Para evitar retrabalho o correto é considerar a qualidade de software em todas as etapas do desenvolvimento, desde o planejamento e iniciação até a implantação e manutenção.


## Requisitos:

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