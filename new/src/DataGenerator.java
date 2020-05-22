import java.util.Date;
//For at generere og gemme ny data

public class DataGenerator extends Thread{
	private JDBCConnector connection;
	
	private final double maxTemperatureIn = 25;
	private final double maxTemperatureOut = 62;
	private final double maxAmbientAirTemperature = 18.5;
	private final int maxIrradiance = 1015;
	private final double maxV = 0.99;
	private final int averageTime = 20;
	private final double maxCurrent = 0.75;
	private final double maxVolt = 19.5;
	private final int waitTime = 3000; //Find ud af hvor mange sekunder/minutter mellem hver måling.
	//calculations
	
	public DataGenerator(JDBCConnector connection) {
		this.connection = connection;
	}
	
	public void runThermal() {
		while(true) {
			// lave korrekte 'udregninger'
			double temperatureIn= (double)Math.floor(Math.random()*(maxTemperatureIn - 10 + 1))+10;
			System.out.println("Temperature In: " + temperatureIn);
			
			double temperatureOut= (double)Math.floor(Math.random()*(maxTemperatureOut- 20 +1))+20;
			System.out.println("Temperature Out: " + temperatureOut);
			
			double ambientAirTemperature= (double)Math.floor(Math.random()*(maxAmbientAirTemperature- 16.8 +1))+20;
			System.out.println("Ambient Ai rTemperature: " + ambientAirTemperature);
			
			int irradiance= (int)Math.floor(Math.random()*(maxIrradiance-980 + 1))+980;
			System.out.println("Irradiance: " + irradiance);
			
			double v= (double)Math.floor(Math.random()*(maxV - 0.01 + 1))+0.01;
			System.out.println("V: " + v);
			
			int time= averageTime;
			System.out.println("Time: " + time);
			//time er en konstant derfor ikke nødvendig at udregne. 
			Date date = new Date();
			System.out.println("Time: " + date);
			
			Thermal observationTherm = new Thermal(date, temperatureIn, temperatureOut, ambientAirTemperature, irradiance, v, time);
			connection.storeAsNewObservation(observationTherm);
			
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				System.out.println("Thread sleeping interrupted");
				e.printStackTrace();
			}
		}
	}
	public void runPv() {
		while(true) {
			double current= (double)Math.floor(Math.random()*(maxCurrent-0.11+1))+0.11;
			System.out.println("Current: " + current);
			
			double volt= (double)Math.floor(Math.random()*(maxVolt-0.30+1))+0.30;
			System.out.println("Volt: " + volt);
			
			int irradiance =800;
			
			double R = volt/current;
			
			double power = current * volt;
			
			double effeciency = (power/irradiance*0.0761*1000)*100;
			
			Date date = new Date();
			
			PV observationPv = new PV(date, current, volt, irradiance, R, power, effeciency);
			connection.storeAsNewObservation(observationPv);
		}
	}

}
