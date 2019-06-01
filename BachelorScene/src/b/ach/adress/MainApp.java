package b.ach.adress;
import java.io.IOException;
import java.time.Duration;
import org.reactfx.util.FxTimer;

import b.ach.adress.model.FinalMachine;
import b.ach.adress.model.Machine;
import b.ach.adress.model.RawMaterialsBox;
import b.ach.adress.view.MainController;
import b.ach.adress.view.OverController;
import b.ach.adress.view.RawController;
import b.ach.adress.view.StatController;
import b.ach.adress.view.WeeklyController;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
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

public class MainApp extends Application {
private Stage window;
private AnchorPane mainlayout;
private Machine[] Machines = {new Machine(15000,"maszyna1",1750),new Machine(7500,"maszyna2",625),new Machine(22500,"maszyna3",375),new Machine(22500,"maszyna4",750)};
private FinalMachine machinefinal = new FinalMachine(1562);
private int Cash = 1500;
private String a;
private RawController controler;
private StatController controler1;
private WeeklyController controler2;
private OverController controler3;
private  int machinesells1;
private int machinesells2;
private int finalmachinesells;
private int matsales;
private int netflow;




	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Challenge");
		InitLayout();
		
	}

	private void InitLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/mainscreen.fxml"));
			
				mainlayout = loader.load();
				Scene scene = new Scene(mainlayout);
				window.setScene(scene);
				window.show();
				window.setResizable(false);
				MainController controler = loader.getController();
				controler.setMainApp(this);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
			
		
	}
	public String ShowRaw(){
		try {
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/RawBox.fxml"));
			AnchorPane layout= loader.load();
			 controler = loader.getController();
			controler.make();
			a=(controler.display(layout));
			return a;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	}
	public void Statistics(){
	
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Statistics.fxml"));
			AnchorPane layout =loader.load();
			controler1 = loader.getController();
			controler1.make();
			controler1.display(layout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void Weekly(){
			
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("view/Weekly.fxml"));
				SplitPane layout =loader.load();
				controler2 = loader.getController();
				controler2.endweek(Cash);
				controler2.sales(machinesells1, machinesells2,finalmachinesells);
				controler2.mats(matsales);
				net();
				controler2.net(netflow);
				controler2.a(Machines[0].Getres(),Machines[0].Getproc());
				controler2.b(Machines[1].Getres(),Machines[1].Getproc());
				controler2.c(Machines[2].Getres(),Machines[2].Getproc());
				controler2.d(Machines[3].Getres(),Machines[3].Getproc());
				controler2.e(machinefinal.getres1(),machinefinal.getres2(),machinefinal.getproc());
				controler2.chart(machinesells1/30, machinesells2/40, finalmachinesells/50);
				controler2.make();
				
				controler2.display(layout);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
public void Weekly1(){
			
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("view/Weekly.fxml"));
				SplitPane layout =loader.load();
				controler2 = loader.getController();
				controler2.endweek(Cash);
				controler2.sales(machinesells1, machinesells2,finalmachinesells);
				controler2.mats(matsales);
				net1();
				controler2.net(netflow);
				controler2.a(Machines[0].Getres(),Machines[0].Getproc());
				controler2.b(Machines[1].Getres(),Machines[1].Getproc());
				controler2.c(Machines[2].Getres(),Machines[2].Getproc());
				controler2.d(Machines[3].Getres(),Machines[3].Getproc());
				controler2.e(machinefinal.getres1(),machinefinal.getres2(),machinefinal.getproc());
				controler2.chart(machinesells1/30, machinesells2/40, finalmachinesells/50);
				controler2.make();
				
				controler2.display(layout);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
		public void over()
		{
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("view/gameover.fxml"));
				VBox layout =loader.load();
				controler3 = loader.getController();
				controler3.make();
				controler3.display(layout);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
	public static void main(String[] args) {
		launch(args);
	}
	
	public Machine return1 ()
	{
		return Machines[0];	
	}
	public Machine return2 ()
	{
		return Machines[1];	
	}
	public Machine return3 ()
	{
		return Machines[2];	
	}
	public Machine return4 ()
	{
		return Machines[3];
	}
	public FinalMachine return5()
	{
		return machinefinal;
	}
	public int returnCash(){
		return Cash;
	}
	public boolean substract(RawController box,int amount)
	{	
		if(Cash-(amount*10)>=0)
		{ 
			Cash-=(amount*10);
			System.out.println("Cash remaining   "+Cash);
			matsales+=amount*10;
			return true;
		}else
		return false;
		}
	public RawController returncon()
	{
		return controler;
		
	}
	
	public void sell(Machine g,int am)
	{	
		Cash+=g.Getproc()*30;
		System.out.println(Cash);
		machinesells1=machinesells1+am*30;
		
	}
	public void sell1(Machine g,int am)
	{	
		Cash+=g.Getproc()*40;
		System.out.println(Cash);
		machinesells2=machinesells2+am*40;
		
	}
		public void sell(FinalMachine g)
		{
			Cash+=g.getproc()*60;
			System.out.println(Cash);
			finalmachinesells+=g.getproc()*50;
			
		}
	public void MachineProcess(int i)
	{
		Machines[i].resettime();
		Machines[i].getReady(Machines[i].returntimee());
		Machines[i].process();
		Machines[i].timepassed();
	}
	public void Setup(int i)
	{
		Machines[i].getReady(Machines[i].returntimee());
		Machines[i].process();
		Machines[i].timepassed();
		
		
	}
	public void Pause(int i )
	{
		Machines[i].timestop();
		Machines[i].cancel();
		if(Machines[i].returnready()==true){
		Machines[i].stopprocess();
		Machines[i].stoptimeprocessed();}
		
		
		
		
	}
	private void net()
	{
		netflow=machinesells1+machinesells2+finalmachinesells-matsales-2500;
	}
	private void net1()
	{
		netflow=machinesells1+machinesells2+finalmachinesells-matsales-5000;
	}
	public int netflow()
	{
		return netflow;
	}
	public OverController overr()
	{
		return controler3;
	}
	public void reset()
	{
		for(int i =0; i<Machines.length;i++){
		Machines[i].resetproc();
		Machines[i].resetres();
		}
		machinefinal.resetproc();
		machinefinal.resetres1();
		machinefinal.resetres2();
		Cash=1500;
	}
	public void setCash(int cash)
	{
		Cash= cash;
	}
}




