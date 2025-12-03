# 📚 API de Biblioteca

API REST para gerenciamento de livros em uma biblioteca.

## 👥 Integrantes
- Wesley Wiltuschnig - Desenvolvimento completo

## 🚀 Como Executar

### Pré-requisitos:
- Java 17
- Maven 3.6+

### Passos:
1. Clone o projeto
2. Configure o `application.properties` com suas credenciais do Supabase
3. Execute: `mvn spring-boot:run`

### Endpoints:
- `GET /api/livros` - Lista todos os livros
- `GET /api/livros/{id}` - Busca livro por ID
- `POST /api/livros` - Adiciona novo livro
- `GET /api/livros/teste` - Teste da API

## 🛠️ Tecnologias
- Spring Boot 3.2.0
- PostgreSQL (Supabase)
- Spring Data JPA
- Maven