package com.mycompany.servidorcoletorlogs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// guarda a lista de logs compartilhada -- essa lista é a Região Crítica da atividade,
// por isso os dois métodos abaixo são synchronized
public class RepositorioLogs {

    private final List<String> eventos = new ArrayList<>();

    // synchronized porque várias threads (uma por cliente conectado) podem chamar isso ao mesmo tempo
    public synchronized void adicionar(Evento evento, String remetente) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        String linha = "[" + evento.getNivel() + "] " + timestamp
                + " | origem: " + evento.getOrigem()
                + " | mensagem: " + evento.getMensagem()
                + " | remetente: " + remetente;
        eventos.add(linha);
    }

    // também synchronized, pra não ler a lista bem no meio de uma escrita de outra thread
    public synchronized List<String> listarPorNivel(String filtro) {
        List<String> resultado = new ArrayList<>();
        for (String linha : eventos) {
            if (filtro.equals("TODOS") || linha.startsWith("[" + filtro + "]")) {
                resultado.add(linha);
            }
        }
        return resultado;
    }
}
