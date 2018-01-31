package at.fhhagenberg.sqe.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import at.fhhagenberg.sqe.data.ElevatorNotifyable;

public class ElevatorSystemModel implements ElevatorNotifyable
{
  private Map<Integer, Elevator> elevators = new HashMap<Integer, Elevator>();
  private Map<Integer, Floor> floors = new HashMap<Integer, Floor>();

  private Set<ModelNotifyable> controllers;

  public ElevatorSystemModel()
  {
  }

  public void registerModelNotifyable(ModelNotifyable controller)
  {
    controllers.add(controller);
  }

  public void deregisterModelNotifyable(ModelNotifyable controller)
  {
    controllers.remove(controller);
  }

  @Override
  public void commitedDirectionChanged(int nr, int direction)
  {
    // TODO Auto-generated method stub
  }

  @Override
  public void accelChanged(int nr, int accel)
  {
    Elevator elevator = elevators.get(nr);
    if(elevator != null)
    {
      elevator.setAcceleration(accel);
    }
    // TODO Auto-generated method stub

  }

  @Override
  public void buttonChanged(int nr, int floor, boolean active)
  {
    Elevator elevator = elevators.get(nr);
    if(elevator != null)
    {
      elevator.setFloorButton(floor, active);
    }
  }

  @Override
  public void floorChanged(int nr, int floor, DoorStatus doorStatus)
  {
    Elevator elevator = elevators.get(nr);
    if(elevator != null)
    {
      elevator.setCurrentFloor(floor);
      elevator.setDoorStatus(doorStatus);
    }
  }

  @Override
  public void elevatorNumChanged(int nr)
  {
    for(int i = 0; i < nr; i++)
    {
      if(!elevators.containsKey(nr))
      {
        Elevator elevator = new Elevator();
        elevators.put(nr, elevator);
      }
    }
  }

  @Override
  public void positionChanged(int nr, int position)
  {
    Elevator elevator = elevators.get(nr);
    if(elevator != null)
    {
      elevator.setPosition(position);
    }
  }

  @Override
  public void speedChanged(int nr, int speed)
  {
    Elevator elevator = elevators.get(nr);
    if(elevator != null)
    {
      elevator.setSpeed(speed);
    }
  }

  @Override
  public void weightChanged(int nr, int weight)
  {
    // TODO Auto-generated method stub

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

  @Override
  public void floorNumChanged(int nr)
  {
    for(int i = 0; i < nr; i++)
    {
      if(!floors.containsKey(i))
      {
        Floor floor = new Floor();
        floors.put(i, floor);
      }
    }
  }

}
