package application;

import java.io.IOException;
import java.sql.SQLException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SolarController extends Application{
	
	@FXML private Button pvButton;
	@FXML private Button back;
	@FXML private Button thermalButton;
	@FXML private Button tomorrow;
	@FXML private Button backToPv;
	@FXML private Button backToTherm;
	@FXML private Text outputPv;
	@FXML private Button pv;
	@FXML private Button outputTherm;
	@FXML private Text therm;
	
	
	public void start(Stage window) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Solar1.fxml"));
		Scene scene= new Scene(loader.load());
		window.setScene(scene);
		window.show();
	}
	
	public void dailyPerformancePv(ActionEvent event) throws SQLException {
		//Establishing connection to the database
		JDBCConnector connection = new JDBCConnector();
		connection.connect(5432, "mdandwle", "9W5YHMxa7H_55rfP8fz1NXII7qVVLmAl");
		//Typecasting
		String string = Double.toString(connection.outputPV());
		outputPv.setText(string);
	}
	public void dailyPerformanceTherm(ActionEvent event) throws SQLException {
		//Establishing connection to the database
		JDBCConnector connection = new JDBCConnector();
		connection.connect(5432, "mdandwle", "9W5YHMxa7H_55rfP8fz1NXII7qVVLmAl");
		//Typecasting
		String string = Double.toString(connection.outputThermal());
		therm.setText(string);
	}	
	
	//method for shifting the scene to PV. 
	public void handlePvButton(ActionEvent event) throws IOException
	{
		FXMLLoader pvView = new FXMLLoader();
		pvView.setLocation(getClass().getResource("Pv.fxml"));
		Scene pvScene= new Scene(pvView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow(); 
		window.setScene(pvScene);
		window.show();
	}
	// Method for shifting the scene from either PV or Thermal to FrontScene
	public void handleBack(ActionEvent event) throws IOException{
		FXMLLoader frontView = new FXMLLoader();
		frontView.setLocation(getClass().getResource("Solar1.fxml"));
		Scene frontScene= new Scene(frontView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow(); 
		window.setScene(frontScene);
		window.show();
	}
	//Method for shifting the scene to the thermal page. 
	public void handleThermalButton(ActionEvent event) throws IOException{
		FXMLLoader thermView = new FXMLLoader();
		thermView.setLocation(getClass().getResource("Thermal.fxml"));
		Scene thermScene= new Scene(thermView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow(); 
		window.setScene(thermScene);
		window.show();
	}
	// Shifting to prediction scene	
	public void handleTomorrow(ActionEvent event) throws IOException
	{
		FXMLLoader predictView = new FXMLLoader();
		predictView.setLocation(getClass().getResource("PredictionPv.fxml"));
		Scene predictScene= new Scene(predictView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(predictScene);
		window.show();
	}
	//Run the application
	public static void main(String[] args) throws SQLException{
		launch(args);
		
		}
}
