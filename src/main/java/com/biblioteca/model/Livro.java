package com.biblioteca.model;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String isbn;
    private Boolean disponivel = true;
    private java.time.LocalDateTime dataCadastro;
    
    // Construtor vazio (obrigatório para JSON)
    public Livro() {}
    
    // Construtor com parâmetros
    public Livro(String titulo, String autor, Integer anoPublicacao, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.dataCadastro = java.time.LocalDateTime.now();
    }
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
    
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
}