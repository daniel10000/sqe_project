package sqelevator;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

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

	
	
	private class Floor 
	{
		private boolean upButton;
		private boolean downButton;
		
		public Floor() 
		{
			upButton = false;
			downButton = false;
		}

		public boolean getUpButton() 
		{
			return upButton;
		}

		public void setUpButton(boolean upButton) 
		{
			this.upButton = upButton;
		}

		public boolean getDownButton()
		{
			return downButton;
		}

		public void setDownButton(boolean downButton)
		{
			this.downButton = downButton;
		}
	}

	private class Elevator
	{
		private int direction;
		private int acceleration; 
		private int doorStatus;
		private int currentFloor;
		private int targetFloor;
		private int speed;
		private int weight;
		private int capacity;
		
		private Map<Integer, Boolean> servicedFloors = new HashMap<Integer, Boolean>();;
		private Map<Integer, Boolean> floorButtons = new HashMap<Integer, Boolean>();
		
		public int getTargetFloor() 
		{
			return targetFloor;
		}

		public void setTargetFloor(int targetFloor) 
		{
			this.targetFloor = targetFloor;
		}
		
		
		public Map<Integer, Boolean> getFloorButtons() {
			return floorButtons;
		}

		public void setFloorButtons(int floor, boolean pressed) 
		{
			floorButtons.put(floor, pressed);
		}
		
		public Map<Integer, Boolean> getServicedFloors() {
			return servicedFloors;
		}
		
		public void setServicedFloors(int floor, boolean service) 
		{
			servicedFloors.put(floor, service);
		}
		
		public Elevator(int number, int capacity) 
		{
			this.direction = 2;
			this.acceleration = 0;
			this.doorStatus = 2;
			this.currentFloor = 0;
			this.targetFloor = 0;
			this.speed = 0;
			this.weight = capacity*155;
			this.capacity = capacity;	
			
			for (int i = 0; i < FLOORS; i++) 
			{
				floorButtons.put(0, false);
				if(number % 2 == 0) 
				{				
					if(i % 2 == 0) 
					{
						servicedFloors.put(i, true);					
					}
					else 
					{
						servicedFloors.put(i, false);
					}
				}
				else 
				{
					if(i % 2 == 0) 
					{
						servicedFloors.put(i, false);					
					}
					else 
					{
						servicedFloors.put(i, true);
					}
				}
			}
		}

		public int getDirection() 
		{
			return direction;
		}

		public void setDirection(int direction) 
		{
			this.direction = direction;
		}

		public int getAcceleration() 
		{
			return acceleration;
		}

		public void setAcceleration(int acceleration) 
		{
			this.acceleration = acceleration;
		}

		public int getDoorStatus() 
		{
			return doorStatus;
		}

		public void setDoorStatus(int doorStatus) 
		{
			this.doorStatus = doorStatus;
		}

		public int getCurrentFloor() 
		{
			return currentFloor;
		}

		public void setCurrentFloor(int currentFloor) 
		{
			this.currentFloor = currentFloor;
		}

		public int getSpeed() 
		{
			return speed;
		}

		public void setSpeed(int speed) 
		{
			this.speed = speed;
		}

		public int getWeight() 
		{
			return weight;
		}

		public void setWeight(int weight) 
		{
			this.weight = weight;
		}

		public void setCapacity(int capacity) 
		{
			this.capacity = capacity;
		}
		
		public int getCapacity() 
		{
			return capacity;
		}
	}
}
