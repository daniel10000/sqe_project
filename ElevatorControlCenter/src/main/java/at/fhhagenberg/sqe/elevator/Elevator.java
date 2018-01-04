package at.fhhagenberg.sqe.elevator;

import java.util.Map;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Elevator 
{
	private IntegerProperty number = new SimpleIntegerProperty();
	private IntegerProperty direction = new SimpleIntegerProperty();
	private IntegerProperty acceleration = new SimpleIntegerProperty(); 
	private IntegerProperty doorStatus = new SimpleIntegerProperty();
	private IntegerProperty currentFloor = new SimpleIntegerProperty();
	private IntegerProperty targetFloor = new SimpleIntegerProperty();
	private IntegerProperty speed = new SimpleIntegerProperty();
	private IntegerProperty weight = new SimpleIntegerProperty();
	private IntegerProperty capacity = new SimpleIntegerProperty();
	
	
	private static final Integer FLOORS = 4;
	
	private Map<Integer, Boolean> servicedFloors;
	private Map<Integer, Boolean> floorButtons;
	
	public Integer getTargetFloor() 
	{
		return targetFloor.get();
	}

	public void setTargetFloor(Integer targetFloor) 
	{
		this.targetFloor.set(targetFloor);
	}
	
	
	public Map<Integer, Boolean> getFloorButtons() {
		return floorButtons;
	}

	public Map<Integer, Boolean> getServicedFloors() {
		return servicedFloors;
	}
	
	public void setServicedFloors(Integer floor, Boolean service) 
	{
		servicedFloors.remove(floor);
		servicedFloors.put(floor, service);
	}
	
	public Elevator(Integer number, Integer capacity) 
	{
		this.number.set(number);
		this.direction.set(2);
		this.acceleration.set(0);
		this.doorStatus.set(2);
		this.currentFloor.set(0);
		this.targetFloor.set(0);
		this.speed.set(0);
		this.weight.set(capacity*70);
		this.capacity.set(capacity);	
		
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

	public Integer getDirection() 
	{
		return direction.get();
	}

	public void setDirection(Integer direction) 
	{
		this.direction.set(direction);
	}

	public Integer getAcceleration() 
	{
		return acceleration.get();
	}

	public void setAcceleration(Integer acceleration) 
	{
		this.acceleration.set(acceleration);
	}

	public Integer getDoorStatus() 
	{
		return doorStatus.get();
	}

	public void setDoorStatus(Integer doorStatus) 
	{
		this.doorStatus.set(doorStatus);
	}

	public Integer getCurrentFloor() 
	{
		return currentFloor.get();
	}

	public void setCurrentFloor(Integer currentFloor) 
	{
		this.currentFloor.set(currentFloor);
	}

	public Integer getSpeed() 
	{
		return speed.get();
	}

	public void setSpeed(Integer speed) 
	{
		this.speed.set(speed);
	}

	public Integer getWeight() 
	{
		return weight.get();
	}

	public void setWeight(Integer weight) 
	{
		this.weight.set(weight);
	}

	public Integer getNumber() 
	{
		return number.get();
	}

	public Integer getCapacity() 
	{
		return capacity.get();
	}	
}
