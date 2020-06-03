package application;
import java.util.Date;
//This class is used to store data from the database

public class Measurements {
	private Date time;
	
	public Measurements(Date time) {
		this.time = time;
	}
	
	public Date getTime(){
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String toString() {
		return "Time: " + time;
	}

}
