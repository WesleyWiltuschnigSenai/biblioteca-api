package com.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
public class App {
    
    // Banco de dados em memória
    private List<Map<String, Object>> livros = new ArrayList<>();
    private int proximoId = 1;
    
    public App() {
        System.out.println("✅ Inicializando API Biblioteca...");
        // Adiciona livros de exemplo
        criarLivro("Dom Quixote", "Miguel de Cervantes", 1605);
        criarLivro("1984", "George Orwell", 1949);
        criarLivro("Orgulho e Preconceito", "Jane Austen", 1813);
    }
    
    private void criarLivro(String titulo, String autor, int ano) {
        Map<String, Object> livro = new HashMap<>();
        livro.put("id", proximoId++);
        livro.put("titulo", titulo);
        livro.put("autor", autor);
        livro.put("ano", ano);
        livro.put("disponivel", true);
        livro.put("dataCadastro", new Date());
        livros.add(livro);
        System.out.println("📚 Livro adicionado: " + titulo);
    }
    
    // ========== ENDPOINTS ==========
    
    @GetMapping("/")
    public String home() {
        return "<h1>📚 API Biblioteca - SPRING BOOT</h1>" +
               "<p><strong>Endpoints disponíveis:</strong></p>" +
               "<ul>" +
               "<li><a href='/api/livros'>GET /api/livros</a> - Listar todos</li>" +
               "<li><a href='/api/livros/1'>GET /api/livros/1</a> - Buscar por ID</li>" +
               "<li>POST /api/livros - Criar novo (usar Postman)</li>" +
               "</ul>" +
               "<p>✅ CRUD completo implementado</p>";
    }
    
    // GET /api/livros - Listar TODOS os livros
    @GetMapping("/api/livros")
    public List<Map<String, Object>> listarLivros() {
        System.out.println("📋 Listando " + livros.size() + " livros");
        return livros;
    }
    
    // GET /api/livros/{id} - Buscar por ID
    @GetMapping("/api/livros/{id}")
    public Object buscarLivro(@PathVariable int id) {
        System.out.println("🔍 Buscando livro ID: " + id);
        for (Map<String, Object> livro : livros) {
            if ((int) livro.get("id") == id) {
                return livro;
            }
        }
        return Map.of("erro", "Livro não encontrado", "id", id);
    }
    
    // POST /api/livros - Criar NOVO livro
    @PostMapping("/api/livros")
    public Object criarLivro(@RequestBody Map<String, Object> novoLivro) {
        System.out.println("➕ Criando novo livro: " + novoLivro.get("titulo"));
        novoLivro.put("id", proximoId++);
        novoLivro.put("dataCadastro", new Date());
        novoLivro.put("disponivel", true);
        livros.add(novoLivro);
        return Map.of(
            "mensagem", "Livro criado com sucesso!",
            "id", novoLivro.get("id"),
            "livro", novoLivro
        );
    }
    
    // PUT /api/livros/{id} - Atualizar livro
    @PutMapping("/api/livros/{id}")
    public Object atualizarLivro(@PathVariable int id, @RequestBody Map<String, Object> livroAtualizado) {
        System.out.println("✏️ Atualizando livro ID: " + id);
        for (int i = 0; i < livros.size(); i++) {
            Map<String, Object> livro = livros.get(i);
            if ((int) livro.get("id") == id) {
                livroAtualizado.put("id", id);
                livroAtualizado.put("dataCadastro", livro.get("dataCadastro"));
                livros.set(i, livroAtualizado);
                return Map.of("mensagem", "Livro atualizado", "livro", livroAtualizado);
            }
        }
        return Map.of("erro", "Livro não encontrado");
    }
    
    // DELETE /api/livros/{id} - Remover livro
    @DeleteMapping("/api/livros/{id}")
    public Object removerLivro(@PathVariable int id) {
        System.out.println("🗑️ Removendo livro ID: " + id);
        for (int i = 0; i < livros.size(); i++) {
            if ((int) livros.get(i).get("id") == id) {
                Map<String, Object> removido = livros.remove(i);
                return Map.of("mensagem", "Livro removido", "livro", removido);
            }
        }
        return Map.of("erro", "Livro não encontrado");
    }
    
    // ========== MÉTODO MAIN ==========
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("\n" +
            "========================================\n" +
            "✅  API BIBLIOTECA INICIADA COM SUCESSO!\n" +
            "🌐  URL: http://localhost:8080\n" +
            "📚  Livros: http://localhost:8080/api/livros\n" +
            "🔍  Exemplo: http://localhost:8080/api/livros/1\n" +
            "🔄  Use Postman para POST/PUT/DELETE\n" +
            "========================================\n");
    }
}