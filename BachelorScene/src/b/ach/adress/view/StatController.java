package b.ach.adress.view;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StatController {
	@FXML
	private Button OK;
	private Stage window;
	public void make(){
		
		 window = new Stage();	
		 window.setResizable(false);
		window.setTitle("Statistics");
	
	}
	public void display(AnchorPane layout) {
			
		Scene scene= new Scene(layout);
		
		 OK.setOnAction(e-> window.close());
			
		 scene.setOnKeyPressed(e->
			{
				if(e.getCode()==KeyCode.ENTER)
				{
					
					 window.close();
								
				}});	 
		 	 
		 window.setScene(scene);
			window.show();
		
				 	
	}
	
}
