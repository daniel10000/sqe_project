package at.fhhagenberg.sqe.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ElevatorFloorClickedEventHandler implements EventHandler<MouseEvent>
{

  private int elevator;
  private int floor;
  private ElevatorClickedNotifyable notifyable;
  
  public ElevatorFloorClickedEventHandler(int elevator, int floor, ElevatorClickedNotifyable notifyable)
  {
    this.elevator = elevator;
    this.floor = floor;
    this.notifyable = notifyable;
  }
  
  @Override
  public void handle(MouseEvent event)
  {
    System.out.println("ElevatorFloorClickedEvent " + elevator + " " + floor);
    notifyObserver();
  }

  private void notifyObserver()
  {
    if(notifyable != null)
      notifyable.elevatorFloorClicked(elevator, floor);
  }
}
