package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    
    private Map<Long, Livro> livros = new HashMap<>();
    private Long proximoId = 1L;
    
    public LivroController() {
        // Adiciona livros de exemplo
        adicionarLivro(new Livro("Dom Quixote", "Miguel de Cervantes", 1605, "978-8535902775"));
        adicionarLivro(new Livro("1984", "George Orwell", 1949, "978-0451524935"));
        adicionarLivro(new Livro("Orgulho e Preconceito", "Jane Austen", 1813, "978-8535909552"));
    }
    
    private void adicionarLivro(Livro livro) {
        livro.setId(proximoId++);
        livros.put(livro.getId(), livro);
    }
    
    // GET /api/livros - Listar todos
    @GetMapping
    public List<Livro> listarTodos() {
        return new ArrayList<>(livros.values());
    }
    
    // GET /api/livros/{id} - Buscar por ID
    @GetMapping("/{id}")
    public Object buscarPorId(@PathVariable Long id) {
        Livro livro = livros.get(id);
        if (livro != null) {
            return livro;
        }
        return Map.of("error", "Livro não encontrado");
    }
    
    // POST /api/livros - Criar novo
    @PostMapping
    public Object criarLivro(@RequestBody Livro livro) {
        livro.setId(proximoId++);
        livro.setDataCadastro(java.time.LocalDateTime.now());
        livros.put(livro.getId(), livro);
        return Map.of(
            "message", "Livro criado com sucesso",
            "livro", livro,
            "id", livro.getId()
        );
    }
    
    // PUT /api/livros/{id} - Atualizar
    @PutMapping("/{id}")
    public Object atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        if (livros.containsKey(id)) {
            livroAtualizado.setId(id);
            livros.put(id, livroAtualizado);
            return Map.of(
                "message", "Livro atualizado com sucesso",
                "livro", livroAtualizado
            );
        }
        return Map.of("error", "Livro não encontrado");
    }
    
    // DELETE /api/livros/{id} - Remover
    @DeleteMapping("/{id}")
    public Object removerLivro(@PathVariable Long id) {
        if (livros.containsKey(id)) {
            livros.remove(id);
            return Map.of("message", "Livro removido com sucesso");
        }
        return Map.of("error", "Livro não encontrado");
    }
}