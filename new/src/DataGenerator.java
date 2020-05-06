import java.util.Date;
//For at generere og gemme ny data

public class DataGenerator extends Thread{
	private JDBCConnector connection;
	
	private final double averageTemperatureIn = 19.4;
	private final double averageTemperatureOut = 34.6 ;
	private final double averageAmbientAirTemperature = 17.4;
	private final int averageIrradiance = 997;
	private final double averageV = 0.37;
	private final int averageTime = 20;
	private final int waitTime = 3000; //Find ud af hvor mange sekunder/minutter mellem hver måling. 
	
	public DataGenerator(JDBCConnector connection) {
		this.connection = connection;
	}
	
	public void run() {
		while(true) {
			// lave korrekte 'udregninger'
			double temperatureIn= (double)Math.floor(Math.random()*averageTemperatureIn*2)+averageTemperatureIn-6;
			System.out.println("Temperature In: " + temperatureIn);
			
			double temperatureOut= (double)Math.floor(Math.random()*averageTemperatureOut*2)+averageTemperatureOut-6;
			System.out.println("Temperature Out: " + temperatureOut);
			
			double ambientAirTemperature= (double)Math.floor(Math.random()*averageAmbientAirTemperature*2)+averageAmbientAirTemperature-6;
			System.out.println("Ambient Ai rTemperature: " + ambientAirTemperature);
			
			int irradiance= (int)Math.floor(Math.random()*averageIrradiance*2)+averageIrradiance-6;
			System.out.println("Irradiance: " + irradiance);
			
			double v= (double)Math.floor(Math.random()*averageV*2)+averageV-6;
			System.out.println("V: " + v);
			
			int time= averageTime;
			System.out.println("Time: " + time);
			//time er en konstant derfor ikke nødvendig at udregne. 
			Date date = new Date();
			System.out.println("Time: " + date);
			
			Observation observation = new Observation(date, temperatureIn, temperatureOut, ambientAirTemperature, irradiance, v, time);
			connection.storeAsNewObservation(observation);
			
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				System.out.println("Thread sleeping interrupted");
				e.printStackTrace();
			}
		}
	}

}
