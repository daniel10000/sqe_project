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
	
	private static final String UNIT_ACCEL = "";
	private static final String UNIT_SPEED = "";
	private static final String UNIT_WEIGHT = "";
	
	private static final int INIT_FLOOR = 0;
	
	private Commandable currentCommander = null;
	
	private DataUpdater updater = new DataUpdater(new ElevatorSystemDummy());
	
	public ElevatorController()
	{
//		setSelectedElevator(INIT_FLOOR);
		
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
		
	private int selectedElevator;
	
	@FXML
	protected void elevator1Pressed() 
	{
		setSelectedElevator(0);
		textFieldElevatorNr.setText("1");
		selectedElevator = 0;
	}
	
	@FXML
	protected void elevator2Pressed() 
	{
		textFieldElevatorNr.setText("2");
		selectedElevator = 1;
	}
	
	@FXML
	protected void elevator3Pressed() 
	{
		textFieldElevatorNr.setText("3");
		selectedElevator = 2;
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
		try
		{
			updater.getElevatorSystem().setTarget(1, 0);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator2Pressed1()
	{
		try
		{
			updater.getElevatorSystem().setTarget(1, 1);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator2Pressed2()
	{
		try
		{
			updater.getElevatorSystem().setTarget(1, 2);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator2Pressed3()
	{
		try
		{
			updater.getElevatorSystem().setTarget(1, 3);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator3Pressed0()
	{
		try
		{
			updater.getElevatorSystem().setTarget(2, 0);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator3Pressed1()
	{
		try
		{
			updater.getElevatorSystem().setTarget(2, 1);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator3Pressed2()
	{
		try
		{
			updater.getElevatorSystem().setTarget(2, 2);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	@FXML
	protected void elevator3Pressed3()
	{
		try
		{
			updater.getElevatorSystem().setTarget(2, 3);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	private IntegerProperty counter;
	
	public IntegerProperty counterProperty()
	{
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
	public void commitedDirectionChanged(int nr, int direction)
	{
		// TODO
	}

	@Override
	public void accelChanged(int nr, int accel)
	{
		if(nr == selectedElevator)
		{
			setAccel(accel);
		}
	}

	@Override
	public void buttonChanged(int nr, int floor, boolean active)
	{
		//TODO
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
	public void speedChanged(int nr, int speed)
	{
		if(nr == selectedElevator)
		{
			setSpeed(speed);
		}
	}

	@Override
	public void weightChanged(int nr, int weight)
	{
		if(nr == selectedElevator)
		{
			setWeight(weight);
		}
	}

	@Override
	public void capacityChanged(int nr, int capacity)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonUpChanged(int floor, boolean active)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonDownChanged(int floor, boolean active)
	{
		// TODO Auto-generated method stub
	}
	
	
	private void setAccel(int accel)
	{
		textFieldAcceleration.setText(accel + " " + UNIT_ACCEL);
	}
	
	private void setSpeed(int speed)
	{
		textFieldSpeed.setText(speed + " " + UNIT_SPEED);
	}
	
	private void setWeight(int weight)
	{
		textFieldWeight.setText(weight + " " + UNIT_WEIGHT);
	}
	
	private void setSelectedElevator(int elevator)
	{
		selectedElevator = elevator;
		textFieldElevatorNr.setText(Integer.toString(elevator+1));
	}
}







