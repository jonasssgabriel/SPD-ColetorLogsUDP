package com.mycompany.servidorcoletorlogs;

import com.google.gson.Gson;
import java.util.List;

// o que o servidor devolve pro cliente: confirmação do REGISTRAR ou resultado do LISTAR
public class Resposta {

    private String status; // "OK" ou "ERRO"
    private String timestamp;
    private List<String> dados;

    public Resposta() {
    }

    public Resposta(String status, String timestamp, List<String> dados) {
        this.status = status;
        this.timestamp = timestamp;
        this.dados = dados;
    }

    public String getStatus() {
        return status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public List<String> getDados() {
        return dados;
    }

    public String paraLinha() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Resposta fromLinha(String linha) {
        Gson gson = new Gson();
        return gson.fromJson(linha, Resposta.class);
    }
}
