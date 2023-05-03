// CArtAgO artifact code for project aula10

package artifacts;

import cartago.*;
import jason.asSyntax.Literal;
import jason.environment.grid.Location;

public class CA extends Artifact {
	
	private boolean isClosed;
    private boolean isFullOpen;
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
		ObsProperty prop = getObsProperty("nivel cortina")
        if(prop < 3){prop.updateValue(nivelCortina+1);}
	}
	

	@OPERATION
	void diminuir_nivel() {
		ObsProperty prop = getObsProperty("nivel cortina")
        if(prop > 0){prop.updateValue(nivelCortina-1);}
        
	}

	@OPERATION
	void fechar() {
		ObsProperty prop = getObsProperty("nivel cortina");
        ObsProperty prop1 = getObsProperty("fechada");
        if(prop > 0){prop.updateValue(0);}
        prop1.updateValue(1);
	}
	
	@OPERATION
	void abrir() {
		ObsProperty prop = getObsProperty("aberta");
		if(prop < 3){prop.updateValue(3);}
        prop.updateValue(1);
	}
	
}


