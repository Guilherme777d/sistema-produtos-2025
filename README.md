# Sistema de Produtos — Aplicação Web com Java/Spring Boot

## 1. Sobre o Projeto

Sistema web desenvolvido em Java com Spring Boot e Thymeleaf, com o objetivo de gerenciar produtos.
A aplicação possui autenticação por login, área restrita para usuários autenticados, perfil administrativo
e integração com banco de dados MySQL. O sistema permite cadastro, listagem e persistência de produtos,
seguindo arquitetura em camadas (controller, service e repository).

## 2. Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Thymeleaf
- MySQL
- Maven

## 3. Arquitetura do Projeto

- Controller: controle das rotas web
- Service: regras de negócio
- Repository: acesso ao banco de dados
- Banco de dados relacional MySQL
- Autenticação por formulário com Spring Security

## 4. Requisitos de Ambiente

- JDK 17 ou superior
- Maven 3.8 ou superior
- MySQL 8 ou superior
- IDE (IntelliJ IDEA recomendado)

## 5. Configuração do Banco de Dados

Crie um banco de dados no MySQL:

```sql
CREATE DATABASE sistema_produtos;
