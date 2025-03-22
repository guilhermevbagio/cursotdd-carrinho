package com.cursotdd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteCarrinhoCompras {
    @Test
    public void totalCarrinho(){
        CarrinhoCompras carrinho = new CarrinhoCompras();
        carrinho.adicionar(new Produto("Camisa", 30));
        carrinho.adicionar(new Produto("Calça", 50));
        int total = carrinho.getTotal();
        assertEquals(80, total);
    }

    @Test
    public void escutaAdicaoDeProdutos(){
        CarrinhoCompras carrinho = new CarrinhoCompras();
        MockObservadorCarrinho mock = new MockObservadorCarrinho();
        carrinho.adicionarObservador(mock);
        carrinho.adicionar(new Produto("Camisa", 30));
        mock.verificaRecebimentoProduto("Camisa", 30);
    }

    @Test
    public void adicionarDoisObservadores(){
        CarrinhoCompras carrinho = new CarrinhoCompras();
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();

        carrinho.adicionarObservador(mock1);
        carrinho.adicionarObservador(mock2);

        carrinho.adicionar(new Produto("Camisa", 30));
        mock1.verificaRecebimentoProduto("Camisa", 30);
        mock2.verificaRecebimentoProduto("Camisa", 30);

    }

    @Test
    public void continuaNotificandoComErroEmObservador(){
        CarrinhoCompras carrinho = new CarrinhoCompras();
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
        carrinho.adicionarObservador(mock1);
        carrinho.adicionarObservador(mock2);
        carrinho.adicionarObservador(mock3);

        carrinho.adicionar(new Produto("Camisa", 30));
        mock1.verificaRecebimentoProduto("Camisa", 30);
        mock2.quebra();
        mock2.verificaRecebimentoProduto("Camisa", 30);

    }
}
