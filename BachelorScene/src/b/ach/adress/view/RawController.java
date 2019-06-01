package b.ach.adress.view;
import java.io.IOException;
import java.time.Duration;
import org.reactfx.util.FxTimer;

import b.ach.adress.MainApp;
import b.ach.adress.model.Machine;
import b.ach.adress.model.RawMaterialsBox;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
public class RawController {
	@FXML
	private Label Buy;
	@FXML
	private Label error;
	@FXML 
	private TextField amount;
	@FXML
	private Button OK;
	private Stage window;
	boolean   windowclose=false;
	
	
	public void make(){
		
		 window = new Stage();	
		 window.setResizable(false);
		window.setTitle("Raw materials ");
		window.initModality(Modality.APPLICATION_MODAL);
	}
	
	
	
	
	
public String display(AnchorPane layout) {
		window.setOnCloseRequest(e-> windowclose=true);		
		Scene scene= new Scene(layout);
		
		 OK.setOnAction(e->{ if(isInt(amount.getText(),error)==true) window.close();});
		 scene.setOnKeyPressed(e->
			{
				if(e.getCode()==KeyCode.ENTER)
				{
					
					if(isInt(amount.getText(),error)==true) window.close();
								
				}});	 	 
		 window.setScene(scene);
			window.showAndWait();
		
		if(windowclose==false)
			{
			return amount.getText();
			}
		else{
	
			return "0";
			
		}
		
	}


private boolean isInt(String x, Label err)
{
	try
	{
	int amount = Integer.parseInt(x)	;
	return true;
		
		
		
	}catch(NumberFormatException e)
	{ err.setText("Error: " + x +" is not a number");
	
	return false;
}}

public void close(Stage g)
{
g.close();
	
	
}
public Label reterr(){
	return error;
	
}

}




