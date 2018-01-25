package at.fhhagenberg.sqe.javafxapp;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import sqelevator.ElevatorSystemDummy;

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
	private final static Integer Elevator1 = 1;
	private final static Integer Elevator2 = 1;
	
	private final static Integer Floor0 = 0;
	private final static Integer Floor1 = 1;
	private final static Integer Floor2 = 2;
	private final static Integer Floor3 = 3;
	
	ElevatorSystemDummy elevatorSystemDummy;
	
	@Before
	public void setup() 
	{
		elevatorSystemDummy = new ElevatorSystemDummy();
	}
	
	@Test
	public void testGetCommittedDirectionINITIALSTATE() throws RemoteException 
	{
		int elevator0committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator0);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator0committedDirection);
		
		int elevator1committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator1);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator1committedDirection);
		
		int elevator2committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator2);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator2committedDirection);		
	}

	@Test
	public void testGetElevatorAccelINITIALSTATE() throws RemoteException 
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
	public void testGetElevatorButtonINITIALSTATE() throws RemoteException 
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
	public void testGetElevatorDoorStatusINITIALSTATE() throws RemoteException 
	{
		int elevator0DoorStatus = elevatorSystemDummy.getElevatorDoorStatus(Elevator0);
		assertEquals(ELEVATOR_DOORS_CLOSED, elevator0DoorStatus);
		
		int elevator1DoorStatus = elevatorSystemDummy.getElevatorDoorStatus(Elevator1);
		assertEquals(ELEVATOR_DOORS_CLOSED, elevator1DoorStatus);
		
		int elevator2DoorStatus = elevatorSystemDummy.getElevatorDoorStatus(Elevator2);
		assertEquals(ELEVATOR_DOORS_CLOSED, elevator2DoorStatus);
	}

	@Test
	public void testGetElevatorFloorINITIALSTATE() throws RemoteException 
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
	public void testGetElevatorPositionINITIALSTATE() throws RemoteException
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
	public void testGetElevatorSpeedINITIALSTATE() throws RemoteException 
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
	public void testGetElevatorWeightINITIALSTATE() throws RemoteException 
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
	public void testGetElevatorCapacityINITIALSTATE() throws RemoteException
	{
		int elevator0Capacity = elevatorSystemDummy.getElevatorCapacity(Elevator0);
		assertEquals(ELEVATOR_CAPACITY, elevator0Capacity);
		
		int elevator1Capacity = elevatorSystemDummy.getElevatorCapacity(Elevator1);
		assertEquals(ELEVATOR_CAPACITY, elevator1Capacity);
		
		int elevator2Capacity = elevatorSystemDummy.getElevatorCapacity(Elevator2);
		assertEquals(ELEVATOR_CAPACITY, elevator2Capacity);
	}

	@Test
	public void testGetFloorButtonDownINITIALSTATE() throws RemoteException 
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
	public void testGetFloorButtonUpINITIALSTATE() throws RemoteException 
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
	public void testGetServicesFloorsINITIALSTATE() throws RemoteException 
	{
		boolean elevator0ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor0);
		assertTrue(elevator0ServicesFloor0);
		
		boolean elevator0ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor1);
		assertFalse(elevator0ServicesFloor1);
		
		boolean elevator0ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor2);
		assertTrue(elevator0ServicesFloor2);
		
		boolean elevator0ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor3);
		assertFalse(elevator0ServicesFloor3);
		
		
		boolean elevator1ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor0);
		assertFalse(elevator1ServicesFloor0);
		
		boolean elevator1ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor1);
		assertTrue(elevator1ServicesFloor1);
		
		boolean elevator1ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor2);
		assertFalse(elevator1ServicesFloor2);
		
		boolean elevator1ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor3);
		assertTrue(elevator1ServicesFloor3);
		
		
		boolean elevator2ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor0);
		assertFalse(elevator2ServicesFloor0);
		
		boolean elevator2ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor1);
		assertTrue(elevator2ServicesFloor1);
		
		boolean elevator2ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor2);
		assertFalse(elevator2ServicesFloor2);
		
		boolean elevator2ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor3);
		assertTrue(elevator2ServicesFloor3);
	}

	@Test
	public void testGetTargetINITIALSTATE() throws RemoteException 
	{
		int initialTargetFloor = 0;
		int elevator0TargetFloor = elevatorSystemDummy.getTarget(Elevator0);
		assertEquals(initialTargetFloor, elevator0TargetFloor);
		
		int elevator1TargetFloor = elevatorSystemDummy.getTarget(Elevator1);
		assertEquals(initialTargetFloor, elevator1TargetFloor);
		
		int elevator2TargetFloor = elevatorSystemDummy.getTarget(Elevator2);
		assertEquals(initialTargetFloor, elevator2TargetFloor);			
	}

	@Test
	public void testSetCommittedDirection() throws RemoteException 
	{
		elevatorSystemDummy.setCommittedDirection(Elevator0, ELEVATOR_DIRECTION_UP);
		int elevator0committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator0);
		assertEquals(ELEVATOR_DIRECTION_UP, elevator0committedDirection);
		
		elevatorSystemDummy.setCommittedDirection(Elevator0, ELEVATOR_DIRECTION_UNCOMMITTED);
		elevator0committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator0);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator0committedDirection);
		
		elevatorSystemDummy.setCommittedDirection(Elevator0, ELEVATOR_DIRECTION_DOWN);
		elevator0committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator0);
		assertEquals(ELEVATOR_DIRECTION_DOWN, elevator0committedDirection);
		
		
		elevatorSystemDummy.setCommittedDirection(Elevator1, ELEVATOR_DIRECTION_UP);
		int elevator1committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator1);
		assertEquals(ELEVATOR_DIRECTION_UP, elevator1committedDirection);
		
		elevatorSystemDummy.setCommittedDirection(Elevator1, ELEVATOR_DIRECTION_UNCOMMITTED);
		elevator1committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator1);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator1committedDirection);
		
		elevatorSystemDummy.setCommittedDirection(Elevator1, ELEVATOR_DIRECTION_DOWN);
		elevator1committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator1);
		assertEquals(ELEVATOR_DIRECTION_DOWN, elevator1committedDirection);
		
		
		elevatorSystemDummy.setCommittedDirection(Elevator2, ELEVATOR_DIRECTION_UP);
		int elevator2committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator2);
		assertEquals(ELEVATOR_DIRECTION_UP, elevator2committedDirection);
		
		elevatorSystemDummy.setCommittedDirection(Elevator2, ELEVATOR_DIRECTION_UNCOMMITTED);
		elevator2committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator2);
		assertEquals(ELEVATOR_DIRECTION_UNCOMMITTED, elevator2committedDirection);
		
		elevatorSystemDummy.setCommittedDirection(Elevator2, ELEVATOR_DIRECTION_DOWN);
		elevator2committedDirection = elevatorSystemDummy.getCommittedDirection(Elevator2);
		assertEquals(ELEVATOR_DIRECTION_DOWN, elevator2committedDirection);
	}

	@Test
	public void testSetServicesFloors() throws RemoteException 
	{
		elevatorSystemDummy.setServicesFloors(Elevator0, Floor0, true);
		elevatorSystemDummy.setServicesFloors(Elevator0, Floor1, true);
		elevatorSystemDummy.setServicesFloors(Elevator0, Floor2, true);
		elevatorSystemDummy.setServicesFloors(Elevator0, Floor3, false);
		
		boolean elevator0ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor0);
		assertTrue(elevator0ServicesFloor0);
		
		boolean elevator0ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor1);
		assertTrue(elevator0ServicesFloor1);
		
		boolean elevator0ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor2);
		assertTrue(elevator0ServicesFloor2);
		
		boolean elevator0ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator0, Floor3);
		assertFalse(elevator0ServicesFloor3);
		
		
		elevatorSystemDummy.setServicesFloors(Elevator1, Floor0, true);
		elevatorSystemDummy.setServicesFloors(Elevator1, Floor1, false);
		elevatorSystemDummy.setServicesFloors(Elevator1, Floor2, true);
		elevatorSystemDummy.setServicesFloors(Elevator1, Floor3, false);
		
		boolean elevator1ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor0);
		assertTrue(elevator1ServicesFloor0);
		
		boolean elevator1ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor1);
		assertFalse(elevator1ServicesFloor1);
		
		boolean elevator1ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor2);
		assertTrue(elevator1ServicesFloor2);
		
		boolean elevator1ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator1, Floor3);
		assertFalse(elevator1ServicesFloor3);
		
		
		elevatorSystemDummy.setServicesFloors(Elevator2, Floor0, false);
		elevatorSystemDummy.setServicesFloors(Elevator2, Floor1, true);
		elevatorSystemDummy.setServicesFloors(Elevator2, Floor2, true);
		elevatorSystemDummy.setServicesFloors(Elevator2, Floor3, true);
		
		boolean elevator2ServicesFloor0 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor0);
		assertFalse(elevator2ServicesFloor0);
		
		boolean elevator2ServicesFloor1 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor1);
		assertTrue(elevator2ServicesFloor1);
		
		boolean elevator2ServicesFloor2 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor2);
		assertTrue(elevator2ServicesFloor2);
		
		boolean elevator2ServicesFloor3 = elevatorSystemDummy.getServicesFloors(Elevator2, Floor3);
		assertTrue(elevator2ServicesFloor3);
	}

	@Test
	public void testSetTarget() throws RemoteException 
	{
		int elevator0TargetFloor = 1;
		elevatorSystemDummy.setTarget(Elevator0, elevator0TargetFloor);
		int expectedElevator0TargetFloor = elevatorSystemDummy.getTarget(Elevator0);
		assertEquals(expectedElevator0TargetFloor, elevator0TargetFloor);		
		// ... tempus fugit
		int elevator0CurrentFloor = elevatorSystemDummy.getElevatorFloor(Elevator0);
		assertEquals(expectedElevator0TargetFloor, elevator0CurrentFloor);
		
		int elevator1TargetFloor = 2;
		elevatorSystemDummy.setTarget(Elevator1, elevator1TargetFloor);
		int expectedElevator1TargetFloor = elevatorSystemDummy.getTarget(Elevator1);
		assertEquals(expectedElevator1TargetFloor, elevator1TargetFloor);		
		// ... tempus fugit
		int elevator1CurrentFloor = elevatorSystemDummy.getElevatorFloor(Elevator1);
		assertEquals(expectedElevator1TargetFloor, elevator1CurrentFloor);
		
		int elevator2TargetFloor = 3;
		elevatorSystemDummy.setTarget(Elevator2, elevator2TargetFloor);
		int expectedElevator2TargetFloor = elevatorSystemDummy.getTarget(Elevator2);
		assertEquals(expectedElevator2TargetFloor, elevator2TargetFloor);		
		// ... tempus fugit
		int elevator2CurrentFloor = elevatorSystemDummy.getElevatorFloor(Elevator2);
		assertEquals(expectedElevator2TargetFloor, elevator2CurrentFloor);
	}

	@Test
	public void testGetClockTick() throws RemoteException 
	{
		long expectedClockTick = 2;
		long clockTick = elevatorSystemDummy.getClockTick();
		assertEquals(expectedClockTick, clockTick);
	}
}
