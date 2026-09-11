package com.mycompany.servidorcoletorlogs;

// classe que representa um evento de log (o que o cliente monta ao clicar em Adicionar)
public class Evento {

    private String nivel;
    private String origem;
    private String mensagem;

    // construtor vazio, o Gson usa esse aqui pra recriar o objeto quando ele chega pela rede
    public Evento() {
    }

    public Evento(String nivel, String origem, String mensagem) {
        this.nivel = nivel;
        this.origem = origem;
        this.mensagem = mensagem;
    }

    public String getNivel() {
        return nivel;
    }

    public String getOrigem() {
        return origem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
