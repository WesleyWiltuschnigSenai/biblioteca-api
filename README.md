# 📚 API Biblioteca - Spring Boot

Uma API RESTful para gerenciamento de biblioteca desenvolvida em Spring Boot.

## 👥 Integrantes do Grupo
- **Wesley Wiltuschnig** - Desenvolvimento completo da API

## 🚀 Tecnologias Utilizadas
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (ou seu banco de dados)
- Maven/Gradle

### Livros
- `GET /api/livros` - Lista todos os livros
- `GET /api/livros/{id}` - Busca livro por ID
- `POST /api/livros` - Cria um novo livro
- `PUT /api/livros/{id}` - Atualiza um livro existente
- `DELETE /api/livros/{id}` - Remove um livro

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+ ou Gradle
- Git

### Passos para execução
```bash
# Clone o repositório
git clone [seu-repositorio]

# Entre na pasta do projeto
cd [nome-do-projeto]

# Execute a aplicação
./mvnw spring-boot:run
# ou
mvn spring-boot:run

# A aplicação estará disponível em:
# http://localhost:8080