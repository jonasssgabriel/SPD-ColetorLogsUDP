package com.mycompany.clientecoletorlogs;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// classe que concentra toda a parte de rede do cliente, a tela não sabe nada de socket
public class ServicoCliente {

    private static final String HOST_SERVIDOR = "localhost";
    private static final int PORTA_SERVIDOR = 9999;

    // manda a requisição e fica esperando a resposta -- por isso essa chamada precisa
    // rodar numa thread separada da interface (ver TelaCliente)
    public Resposta enviar(Requisicao requisicao) throws Exception {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress enderecoServidor = InetAddress.getByName(HOST_SERVIDOR);

            byte[] dadosEnvio = requisicao.paraLinha().getBytes();
            DatagramPacket pacoteEnvio = new DatagramPacket(dadosEnvio, dadosEnvio.length, enderecoServidor, PORTA_SERVIDOR);
            socket.send(pacoteEnvio);

            byte[] buffer = new byte[65507];
            DatagramPacket pacoteResposta = new DatagramPacket(buffer, buffer.length);
            socket.receive(pacoteResposta);

            String linha = new String(pacoteResposta.getData(), 0, pacoteResposta.getLength());
            return Resposta.fromLinha(linha);
        }
    }
}
