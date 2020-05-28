package application;

import java.util.Date;

public class Messages {
	private int id;
	private String message;
	private Date date;
	
	public Messages (int id, String message, Date date) {
		this.id = id;
		this.message = message;
		this.date = date; 
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date= date;
	}
	

}
