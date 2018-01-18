package at.fhhagenberg.sqe.javafxapp;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import at.fhhagenberg.sqe.elevator.ElevatorSystemDummy;

public class ElevatorSystemDummyTest 
{
	private final static int ELEVATORS = 3;
	private final static int FLOORS = 4;
	private final static int ELEVATOR_CAPACITY = 10;
	private final static int FLOOR_HEIGHT = 7;
	
	private final static int ELEVATOR_DOORS_OPEN = 1;
	private final static int ELEVATOR_DOORS_CLOSED = 2;
	private final static int ELEVATOR_DOORS_OPENING = 3;
	private final static int ELEVATOR_DOORS_CLOSING = 4;
		
	private final static int ELEVATOR_DIRECTION_UP = 0;
	private final static int ELEVATOR_DIRECTION_DOWN = 1;
	private final static int ELEVATOR_DIRECTION_UNCOMMITTED = 2;		
	
	private final static Integer Elevator0 = 0;
	private final static Integer Elevator1 = 0;
	private final static Integer Elevator2 = 0;
	
	private final static Integer Floor0 = 0;
	private final static Integer Floor1 = 0;
	private final static Integer Floor2 = 0;
	private final static Integer Floor3 = 0;
	
	ElevatorSystemDummy elevatorSystemDummy;
	
	@Before
	public void setup() 
	{
		elevatorSystemDummy = new ElevatorSystemDummy();
	}
	
	@Test
	public void testGetCommittedDirection() throws RemoteException 
	{
		int elevator0committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator0);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator0committedDirection);
		
		int elevator1committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator1);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator1committedDirection);
		
		int elevator2committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator2);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator2committedDirection);		
	}

	@Test
	public void testGetElevatorAccel() throws RemoteException 
	{
		int initialAcceleration = 0;
		int elevator0Acceleration = elevatorSystemDummy.getElevatorAccel(Elevator0);
		assertEquals(initialAcceleration, elevator0Acceleration);
		
		int elevator1Acceleration = elevatorSystemDummy.getElevatorAccel(Elevator1);
		assertEquals(initialAcceleration, elevator1Acceleration);
		
		int elevator2Acceleration = elevatorSystemDummy.getElevatorAccel(Elevator2);
		assertEquals(initialAcceleration, elevator2Acceleration);
	}

	@Test
	public void testGetElevatorButton() throws RemoteException 
	{
		boolean elevator0FloorButton0 = elevatorSystemDummy.getElevatorButton(Elevator0, Floor0);
		assertFalse(elevator0FloorButton0);
		
		boolean elevator0FloorButton1 = elevatorSystemDummy.getElevatorButton(Elevator0, Floor1);
		assertFalse(elevator0FloorButton1);
		
		boolean elevator0FloorButton2 = elevatorSystemDummy.getElevatorButton(Elevator0, Floor2);
		assertFalse(elevator0FloorButton2);
		
		boolean elevator0FloorButton3 = elevatorSystemDummy.getElevatorButton(Elevator0, Floor3);
		assertFalse(elevator0FloorButton3);
		
		
		boolean elevator1FloorButton0 = elevatorSystemDummy.getElevatorButton(Elevator1, Floor0);
		assertFalse(elevator1FloorButton0);
		
		boolean elevator1FloorButton1 = elevatorSystemDummy.getElevatorButton(Elevator1, Floor1);
		assertFalse(elevator1FloorButton1);
		
		boolean elevator1FloorButton2 = elevatorSystemDummy.getElevatorButton(Elevator1, Floor2);
		assertFalse(elevator1FloorButton2);
		
		boolean elevator1FloorButton3 = elevatorSystemDummy.getElevatorButton(Elevator1, Floor3);
		assertFalse(elevator1FloorButton3);
		
		
		boolean elevator2FloorButton0 = elevatorSystemDummy.getElevatorButton(Elevator2, Floor0);
		assertFalse(elevator2FloorButton0);
		
		boolean elevator2FloorButton1 = elevatorSystemDummy.getElevatorButton(Elevator2, Floor1);
		assertFalse(elevator2FloorButton1);
		
		boolean elevator2FloorButton2 = elevatorSystemDummy.getElevatorButton(Elevator2, Floor2);
		assertFalse(elevator2FloorButton2);
		
		boolean elevator2FloorButton3 = elevatorSystemDummy.getElevatorButton(Elevator2, Floor3);
		assertFalse(elevator2FloorButton3);
	}

	@Test
	public void testGetElevatorDoorStatus() throws RemoteException 
	{
		int elevator0DoorStatus = elevatorSystemDummy.getElevatorDoorStatus(Elevator0);
		assertEquals(ELEVATOR_DOORS_CLOSED, elevator0DoorStatus);
		
		int elevator1DoorStatus = elevatorSystemDummy.getElevatorDoorStatus(Elevator1);
		assertEquals(ELEVATOR_DOORS_CLOSED, elevator1DoorStatus);
		
		int elevator2DoorStatus = elevatorSystemDummy.getElevatorDoorStatus(Elevator2);
		assertEquals(ELEVATOR_DOORS_CLOSED, elevator2DoorStatus);
	}

	@Test
	public void testGetElevatorFloor() throws RemoteException 
	{
		int initialFloor = 0;
		int elevator0CurrentFloor = elevatorSystemDummy.getElevatorFloor(Elevator0);
		assertEquals(initialFloor, elevator0CurrentFloor);
		
		int elevator1CurrentFloor = elevatorSystemDummy.getElevatorFloor(Elevator1);
		assertEquals(initialFloor, elevator1CurrentFloor);
		
		int elevator2CurrentFloor = elevatorSystemDummy.getElevatorFloor(Elevator2);
		assertEquals(initialFloor, elevator2CurrentFloor);
	}

	@Test
	public void testGetElevatorNum() throws RemoteException 
	{
		int elevators = elevatorSystemDummy.getElevatorNum();
		assertEquals(ELEVATORS, elevators);
	}

	@Test
	public void testGetElevatorPosition() throws RemoteException
	{
		int initialHeight = 0;
		int elevator0HeightPosition = elevatorSystemDummy.getElevatorPosition(Elevator0);
		assertEquals(initialHeight, elevator0HeightPosition);
		
		int elevator1HeightPosition = elevatorSystemDummy.getElevatorPosition(Elevator1);
		assertEquals(initialHeight, elevator1HeightPosition);
		
		int elevator2HeightPosition = elevatorSystemDummy.getElevatorPosition(Elevator2);
		assertEquals(initialHeight, elevator2HeightPosition);
	}

	@Test
	public void testGetElevatorSpeed() throws RemoteException 
	{
		int initialSpeed = 0;
		int elevator0Speed = elevatorSystemDummy.getElevatorSpeed(Elevator0);
		assertEquals(initialSpeed, elevator0Speed);
		
		int elevator1Speed = elevatorSystemDummy.getElevatorSpeed(Elevator1);
		assertEquals(initialSpeed, elevator1Speed);
		
		int elevator2Speed = elevatorSystemDummy.getElevatorSpeed(Elevator2);
		assertEquals(initialSpeed, elevator2Speed);
	}

	@Test
	public void testGetElevatorWeight() throws RemoteException 
	{
		int initialWeight = 0;
		int elevator0Weight = elevatorSystemDummy.getElevatorWeight(Elevator0);
		assertEquals(initialWeight, elevator0Weight);
		
		int elevator1Weight = elevatorSystemDummy.getElevatorWeight(Elevator1);
		assertEquals(initialWeight, elevator1Weight);
		
		int elevator2Weight = elevatorSystemDummy.getElevatorWeight(Elevator2);
		assertEquals(initialWeight, elevator2Weight);
	}

	@Test
	public void testGetElevatorCapacity() throws RemoteException
	{
		int elevator0Capacity = elevatorSystemDummy.getElevatorCapacity(Elevator0);
		assertEquals(ELEVATOR_CAPACITY, elevator0Capacity);
		
		int elevator1Capacity = elevatorSystemDummy.getElevatorCapacity(Elevator1);
		assertEquals(ELEVATOR_CAPACITY, elevator1Capacity);
		
		int elevator2Capacity = elevatorSystemDummy.getElevatorCapacity(Elevator2);
		assertEquals(ELEVATOR_CAPACITY, elevator2Capacity);
	}

	@Test
	public void testGetFloorButtonDown() throws RemoteException 
	{
		boolean floor0ButtonDown = elevatorSystemDummy.getFloorButtonDown(Floor0);
		assertFalse(floor0ButtonDown);
		
		boolean floor1ButtonDown = elevatorSystemDummy.getFloorButtonDown(Floor1);
		assertFalse(floor1ButtonDown);
		
		boolean floor2ButtonDown = elevatorSystemDummy.getFloorButtonDown(Floor2);
		assertFalse(floor2ButtonDown);
		
		boolean floor3ButtonDown = elevatorSystemDummy.getFloorButtonDown(Floor3);
		assertFalse(floor3ButtonDown);
	}

	@Test
	public void testGetFloorButtonUp() throws RemoteException 
	{
		boolean floor0ButtonUp = elevatorSystemDummy.getFloorButtonUp(Floor0);
		assertFalse(floor0ButtonUp);
		
		boolean floor1ButtonUp = elevatorSystemDummy.getFloorButtonUp(Floor1);
		assertFalse(floor1ButtonUp);
		
		boolean floor2ButtonUp = elevatorSystemDummy.getFloorButtonUp(Floor2);
		assertFalse(floor2ButtonUp);
		
		boolean floor3ButtonUp = elevatorSystemDummy.getFloorButtonUp(Floor3);
		assertFalse(floor3ButtonUp);
	}

	@Test
	public void testGetFloorHeight() throws RemoteException 
	{
		int floorHeight = elevatorSystemDummy.getFloorHeight();
		assertEquals(FLOOR_HEIGHT, floorHeight);
	}

	@Test
	public void testGetFloorNum() throws RemoteException 
	{
		int floors = elevatorSystemDummy.getFloorNum();
		assertEquals(FLOORS, floors);
	}

	@Test
	public void testGetServicesFloors() throws RemoteException 
	{
		boolean elevator0ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor0);
		assertTrue(elevator0ServicesFloor0);
		
		boolean elevator0ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor1);
		assertTrue(elevator0ServicesFloor1);
		
		boolean elevator0ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor2);
		assertTrue(elevator0ServicesFloor2);
		
		boolean elevator0ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor3);
		assertTrue(elevator0ServicesFloor3);
		
		
		boolean elevator1ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor0);
		assertTrue(elevator1ServicesFloor0);
		
		boolean elevator1ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor1);
		assertTrue(elevator1ServicesFloor1);
		
		boolean elevator1ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor2);
		assertTrue(elevator1ServicesFloor2);
		
		boolean elevator1ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor3);
		assertTrue(elevator1ServicesFloor3);
		
		
		boolean elevator2ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor0);
		assertTrue(elevator2ServicesFloor0);
		
		boolean elevator2ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor1);
		assertTrue(elevator2ServicesFloor1);
		
		boolean elevator2ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor2);
		assertTrue(elevator2ServicesFloor2);
		
		boolean elevator2ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor3);
		assertTrue(elevator2ServicesFloor3);
	}

	@Test
	public void testGetTarget() 
	{
		//fail("Not yet implemented");
	}

	@Test
	public void testSetCommittedDirection() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetServicesFloors() {
		//fail("Not yet implemented");
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
		//fail("Not yet implemented");
	}

}
