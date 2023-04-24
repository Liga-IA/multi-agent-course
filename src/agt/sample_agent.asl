// Agent sample_agent in project doors_windows_liara

/* Initial beliefs and rules */

/* Initial goals */

!abrir_porta.
!abrir_janela.

/* Plans */

+!abrir_porta : true <- 
    .print("hello world."); 
    destrancar[artifact_id(porta1)];
    .print("Porta destrancada.").

+!abrir_janela : true <- 
    .print("hello world."); 
    destrancar[artifact_id(janela1)];
    .print("Janela destrancada.").

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
