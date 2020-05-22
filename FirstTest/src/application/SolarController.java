package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SolarController extends Application{
	
	@FXML private Button pvButton;
	@FXML private Button back;
	@FXML private Button thermalButton;
	@FXML private Button tomorrow;
	@FXML private Button backToPv;
	@FXML private Button backToTherm;
	
	public void start(Stage window) throws IOException{
		//window.setTitle("Front Page");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Solar1.fxml"));
		Scene scene= new Scene(loader.load());
		window.setScene(scene);
		window.show();
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
	public void handleBack(ActionEvent event) throws IOException{
		FXMLLoader frontView = new FXMLLoader();
		frontView.setLocation(getClass().getResource("Solar1.fxml"));
		Scene frontScene= new Scene(frontView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow(); 
		window.setScene(frontScene);
		window.show();
	}
	public void handleThermalButton(ActionEvent event) throws IOException{
		FXMLLoader thermView = new FXMLLoader();
		thermView.setLocation(getClass().getResource("Thermal.fxml"));
		Scene thermScene= new Scene(thermView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow(); //typecasting
		window.setScene(thermScene);
		window.show();
	}
	
	public void handleTomorrow(ActionEvent event) throws IOException
	{
		FXMLLoader predictView = new FXMLLoader();
		predictView.setLocation(getClass().getResource("PredictionPv.fxml"));
		Scene predictScene= new Scene(predictView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(predictScene);
		window.show();
	}
	public void handleBackToPv(ActionEvent event) throws IOException{
		FXMLLoader pvView = new FXMLLoader();
		pvView.setLocation(getClass().getResource("Pv.fxml"));
		Scene pvScene= new Scene(pvView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow(); 
		window.setScene(pvScene);
		window.show();
	}
	public void handleBackToTherm(ActionEvent event) throws IOException{
		FXMLLoader thermView = new FXMLLoader();
		thermView.setLocation(getClass().getResource("Thermal.fxml"));
		Scene thermScene= new Scene(thermView.load());
		Stage window =(Stage)((Node)event.getSource()).getScene().getWindow(); 
		window.setScene(thermScene);
		window.show();
	}
	public static void main(String[] args){
		launch(args);
		}


}
