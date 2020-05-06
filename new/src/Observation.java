import java.util.Date;

//This class is used to store data from the database
public class Observation {
	
	private Date date;
	private int temperatureIn;
	private int temperatureOut;
	private int ambientAirTemperature;
	private int irradiance;
	private int v;
	private int time;
	
	public Observation (Date date, int temperatureIn, int temperatureOut, int ambientAirTemperature, int irradiance, int v,int time) {
		this.date = date;
		this.temperatureIn = temperatureIn;
		this.temperatureOut = temperatureOut;
		this.ambientAirTemperature = ambientAirTemperature;
		this.irradiance = irradiance;
		this.v = v;
		this.time = time;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTemperatureIn() {
		return temperatureIn;
	}
	public void setTemperatureIn(int temperatureIn) {
		this.temperatureIn = temperatureIn;
	}
	public int getTemperatureOut() {
		return temperatureOut;
	}
	public void setTemperatureOut(int temperatureOut) {
		this.temperatureOut=temperatureOut;
	}
	public int getAmbientAirTemperature() {
		return  ambientAirTemperature;
	}
	public void setAmbientAirTemperature(int ambientAirTemperature) {
		this.ambientAirTemperature =  ambientAirTemperature;
	}
	public int getIrradiance() {
		return irradiance;
	}
	public void setIrradiance(int irradiance) {
		this.irradiance=irradiance;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public String toString() {
		return "Date: " + date + ", Temperature In: " + temperatureIn + ", Temperature Out: " + temperatureOut + ", Ambient Air Temperature: " + ambientAirTemperature + ", Irradiance: " + irradiance + ", v " + v + ", Time: " + time; 
	}
}

