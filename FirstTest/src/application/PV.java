package application;
import java.util.Date;

public class PV {
	//This class is used to store data from the database
	
	private Date date;
	private double current;
	private double volt;
	private int irradiance;
	private double R;
	private double power;
	private double effeciency; 
	
	//Constructor
	public PV(Date date, double current, double volt, int irradiance, double R, double power, double effeciency) {
		this.date = date;
		this.current = current;
		this.volt = volt;
		this.irradiance = irradiance;
		this.R = R;
		this.power = power;
		this.effeciency = effeciency;
	}
	
	public Date getDate(){
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getCurrent(){
		return current;
	}
	public void setCurrent(double current) {
		this.current = current;
	}
	public double getVolt(){
		return volt;
	}
	public void setVolt(double volt) {
		this.volt = volt;
	}
	public int getIrradiance(){
		return irradiance;
	}
	public void setIrradiance(int irradiance) {
		this.irradiance = irradiance;
	}
	public double getR(){
		return R;
	}
	public void setR(double R) {
		this.R = R;
	}
	public double getPower(){
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public double getEffeciency(){
		return effeciency;
	}
	public void setEffeciency(double effeciency) {
		this.effeciency = effeciency;
	}
	public String toString() {
		return "Date: " + date + ", current: " + current + ", Volt: " + volt + ", Irradiance: " + irradiance + " , R: " + R + " , Power" + power + " , Effeciency: " + effeciency; 
	}

}
