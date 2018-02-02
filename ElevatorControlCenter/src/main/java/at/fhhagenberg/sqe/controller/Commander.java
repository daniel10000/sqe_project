package at.fhhagenberg.sqe.controller;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import at.fhhagenberg.sqe.data.Updateable;
import at.fhhagenberg.sqe.domain.DoorStatus;
import at.fhhagenberg.sqe.domain.Elevator;
import at.fhhagenberg.sqe.domain.ElevatorSystemModel;
import at.fhhagenberg.sqe.domain.Floor;
import sqelevator.IElevator;

public class Commander implements Commandable, Updateable
{
  
  private IElevator system;
  private ElevatorMode mode;

  private ElevatorSystemModel model;
  
  public Commander(IElevator system, ElevatorSystemModel model)
  {
    this.system = system;
    this.model = model;
    mode = ElevatorMode.Manual;
  }
  
	@Override
	public void setTargetFloor(int nr, int floor)
	{
	  if(mode == ElevatorMode.Manual)
	  {
      try
      {
        system.setTarget(nr, floor);
      }
      catch(RemoteException e)
      {
        e.printStackTrace();
      }	    
	  }
	}

  @Override
  public void setMode(ElevatorMode mode)
  {
    this.mode = mode;
  }
  
  @Override
  public ElevatorMode getMode()
  {
    return mode;
  }

  @Override
  public void toggleMode()
  {
    if(mode == ElevatorMode.Automatic)
      mode = ElevatorMode.Manual;
    else
      mode = ElevatorMode.Automatic;
  }

  
  private Map<Elevator, Integer> elevatorTargets = new HashMap<Elevator, Integer>();
  
  @Override
  public void updateFinished(long tick)
  {
    if(mode == ElevatorMode.Automatic)
    {
      processReachedTarget();
      
      for(Elevator elevator : model.getElevators())
      {
        if(elevatorTargets.get(elevator) == null && elevator.getAnyButtonPressed())
        {
          try
          {
            int nextTarget = getNextTargetFloor(elevator);
            system.setTarget(elevator.getNumber(), nextTarget);
            elevatorTargets.put(elevator, nextTarget);
          }
          catch(RemoteException e)
          {
            e.printStackTrace();
          }
        }
      }
      
      for(Floor floor : model.getFloors())
      {
        if(floor.getAnyButton() && !floorIsServiced(floor.getNr()))
        {
          Elevator elevator = getFirstIdleElevator();
          if(elevator != null)
          {
            try
            {
              int nextTarget = floor.getNr();
              system.setTarget(elevator.getNumber(), nextTarget);
              elevatorTargets.put(elevator, nextTarget);
            }
            catch(Exception e)
            {
              e.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  private Elevator getFirstIdleElevator()
  {
    for(Elevator elevator : model.getElevators())
    {
      if(elevatorTargets.get(elevator) == null)
        return elevator;
    }
    return null;
  }
  
  private int getNextTargetFloor(Elevator elevator)
  {
    int floorCount = model.getFloors().size();
    
    int currentFloor = elevator.getCurrentFloor();
    
    for(int distance = 1; currentFloor - distance >= 0 || currentFloor + distance < floorCount; distance++)
    {
      int nextDownFloor = currentFloor - distance;
      int nextUpFloor = currentFloor + distance;
      
      if(floorIsValid(nextDownFloor) && elevator.getFloorButtonsActive().contains(nextDownFloor))
        return nextDownFloor;
      if(floorIsValid(nextUpFloor) && elevator.getFloorButtonsActive().contains(nextUpFloor))
        return nextUpFloor;
    }
    return 0;
  }
  
  private void processReachedTarget()
  {
    for(Elevator elevator : model.getElevators())
    {
      if(elevatorTargets.get(elevator) != null && elevator.getDoorStatus() == DoorStatus.Opened)
      {
        elevatorTargets.remove(elevator);
      }
    }
  }

  private boolean floorIsServiced(int floor)
  {
    for(Elevator elevator : model.getElevators())
    {
      if(elevatorTargets.get(elevator) != null)
      {
        if(elevatorTargets.get(elevator) == floor)
        {
          return true;
        }
      }
    }
    return false;
  }

  private boolean floorIsValid(int floor)
  {
    return floor >= 0 && floor < model.getFloors().size();
  }
}
