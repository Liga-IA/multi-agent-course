// CArtAgO artifact code for project aula10

package artifacts;

import cartago.*;
import jason.asSyntax.Literal;
import jason.environment.grid.Location;


public class Camera extends Artifact {
    
	private int desligada;
	private int ligada;
	private int filmando;
    
    void init(int valorInicialDesligada, int valorInicialLigada) {
		ligada = valorInicialLigada;
		if (ligada == 1) {
			signal("esta ligada");
            if(filmando == 1){
                signal("esta ligada e filmando");
            }
		} 
        else {
			signal("esta desligada");
		}

		defineObsProperty("ligada", ligada);
		defineObsProperty("desligada", desligada);
        defineObsProperty("filmando", filmando);	
	
	}

    @OPERATION
    void filmar() {
        ObsProperty prop = getObsProperty("filmando");
        prop.updateValue(1);
        signal("tick");
    }

	@OPERATION
	void ligar() {
		ObsProperty prop = getObsProperty("ligada");
		prop.updateValue(1);
		signal("tick");
	}

	@OPERATION
	void desligar() {
		ObsProperty prop = getObsProperty("desligada");
		ObsProperty prop2 = getObsProperty("filmando");

		prop2.updateValue(0);
        prop.updateValue(0);
        signal("tick");
    }

    
}
