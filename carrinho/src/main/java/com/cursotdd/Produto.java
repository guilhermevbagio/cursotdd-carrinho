package com.cursotdd;

public class Produto {
    
    private final String nome;
    private final int valor;

    public Produto(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return this.nome;
    }    

    public int getValor() {
        return this.valor;
    }
}
