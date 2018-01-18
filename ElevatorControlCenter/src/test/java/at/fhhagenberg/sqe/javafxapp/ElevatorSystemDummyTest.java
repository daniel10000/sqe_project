package at.fhhagenberg.sqe.javafxapp;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import at.fhhagenberg.sqe.elevator.ElevatorSystemDummy;

public class ElevatorSystemDummyTest 
{
	public final static int ELEVATOR_DOORS_OPEN = 1;
	public final static int ELEVATOR_DOORS_CLOSED = 2;
	public final static int ELEVATOR_DOORS_OPENING = 3;
	public final static int ELEVATOR_DOORS_CLOSING = 4;
		
	public final static int ELEVATOR_DIRECTION_UP = 0;
	public final static int ELEVATOR_DIRECTION_DOWN = 1;
	public final static int ELEVATOR_DIRECTION_UNCOMMITTED = 2;		
	
	private static final Integer ElevatorNr0 = 0;
	private static final Integer ElevatorNr1 = 0;
	private static final Integer ElevatorNr2 = 0;
	
	ElevatorSystemDummy elevatorSystemDummy;
	
	@Before
	public void setup() 
	{
		elevatorSystemDummy = new ElevatorSystemDummy();
	}
	
	@Test
	public void testGetCommittedDirection() throws RemoteException 
	{
		int committedDirection = elevatorSystemDummy.getCommittedDirection(ElevatorNr0);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, committedDirection);
	}

	@Test
	public void testGetElevatorAccel() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetElevatorButton() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetElevatorDoorStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetElevatorFloor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetElevatorNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetElevatorPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetElevatorSpeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetElevatorWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetElevatorCapacity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFloorButtonDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFloorButtonUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFloorHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFloorNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServicesFloors() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTarget() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCommittedDirection() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetServicesFloors() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTarget() throws RemoteException 
	{
		int elevatorNumber = 2;
		int target = 2;
		int acceleration = 0;
		//fail("Not yet implemented");
		acceleration = elevatorSystemDummy.getElevatorAccel(0);
		
		elevatorSystemDummy.setTarget(elevatorNumber, target);
	}

	@Test
	public void testGetClockTick() 
	{
		fail("Not yet implemented");
	}

}
