// Agent gui in project aula10

/* Initial beliefs and rules */

/* Initial goals */

!test_gui.

+!test_gui
  <- makeArtifact("gui","artifacts.MySimpleGUI",[],D);
  		focus(D);
  		println("Hello").

  
+ok : temperaturaAtual(TA) & temperaturaDesejada(T)
  <-  .print("Valores: ");
  	  .print("\n Temperatura Atual: ", TA, "\n Temperatura Desejada: ", T);
  	  !create_ac.
      
+closed  <-  .print("Close").

 +!create_ac: temperaturaAtual(TA) & temperaturaDesejada(TD)
 	<- makeArtifact("ac","artifacts.AC",[TA,TD],D);
  	   focus(D);
  	   !climatizar.
  	   
 +!climatizar: temperatura_ambiente(TA) & temperatura(T) & TA > T & ligado(false)
 	<-   ligar(T);
 		.print("Ligar.. ");
 		.print("Temperatura: ", TA);
 		.wait(1000);
 		!climatizar.
 		
  +!climatizar: temperatura_ambiente(TA) & temperatura(T) & TA > T & ligado(true)
 	<-   consultar;
 		?temperatura_ambiente(TA2);
 		.print("Aguardando regularizar temperatura para desligar ");
 		.print("Temperatura: ", TA2);
 		.wait(1000);
 		!climatizar.
 	
  +!climatizar: temperatura_ambiente(TA) & temperatura(T) & TA == T & ligado(true)
 	<-   desligar;
 		.print("Desligar.. ");
 		.print("Temperatura: ", TA).

  
 +!climatizar 
 	<- 	.print("Nao foram implementadas outras opcoes");
 		.print("TEMPERATURA REGULARIZADA").


