package at.fhhagenberg.sqe.data;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import at.fhhagenberg.sqe.domain.DoorStatus;
import sqelevator.IElevator;

public class DataUpdater extends TimerTask
{
	private static final long UPDATE_INTERVAL = 1000;
	
	private Set<ElevatorNotifyable> elevators = new HashSet<ElevatorNotifyable>();
	private Set<Updateable> updateables = new HashSet<Updateable>();
	
	private IElevator system;

	private Timer timer = new Timer();
	
	private int nrFloors;
	private int nrElevators;

	public DataUpdater(IElevator system)
	{
		this.system = system;
	}
	
	public void start()
	{
		timer.schedule(this, 1000, UPDATE_INTERVAL);
	}
	
	public void stop()
	{
		timer.cancel();
	}
	
	public void registerElevator(ElevatorNotifyable elevator)
	{
		elevators.add(elevator);
	}
	
	public void deregisterElevator(ElevatorNotifyable elevator)
	{
		elevators.remove(elevator);
	}
	
	public void registerUpdateable(Updateable updateable)
	{
	  updateables.add(updateable);
	}
	
	public void deregisterUpdateable(Updateable updateable)
	{
	  updateables.remove(updateable);
	}
	
	public IElevator getElevatorSystem()
	{
		return system;
	}

	private void notifyFloorChanged(int nr, int floor, DoorStatus door)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.floorChanged(nr, floor, door);
		}
	}
	
	private void notifyElevatorButtonChanged(int nr, int floor, boolean active)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.buttonChanged(nr, floor, active);
		}
	}
	
	private void notifyAccelChanged(int nr, int accel)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.accelChanged(nr, accel);
		}
	}
	
	private void notifySpeedChanged(int nr, int speed)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.speedChanged(nr, speed);
		}
	}
	
	private void notifyWeightChanged(int nr, int weight)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.weightChanged(nr, weight);
		}
	}
	
	private void notifyCapacityChanged(int nr, int capacity)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.capacityChanged(nr, capacity);
		}
	}
	
	private void notifyButtonUpChanged(int floor, boolean active)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.buttonUpChanged(floor, active);
		}
	}
	
	private void notifyButtonDownChanged(int floor, boolean active)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.buttonDownChanged(floor, active);
		}
	}
	
	private void notifyElevatorNumChanged(int nr)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.elevatorNumChanged(nr);
		}
	}
	
	private void notifyFloorNumChanged(int nr)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.floorNumChanged(nr);
		}
	}
	
	private void notifyUpdateFinished(long tick)
	{
	  for(Updateable u : updateables)
	  {
	    u.updateFinished(tick);
	  }
	}
	
	private boolean initialized = false;
	
	@Override
	public void run()
	{
		// general
		try
		{
		  if(!initialized)
		  {
		    nrElevators = system.getElevatorNum();
        nrFloors = system.getFloorNum();
  			notifyElevatorNumChanged(nrElevators);
  			notifyFloorNumChanged(nrFloors);
  			initialized = true;
      }
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}
		
		// elevator dependent
		for(int i = 0; i < nrElevators; i++)
		{
			try
			{
				DoorStatus status = convertDoorStatus(system.getElevatorDoorStatus(i));
				notifyFloorChanged(i, system.getElevatorFloor(i), status);
				for(int j = 0; j < nrFloors; j++)
					notifyElevatorButtonChanged(i, j, system.getElevatorButton(i, j));
				notifyAccelChanged(i, system.getElevatorAccel(i));
				notifySpeedChanged(i, system.getElevatorSpeed(i));
				notifyWeightChanged(i, system.getElevatorWeight(i));
				notifyCapacityChanged(i, system.getElevatorCapacity(i));
			}
			catch(RemoteException e)
			{
				e.printStackTrace();
			}
			
			try
			{
			  notifyUpdateFinished(system.getClockTick());
			}
			catch(RemoteException e)
			{
			  e.printStackTrace();
			}
		}
		
		// floor dependent
		for(int i = 0; i < nrFloors; i++)
		{
			try
			{
				notifyButtonUpChanged(i, system.getFloorButtonUp(i));
				notifyButtonDownChanged(i, system.getFloorButtonDown(i));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private DoorStatus convertDoorStatus(int door)
	{
		switch(door)
		{
		case 1:
			return DoorStatus.Opened;
		case 2:
			return DoorStatus.Closed;
		}
		return null;
	}
}
