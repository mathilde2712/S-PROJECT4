import java.util.Date;

//This class is used to store data from the database
public class Thermal {
	
	private Date date;
	private double temperatureIn;
	private double temperatureOut;
	private double ambientAirTemperature;
	private int irradiance;
	private double v;
	private int time;
	//calculation attributes. 
	
	public Thermal (Date date, double temperatureIn, double temperatureOut, double ambientAirTemperature, int irradiance, double v,int time) {
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
	public double getTemperatureIn() {
		return temperatureIn;
	}
	public void setTemperatureIn(double temperatureIn) {
		this.temperatureIn = temperatureIn;
	}
	public double getTemperatureOut() {
		return temperatureOut;
	}
	public void setTemperatureOut(double temperatureOut) {
		this.temperatureOut=temperatureOut;
	}
	public double getAmbientAirTemperature() {
		return  ambientAirTemperature;
	}
	public void setAmbientAirTemperature(double ambientAirTemperature) {
		this.ambientAirTemperature =  ambientAirTemperature;
	}
	public int getIrradiance() {
		return irradiance;
	}
	public void setIrradiance(int irradiance) {
		this.irradiance=irradiance;
	}
	public double getV() {
		return v;
	}
	public void setV(double v) {
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

