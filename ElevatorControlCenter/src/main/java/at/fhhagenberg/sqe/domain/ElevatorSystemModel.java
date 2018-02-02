package at.fhhagenberg.sqe.domain;

import java.util.HashSet;
import java.util.Set;

import at.fhhagenberg.sqe.data.ElevatorNotifyable;
import at.fhhagenberg.sqe.data.Updateable;

public class ElevatorSystemModel implements ElevatorNotifyable, Updateable
{
  private Set<Elevator> elevators = new HashSet<Elevator>();
  private Set<Floor> floors = new HashSet<Floor>();

  private Set<ModelNotifyable> controllers = new HashSet<ModelNotifyable>();

  private boolean modelChanged = false;
  private boolean initialized = false;
  
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
  
  private void notifyModelChanged()
  {
    for(ModelNotifyable c : controllers)
    {
      c.modelChanged(this);
    }
  }
  
  private void notifyModelInitialized()
  {
    for(ModelNotifyable c : controllers)
    {
      c.initialized(elevators.size(), floors.size());
    }
  }
  
  public Set<Elevator> getElevators()
  {
    return elevators;
  }
  
  public Set<Floor> getFloors()
  {
    return floors;
  }
  
  @Override
  public void accelChanged(int nr, int accel)
  {
    Elevator elevator = getElevator(nr);
    if(elevator != null)
    {
      elevator.setAcceleration(accel);
      modelChanged = true;
    }
    notifyModelChanged();
  }

  @Override
  public void buttonChanged(int nr, int floor, boolean active)
  {
    Elevator elevator = getElevator(nr);
    if(elevator != null)
    {
      elevator.setFloorButton(floor, active);
      modelChanged = true;
    }
  }

  @Override
  public void floorChanged(int nr, int floor, DoorStatus doorStatus)
  {
    Elevator elevator = getElevator(nr);
    if(elevator != null)
    {
      elevator.setCurrentFloor(floor);
      elevator.setDoorStatus(doorStatus);
      modelChanged = true;
    }
  }

  @Override
  public void elevatorNumChanged(int nr)
  {
    for(int i = 0; i < nr; i++)
    {
      if(getElevator(nr) == null)
      {
        Elevator elevator = new Elevator(i);
        elevators.add(elevator);
        initialized = true;
        modelChanged = true;
      }
    }
  }

  @Override
  public void positionChanged(int nr, int position)
  {
    Elevator elevator = getElevator(nr);
    if(elevator != null)
    {
      elevator.setPosition(position);
      modelChanged = true;
    }
  }

  @Override
  public void speedChanged(int nr, int speed)
  {
    Elevator elevator = getElevator(nr);
    if(elevator != null)
    {
      elevator.setSpeed(speed);
      modelChanged = true;
    }
  }

  @Override
  public void weightChanged(int nr, int weight)
  {
    Elevator elevator = getElevator(nr);
    if(elevator != null)
    {
      elevator.setWeight(weight);
      modelChanged = true;
    }
  }

  @Override
  public void capacityChanged(int nr, int capacity)
  {
    Elevator elevator = getElevator(nr);
    if(elevator != null)
    {
      elevator.setCapacity(capacity);
      modelChanged = true;
    }
  }

  @Override
  public void buttonUpChanged(int floor, boolean active)
  {
    Floor f = getFloor(floor);
    if(f != null)
    {
      f.setUpButton(active);
      modelChanged = true;
    }
  }

  @Override
  public void buttonDownChanged(int floor, boolean active)
  {
    Floor f = getFloor(floor);
    if(f != null)
    {
      f.setDownButton(active);
      modelChanged = true;
    }
  }

  @Override
  public void floorNumChanged(int nr)
  {
    for(int i = 0; i < nr; i++)
    {
      if(getFloor(nr) == null)
      {
        Floor floor = new Floor(i);
        floors.add(floor);
        initialized = true;
        modelChanged = true;
      }
    }
  }
  
  @Override
  public void updateFinished(long tick)
  {
    if(modelChanged)
    {
      notifyModelChanged();
      modelChanged = false;
    }
    
    if(initialized)
    {
      notifyModelInitialized();
      initialized = false;
    }
  }
  
  private Elevator getElevator(int nr)
  {
    for(Elevator e : elevators)
    {
      if(e.getNumber() == nr)
        return e;
    }
    return null;
  }
  
  private Floor getFloor(int nr)
  {
    for(Floor f : floors)
    {
      if(f.getNr() == nr)
        return f;
    }
    return null;
  }

}
