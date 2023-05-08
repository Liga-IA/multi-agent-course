// CArtAgO artifact code for project aula10

package artifacts;

import cartago.*;
import jason.asSyntax.Literal;
import jason.environment.grid.Location;

public class AC extends Artifact {
	
	private TemperaturaAmbiente TA;
	private ArCondicionado ac_model = new ArCondicionado(false, 35, 25);
	
	void init(int tempA, int tempD) {
		ac_model.setTemperatura_ambiente(tempA);
		ac_model.setTemperatura(tempD);
		defineObsProperty("ligado", this.ac_model.isOn());
		defineObsProperty("temperatura_ambiente", this.ac_model.getTemperatura_ambiente());
		defineObsProperty("temperatura", this.ac_model.getTemperatura());
		System.out.println("Inicializado com " + this.ac_model.getTemperatura());
	}

	@OPERATION
	void ligar(int temp) {
		this.ac_model.setOn(true);
		ObsProperty prop = getObsProperty("ligado");
		prop.updateValue(ac_model.isOn());
		this.ac_model.setTemperatura(temp);
		this.TA = new TemperaturaAmbiente(ac_model);
		TA.start();
	}
	
	@OPERATION
	void desligar() {
		TA.stopThread();
	}
	
	@OPERATION
	void consultar() {
		ObsProperty prop = getObsProperty("temperatura_ambiente");
		prop.updateValue(ac_model.getTemperatura_ambiente());
	}
	
	@OPERATION
	void resfriar() {
		ac_model.setTemperatura(ac_model.getTemperatura()-1);;
		ObsProperty prop = getObsProperty("temperatura");
		prop.updateValue(ac_model.getTemperatura());
	}
	
	@OPERATION
	void aquecer() {
		ac_model.setTemperatura(ac_model.getTemperatura()+1);;
		ObsProperty prop = getObsProperty("temperatura");
		prop.updateValue(ac_model.getTemperatura());
	}
	
	@OPERATION
	void definir_temperatura(int temperatura) {
		ac_model.setTemperatura(temperatura);;
		ObsProperty prop = getObsProperty("temperatura");
		prop.updateValue(ac_model.getTemperatura());
	}
	
}


class ArCondicionado {
	
	private boolean isOn = false;
	private int temperatura_ambiente = 0;
	private int temperatura = 0;
	
	public ArCondicionado(boolean isOn, int temperatura_ambiente, int temperatura_desejavel) {
		super();
		this.isOn = isOn;
		this.temperatura_ambiente = temperatura_ambiente;
		this.temperatura = temperatura_desejavel;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public int getTemperatura_ambiente() {
		return temperatura_ambiente;
	}

	public void setTemperatura_ambiente(int temperatura_ambiente) {
		this.temperatura_ambiente = temperatura_ambiente;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura_desejavel) {
		this.temperatura = temperatura_desejavel;
	}	
		
}



class TemperaturaAmbiente extends Thread {
	
    private ArCondicionado ac;
    private boolean running;

    public TemperaturaAmbiente(ArCondicionado ac) {
        this.ac = ac;
        this.running = true;
    }

    public void stopThread() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
        	System.out.println("temperatura ambiente: " + ac.getTemperatura_ambiente());
            try {
                Thread.sleep(5000); 
                int currentTemp = ac.getTemperatura_ambiente();
                if (currentTemp > ac.getTemperatura()) { 
                    ac.setTemperatura_ambiente(currentTemp - 1); 
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
