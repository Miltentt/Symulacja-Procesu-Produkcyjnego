package b.ach.adress.model;

import java.time.Duration;

import org.reactfx.util.FxTimer;
import org.reactfx.util.Timer;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Machine {
	public SimpleIntegerProperty resources= new SimpleIntegerProperty(this,"resources");
	public SimpleIntegerProperty processed = new SimpleIntegerProperty(this,"processed");
	public SimpleStringProperty Status= new SimpleStringProperty(this,"Status");
	private int timechanged;
	private int processtime;
	private String namee;
	private boolean ready = false;
	private int timepass=0;
	private Timer timer;
	private Timer getreadytimer;
	private Timer processtimer;
	private boolean timeron;
private Timer timer3;
private int timeprocessed=0;

	public Machine(int changetime, String name, int procestime) {
		timechanged = changetime;
		namee = name;
		processtime = procestime;
		processed.set(0);

	}

	public void send(int amount) {
		resources.set(resources.getValue()+amount);
	}
	public void getReady(int time_passed)
	{timeron=false;
	Status.set("Setting up...");
		getreadytimer =	FxTimer.runLater(Duration.ofMillis(timechanged-time_passed), () -> {
			ready = true;

		});
	}
	public void process() {
		timer3 = FxTimer.runPeriodically(Duration.ofMillis(1000), () -> { 
			timeprocessed++;
		});
		
		processtimer = FxTimer.runPeriodically(Duration.ofMillis(processtime), () -> {
			if (ready == true) {
				timeron= true;
				if (resources.getValue() > 0) {
					resources.set(resources.getValue()-1);
					processed.set(processed.getValue()+1);
					Status.set("Processing...");
				} else {
					Status.set("Waiting...");
					FxTimer.runPeriodically(Duration.ofMillis(processtime), () -> {});

				}
			}
		});
	}

	public int Getres() {
		return resources.getValue();

	}

	public int Getproc() {

		return processed.getValue();

	}



	public void cancel()
	{
		getreadytimer.stop();

	}
	public void timepassed()
	{
		timer = FxTimer.runPeriodically(Duration.ofMillis(5), () -> {
		timepass+=5;

		});
	}
	public void resettime(){
		timepass=0;
	}
	public void timestop(){

		timer.stop();
	}
	public int returntimee()
	{
		return timepass;

	}
	public void stopprocess()
	{
		processtimer.stop();
		timeron=false;
	}

	public void stop() {

		ready = false;

	}

	public String getName() {

		return namee;
	}


public void resetproc()
{
	processed.set(0);

}
public void resetres()
{
	resources.set(0);
}
public int returntime()
{
	return processtime;

}
public boolean returnready()
{

	return ready;
}
public int Getchangetime(){
	return timechanged;
}
public IntegerProperty GetPropres(){
	return resources;
}
public IntegerProperty GetProprproc(){
	return processed;
}
public boolean timieron()
{
	return timeron;
	
}
public StringProperty GetStatus()
{
	return Status;
	
}
public void resettimeprocessed()
{
	timeprocessed=0;
}
public int gettimeprocessed()
{
	return timeprocessed;
}
public void stoptimeprocessed()
{
	timer3.stop();
}
public void setproc(int x)
{
	processed.set(x);
}
}

