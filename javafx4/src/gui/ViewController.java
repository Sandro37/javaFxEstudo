package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

	@FXML private TextField txtNumberOne;
	@FXML private TextField txtNumberTwo;
	
	@FXML private Label labelResult;
	@FXML private Button btSum;
	
	@FXML
	public void onBtSumAction(){
		Locale.setDefault(Locale.US);
		try {
			double numberOne = Double.parseDouble(txtNumberOne.getText());
			double numberTwo = Double.parseDouble(txtNumberTwo.getText());
			
			double result = numberOne + numberTwo;
			
			labelResult.setText(String.format("%.2f", result));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parser error", e.getMessage(), AlertType.ERROR);
		}
		
	}
}
