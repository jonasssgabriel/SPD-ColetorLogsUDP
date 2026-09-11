# Coletor de Logs Centralizado com Sockets UDP

Atividade pontuada da disciplina de Sistemas Paralelos e Distribuídos (SPD).

Vários clientes enviam eventos de log (nível, origem e mensagem) para um servidor
central via UDP. O servidor cria uma thread para cada lista recebida, protegendo
o acesso à lista compartilhada de eventos com `synchronized`.

## Estrutura

- `ServidorColetorLogs/` — projeto Maven/NetBeans do servidor (`ServidorApp`, `RepositorioLogs`).
- `ClienteColetorLogs/` — projeto Maven/NetBeans do cliente (`TelaCliente`, Swing).

Classes de protocolo (`Evento`, `Requisicao`, `Resposta`) são copiadas idênticas
nos dois projetos e usam Gson para serializar/desserializar em JSON.

## Como executar

1. Abra os dois projetos no NetBeans.
2. Rode `ServidorApp.java` (Run File) no projeto `ServidorColetorLogs`.
3. Rode `TelaCliente.java` (Run File) no projeto `ClienteColetorLogs` — pode abrir
   mais de uma instância para testar concorrência.
4. Adicione eventos, clique em **Enviar**, depois em **Consultar** para ver os
   logs registrados.
