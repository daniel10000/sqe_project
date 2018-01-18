package at.fhhagenberg.sqe.controller;

import java.io.Console;

import javax.activity.InvalidActivityException;

import at.fhhagenberg.sqe.data.DataUpdater;
import at.fhhagenberg.sqe.data.DoorStatus;
import at.fhhagenberg.sqe.data.ElevatorNotifyable;
import at.fhhagenberg.sqe.elevator.ElevatorSystemDummy;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class ElevatorController implements ElevatorNotifyable
{
	private static final int ELEVATOR_NUM = 3;
	private static final int FLOOR_NUM = 4;
	
	private Commandable currentCommander = null;
	
	private DataUpdater updater = new DataUpdater(new ElevatorSystemDummy());
	
	public ElevatorController()
	{
		updater.registerElevator(this);
		updater.start();
	}
	
	@FXML
	Rectangle elevator1Floor3;
	
	@FXML
	Rectangle elevator1Floor2;
	
	@FXML
	Rectangle elevator1Floor1;
	
	@FXML
	Rectangle elevator1Floor0;
	
		
	@FXML
	Rectangle elevator2Floor3;
	
	@FXML
	Rectangle elevator2Floor2;
	
	@FXML
	Rectangle elevator2Floor1;
	
	@FXML
	Rectangle elevator2Floor0;
	
	
	@FXML
	Rectangle elevator3Floor3;
	
	@FXML
	Rectangle elevator3Floor2;
	
	@FXML
	Rectangle elevator3Floor1;
	
	@FXML
	Rectangle elevator3Floor0;
	
	@FXML
	TextField textFieldElevatorNr;
	
	@FXML
	TextField textFieldSpeed;
	
	@FXML
	TextField textFieldAcceleration;
	
	@FXML
	TextField textFieldWeight;
		
	@FXML
	TextField textFieldCapacity;
	
	@FXML
	ImageView floor3UpButton;
	
	@FXML
	ImageView floor3DownButton;
	
	@FXML
	ImageView floor2UpButton;
	
	@FXML
	ImageView floor2DownButton;
	
	@FXML
	ImageView floor1UpButton;
	
	@FXML
	ImageView floor1DownButton;
	
	
	@FXML
	ImageView floor0UpButton;
	
	@FXML
	ImageView floor0DownButton;
	
	@FXML
	Rectangle elevator1SelectedFloor3;
	
	@FXML
	Rectangle elevator1SelectedFloor2;
	
	@FXML
	Rectangle elevator1SelectedFloor1;
	
	@FXML
	Rectangle elevator1SelectedFloor0;
	
	@FXML
	Rectangle elevator2SelectedFloor3;
	
	@FXML
	Rectangle elevator2SelectedFloor2;
	
	@FXML
	Rectangle elevator2SelectedFloor1;
	
	@FXML
	Rectangle elevator2SelectedFloor0;
	
	@FXML
	Rectangle elevator3SelectedFloor3;
	
	@FXML
	Rectangle elevator3SelectedFloor2;
	
	@FXML
	Rectangle elevator3SelectedFloor1;
	
	@FXML
	Rectangle elevator3SelectedFloor0;
	
	@FXML
	ImageView elevator1Direction;
	
	@FXML
	ImageView elevator2Direction;
	
	@FXML
	ImageView elevator3Direction;
		
	@FXML
	protected void elevator1Pressed() 
	{
		textFieldElevatorNr.setText("1");
	}
	
	@FXML
	protected void elevator2Pressed() 
	{
		textFieldElevatorNr.setText("2");
	}
	
	@FXML
	protected void elevator3Pressed() 
	{
		textFieldElevatorNr.setText("3");
	}
	
	@FXML
	protected void elevator1Pressed0()
	{
		try
		{
			updater.getElevatorSystem().setTarget(0, 0);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator1Pressed1()
	{
		try
		{
			updater.getElevatorSystem().setTarget(0, 1);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator1Pressed2()
	{
		try
		{
			updater.getElevatorSystem().setTarget(0, 2);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator1Pressed3()
	{
		try
		{
			updater.getElevatorSystem().setTarget(0, 3);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator2Pressed0()
	{
		System.out.println("elevator 2 0");
	}
	
	@FXML
	protected void elevator2Pressed1()
	{
		System.out.println("elevator 2 1");
	}
	
	@FXML
	protected void elevator2Pressed2()
	{
		System.out.println("elevator 2 2");
	}
	
	@FXML
	protected void elevator2Pressed3()
	{
		System.out.println("elevator 2 3");
	}
	
	@FXML
	protected void elevator3Pressed0()
	{
		System.out.println("elevator 3 0");
	}
	
	@FXML
	protected void elevator3Pressed1()
	{
		System.out.println("elevator 3 1");	
	}
	
	@FXML
	protected void elevator3Pressed2()
	{
		System.out.println("elevator 3 2");	
	}
	
	@FXML
	protected void elevator3Pressed3()
	{
		System.out.println("elevator 3 3");
	}
	
	private IntegerProperty counter;
	
	public IntegerProperty counterProperty() {
	    return counter;
	}	
		
	private Rectangle getRect(int nr, int floor)
	{
		switch(nr)
		{
		case 0:
			switch(floor)
			{
			case 0: return elevator1Floor0;
			case 1: return elevator1Floor1;
			case 2: return elevator1Floor2;
			case 3: return elevator1Floor3;
			}
		case 1:
			switch(floor)
			{
			case 0: return elevator2Floor0;
			case 1: return elevator2Floor1;
			case 2: return elevator2Floor2;
			case 3: return elevator2Floor3;
			}
		case 2:
			switch(floor)
			{
			case 0: return elevator3Floor0;
			case 1: return elevator3Floor1;
			case 2: return elevator3Floor2;
			case 3: return elevator3Floor3;
			}
		}
		return null;
	}

	@Override
	public void commitedDirectionChanged(int nr, int direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accelChanged(int nr, int accel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonChanged(int nr, int floor, boolean active) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doorStatusChanged(int nr, int floor, DoorStatus status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void floorChanged(int nr, int floor)
	{
		for(int i = 0; i < FLOOR_NUM; i++)
			getRect(nr, i).setFill(Color.WHITE);
		getRect(nr, floor).setFill(Color.YELLOW);
	}

	@Override
	public void positionChanged(int nr, int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speedChanged(int nr, int speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void weightChanged(int nr, int weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void capacityChanged(int nr, int capacity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonUpChanged(int floor, boolean active) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonDownChanged(int floor, boolean active) {
		// TODO Auto-generated method stub
		
	}
}
