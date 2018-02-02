package at.fhhagenberg.sqe.controller;

import at.fhhagenberg.sqe.domain.DoorStatus;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ElevatorPresenter
{
  private ImageView direction;
  private Rectangle[] floors;
  private Rectangle[] buttons;
  private Button elevatorNumber;
  
  private int elevatorNr;
  
  public ElevatorPresenter(int elevatorNr, int floorCount, ElevatorClickedNotifyable notifyable)
  {
    this.elevatorNr = elevatorNr;
    
    direction = new ImageView();
    
    floors = new Rectangle[floorCount];
    
    buttons = new Rectangle[floorCount];
    
    for(int i = 0; i < floorCount; i++)
    {
      Rectangle r = new Rectangle();
      r.setWidth(40);
      r.setHeight(40);
      r.setOnMouseClicked(new ElevatorFloorClickedEventHandler(elevatorNr, i, notifyable));
      floors[i] = r;
      
      Rectangle b = new Rectangle();
      b.setWidth(15);
      b.setHeight(15);
      b.setFill(Color.RED);
      buttons[i] = b;
    }
    
    elevatorNumber = new Button(Integer.toString(elevatorNr));
    elevatorNumber.setAlignment(Pos.CENTER);
    elevatorNumber.setOnMouseClicked(new ElevatorSelectedEventHandler(elevatorNr, notifyable));

  }
  
  public void addNodes(GridPane pane, int colIdxOffset)
  {
    pane.add(direction, elevatorNr+colIdxOffset, 0);
    
    for(int i = 0; i < floors.length; i++)
    {
      int fIdx = (floors.length - i);
      pane.add(floors[i], elevatorNr+colIdxOffset, fIdx);
    }

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setVgap(10);
    
    pane.add(grid, elevatorNr+colIdxOffset, floors.length + 1);
    
    for(int i = 0; i < buttons.length; i++)
    {
      int bIdx = (buttons.length - 1 - i);
      grid.add(buttons[i], elevatorNr+colIdxOffset, bIdx);
    }
    
    grid.add(elevatorNumber, elevatorNr+colIdxOffset, buttons.length + 1);
  }
  
  public void setElevatorPosition(int floorNr, DoorStatus doorStatus)
  {
    if(floorNrValid(floorNr))
    {
      for(Rectangle f : floors)
      {
        f.setFill(Color.WHITE);
      }
      floors[floorNr].setFill(doorStatus == DoorStatus.Opened ? Color.YELLOW : Color.ORANGE);
    }
  }
  
  public void setElevatorButton(int floorNr, boolean active)
  {
    if(floorNrValid(floorNr))
    {
      buttons[floorNr].setFill(active ? Color.GREEN : Color.RED);
    }
  }
  
  private boolean floorNrValid(int floorNr)
  {
    return floorNr >= 0 && floorNr < floors.length;
  }
}
