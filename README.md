# api-screen-filmes [![Swagger](https://img.shields.io/badge/swagger-UI-green)](http://localhost:8080/swagger-ui.html)

## Descrição
Está API tem a finalidade de buscar informações sobre series e filmes da base o OMDB
que é uma plataforma gratuita para estudo e testes e tem como finalidade praticar 
o uso de: 
- Variaveis de ambiente
- Configuração de conexão do banco de dados (Mongodb)
- Lógica de programação 
- Desenvolvimento orientado a objetos

## Tecnologias utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)


## Como utilizar a API

Subistitua os valores das variaveis declaradas no arquivo application.yaml

- USERNAME_CONNECTION
- PASSWORD_CONNECTION
- OMDB_APIKEY

## API Documentation

Para acessar a documentação da aplicação depois de configurar local
basta clicar no link abaixo: 

[Swagger UI](http://localhost:8080/swagger-ui.html)

##

### Executando a aplicação em um container docker:
-   Para executar a aplicação em um container docker execute os comandos:
  - Com o docker em execução através do terminal digite docker build -t app-spring .

dessa forma o docker realizar a construção da imagem docker.

### Após a construção da imagem execute o próximo comando.

``
docker run -d -p 8080:8080 -e USERNAME_CONNECTION=<seu usuario> -e PASSWORD_CONNECTION=<sua senha db>  app-screen-filmes
``

## 

Caso não tenha cadastro nos serviços de database e a API do OMDB segue links para cadastros: 

- https://account.mongodb.com/account/login?signedOut=true
- https://www.omdbapi.com/