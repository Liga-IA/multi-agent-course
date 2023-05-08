package artifacts;

import cartago.*;
import jason.asSyntax.Literal;
import java.lang.Math;


public class Lampada extends Artifact{
    
	private int desligada;
	private int ligada;
    
    void init(int valorInicialDesligada, int valorInicialLigada) {
		ligada = valorInicialLigada;
		if (ligada == 1) {
			signal("esta ligada");
		} else {
			signal("esta desligada");
		}

		defineObsProperty("ligada", ligada);
		defineObsProperty("desligada", desligada);	
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
        prop.updateValue(0);
        signal("tick");
    }


}
