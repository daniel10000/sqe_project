package at.fhhagenberg.sqe.javafxapp;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhagenberg.sqe.domain.ElevatorSystemModel;
import at.fhhagenberg.sqe.domain.ModelNotifyable;

import org.junit.Before;

public class ElevatorSystemModelTest implements ModelNotifyable
{

  private ElevatorSystemModel model;
  
  private int initializedCalled;
  private int elevatorCount;
  private int floorCount;
  private int modelChangedCalled;

  @Before
  public void setup()
  {
    model = new ElevatorSystemModel();
    
    model.registerModelNotifyable(this);    

    initializedCalled = 0;
    elevatorCount = 0;
    floorCount = 0;
    modelChangedCalled = 0;
  }
  
  
  @Test
  public void testCallInitializeOnSystemChanged()
  {
    assertEquals(0, initializedCalled);
    
    model.speedChanged(3, 4);
    model.updateFinished(0);
    
    assertEquals(0, initializedCalled);
    
    model.floorNumChanged(3);
    
    assertEquals(0, initializedCalled);
    
    model.updateFinished(1);
    
    assertEquals(1, initializedCalled);
    
    model.elevatorNumChanged(3);
    
    assertEquals(1, initializedCalled);
    
    model.updateFinished(3);
    
    assertEquals(2, initializedCalled);
  }
  
  @Test
  public void testInitializeParameter()
  {
    assertEquals(0, initializedCalled);
    
    model.floorNumChanged(3);
    model.elevatorNumChanged(4);    
    model.updateFinished(3);
    
    assertEquals(1, initializedCalled);
    assertEquals(3, floorCount);
    assertEquals(4, elevatorCount);
  }
  
  @Override
  public void initialized(int elevatorCount, int floorCount)
  {
    initializedCalled++;
    this.elevatorCount = elevatorCount;
    this.floorCount = floorCount;
  }

  @Override
  public void modelChanged(ElevatorSystemModel model)
  {
    modelChangedCalled++;
  }

}
