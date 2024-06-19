# ⛍ OHT - API-REST 
Este projeto consiste na implementação de uma API RESTful utilizando Spring Boot para um órgão de trânsito. A API permite a gestão de multas de trânsito e serviços de ouvidoria. Inclui operações CRUD (Create, Read, Update, Delete) para gerenciar os registros de multas e ouvidorias, além de segurança com autenticação via tokens JWT (JSON Web Token) e criptografia de informações sensíveis. Versão do projeto 1.0

## ⚙️ Tecnologias Usadas 

- ![Blog](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Blog](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![Blog](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white) ![Blog](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

- Spring Boot: Framework para criar aplicações Java stand-alone e prontas para produção.
  
- Spring Data JPA: Facilita a integração com bancos de dados, fornecendo uma abstração de alto nível sobre o JPA.
  
- Spring Security com JWT: Fornece autenticação e autorização baseadas em tokens JWT para proteger os endpoints da API.
  
- MySQL: Banco de dados em memória para desenvolvimento e testes.
  
- Maven: Ferramenta de gerenciamento de dependências e build.
  
- Insomnia: Ferramenta para testar a API.
  
## 🌐 Endpoints Disponíveis para Usuario 'Motorista'

### 📜 Multas

- POST login/CreateUser: Criação de usuario.
- POST principal/User: Retorna informações do usuario em questão
- POST principal/Read/{n}/{m}: Retorna uma lista de multas a respeito do usuario. Onde {n} é o numero da pagina. E {m} e o numero de dados por pagina.
- POST principal/atualizar: Atualiza informações de endereço do User.
- POST principal/Relatorio: Recebe FeedBack do usuario.

## 🚨 Segurança com Spring Security e JWT

A API utiliza autenticação JWT para garantir que apenas usuários autorizados possam acessar os endpoints.
As informações sensíveis são criptografadas antes de serem armazenadas no banco de dados para garantir a segurança dos dados.

Afim de tornar este projeto mais completo e intuitivo, se estende tambem uma aplicação Front-End que pode ser encontrado no Repositorio OHT---Front-End. 💻

