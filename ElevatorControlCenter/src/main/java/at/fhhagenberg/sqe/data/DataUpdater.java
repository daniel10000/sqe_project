package at.fhhagenberg.sqe.data;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import at.fhhagenberg.sqe.elevator.IElevatorSystem;

public class DataUpdater extends TimerTask
{
	private static final long UPDATE_INTERVAL = 1000;
	
	private Set<ElevatorNotifyable> elevators = new HashSet<ElevatorNotifyable>();
	
	private IElevatorSystem system;

	private Timer timer = new Timer();

	public DataUpdater(IElevatorSystem system)
	{
		this.system = system;
	}
	
	public void start()
	{
		timer.schedule(this, 1000, UPDATE_INTERVAL);
	}
	
	public void registerElevator(ElevatorNotifyable elevator)
	{
		elevators.add(elevator);
	}
	
	public void deregisterElevator(ElevatorNotifyable elevator)
	{
		elevators.remove(elevator);
	}
	
	public IElevatorSystem getElevatorSystem()
	{
		return system;
	}

	private void notifyFloorChanged(int nr, int floor)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.floorChanged(nr, floor);
		}
	}
	
	private void notifyWeightChanged(int nr, int weight)
	{
		for(ElevatorNotifyable e : elevators)
		{
			e.weightChanged(nr, weight);
		}
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < /*TODO*/3; i++)
		{
			try
			{
				notifyFloorChanged(i, system.getElevatorFloor(i));
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
			try
			{
				notifyWeightChanged(i, system.getElevatorWeight(i));
			}
			catch(RemoteException e)
			{
				e.printStackTrace();
			}
		}
	}
}
