!ligar_luz.
!desligar_luz.
!abrir.
!fechar.

+!ligar_luz : true <-
    ligar[artifact_id(lampada1)];
    .print("Luz ligada.").

-!ligar_luz: true <-
    .print("ERRO: Falha ao ligar luz").

+!desligar_luz : true <-
    desligar[artifact_id(lampada1)];
    .print("Luz desligada.").

-!desligar_luz: true <-
    .print("ERRO: Falha ao desligar luz").

+!abrir: true <-
    abrir[artifact_id(cortina1)];
    .print("Cortina aberta").

+!fechar: true <-
    fechar[artifact_id(cortina1)];
    .print("Cortina aberta").

