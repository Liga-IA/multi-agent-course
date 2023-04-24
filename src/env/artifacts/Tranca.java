package artifacts;

import cartago.*;
import jason.asSyntax.Literal;
import java.lang.Math;

public class Tranca extends Artifact {

	private double fechada;
	private int trancada;
    
    void init(double valorInicialFechada, int valorInicialTrancada) {
		trancada = valorInicialTrancada;
		if (trancada == 1) {
			fechada = 100.0;
		} else {
			fechada = valorInicialFechada;
		}

		defineObsProperty("trancada", trancada);
		defineObsProperty("fechada", fechada);
		
	}

	@OPERATION
	void destrancar() {
		ObsProperty prop = getObsProperty("trancada");
		prop.updateValue(0);
		signal("tick");
	}

	@OPERATION
	void trancar() {
		ObsProperty prop = getObsProperty("fechada");
		if (prop.doubleValue() != 100.0) prop.updateValue(100.0);

        prop = getObsProperty("trancada");
        prop.updateValue(1);
        signal("tick");
    }

	@OPERATION
    void abrir(float abertura) {
		ObsProperty prop = getObsProperty("trancada");
		prop.updateValue(0);

		prop = getObsProperty("fechada");
		prop.updateValue(Math.abs(prop.doubleValue() + abertura) % 100);
		signal("tick");
	}

	@OPERATION
	void fechar(float fechamento) {
        ObsProperty prop = getObsProperty("fechada");
        prop.updateValue(Math.abs(prop.doubleValue() - fechamento) % 100);
        signal("tick");
    }

}
