package com.mycompany.servidorcoletorlogs;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorApp {

    // um repositorio só, compartilhado por todas as threads que forem criadas
    private static final RepositorioLogs repositorio = new RepositorioLogs();

    public static void main(String[] args) {
        final int PORTA = 9999;
        ExecutorService executor = Executors.newFixedThreadPool(10); // pool de 10 threads, como pedido no enunciado

        try (DatagramSocket socket = new DatagramSocket(PORTA)) {
            System.out.println("Servidor de logs iniciado na porta " + PORTA);

            while (true) {
                byte[] buffer = new byte[65507]; // tamanho máximo de um datagrama UDP
                DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);

                socket.receive(pacoteRecebido); // fica travado aqui até chegar algum pacote

                // tira o texto e os dados do remetente logo aqui, antes de criar a thread,
                // porque esse buffer vai ser reaproveitado no próximo receive()
                String linha = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());
                InetAddress enderecoCliente = pacoteRecebido.getAddress();
                int portaCliente = pacoteRecebido.getPort();

                // manda pra uma thread do pool cuidar disso e já volta pro receive()
                executor.submit(() -> atender(socket, linha, enderecoCliente, portaCliente));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // cada thread do pool roda esse método pra atender um cliente
    private static void atender(DatagramSocket socket, String linha, InetAddress enderecoCliente, int portaCliente) {
        try {
            Requisicao requisicao = Requisicao.fromLinha(linha);
            String remetente = enderecoCliente.getHostAddress() + ":" + portaCliente;
            String timestamp = java.time.LocalDateTime.now().format(
                    java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            java.util.List<String> dados;

            if (requisicao.getOperacao().equals("REGISTRAR")) {
                // adiciona um evento por vez esperando 1s entre cada -- é isso que faz a
                // concorrência ficar visível quando vários clientes mandam ao mesmo tempo
                for (Evento evento : requisicao.getEventos()) {
                    repositorio.adicionar(evento, remetente);
                    Thread.sleep(1000);
                }
                dados = new java.util.ArrayList<>();
                dados.add("Lista processada. " + requisicao.getEventos().size() + " evento(s) armazenado(s).");
            } else {
                dados = repositorio.listarPorNivel(requisicao.getNivel());
            }

            Resposta resposta = new Resposta("OK", timestamp, dados);
            byte[] dadosResposta = resposta.paraLinha().getBytes();
            DatagramPacket pacoteResposta = new DatagramPacket(dadosResposta, dadosResposta.length, enderecoCliente, portaCliente);
            socket.send(pacoteResposta);

        } catch (Exception e) {
            System.err.println("Erro ao atender cliente: " + e.getMessage());
        }
    }
}
