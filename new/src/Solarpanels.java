import java.util.Date;
public class Solarpanels {
	
	private String place;
	private int numberOfPanels;
	private String producer;
	private Date installationYear;
	
	public Solarpanels (String place, int numberOfPanels, String producer, Date installationYear) {
		this.place = place;
		this.numberOfPanels=numberOfPanels;
		this.producer=producer;
		this.installationYear=installationYear;
	}
	
	public String getPlace(){
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getNumberOfPanels(){
		return numberOfPanels;
	}
	public void setNumberOfPanels(int numberOfPanles) {
		this.numberOfPanels = numberOfPanels;
	}
	public String getProducer(){
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public Date getInstallationYear(){
		return installationYear;
	}
	public void setInstallationYear(Date iInstallationYear) {
		this.installationYear = installationYear;
	}
	
	public String toString() {
		return "Place: " + place + " Number of panels: " + numberOfPanels + " Producer: " + producer + " Installation year: " + installationYear;
	}

}
