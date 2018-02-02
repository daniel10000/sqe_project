package at.fhhagenberg.sqe.controller;

import java.rmi.RemoteException;

import at.fhhagenberg.sqe.data.Updateable;
import sqelevator.IElevator;

public class Commander implements Commandable, Updateable
{
  
  private IElevator system;
  private ElevatorMode mode;

  public Commander(IElevator system)
  {
    this.system = system;
    mode = ElevatorMode.Manual;
  }
  
	@Override
	public void setTargetFloor(int nr, int floor)
	{
	  switch(mode)
	  {
	  case Manual:
	    try
	    {
	      system.setTarget(nr, floor);
	    }
	    catch(RemoteException e)
	    {
	      e.printStackTrace();
	    }
	    break;
	  case Automatic:
	    break;
	  }
	}

  @Override
  public void setMode(ElevatorMode mode)
  {
    this.mode = mode;
  }

  @Override
  public void toggleMode()
  {
    if(mode == ElevatorMode.Automatic)
      mode = ElevatorMode.Manual;
    else
      mode = ElevatorMode.Automatic;
  }

  @Override
  public void updateFinished(long tick)
  {
    if(mode == ElevatorMode.Automatic)
    {
    }
  }

}
