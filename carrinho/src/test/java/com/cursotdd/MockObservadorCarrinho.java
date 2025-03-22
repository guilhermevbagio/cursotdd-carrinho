package com.cursotdd;
import static  org.junit.jupiter.api.Assertions.assertEquals;

class MockObservadorCarrinho implements ObservadorCarrinho{ 

    private String nomeRecebido;
    private int valorRecebido;
    private boolean quebrado = false;

    @Override
    public void produtoAdicionado(String nome, int valor) {
        this.nomeRecebido = nome;
        this.valorRecebido = valor;
        if(quebrado) 
            throw new RuntimeException("problema simulado pelo mock");

    }

    public void verificaRecebimentoProduto(String nomeEsperado, int valorEsperado){
        assertEquals(nomeEsperado, this.nomeRecebido);
        assertEquals(valorEsperado, this.valorRecebido);
    };

    public void quebra(){
        quebrado = true;
    }
}
