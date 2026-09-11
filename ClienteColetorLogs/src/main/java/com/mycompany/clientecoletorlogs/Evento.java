package com.mycompany.clientecoletorlogs;

// classe que representa um evento de log (o que a gente monta ao clicar em Adicionar)
// precisa ser igual à do servidor, senão o Gson não consegue traduzir de um lado pro outro
public class Evento {

    private String nivel;
    private String origem;
    private String mensagem;

    // construtor vazio, o Gson usa esse aqui pra recriar o objeto quando chega pela rede
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
