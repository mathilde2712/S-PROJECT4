package application;
import java.util.Date;
//To generate and store new data

public class DataGenerator extends Thread{
	
	private JDBCConnector connection;
	private final double  MAX_TEMPERATURE_IN = 25;
	private final double MAX_TEMPERATURE_OUT = 62;
	private final double MAX_AMBIENT_AIRTEMPERATURE = 18.5;
	private final int MAX_IRRADIANCE = 1015;
	private final double MAX_V = 0.99;
	private final int  AVERAGE_TIME  = 20;
	private final double MAX_CURRENT = 0.75;
	private final double MAX_VOLT = 19.5;
	private final int WAIT_TIME = 10000; 
	
	public DataGenerator(JDBCConnector connection) {
		this.connection = connection;
	}
	
	//Generating random numbers to simulate a solar cell receiving inputs
	public void runThermal() {
		while(true) {
			
			double temperatureIn= (double)Math.floor(Math.random()*(MAX_TEMPERATURE_IN - 10 + 1))+10;
			System.out.println("Temperature In: " + temperatureIn);
			
			double temperatureOut= (double)Math.floor(Math.random()*(MAX_TEMPERATURE_OUT- 20 +1))+20;
			System.out.println("Temperature Out: " + temperatureOut);
			
			double ambientAirTemperature= (double)Math.floor(Math.random()*(MAX_AMBIENT_AIRTEMPERATURE- 16.8 +1))+20;
			System.out.println("Ambient Ai rTemperature: " + ambientAirTemperature);
			
			int irradiance= (int)Math.floor(Math.random()*(MAX_IRRADIANCE-980 + 1))+980;
			System.out.println("Irradiance: " + irradiance);
			
			double v= (double)Math.floor(Math.random()*(MAX_V - 0.01 + 1))+0.01;
			System.out.println("V: " + v);
			
			int time= AVERAGE_TIME;
			System.out.println("Time: " + time);
			 
			Date date = new Date();
			System.out.println("Time: " + date);
			
			//Calculations received from the mechanical students. 
			double liquidTemperature = Math.floor((temperatureIn+temperatureOut)/2);
			
			double tmta = Math.floor(liquidTemperature - ambientAirTemperature);
			
			double Q =Math.floor( v *4100*tmta);
			
			double heatOutput = Math.floor(Q/time); 
			
			double effeciency = Math.floor(heatOutput/(0.913*irradiance));
			
			Thermal observation = new Thermal(date, temperatureIn, temperatureOut, ambientAirTemperature, irradiance, v, time, Q, heatOutput, effeciency, liquidTemperature, tmta);
			connection.storeAsNewThermalObservation(observation);
			
			try {
				//Time between the measurements
				Thread.sleep(WAIT_TIME);
			} catch (InterruptedException e) {
				System.out.println("Thread sleeping interrupted");
				e.printStackTrace();
			}
		}
	}
	
	public void runPv() {
		while(true) {
			
			double current= (double)Math.floor(Math.random()*(MAX_CURRENT-0.11+1))+0.11;
			System.out.println("Current: " + current);
			
			double volt= (double)Math.floor(Math.random()*(MAX_VOLT-0.30+1))+0.30;
			System.out.println("Volt: " + volt);
			
			int irradiance =800;
			System.out.println("Irradiance: " + irradiance);
			
			double R = Math.floor(volt/current);
			System.out.println("R: " + R);
			
			double power = Math.floor(current * volt);
			System.out.println("power: " + power);
			
			double effeciency = Math.floor((power/irradiance*0.0761*1000)*100);
			System.out.println("Effeciency: " + effeciency);
			
			Date date = new Date();
			System.out.println("Date: " + date);
			
			PV observation = new PV(date, current, volt, irradiance, R, power, effeciency);
			
			connection.storeAsNewPVObservation(observation);
			
			try {
				Thread.sleep(WAIT_TIME);
			} catch (InterruptedException e) {
				System.out.println("Thread sleeping interrupted");
				e.printStackTrace();
			}
		}
	}
	public void runMeasure() {
		while(true) {
			
			Date time = new Date();
			System.out.println("Time: " + time);
			Measurements observation = new Measurements(time);
			connection.storeAsNewMeasureObservation(observation);
			
			try {
				Thread.sleep(WAIT_TIME);
			} catch (InterruptedException e) {
				System.out.println("Thread sleeping interrupted");
				e.printStackTrace();
			}
		}
	}

}
