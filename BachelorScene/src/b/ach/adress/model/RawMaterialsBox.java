package b.ach.adress.model;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class RawMaterialsBox {
	VBox layout = new VBox(10);
	private Scene scene= new Scene(layout, 200, 200);
	private boolean k=false;
	private String name;
	boolean   windowclose;
	private int butt=0;
	private Stage window;
	private Button OK = new Button("OK");
	private Label error = new Label();
	private TextField amount = new TextField();
	private RawMaterialsBox(String namee) {
		
		name = namee;

	}
	
	public void make(AnchorPane x){
		
		 window = new Stage();	
		 window.setResizable(false);
		window.setTitle("Raw materials " + name);
		window.initModality(Modality.APPLICATION_MODAL);
		layout.setAlignment(Pos.CENTER);
		Label info = new Label(String.format("Buy raw material #%s",name));
		layout.getChildren().addAll(info, amount, OK,error);
		
		
		
	}
	
	
	
	
	

	public String display() {
		
		
		window.setOnCloseRequest(e-> windowclose=true);		
		
		amount.setMaxWidth(60);
		 OK.setOnAction(e->{ if(isInt(amount.getText(),error)==true) window.close();});
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
			
			
			
		}
		}
	
	
	public void close(Stage g)
	{
	g.close();
		
		
	}

}