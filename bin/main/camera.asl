
!inicializar_camera.

+!inicializar_camera
  <- 	makeArtifact("camera_frente","artifacts.Camera",[],D);
  	   	focus(D).
  	   	
+movimento 
  <-  !!verificar_pessoa.
      
+closed  <-  .print("Close event from GUIInterface").
   
 +!verificar_pessoa: pessoa(P) & local(L)
 	<-  .print("Pessoa: ", P, " reconhecida no local ", L).