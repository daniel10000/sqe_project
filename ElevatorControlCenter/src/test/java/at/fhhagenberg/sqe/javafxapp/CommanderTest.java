package at.fhhagenberg.sqe.javafxapp;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import at.fhhagenberg.sqe.controller.Commander;
import at.fhhagenberg.sqe.controller.ElevatorMode;
import at.fhhagenberg.sqe.domain.ElevatorSystemModel;
import sqelevator.IElevator;

public class CommanderTest implements IElevator
{

  private ElevatorSystemModel model;
  private Commander commander;
  
  private int setTargetCalled;
  private int elevatorNumber;
  private int target;
  
  @Before
  public void setup()
  {
    model = new ElevatorSystemModel();
    model.elevatorNumChanged(5);
    model.floorNumChanged(20);
    commander = new Commander(this, model);
  }
  
  @Test
  public void testAutomaticModeButtonInElevator()
  {
    commander.setMode(ElevatorMode.Automatic);
    
    assertEquals(0, setTargetCalled);
    
    commander.updateFinished(0);
    
    assertEquals(0, setTargetCalled);
    
    model.buttonChanged(3, 4, true);
    commander.updateFinished(1);
    
    assertEquals(1, setTargetCalled);
    assertEquals(3, elevatorNumber);
    assertEquals(4, target);
  }
  
  @Test
  public void testAutomaticModeButtonDownOnFloor()
  {
    commander.setMode(ElevatorMode.Automatic);
    
    assertEquals(0, setTargetCalled);
    
    commander.updateFinished(0);
    
    assertEquals(0, setTargetCalled);
    
    model.buttonDownChanged(2, true);
    commander.updateFinished(1);
    
    assertEquals(1, setTargetCalled);
    assertEquals(2, target);
  }
  
  @Test
  public void testAutomaticModeButtonUpOnFloor()
  {
    commander.setMode(ElevatorMode.Automatic);
    
    assertEquals(0, setTargetCalled);
    
    commander.updateFinished(0);
    
    assertEquals(0, setTargetCalled);
    
    model.buttonUpChanged(5, true);
    commander.updateFinished(1);
    
    assertEquals(1, setTargetCalled);
    assertEquals(5, target);
  }
  
  @Test
  public void testManualModeSendCommands()
  {
    commander.setMode(ElevatorMode.Manual);

    assertEquals(0, setTargetCalled);
    
    commander.setTargetFloor(3, 12);
    
    assertEquals(1, setTargetCalled);
    assertEquals(3, elevatorNumber);
    assertEquals(12, target);
  }
  
  @Test
  public void testAutomaticModeBlockCommands()
  {
    commander.setMode(ElevatorMode.Automatic);

    assertEquals(0, setTargetCalled);
    
    commander.setTargetFloor(3, 12);
    
    assertEquals(0, setTargetCalled);
  }

  @Override
  public int getCommittedDirection(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public int getElevatorAccel(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public boolean getElevatorButton(int elevatorNumber, int floor) throws RemoteException
  {
    return false;
  }

  @Override
  public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public int getElevatorFloor(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public int getElevatorNum() throws RemoteException
  {
    return 0;
  }

  @Override
  public int getElevatorPosition(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public int getElevatorSpeed(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public int getElevatorWeight(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public int getElevatorCapacity(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public boolean getFloorButtonDown(int floor) throws RemoteException
  {
    return false;
  }

  @Override
  public boolean getFloorButtonUp(int floor) throws RemoteException
  {
    return false;
  }

  @Override
  public int getFloorHeight() throws RemoteException
  {
    return 0;
  }

  @Override
  public int getFloorNum() throws RemoteException
  {
    return 0;
  }

  @Override
  public boolean getServicesFloors(int elevatorNumber, int floor) throws RemoteException
  {
    return false;
  }

  @Override
  public int getTarget(int elevatorNumber) throws RemoteException
  {
    return 0;
  }

  @Override
  public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException
  {
  }

  @Override
  public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException
  {
  }

  @Override
  public void setTarget(int elevatorNumber, int target) throws RemoteException
  {
    setTargetCalled++;
    this.elevatorNumber = elevatorNumber;
    this.target = target;
  }

  @Override
  public long getClockTick() throws RemoteException
  {
    return 0;
  }

}
