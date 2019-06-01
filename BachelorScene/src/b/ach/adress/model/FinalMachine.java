package b.ach.adress.model;

import java.time.Duration;

import org.reactfx.util.FxTimer;
import org.reactfx.util.Timer;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class FinalMachine {
	public SimpleIntegerProperty resources1= new SimpleIntegerProperty(this,"resources");
	public SimpleIntegerProperty processed = new SimpleIntegerProperty(this,"processed");
	public SimpleIntegerProperty resources2= new SimpleIntegerProperty(this,"resources");
private boolean timeron=false;
private int processt;
private Timer timer;

public FinalMachine(int processtime)
{
	processt=processtime;
}
public void send1(Machine m1)
{  
	
	resources1.set(m1.Getproc()+resources1.getValue());
	
}

public void send2(Machine m2)
{
	resources2.set(m2.Getproc()+resources2.getValue());
	
}

public void process()
{
	timeron=true;
timer=	FxTimer.runPeriodically(
	        Duration.ofMillis(processt),
	        () -> {
	        	if(resources1.getValue()>0 && resources2.getValue()>0)
	        	{
	        		resources1.set(resources1.getValue()-1);
	        		resources2.set(resources2.getValue()-1);
	        		processed.set(processed.getValue()+1);
	        	}
	        	else
	        	{
	        		
	        	}
	        	       	        	
	        });
	

}
public void processstop()
{
	timer.stop();
	timeron=false;
}
public boolean returntimer()
{
	return timeron;
}
public int getres1()
{
	return resources1.getValue();
}
public int getres2()
{
	return resources2.getValue();
}
public int getproc()
{
	return processed.getValue();
}	
public void resetproc()
{
	processed.set(0);
}
public void resetres1()
{
	resources1.set(0);
}
public void resetres2()
{
	resources2.set(0);
}
public IntegerProperty GetPropres1(){
	return resources1;
}
public IntegerProperty GetProprproc(){
	return processed;
}
public IntegerProperty GetPropres2(){
	return resources2;
}
}