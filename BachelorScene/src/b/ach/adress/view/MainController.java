package b.ach.adress.view;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.reactfx.util.FxTimer;
import org.reactfx.util.Timer;

import b.ach.adress.MainApp;
import b.ach.adress.model.Gantt;
import b.ach.adress.model.Machine;
import b.ach.adress.model.RawMaterialsBox;
import b.ach.adress.model.Gantt.ExtraData;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainController {
	private String resource1;
	private int raw1;
	private int raw2;
	private String resource2;
	private MainApp mainapp;
	private int minutes, hours = 8;
	private String[] day = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
	private int i = 0;
	private String Cashh;
	private int j = 0;
	private Timer timer;
	private boolean mach1;
	private boolean mach2;
	private boolean mach3;
	private boolean mach4;
	private boolean gamestarted;
	private int product1=0;
	private int product2=0;
	private int mainproduct=0;
	private int mac2=0;
	private int mac4=0;
	private int mac1=0;
	private int mac3=0;
	private int week=1;
	private int mac5=0;
	private int totaltime=0;
	private Timer timer5;
	private int machine1tot;
	private int machine2tot;
	private int machine3tot;
	private int machine4tot;
	private int machine1time;
	private int machine2time;
	private int machine3time;
	private int machine4time;
	private Timer selltimer1;
	private Timer selltimer2;
private XYChart.Series series1 = new XYChart.Series();
private XYChart.Series series2 = new XYChart.Series();
final NumberAxis xAxis = new NumberAxis();
final CategoryAxis yAxis = new CategoryAxis();

final Gantt<Number,String> chart = new Gantt<Number,String>(xAxis,yAxis);

private Timer Gant1;
private Timer Gant2;
private Timer Gant3;
private Timer Gant4;
	@FXML
	private TextField res1;
	@FXML
	private TextField res2;
	@FXML
	private TextField m1processed;
	@FXML
	private TextField m2processed;
	@FXML
	private TextField final1;
	@FXML
	private TextField m3resources;
	@FXML
	private TextField m3processed;
	@FXML
	private TextField m4resources;
	@FXML
	private TextField m4processed;
	@FXML
	private TextField final2;
	@FXML
	private TextField final3;
	@FXML
	private Label cash;
	@FXML
	private TextField time;
	@FXML
	private TextField dayy;
	@FXML
	private TextField cashy;
	@FXML
	private Label State1;
	@FXML
	private Label State2;
	@FXML
	private Label State3;
	@FXML
	private Label State4;
	@FXML 
	private Button Button2;
	@FXML
	private TextField Product1;
	@FXML
	private TextField Product2;
	@FXML
	private TextField MainProduct;
	@FXML
	private Label Finale;
	@FXML
	private TextField Week;
	@FXML
	private Button butt1;
	@FXML
	private Button butt2;
	@FXML
	private Button butt3;
	@FXML
	private Button butt4;
	@FXML
	private Button butt5;
	@FXML
	private Button butt6;
	@FXML
	private Button butt7;
	

	@FXML
	private void initialize() {
		resource1 = "0";
		dayy.setText(day[0]);
		Cashh = Integer.toString(1500);
		cashy.setText(Cashh);
		 String[] machines = new String[] { "Machine 1", "Machine 2", "Machine 3" };

	        final NumberAxis xAxis = new NumberAxis();
	        final CategoryAxis yAxis = new CategoryAxis();

	        final Gantt<Number,String> chart = new Gantt<Number,String>(xAxis,yAxis);
	        xAxis.setLabel("");
	        xAxis.setTickLabelFill(Color.CHOCOLATE);
	        xAxis.setMinorTickCount(4);

	        yAxis.setLabel("");
	        yAxis.setTickLabelFill(Color.CHOCOLATE);
	        yAxis.setTickLabelGap(10);
	        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(machines)));

	        chart.setTitle("Machine Monitoring");
	        chart.setLegendVisible(false);
	        chart.setBlockHeight( 50);
		
	        Image crates = new Image(getClass().getResourceAsStream("crates75.jpg"),50,50,false,false);
		butt1.setGraphic(new ImageView(crates));
		 Image net = new Image(getClass().getResourceAsStream("metal75.jpg"),50,50,false,false);
			butt2.setGraphic(new ImageView(net));
			 Image m1 = new Image(getClass().getResourceAsStream("machine175.jpg"),50,50,false,false);
				butt3.setGraphic(new ImageView(m1));
				butt5.setGraphic(new ImageView(m1));
				 Image m2 = new Image(getClass().getResourceAsStream("machine575.png"),50,50,false,false);
					butt4.setGraphic(new ImageView(m2));
					butt6.setGraphic(new ImageView(m2));
					 Image m3 = new Image(getClass().getResourceAsStream("machine275.jpg"),50,50,false,false);
					 butt7.setGraphic(new ImageView(m3));
	}
	private void start()
	{
		

       
	}

	public void setMainApp(MainApp mainApp) {
		mainapp = mainApp;
	}

	public void Raw1() {
		m1processed.textProperty().bind(Bindings.convert(mainapp.return1().GetProprproc()));
		res1.textProperty().bind(Bindings.convert(mainapp.return1().GetPropres()));
		raw1 = Integer.parseInt(mainapp.ShowRaw());
		if (mainapp.substract(mainapp.returncon(), raw1) == true) {
			mainapp.return1().send(raw1);
			resource1 = Integer.toString(mainapp.return1().Getres());
			cash.setText(null);
			cashy.setText(Integer.toString(mainapp.returnCash()));
		} else {
			cash.setText("not enough cash");
		}

	}
	public void Raw2() {
		m2processed.textProperty().bind(Bindings.convert(mainapp.return2().GetProprproc()));
		res2.textProperty().bind(Bindings.convert(mainapp.return2().GetPropres()));
		
		m3processed.textProperty().bind(Bindings.convert(mainapp.return3().GetProprproc()));
		m3resources.textProperty().bind(Bindings.convert(mainapp.return3().GetPropres()));
		
		m4resources.textProperty().bind(Bindings.convert(mainapp.return4().GetPropres()));
		m4processed.textProperty().bind(Bindings.convert(mainapp.return4().GetProprproc()));

final1.textProperty().bind(Bindings.convert(mainapp.return5().GetPropres1()));
final2.textProperty().bind(Bindings.convert(mainapp.return5().GetPropres2()));
		final3.textProperty().bind(Bindings.convert(mainapp.return5().GetProprproc()));
		raw2 = Integer.parseInt(mainapp.ShowRaw());
		if (mainapp.substract(mainapp.returncon(), raw2) == true) {
			mainapp.return2().send(raw2);
			resource2 = Integer.toString(mainapp.return2().Getres());
			cash.setText(null);
			cashy.setText(Integer.toString(mainapp.returnCash()));

		} else {
			cash.setText("not enough cash");
		}
	}

	public void Machine1() {
	
		mach1=true;
		mach3=false;
		State1.setText("Setting up...");
		State3.setText("Idle");
		 FxTimer.runPeriodically(Duration.ofMillis(30), () -> {
				if(mainapp.return1().timieron()==true)
					State1.setText("Processing...");
					 });
		machine1tot=totaltime;
		
		if(gamestarted==true){
			Gant1 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
				machine1time++;
			});
			mac3=0;
			mac1++;
			series1.getData().add(new XYChart.Data(machine3tot, "Machine 1", new ExtraData(machine3time, "status-mach3")));
			if(machine3time>0){
			Gant3.stop();
			machine3time=0;
			}
			if (mainapp.return3().returntimee() > 0){
				if(mainapp.return3().timieron()==true)	{mainapp.return3().stopprocess();
				
				
				}
				mainapp.Pause(2);
				
				mainapp.return3().stop();
				mainapp.return3().resettimeprocessed();
			}
			if(mac1==1){
				
		mainapp.MachineProcess(0);
		
		}
		
		}
}

	public void Machine2() {
		
		mach2=true;
		mach4=false;
		State2.setText("Setting up...");
		State4.setText("Idle");
		 FxTimer.runPeriodically(Duration.ofMillis(30), () -> {
	if(mainapp.return2().timieron()==true)
		State2.setText("Processing...");
		 });
		 machine2tot=totaltime;
		
		
		
		if(gamestarted==true){
			Gant2 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
				machine2time++;
			});
			mac4=0;
			mac2++;
			series2.getData().add(new XYChart.Data(machine4tot, "Machine 2", new ExtraData(machine4time, "status-mach4")));
			if(machine4time>0){
			Gant4.stop();
			machine4time=0;
			}
			if (mainapp.return4().returntimee() > 0){
				if(mainapp.return4().timieron()==true) {mainapp.return4().stopprocess();
				
				}
				mainapp.Pause(3);
				
				mainapp.return4().stop();
				mainapp.return4().resettimeprocessed();
			}
			if(mac2==1){
				
		mainapp.MachineProcess(1);
		
		}
		
		}
}
		
	public void Machine4() {
		
		mach2=false;
		mach4=true;
		State4.setText("Setting up...");
		State2.setText("Idle");
		 FxTimer.runPeriodically(Duration.ofMillis(30), () -> {
				if(mainapp.return4().timieron()==true)
					State4.setText("Processing...");
		 });
		 machine4tot=totaltime;
			if(gamestarted==true){
				Gant4 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
					machine4time++;
				});
				mac2=0;
				mac4++;
				series2.getData().add(new XYChart.Data(machine2tot, "Machine 2", new ExtraData( machine2time, "status-mach2")));
				if(machine2time>0){
				Gant2.stop();
				machine2time=0;}
				if (mainapp.return2().returntimee() > 0){
					if(mainapp.return2().timieron()==true) {mainapp.return2().stopprocess();
					
					}
					mainapp.Pause(1);
					mainapp.return2().stop();
					
				}
				if(mac4==1){
					
			mainapp.MachineProcess(3);	
				}}	


		}
	public void Machine3() {
		
		mach3=true;
		mach1=false;
		State3.setText("Setting up...");
		State1.setText("Idle");
		 FxTimer.runPeriodically(Duration.ofMillis(30), () -> {
				if(mainapp.return3().timieron()==true)
					State3.setText("Processing...");
					 });
		machine3tot=totaltime;
		
		if(gamestarted==true){
			Gant3 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
				machine3time++;
			});
			mac1=0;
			mac3++;
			series1.getData().add(new XYChart.Data(machine1tot, "Machine 1", new ExtraData(machine1time, "status-mach1")));
			if(machine1time>0){
			Gant1.stop();
			machine1time=0;}
			if (mainapp.return1().returntimee() > 0){
				if(mainapp.return1().timieron()==true)	{mainapp.return1().stopprocess();
				
				}
				mainapp.Pause(0);
				
				mainapp.return1().stop();
				
			}
			if(mac3==1){
				
		mainapp.MachineProcess(2);
		
		}
		
		}
}
	

	public void FinalMachine() {
		mainapp.return5().process();
Finale.setText("Processing...");
mac5=1;
	}

	public void Send1() {
		mainapp.return5().send1(mainapp.return1());
		mainapp.return1().resetproc();
		
	}

	public void Send2() {
		mainapp.return3().send(mainapp.return2().Getproc());
		mainapp.return2().resetproc();
	}

	public void Send3() {
		mainapp.return4().send(mainapp.return3().Getproc());
		mainapp.return3().resetproc();
		
	}

	public void Send4() {
		mainapp.return4().send(mainapp.return3().Getproc());
		mainapp.return3().resetproc();
		
	}

	public void Send5() {
		mainapp.return5().send2(mainapp.return4());
		mainapp.return4().resetproc();
		
	}

	public void Sell1() {
		int am;
		if(mainproduct>product1){
			if(mainapp.return1().Getproc()>(mainproduct-product1))
				  am=mainproduct-product1;
			else
				am=mainapp.return1().Getproc();
		mainapp.sell1(mainapp.return1(),am);
		product1+=am;
		mainapp.return1().setproc(mainapp.return1().Getproc()-am);
		Product1.setText(Integer.toString(product1));
		cashy.setText(Integer.toString(mainapp.returnCash()));
	}}

	public void Sell2() {
		int am;
		if(mainproduct>product2){
			if(mainapp.return4().Getproc()>(mainproduct-product2))
				  am=mainproduct-product2;
			else
				am=mainapp.return4().Getproc();
		mainapp.sell(mainapp.return4(),am);
		product2+=am;
		mainapp.return4().setproc(mainapp.return4().Getproc()-am);
		Product2.setText(Integer.toString(product2));
		cashy.setText(Integer.toString(mainapp.returnCash()));
	}}

	public void Sell3() {
		mainapp.sell(mainapp.return5());
		mainproduct+=mainapp.return5().getproc();
		mainapp.return5().resetproc();
		MainProduct.setText(Integer.toString(mainproduct));
		cashy.setText(Integer.toString(mainapp.returnCash()));
	}

	public void Start() {
gamestarted=true;

		j++;
		if (j == 1) {
			timer();
			StartPause();
		}
		if (j == -99) {
			gamestarted=true;
			timer();
			if(mac5==1 && mainapp.return5().returntimer()==false)
			{
				mainapp.return5().process();
			}
			if(machine2time>0)
			{
				Gant2 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
					machine2time++;
				});
			}
			if(machine1time>0)
			{
				Gant1 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
					machine1time++;
				});
			}
			if(machine3time>0)
			{
				Gant3 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
					machine3time++;
				});
			}
			if(machine4time>0)
			{
				Gant4 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
					machine4time++;
				});
			}
			if (mach1 == true) {
				if(mainapp.return1().returnready()==true)
				{
					mainapp.return1().process();
					
				}else 
			
				mainapp.return1().getReady(mainapp.return1().returntimee());
				mainapp.return1().timepassed();
			}
			
			if (mach2 ==true) { 
				if(mainapp.return2().returnready()==true)
				{
					mainapp.return2().process();
					
				}
				else
				{
				
				mainapp.return2().getReady(mainapp.return2().returntimee());
				mainapp.return2().timepassed();
				}
			}
			if (mach3 == true) {
				if(mainapp.return3().returnready()==true)
				{
					mainapp.return3().process();
					
				} else {
				mainapp.return3().getReady(mainapp.return3().returntimee());
				mainapp.return3().timepassed();
				
			}
			}
			if (mach4 ==true) {
				if(mainapp.return4().returnready()==true)
				{
					mainapp.return4().process();
					
				} else {
			
				mainapp.return4().getReady(mainapp.return4().returntimee());
				mainapp.return4().timepassed();
				}
			}
		}
	}

	public void Pause() {
gamestarted=false;
	timerpause();
		if (mainapp.return1().returntimee() > 0) {
			mainapp.Pause(0);
		}
		if (mainapp.return2().returntimee() > 0) {
			mainapp.Pause(1);
		}
		if (mainapp.return3().returntimee() > 0) {
			mainapp.Pause(2);
		}
		if (mainapp.return4().returntimee() > 0) {
			mainapp.Pause(3);
		}
		if(mainapp.return5().returntimer()==true)
			mainapp.return5().processstop();
		if(machine2time>0)
		{
			Gant2.stop();
		}
		if(machine1time>0)
		{
			Gant1.stop();
		}
		if(machine3time>0)
		{
			Gant3.stop();
		}
		if(machine4time>0)
		{
			Gant4.stop();
		}
		j = -100;
	}
	
	public void ShowStat(){
		
		
		mainapp.Statistics();
	}
	
	public void ShowWeekly()
	{
		mainapp.Weekly();
		
	}
	public void ShowWeekly1()
	{
		mainapp.Weekly1();
		
	}
	private  void timer()
	{
		timer5 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> {
			
			totaltime++;
		});
		timer = FxTimer.runPeriodically(Duration.ofMillis(80), () -> {
			minutes++;
			if (minutes == 60) {
				minutes = 0;
				hours++;
			}
			if(minutes<10 && hours<10)
				time.setText(String.format(" 0%d : 0%d", hours, minutes));
			else if(minutes<10 && hours >=10)
				time.setText(String.format(" %d : 0%d", hours, minutes));
			else if(minutes>=10 && hours<10)
				time.setText(String.format(" 0%d : %d", hours, minutes));
				else
				time.setText(String.format(" %d : %d", hours, minutes));
			if (hours == 16 && day[i]!="Friday") {
				i++;
				dayy.setText(day[i]);
				hours = 8;
				minutes = 0;
				
				
			}
			if(day[i]=="Friday" && hours==16 && week==1)
			{
				i=0;
				dayy.setText(day[i]);
				hours = 8;
				minutes = 0;
				week=2;
				Week.setText(Integer.toString(week));
				        
mainapp.setCash(mainapp.returnCash()-2500);
cashy.setText(Integer.toString(mainapp.returnCash()));
		      
		       
				Pause();
				ShowWeekly();
				if(mainapp.returnCash()<0)
				{
					
				mainapp.over();
				mainapp.reset();
				Product1.setText(Integer.toString(0));
				Product2.setText(Integer.toString(0));
				MainProduct.setText(Integer.toString(0));
				cashy.setText(Integer.toString(mainapp.returnCash()));
				
				}
			}
			if(day[i]=="Friday" && hours==16 && week==2)
			{
				
				Pause();
				ShowWeekly1();
				  chart.getStylesheets().add(getClass().getResource("ganttchart.css").toExternalForm());

			        Scene scene  = new Scene(chart);
				Stage stage= new Stage();
				chart.getData().addAll(series1, series2);
				 stage.setScene(scene);
			        stage.show();
			        if(machine2time>0)
					{
			        	series2.getData().add(new XYChart.Data(machine2tot, "Machine 2", new ExtraData( machine2time, "status-mach2")));
					}
			        if(machine1time>0)
					{
			        	series1.getData().add(new XYChart.Data(machine1tot, "Machine 1", new ExtraData( machine1time, "status-mach1")));
					}
			        if(machine3time>0)
					{
			        	series1.getData().add(new XYChart.Data(machine3tot, "Machine 1", new ExtraData( machine3time, "status-mach3")));
					}
			        if(machine4time>0)
					{
			        	series2.getData().add(new XYChart.Data(machine4tot, "Machine 2", new ExtraData( machine4time, "status-mach4")));
					}
				if(mainapp.netflow()<0)
				{
				mainapp.over();
				mainapp.reset();
				Product1.setText(Integer.toString(0));
				Product2.setText(Integer.toString(0));
				MainProduct.setText(Integer.toString(0));
				cashy.setText(Integer.toString(mainapp.returnCash()));
				}
				else {
					
					mainapp.reset();
					Product1.setText(Integer.toString(0));
					Product2.setText(Integer.toString(0));
					MainProduct.setText(Integer.toString(0));
					cashy.setText(Integer.toString(mainapp.returnCash()));
				}
				
			}
		});
		
		
		
		
		
		
	}
	private void timerpause()
	{
		timer.stop();
		timer5.stop();
		if(minutes<10 && hours<10)
			time.setText(String.format(" 0%d : 0%d", hours, minutes));
		else if(minutes<10 && hours >=10)
			time.setText(String.format(" %d : 0%d", hours, minutes));
		else if(minutes>=10 && hours<10)
			time.setText(String.format(" 0%d : %d", hours, minutes));
			else time.setText(String.format(" %d : %d", hours, minutes));
	}
	private void StartPause()
	{
		if(mach2==true){
			mac2=1;
			mainapp.MachineProcess(1);	
			Gant2 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
				machine2time++;
			});
			
			}
if(mach4==true){

			mac4=1;
			mainapp.MachineProcess(3);
			Gant4 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
				machine4time++;
			});
			}
if(mach3==true){

	mac3=1;
	mainapp.MachineProcess(2);
	Gant3 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
		machine3time++;
	});
	
	}
if(mach1==true){

	mac1=1;
	mainapp.MachineProcess(0);
	Gant1 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
		machine1time++;
	});
	}
	}
	
	
}
