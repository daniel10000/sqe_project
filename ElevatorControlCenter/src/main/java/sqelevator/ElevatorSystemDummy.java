package sqelevator;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import at.fhhagenberg.sqe.domain.Elevator;
import at.fhhagenberg.sqe.domain.Floor;

public class ElevatorSystemDummy implements IElevator
{
	private static final Integer ELEVATORS = 3;
	private static final Integer FLOORS = 4;
	private static final Integer ELEVATOR_CAPACITY = 10;
	private static final Integer FLOOR_HEIGHT = 7;

	private Map<Integer, Elevator> elevators = new HashMap<Integer, Elevator>();
	private Map<Integer, Floor> floors = new HashMap<Integer, Floor>();
	
	public ElevatorSystemDummy() 
	{
		for (int i = 0; i < ELEVATORS; i++) 
		{
			elevators.put(i, new Elevator(i,ELEVATOR_CAPACITY));			
		}
		
		for (int i = 0; i < FLOORS; i++) 
		{
			floors.put(i, new Floor());			
		}
		
		for (int elevator = 0; elevator < ELEVATORS; elevator++) 
		{
			elevators.get(elevator).setDirection(ELEVATOR_DIRECTION_UNCOMMITTED);
			elevators.get(elevator).setAcceleration(0);
			
			for (int floor = 0; floor < FLOORS; floor++) 
			{
				elevators.get(elevator).setFloorButtons(floor,false);
				
				if(elevator % 2 == 0) 
				{				
					if(floor % 2 == 0) 
					{
						elevators.get(elevator).setServicedFloors(floor, true);					
					}
					else 
					{
						elevators.get(elevator).setServicedFloors(floor, false);
					}
				}
				else 
				{
					if(floor % 2 == 0) 
					{
						elevators.get(elevator).setServicedFloors(floor, false);					
					}
					else 
					{
						elevators.get(elevator).setServicedFloors(floor, true);
					}
				}
			}
			
			elevators.get(elevator).setDoorStatus(ELEVATOR_DOORS_CLOSED);
			elevators.get(elevator).setCurrentFloor(0);
			elevators.get(elevator).setSpeed(0);
			elevators.get(elevator).setWeight(0);
			elevators.get(elevator).setCapacity(ELEVATOR_CAPACITY);
			elevators.get(elevator).setTargetFloor(0);
		}
		
		for (int floor = 0; floor < FLOORS; floor++) 
		{
			floors.get(floor).setDownButton(false);
			floors.get(floor).setUpButton(false);
			//floors.get(floor).setHeight(7);
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
	public int getElevatorPosition(int elevatorNumber) throws RemoteException 
	{
		return elevators.get(elevatorNumber).getCurrentFloor() * FLOOR_HEIGHT;
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
		// ... tempus fugit
		elevators.get(elevatorNumber).setCurrentFloor(target);
	}

	@Override
	public long getClockTick() throws RemoteException 
	{
		return 2; // es ist nur ein dummy ....
	}

}
