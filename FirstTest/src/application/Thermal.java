package application;
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
	private double Q;
	private double heatOutput;
	private double effeciency;
	private double liquidTemperature;
	private double tmta; 
	
	public Thermal (Date date, double temperatureIn, double temperatureOut, double ambientAirTemperature, int irradiance, double v,int time, double Q, double heatOutput, double effeciency, double liquidTemperature, double tmta) {
		this.date = date;
		this.temperatureIn = temperatureIn;
		this.temperatureOut = temperatureOut;
		this.ambientAirTemperature = ambientAirTemperature;
		this.irradiance = irradiance;
		this.v = v;
		this.time = time;
		this.Q = Q;
		this.heatOutput = heatOutput;
		this.effeciency = effeciency;
		this.liquidTemperature = liquidTemperature;
		this.tmta = tmta;
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
	public double getQ() {
		return Q;
	}
	public void setQ(double Q) {
		this.Q = Q;
	}
	public double getHeatOutput() {
		return heatOutput;
	}
	public void setHeatOutput(double heatOutput) {
		this.heatOutput = heatOutput;
	}
	public double getEffeciency() {
		return effeciency;
	}
	public void setEffeciency(double effeciency) {
		this.effeciency = effeciency;
	}
	public double getLiquidTemperature() {
		return liquidTemperature;
	}
	public void setLiquidTemperature(double liquidTemperature) {
		this.liquidTemperature = liquidTemperature;
	}
	public double getTmta() {
		return tmta;
	}
	public void setTmta(double Tmta) {
		this.tmta = tmta;
	}
	public String toString() {
		return "Date: " + date + ", Temperature In: " + temperatureIn + ", Temperature Out: " + temperatureOut + ", Ambient Air Temperature: " + ambientAirTemperature + ", Irradiance: " + irradiance + ", v " + v + ", Time: " + time 
				+ " Q: " + Q + " Heat Output: " + heatOutput + " Effeciency: " + effeciency + " Liquid temperature: " + liquidTemperature + " Tm-Ta: " + tmta; 
		
	}
}

