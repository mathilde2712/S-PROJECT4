package application;

import java.util.Date;
//This class is used to store data from the database
public class Messages {
	private int id;
	private String message;
	private Date time;
	
	public Messages (int id, String message, Date time) {
		this.id = id;
		this.message = message;
		this.time = time; 
	}
	public Messages(String message) {
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id= id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message= message;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time= time;
	}
	
	public String toString() {
		return "Id: " + " Message: " + message + "date: " + time;
	}
	

}
