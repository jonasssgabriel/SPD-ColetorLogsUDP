package com.mycompany.clientecoletorlogs;

import com.google.gson.Gson;
import java.util.List;

// "envelope" que a gente manda pro servidor, tanto pra REGISTRAR quanto pra LISTAR
public class Requisicao {

    private String operacao; // "REGISTRAR" ou "LISTAR"
    private String nivel; // usado só no LISTAR, é o filtro escolhido no combo
    private List<Evento> eventos; // usado só no REGISTRAR, vai vazio no LISTAR

    public Requisicao() {
    }

    public Requisicao(String operacao, String nivel, List<Evento> eventos) {
        this.operacao = operacao;
        this.nivel = nivel;
        this.eventos = eventos;
    }

    public String getOperacao() {
        return operacao;
    }

    public String getNivel() {
        return nivel;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    // vira JSON pra poder viajar como texto dentro do pacote UDP
    public String paraLinha() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Requisicao fromLinha(String linha) {
        Gson gson = new Gson();
        return gson.fromJson(linha, Requisicao.class);
    }
}
