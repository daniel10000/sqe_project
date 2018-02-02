package at.fhhagenberg.sqe.javafxapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import at.fhhagenberg.sqe.data.DataUpdater;
import at.fhhagenberg.sqe.data.ElevatorNotifyable;
import at.fhhagenberg.sqe.domain.DoorStatus;
import sqelevator.ElevatorSystemDummy;

public class DataUpdaterTest implements ElevatorNotifyable
{

  private DataUpdater updater;
  private ElevatorSystemDummy dummy;
  
  private int accelChangedCalled = 0;
  private int buttonChangedCalled = 0;
  private int floorChangedCalled = 0;
  private int elevatorNumChangedCalled = 0;
  private int positionChangedCalled = 0;
  private int speedChangedCalled = 0;
  private int weightChangedCalled = 0;
  private int capacityChangedCalled = 0;
  private int buttonUpChangedCalled = 0;
  private int buttonDownChangedCalled = 0;
  private int floorNumChangedCalled = 0;
  
  @Before
  public void setup()
  {
    dummy = new ElevatorSystemDummy();
    updater = new DataUpdater(dummy);
    updater.stop();
    updater.registerElevator(this);
    
    accelChangedCalled = 0;
    buttonChangedCalled = 0;
    floorChangedCalled = 0;
    elevatorNumChangedCalled = 0;
    positionChangedCalled = 0;
    speedChangedCalled = 0;
    weightChangedCalled = 0;
    capacityChangedCalled = 0;
    buttonUpChangedCalled = 0;
    buttonDownChangedCalled = 0;
    floorNumChangedCalled = 0;

  }

  @Test
  public void testNotifiesAccelChangedForEachElevator()
  {
    assertEquals(0, accelChangedCalled);
    
    updater.run();
    
    assertEquals(3, accelChangedCalled);
    
    updater.run();
    
    assertEquals(6, accelChangedCalled);
  }

  @Test
  public void testNotifiesFloorNumChangedOnceAfterInit()
  {
    assertEquals(0, floorNumChangedCalled);
    
    updater.run();
    
    assertEquals(1, floorNumChangedCalled);
    
    updater.run();
    
    assertEquals(1, floorNumChangedCalled);
  }
  
  @Test
  public void testNotifiesElevatorNumChangedOnceAfterInit()
  {
    assertEquals(0, elevatorNumChangedCalled);

    updater.run();
    
    assertEquals(1, elevatorNumChangedCalled);
    
    updater.run();
    
    assertEquals(1, elevatorNumChangedCalled);    
  }
  
  @Test
  public void testNotifiesButtonChangedForEachFloorAndElevator()
  {
    assertEquals(0, buttonChangedCalled);
    
    updater.run();

    assertEquals(12, buttonChangedCalled);
    
    updater.run();

    assertEquals(24, buttonChangedCalled);
  }
  
  @Test
  public void testNotifiesFloorChangedForEachElevator()
  {
    assertEquals(0, floorChangedCalled);
    
    updater.run();
    
    assertEquals(3, floorChangedCalled);
    
    updater.run();
    
    assertEquals(6, floorChangedCalled);
  }
  
  @Override
  public void accelChanged(int nr, int accel)
  {
    accelChangedCalled++;
  }

  @Override
  public void buttonChanged(int nr, int floor, boolean active)
  {
    buttonChangedCalled++;
  }

  @Override
  public void floorChanged(int nr, int floor, DoorStatus status)
  {
    floorChangedCalled++;
  }

  @Override
  public void elevatorNumChanged(int nr)
  {
    elevatorNumChangedCalled++;
  }

  @Override
  public void positionChanged(int nr, int position)
  {
    positionChangedCalled++;
  }

  @Override
  public void speedChanged(int nr, int speed)
  {
    speedChangedCalled++;
  }

  @Override
  public void weightChanged(int nr, int weight)
  {
    weightChangedCalled++;
  }

  @Override
  public void capacityChanged(int nr, int capacity)
  {
    capacityChangedCalled++;
  }

  @Override
  public void buttonUpChanged(int floor, boolean active)
  {
    buttonUpChangedCalled++;
  }

  @Override
  public void buttonDownChanged(int floor, boolean active)
  {
    buttonDownChangedCalled++;
  }

  @Override
  public void floorNumChanged(int nr)
  {
    floorNumChangedCalled++;
  }

}
