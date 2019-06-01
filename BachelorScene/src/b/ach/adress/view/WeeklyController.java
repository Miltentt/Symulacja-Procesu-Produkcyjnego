package b.ach.adress.view;



import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WeeklyController {
	@FXML 
	private Label endweek;
	@FXML
	private Label sales;
	@FXML
	private Label raws; 
	@FXML
	private Label netflow;
	@FXML
	private Label apre;
	@FXML
	private Label bpre;
	@FXML
	private Label cpre;
	@FXML
	private Label dpre;
	@FXML
	private Label epre;
	@FXML
	private Label apo;
	@FXML
	private Label bpo;
	@FXML
	private Label cpo;
	@FXML
	private Label dpo;
	@FXML
	private Label epo;
	@FXML
	private PieChart piechart;
	private Stage window;
	public void make(){
		
		 window = new Stage();	
		 window.setResizable(false);
		window.setTitle("Weekly Statistics ");
		window.initModality(Modality.APPLICATION_MODAL);
	}
	public void display(SplitPane layout) {
		
		Scene scene= new Scene(layout);
		
			
		 scene.setOnKeyPressed(e->
			{
				if(e.getCode()==KeyCode.ENTER)
				
				{
					
					 window.close();
								
				}});	 
		 	 
		 window.setScene(scene);
			window.show();		
				 	
	}
	public void endweek(int cash)
	{
		endweek.setText(Integer.toString(cash));
	}
	public void sales(int sales1, int sales2,int sales3)
	{ int a=sales1+sales2+sales3;
	sales.setText(Integer.toString(a));
		
	}
	public void mats(int mats)
	{
		raws.setText(Integer.toString(mats));
	}
	public void net(int net)
	{
	netflow.setText(Integer.toString(net));	
	}
public void a(int ar, int ap)
{
	apre.setText(Integer.toString(ar));
	apo.setText(Integer.toString(ap));
}

public void b(int ar, int ap)
{
	bpre.setText(Integer.toString(ar));
	bpo.setText(Integer.toString(ap));
}

public void c(int ar, int ap)
{
	cpre.setText(Integer.toString(ar));
	cpo.setText(Integer.toString(ap));
}

public void d(int ar, int ap)
{
	dpre.setText(Integer.toString(ar));
	dpo.setText(Integer.toString(ap));
}

public void e(int ar1, int ar2, int ap)
{
	epre.setText(String.format("%d    %d",ar1,ar2));
	epo.setText(Integer.toString(ap));
}
public void chart(int sales1,int  sales2, int sales3)
		{
	ObservableList<PieChart.Data> piedata= FXCollections.observableArrayList(
			new PieChart.Data("Product 1", sales1),
			new PieChart.Data("Product 2", sales2),
			new PieChart.Data("Main Product", sales3));
	 piechart.setData(piedata);
		}
               
}
