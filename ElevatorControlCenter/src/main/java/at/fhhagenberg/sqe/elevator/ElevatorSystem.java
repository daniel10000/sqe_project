package at.fhhagenberg.sqe.elevator;

import java.rmi.RemoteException;
import java.util.Map;

public class ElevatorSystem implements IElevator
{
	private static final Integer ELEVATORS = 3;
	private static final Integer FLOORS = 4;
	private static final Integer ELEVATOR_CAPACITY = 8;
	private static final Integer FLOOR_HEIGHT = 3;
	
	private Map<Integer, Elevator> elevators;
	private Map<Integer, Floor> floors;
	
	public ElevatorSystem() 
	{
		for (int i = 1; i <= ELEVATORS; i++) 
		{
			elevators.put(i, new Elevator(i,ELEVATOR_CAPACITY));			
		}		
		
		for (int i = 0; i < FLOORS; i++) 
		{
			floors.put(i, new Floor());			
		}
	}
	
	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException 
	{		
		return elevators.get(elevatorNumber).getDirection();
	}

	@Override
	public int getElevatorAccel(int elevatorNumber) throws RemoteException 
	{		
		return elevators.get(elevatorNumber).getAcceleration();
	}

	@Override
	public boolean getElevatorButton(int elevatorNumber, int floor) throws RemoteException 
	{		
		return elevators.get(elevatorNumber).getFloorButtons().get(floor);
	}

	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException 
	{
		return elevators.get(elevatorNumber).getDoorStatus();
	}

	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException 
	{
		return elevators.get(elevatorNumber).getCurrentFloor();
	}

	@Override
	public int getElevatorNum() throws RemoteException 
	{
		return elevators.size();
	}

	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException {
		// ????????????????
		return 0;
	}

	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException 
	{
		return elevators.get(elevatorNumber).getSpeed();
	}

	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException 
	{
		return elevators.get(elevatorNumber).getWeight();
	}

	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException 
	{
		return elevators.get(elevatorNumber).getCapacity();
	}

	@Override
	public boolean getFloorButtonDown(int floor) throws RemoteException 
	{
		return floors.get(floor).getDownButton();
	}

	@Override
	public boolean getFloorButtonUp(int floor) throws RemoteException 
	{
		return floors.get(floor).getUpButton();
	}

	@Override
	public int getFloorHeight() throws RemoteException 
	{
		return FLOOR_HEIGHT;
	}

	@Override
	public int getFloorNum() throws RemoteException 
	{
		return FLOORS;
	}

	@Override
	public boolean getServicesFloors(int elevatorNumber, int floor) throws RemoteException {
		
		return elevators.get(elevatorNumber).getServicedFloors().get(floor);
	}

	@Override
	public int getTarget(int elevatorNumber) throws RemoteException 
	{
		return elevators.get(elevatorNumber).getTargetFloor();
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException 
	{
		elevators.get(elevatorNumber).setDirection(direction);
	}

	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException 
	{
		elevators.get(elevatorNumber).setServicedFloors(floor, service);		
	}

	@Override
	public void setTarget(int elevatorNumber, int target) throws RemoteException 
	{
		elevators.get(elevatorNumber).setTargetFloor(target);
	}

	@Override
	public long getClockTick() throws RemoteException 
	{
		// ???????????????????????
		return 0;
	}

}
