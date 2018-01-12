package at.fhhagenberg.sqe.controller;

import at.fhhagenberg.sqe.elevator.IElevatorSystem;
import javafx.beans.property.IntegerProperty;

public class ElevatorController
{
	private IElevatorSystem elevatorSystem;
	
	private IntegerProperty counter;
	
	public IntegerProperty counterProperty() {
	    return counter;
	}
}
