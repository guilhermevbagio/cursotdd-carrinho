package com.cursotdd;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    
    private List<Produto> produtos = new ArrayList<>();
    private List<ObservadorCarrinho> observadores = new ArrayList<>();

    public void adicionar(Produto produto) {
        this.produtos.add(produto);

        for (ObservadorCarrinho observador : observadores) {
            try {
                observador.produtoAdicionado(produto.getNome(), produto.getValor());
            } catch (Exception e) {
            }
        }
    }

    public int getTotal() {
        int total = 0;
        for (Produto produto : this.produtos) {
            total += produto.getValor();
        }
        return total;
    }

    public void adicionarObservador(ObservadorCarrinho observador) {
        observadores.add(observador);
    }
}
