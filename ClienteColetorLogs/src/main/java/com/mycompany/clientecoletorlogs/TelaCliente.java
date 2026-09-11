package com.mycompany.clientecoletorlogs;

public class TelaCliente extends javax.swing.JFrame {

    private final java.util.List<Evento> pendentes = new java.util.ArrayList<>(); // lista local, só em memória
    private final ServicoCliente servico = new ServicoCliente(); // quem manda/recebe os pacotes UDP

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(TelaCliente.class.getName());

    public TelaCliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        painelEvento = new javax.swing.JPanel();
        lbOrigem = new javax.swing.JLabel();
        tfOrigem = new javax.swing.JTextField();
        lbMensagem = new javax.swing.JLabel();
        tfMensagem = new javax.swing.JTextField();
        lbNivel = new javax.swing.JLabel();
        cbNivel = new javax.swing.JComboBox<>();
        btnAdicionar = new javax.swing.JButton();
        scrollPendentes = new javax.swing.JScrollPane();
        taPendentes = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        painelConsulta = new javax.swing.JPanel();
        lbFiltro = new javax.swing.JLabel();
        cbFiltro = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();
        scrollResposta = new javax.swing.JScrollPane();
        taResposta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Coletor de Logs - Cliente");

        painelEvento.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo Evento"));
        lbOrigem.setText("Origem:");
        lbMensagem.setText("Mensagem:");
        lbNivel.setText("Nivel:");
        cbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] {"INFO", "WARN", "ERROR"}));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(evt -> btnAdicionarActionPerformed(evt));

        javax.swing.GroupLayout painelEventoLayout =
                new javax.swing.GroupLayout(painelEvento);
        painelEvento.setLayout(painelEventoLayout);
        painelEventoLayout.setHorizontalGroup(
            painelEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEventoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbOrigem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfOrigem, 120, 120, 120)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMensagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMensagem, 150, 150, 150)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionar)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        painelEventoLayout.setVerticalGroup(
            painelEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOrigem)
                    .addComponent(tfOrigem)
                    .addComponent(lbMensagem)
                    .addComponent(tfMensagem)
                    .addComponent(lbNivel)
                    .addComponent(cbNivel)
                    .addComponent(btnAdicionar))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        taPendentes.setEditable(false);
        taPendentes.setColumns(20);
        taPendentes.setRows(5);
        taPendentes.setBorder(javax.swing.BorderFactory.createTitledBorder("Eventos Pendentes"));
        scrollPendentes.setViewportView(taPendentes);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(evt -> btnEnviarActionPerformed(evt));

        painelConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar"));
        lbFiltro.setText("Filtro:");
        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] {"TODOS", "INFO", "WARN", "ERROR"}));
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(evt -> btnConsultarActionPerformed(evt));

        javax.swing.GroupLayout painelConsultaLayout =
                new javax.swing.GroupLayout(painelConsulta);
        painelConsulta.setLayout(painelConsultaLayout);
        painelConsultaLayout.setHorizontalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultar)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        painelConsultaLayout.setVerticalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFiltro)
                    .addComponent(cbFiltro)
                    .addComponent(btnConsultar))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        taResposta.setEditable(false);
        taResposta.setColumns(20);
        taResposta.setRows(5);
        taResposta.setBorder(javax.swing.BorderFactory.createTitledBorder("Resposta do Servidor"));
        scrollResposta.setViewportView(taResposta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelEvento, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPendentes)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollResposta))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelEvento, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar)
                .addGap(18, 18, 18)
                .addComponent(painelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // pega o que foi digitado, sem espaço sobrando no começo/fim
        String origem = tfOrigem.getText().trim();
        String mensagem = tfMensagem.getText().trim();
        String nivel = (String) cbNivel.getSelectedItem();

        if (origem.isEmpty() || mensagem.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Preencha origem e mensagem.");
            return;
        }

        // só guarda na lista local, nada de rede ainda -- isso só acontece no Enviar
        Evento evento = new Evento(nivel, origem, mensagem);
        pendentes.add(evento);

        taPendentes.append(nivel + " | " + origem + " | " + mensagem + "\n");

        tfOrigem.setText("");
        tfMensagem.setText("");
    }//GEN-LAST:event_btnAdicionarActionPerformed

    // quebra a lista de pendentes em pedaços menores caso o JSON fique maior que o
    // tamanho máximo de um datagrama UDP (pedido no enunciado). Com poucos eventos,
    // isso sempre devolve um pacote só.
    private java.util.List<java.util.List<Evento>> dividirEmPacotes(java.util.List<Evento> eventos, int tamanhoMaximo) {
        java.util.List<java.util.List<Evento>> pacotes = new java.util.ArrayList<>();
        java.util.List<Evento> atual = new java.util.ArrayList<>();

        for (Evento evento : eventos) {
            atual.add(evento);
            Requisicao teste = new Requisicao("REGISTRAR", "", atual);
            int tamanho = teste.paraLinha().getBytes().length;

            if (tamanho > tamanhoMaximo) {
                // esse último evento não cabe mais nesse pacote, tira ele, fecha o
                // pacote atual e começa um novo já com ele dentro
                atual.remove(atual.size() - 1);
                pacotes.add(atual);
                atual = new java.util.ArrayList<>();
                atual.add(evento);
            }
        }

        if (!atual.isEmpty()) {
            pacotes.add(atual);
        }

        return pacotes;
    }

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (pendentes.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nenhum evento pendente para enviar.");
            return;
        }

        final int TAMANHO_MAXIMO_PACOTE = 60000;
        java.util.List<java.util.List<Evento>> pacotes =
                dividirEmPacotes(new java.util.ArrayList<>(pendentes), TAMANHO_MAXIMO_PACOTE);
        btnEnviar.setEnabled(false); // evita clique duplo enquanto está enviando

        // SwingWorker pra não travar a tela -- o servidor demora 1s por evento pra responder
        new javax.swing.SwingWorker<java.util.List<Resposta>, Void>() {
            @Override
            protected java.util.List<Resposta> doInBackground() throws Exception {
                // isso roda numa thread separada, é aqui que a espera de verdade acontece
                java.util.List<Resposta> respostas = new java.util.ArrayList<>();
                for (java.util.List<Evento> pacote : pacotes) {
                    Requisicao requisicao = new Requisicao("REGISTRAR", "", pacote);
                    respostas.add(servico.enviar(requisicao));
                }
                return respostas;
            }

            @Override
            protected void done() {
                // volta pra thread da interface automaticamente, seguro mexer na tela aqui
                btnEnviar.setEnabled(true);
                try {
                    java.util.List<Resposta> respostas = get();
                    StringBuilder texto = new StringBuilder();
                    for (Resposta resposta : respostas) {
                        texto.append("OK (").append(resposta.getTimestamp()).append(")\n")
                             .append(resposta.getDados().get(0)).append("\n");
                    }
                    taResposta.setText(texto.toString());
                    pendentes.clear();
                    taPendentes.setText("");
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(TelaCliente.this, "Erro ao enviar: " + e.getMessage());
                }
            }
        }.execute();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String filtro = (String) cbFiltro.getSelectedItem();
        // no LISTAR o nivel carrega o filtro e a lista de eventos vai vazia
        Requisicao requisicao = new Requisicao("LISTAR", filtro, new java.util.ArrayList<>());
        btnConsultar.setEnabled(false);

        new javax.swing.SwingWorker<Resposta, Void>() {
            @Override
            protected Resposta doInBackground() throws Exception {
                return servico.enviar(requisicao);
            }

            @Override
            protected void done() {
                btnConsultar.setEnabled(true);
                try {
                    Resposta resposta = get();
                    StringBuilder texto = new StringBuilder();
                    for (String linha : resposta.getDados()) {
                        texto.append(linha).append("\n");
                    }
                    if (resposta.getDados().isEmpty()) {
                        texto.append("Nenhum evento encontrado.");
                    }
                    taResposta.setText(texto.toString());
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(TelaCliente.this, "Erro ao consultar: " + e.getMessage());
                }
            }
        }.execute();
    }//GEN-LAST:event_btnConsultarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new TelaCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JComboBox<String> cbNivel;
    private javax.swing.JLabel lbFiltro;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JLabel lbNivel;
    private javax.swing.JLabel lbOrigem;
    private javax.swing.JPanel painelConsulta;
    private javax.swing.JPanel painelEvento;
    private javax.swing.JScrollPane scrollPendentes;
    private javax.swing.JScrollPane scrollResposta;
    private javax.swing.JTextArea taPendentes;
    private javax.swing.JTextArea taResposta;
    private javax.swing.JTextField tfMensagem;
    private javax.swing.JTextField tfOrigem;
    // End of variables declaration//GEN-END:variables
}
