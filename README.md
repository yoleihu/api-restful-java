# Desafio Java - Controle de Delivery de Restaurante

Este projeto consiste na implementação de um sistema simplificado para o controle de delivery de um restaurante, utilizando Java e as seguintes tecnologias:

- Código versionado em repositório Git
- Java 17
- Spring Boot 3
- Banco de Dados H2 (banco em memória facilmente substituível)
- API RESTful
- Maven
- OpenAPI 3.0 (Swagger)

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

- Java 8: https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
- Git: https://git-scm.com/downloads
- Maven: https://maven.apache.org/download.cgi
- Firebird: Instale o servidor do Firebird de acordo com as instruções do seu sistema operacional.

## Configuração do Projeto

Siga as etapas abaixo para configurar e executar a aplicação:

1. Clone o repositório do projeto:

   ```bash
   git clone https://github.com/seu-usuario/repo.git
   ```

2. Navegue até o diretório raiz do projeto:

   ```bash
   cd repo
   ```

3. Configure o banco de dados Firebird:

    - Crie um banco de dados Firebird vazio.
    - Edite o arquivo `application.properties` localizado em `src/main/resources` e configure as informações de conexão com o banco de dados, como URL, usuário e senha.

4. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

5. Acesse a documentação da API:

   A documentação da API está disponível no Swagger. Acesse o seguinte URL em seu navegador:

   ```
   http://localhost:8080/swagger-ui.html
   ```

## Funcionalidades da API

A API suporta as seguintes operações:

### Segurança

- Cadastro de usuários
- Login com autenticação via token JWT

**Observação:** Os métodos das APIs abaixo só podem ser executados por usuários autenticados.

### Cliente

- Cadastro de cliente
- Alteração de cliente
- Deleção de cliente
- Consulta de cliente

### Pedido

- Cadastro de pedido
- Alteração de pedido
- Deleção de pedido
- Consulta de pedido

### Entrega

- Cadastro de entrega
- Alteração de entrega
- Deleção de entrega
- Consulta de entrega

**Observação:** Tanto o pedido quanto a entrega obrigatoriamente precisam estar vinculados a um cliente.

## Considerações Finais

Este é um projeto de exemplo para demonstrar a implementação de um sistema simplificado de controle de delivery de restaurante utilizando Java e Spring Boot.