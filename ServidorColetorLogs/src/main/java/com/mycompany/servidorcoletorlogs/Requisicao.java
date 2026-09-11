package com.mycompany.servidorcoletorlogs;

import com.google.gson.Gson;
import java.util.List;

// "envelope" que viaja do cliente pro servidor, tanto pra REGISTRAR quanto pra LISTAR
public class Requisicao {

    private String operacao; // "REGISTRAR" ou "LISTAR"
    private String nivel; // usado só no LISTAR, é o filtro escolhido
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

    // transforma o objeto em JSON pra poder mandar como texto pela rede
    public String paraLinha() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // caminho contrário: pega o JSON que chegou e monta o objeto de novo
    public static Requisicao fromLinha(String linha) {
        Gson gson = new Gson();
        return gson.fromJson(linha, Requisicao.class);
    }
}
