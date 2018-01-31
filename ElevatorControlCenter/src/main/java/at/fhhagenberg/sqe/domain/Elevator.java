package at.fhhagenberg.sqe.domain;

import java.util.HashSet;
import java.util.Set;

public class Elevator
{
  private int number;
  private int direction;
  private int acceleration;
  private DoorStatus doorStatus;
  private int currentFloor;
  private int targetFloor; 
  private int speed;
  private int weight;
  private int capacity;
  private int position;

  private Set<Integer> servicedFloors = new HashSet<Integer>();
  private Set<Integer> floorButtonsActive = new HashSet<Integer>();

  public int getTargetFloor()
  {
    return targetFloor;
  }

  public void setTargetFloor(int targetFloor)
  {
    this.targetFloor = targetFloor;
  }

  public Set<Integer> getFloorButtonsActive()
  {
    return floorButtonsActive;
  }

  public void setFloorButton(int floor, boolean active)
  {
    if(active)
    {
        floorButtonsActive.add(floor);
    }
    else
    {
        floorButtonsActive.remove(floor);
    }
  }

  public Set<Integer> getServicedFloors()
  {
    return servicedFloors;
  }

  public void setServicedFloors(int floor, boolean service)
  {
    if(service)
      servicedFloors.add(floor);
    else
      servicedFloors.remove(floor);
  }

  public Elevator()
  {
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

  public DoorStatus getDoorStatus() 
  {
    return doorStatus;
  }

  public void setDoorStatus(DoorStatus doorStatus) 
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

  public int getNumber() 
  {
    return number;
  }

  public void setCapacity(int capacity) 
  {
    this.capacity = capacity;
  }
  
  public int getCapacity() 
  {
    return capacity;
  }
  
  public void setPosition(int position)
  {
    this.position = position;
  }
  
  public int getPosition()
  {
    return position;
  }
}
