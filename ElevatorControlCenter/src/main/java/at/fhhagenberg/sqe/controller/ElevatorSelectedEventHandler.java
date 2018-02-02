package at.fhhagenberg.sqe.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ElevatorSelectedEventHandler implements EventHandler<MouseEvent>
{
  private int elevator;
  private ElevatorClickedNotifyable notifyable;
  
  public ElevatorSelectedEventHandler(int elevator, ElevatorClickedNotifyable notifyable)
  {
    this.elevator = elevator;
    this.notifyable = notifyable;
  }
  
  @Override
  public void handle(MouseEvent event)
  {
    System.out.println("ElevatorSelectedEvent " + elevator);
    notifyObserver();
  }

  private void notifyObserver()
  {
    if(notifyable != null)
      notifyable.elevatorSelected(elevator);
  }
  
}
