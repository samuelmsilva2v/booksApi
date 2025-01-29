# Books API

[🇧🇷 Leia em Português](#api-books)

API RESTful developed in Spring Boot that provides a CRUD for book management.

Technologies:
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Swagger**
- **Lombok**
- **Model Mapper**
- **Bean Validation (javax.validation)**
- **Docker**

| Método | Endpoint          | Descrição              |
|--------|-------------------|------------------------|
| POST   | `/api/books`      | Registers a new book   |
| GET    | `/api/books`      | Retrieves all books    |
| GET    | `/api/books/{id}` | Retrieves a book by ID |
| PUT    | `/api/books/{id}` | Updates a book         |
| DELETE | `/api/books/{id}` | Deletes a book         |

## Installation:

##### Building the Docker image:
#### 1. Open the terminal and navigate to the project folder.
#### 2. Run the following command to create the Docker image:
```bash
docker build -t booksapi .
```
##### Running the container
```bash
docker-compose up -d
```

#### 3. Access the Swagger documentation: http://localhost:8080/swagger-ui/index.html#

[Frontend repository](https://github.com/samuelmsilva2v/webBooks)

---

# API Books

[🇺🇸 Read in English](#books-api)

API RESTful desenvolvida em Spring Boot que oferece um CRUD para o gerenciamento de livros.

## Tecnologias: 
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Swagger**
- **Lombok**
- **Model Mapper**
- **Bean Validation (javax.validation)**
- **Docker**

## Endpoints

| Método | Endpoint          | Descrição                    |
|--------|-------------------|------------------------------|
| POST   | `/api/books`      | Registra uma nova categoria  |
| GET    | `/api/books`      | Consulta todas as categorias |
| GET    | `/api/books/{id}` | Detalha uma categoria por ID |
| PUT    | `/api/books/{id}` | Atualiza uma categoria       |
| DELETE | `/api/books/{id}` | Remove uma categoria         |

## Instalação:

##### Construindo a imagem no Docker:
#### 1. No terminal, navegue até a pasta do projeto.
#### 2. Execute o comando abaixo para criar a imagem Docker:
```bash
docker build -t booksapi .
```
##### Executando o container
```bash
docker-compose up -d
```

#### 3. Acesse a documentação no Swagger: http://localhost:8080/swagger-ui/index.html#

[Repositório do front-end](https://github.com/samuelmsilva2v/webBooks)
