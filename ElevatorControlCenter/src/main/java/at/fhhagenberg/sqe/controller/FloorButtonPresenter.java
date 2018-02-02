package at.fhhagenberg.sqe.controller;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FloorButtonPresenter
{
  private ImageView upButtons[];
  private ImageView downButtons[];
  
  private int floorCount;
  
  public FloorButtonPresenter(int floorCount)
  {
    this.floorCount = floorCount;
    
    upButtons = new ImageView[floorCount];
    downButtons = new ImageView[floorCount];
    
    for(int i = 0; i < floorCount; i++)
    {
      upButtons[i] = new ImageView("arrow_up.png");
      downButtons[i] = new ImageView("arrow_down.png");
    }
  }
  
  public void addNodes(GridPane pane, int column, int rowIdxOffset)
  {
    for(int i = 0; i < floorCount; i++)
    {
      pane.add(getGridOfUpAndDown(i), column, floorCount - i + rowIdxOffset);
    }
  }
  
  private Node getGridOfUpAndDown(int idx)
  {
    GridPane pane = new GridPane();
    pane.add(upButtons[idx], 0, 0);
    pane.add(downButtons[idx], 0, 1);
    return pane;
  }
  
  public void setUpButton(int floor, boolean active)
  {
    if(floorIsValid(floor))
    {
      upButtons[floor].setImage(new Image(active ? "arrow_up_green.png" : "arrow_up.png"));
    }
    else
    {
      System.out.println("error wrong floor nr");
    }
  }
  
  public void setDownButton(int floor, boolean active)
  {
    if(floorIsValid(floor))
    {
      downButtons[floor].setImage(new Image(active ? "arrow_down_green.png" : "arrow_down.png"));
    }
    else
    {
      System.out.println("error wrong floor nr");
    }
  }
  
  private boolean floorIsValid(int floor)
  {
    return floor >= 0 && floor < floorCount;
  }
}





