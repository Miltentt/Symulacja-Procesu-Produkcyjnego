package b.ach.adress.view;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OverController {
	private Stage window;
	
	@FXML
	private Button OK;
	@FXML
	private Label game;
	
	public void make(){
		
		 window = new Stage();	
		 window.setResizable(false);
		window.setTitle("Game Status ");
		window.initModality(Modality.APPLICATION_MODAL);
	}
	public void display(VBox layout) {		
		Scene scene= new Scene(layout);
		 OK.setOnAction(e->{  window.close();});
		 scene.setOnKeyPressed(e->
			{
				if(e.getCode()==KeyCode.ENTER)
				{
					
					 window.close();
								
				}});	 	 
		 window.setScene(scene);
			window.show();
}
	public void gameover(int i)
	{
		if(i==1)
		{
			game.setText("You won!");
		}else
		{
			game.setText("You lost!");
		}
		
	}



}
