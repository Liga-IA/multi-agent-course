// CArtAgO artifact code for project aula10

package artifacts;

import cartago.*;
import jason.asSyntax.Literal;
import jason.environment.grid.Location;

public class Cortina extends Artifact {
	
	private int isClosed;
    private int isFullOpen;
    private int nivelCortina;
	
	void init() {
        isClosed = 1;
        isFullOpen = 0;
        nivelCortina = 0;
		defineObsProperty("fechada", isClosed);
		defineObsProperty("aberta", isFullOpen);
		defineObsProperty("nivel cortina", nivelCortina);
	}

	@OPERATION
	void aumentar_nivel() {

		ObsProperty prop = getObsProperty("nivel cortina");
		
        if(nivelCortina < 3){
			prop.updateValue(nivelCortina+1);
		}
	}
	

	@OPERATION
	void diminuir_nivel() {
		ObsProperty prop = getObsProperty("nivel cortina");
        if(nivelCortina > 0){
			prop.updateValue(nivelCortina-1);
		}
        
	}

	@OPERATION
	void fechar() {
		ObsProperty prop = getObsProperty("nivel cortina");
        ObsProperty prop1 = getObsProperty("fechada");

		prop.updateValue(0);
        prop1.updateValue(1);
		
	}
	
	@OPERATION
	void abrir() {
		ObsProperty prop = getObsProperty("nivel cortina");
		ObsProperty prop1 = getObsProperty("aberta");
		
		prop.updateValue(3);
        prop1.updateValue(1);
	}
	
}


