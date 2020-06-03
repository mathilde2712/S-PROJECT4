package application;

import java.sql.*;
import java.util.Date;
//This class handles all interaction with the database
public class JDBCConnector {
private Connection connection;

	public Connection connect(int portNo, String userName, String password) {
	
		// Establishing a PostgreSQL database connection
		String databaseUrl = "jdbc:postgresql://drona.db.elephantsql.com:" + portNo + "/mdandwle";

		try {
			connection = DriverManager.getConnection(databaseUrl, userName, password);
			System.out.println("Connection established to: " + databaseUrl);
		} 
		catch (Exception exception) {
			System.out.println("Connection failed");
			exception.printStackTrace();
		}
		return connection;
	}	

	public double outputPV() throws SQLException {
		// Used to display the daily output of the pv panel. 
		 String query = "SELECT SUM(power) as output FROM Solarpanel.PV WHERE date BETWEEN '2020-06-01' AND '2020-06-01 17:00:00';";

	      // create the java statement
	      Statement statement = connection.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = statement.executeQuery(query);
	      
	      // iterate through the java resultset
	      rs.next();
	      
	      double output = rs.getDouble("output");
	 
	      return output;
	}
	public double outputThermal() throws SQLException {
		// Used to display the daily output of the  panel
		
		  String query = "SELECT SUM(heatOutput) as output FROM Solarpanel.Thermal WHERE date BETWEEN '2020-06-01' AND '2020-06-01 17:00:00';";

	      Statement statement = connection.createStatement();
	      ResultSet rs = statement.executeQuery(query);
	  
	      rs.next();
	      double output = rs.getDouble("output");
	      return output;
	 
	}
	
	public void storeAsNewPVObservation(PV observation) {
		// Used to store new observation 
		
		String sql = "INSERT INTO Solarpanel.PV (date, current, volt, irradiance, R, power, efficiency) VALUES ('" + convertToSqlTimestamp(observation.getDate()) + "', '" + observation.getCurrent() + "', '" + observation.getVolt() + "', '" + observation.getIrradiance() + "', '" + observation.getR() + "', '" + observation.getPower() + "', '" + observation.getEffeciency() + "');";
		
		try {
			
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
		} catch (SQLException e) {
			
			System.out.println("Error trying to insert a new observation in PV table");
			e.printStackTrace();
		}
		
		// Creates a new warning message an stores it in the database if the desired value is not met. 
		if(observation.getPower()<2) {
			
			Messages mess = new Messages("Warning: genereted energy from PV-panels is under expected. Check panels");
			String query = "INSERT INTO Solarpanel.Messages (message) VALUES ('" + mess.getMessage() + "');" ;
			
			try {
				
				Statement statement = connection.createStatement();
				statement.execute(query);
				
			} catch (SQLException e) {
				
				System.out.println("Error trying to insert a new observation in Message table");
				e.printStackTrace();
			}
		}
	}
	
	public void storeAsNewMeasureObservation(Measurements observation) {
		
		// Used to store new observation 
		
		String sql = "INSERT INTO Solarpanel.Measurements(time) VALUES ('" + convertToSqlTimestamp(observation.getTime()) + "');";
		
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
		} catch (SQLException e) {
			
			System.out.println("Error trying to insert a new observation in Measures table");
			e.printStackTrace();
		}
	}
	
	public void storeAsNewThermalObservation(Thermal observation) {
		// Used to store new observation 
		
		String sql = "INSERT INTO Thermal (date, temperatureIn, temperatureOut, ambientAirTemperature, irradiance, v, time, Q, heatOutput, effeciency, liquidTemperature, tmta) "
				+ "VALUES ('" + convertToSqlTimestamp(observation.getDate()) + "', '" + observation.getTemperatureIn() + "', '" + observation.getTemperatureOut() + "', " + observation.getAmbientAirTemperature() + "', '" + observation.getIrradiance() + "', '" + observation.getV() + "', '" + observation.getTime()
				+ "', '" + observation.getQ() + "', '" + observation.getHeatOutput() + "', '" + observation.getEffeciency() + "', '" + observation.getLiquidTemperature() + "', '" + observation.getTmta() + "');";
		
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
		} catch (SQLException e) {
			
			System.out.println("Error trying to insert a new observation in Thermal table");
			e.printStackTrace();
		}
		
		// Creates a new warning message an stores it in the database if the desired value is not met.
		if(observation.getHeatOutput()<10) {
			
			Messages mess = new Messages("Warning: generated heat from Thermal-panels is under expected. Check Panels");
			String query = "INSERT INTO Solarpanel.Messages (message) VALUES ('" + mess.getMessage() + "');" ;
			
			try {
				Statement statement = connection.createStatement();
				statement.execute(query);
				
			} catch (SQLException e) {
				
				System.out.println("Error trying to insert a new observation in Message table");
				e.printStackTrace();
			}
		}
	}
	
	
	public void close() {
		// Close the connection
		try {
			connection.close();
			System.out.println("Connection closed");
		} catch (SQLException exception) {
			System.out.println("Connection closing failed");
			exception.printStackTrace();
		}
	}

	// method to convert from one java date/time to sql date/time
    private java.sql.Timestamp convertToSqlTimestamp(java.util.Date uDate) {
        java.sql.Timestamp timestamp = new java.sql.Timestamp(uDate.getTime());
        return timestamp;
    }
}
