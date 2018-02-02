package at.fhhagenberg.sqe.controller;

import java.util.Set;

import at.fhhagenberg.sqe.domain.Elevator;
import at.fhhagenberg.sqe.domain.ElevatorSystemModel;
import at.fhhagenberg.sqe.domain.Floor;
import at.fhhagenberg.sqe.domain.ModelNotifyable;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ElevatorController implements ModelNotifyable, ElevatorClickedNotifyable
{
  private int elevatorCount = 0;
  private int floorCount = 0;

  private static final String UNIT_ACCEL = "ft/s²";
  private static final String UNIT_SPEED = "ft/s";
  private static final String UNIT_WEIGHT = "lbs";
  private static final String UNIT_CAPACITY = "";

  private static final int INIT_FLOOR = 0;

  private ElevatorPresenter[] elevatorPresenters;
  private FloorButtonPresenter floorButtonPresenter;
  
  private Commandable commandable;

  public ElevatorController()
  {
  }
  
  public void setCommandable(Commandable commandable)
  {
    this.commandable = commandable;
  }

  @FXML
  public void initialize()
  {
    System.out.println("initialized controller");
    setSelectedElevator(INIT_FLOOR);
  }

  @FXML
  GridPane elevatorsArea;

  @FXML
  TextField textFieldElevatorNr;

  @FXML
  TextField textFieldSpeed;

  @FXML
  TextField textFieldAcceleration;

  @FXML
  TextField textFieldWeight;

  @FXML
  TextField textFieldCapacity;
  
  @FXML
  public void toggleMode()
  {
    if(commandable != null)
      commandable.toggleMode();
  }

  private int selectedElevator;

  private void setAccel(int accel)
  {
    textFieldAcceleration.setText(accel + " " + UNIT_ACCEL);
  }

  private void setSpeed(int speed)
  {
    textFieldSpeed.setText(speed + " " + UNIT_SPEED);
  }

  private void setWeight(int weight)
  {
    textFieldWeight.setText(weight + " " + UNIT_WEIGHT);
  }

  private void setCapacity(int capacity)
  {
    textFieldCapacity.setText(capacity + " " + UNIT_CAPACITY);
  }

  private void setSelectedElevator(int elevator)
  {
    selectedElevator = elevator;
    textFieldElevatorNr.setText(Integer.toString(elevator));
  }
  
  private void updateElevatorPresenters()
  {
    elevatorPresenters = new ElevatorPresenter[elevatorCount];
    
    for(int i = 0; i < elevatorCount; i++)
    {
      ElevatorPresenter p = new ElevatorPresenter(i, floorCount, this);
      elevatorPresenters[i] = p;
    }
  }
  
  private void updateFloorButtonPresenter()
  {
    floorButtonPresenter = new FloorButtonPresenter(floorCount);
  }
  
  private void createElevatorsArea()
  {
    if(elevatorCount != 0 && floorCount != 0)
    {
      elevatorsArea.getChildren().clear();
      
      floorButtonPresenter.addNodes(elevatorsArea, 0, 0);
      
      for(ElevatorPresenter p : elevatorPresenters)
      {
        p.addNodes(elevatorsArea, 1);
      }
    }
  }

  @Override
  public void elevatorFloorClicked(int elevator, int floor)
  {
    System.out.println("clicked " + elevator + " " + floor);
    try
    {
      commandable.setTargetFloor(elevator, floor);
    } 
    catch (Exception e)
    {
      System.out.println(e.toString());
    }
  }

  @Override
  public void elevatorSelected(int elevator)
  {
    System.out.println("selected " + elevator);
    
    setSelectedElevator(elevator);
  }

  @Override
  public void initialized(int elevatorCount, int floorCount)
  {
    System.out.println("initialized " + elevatorCount + " " + floorCount);
    
    this.floorCount = floorCount;
    this.elevatorCount = elevatorCount;
    
    updateElevatorPresenters();
    updateFloorButtonPresenter();
    
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        createElevatorsArea();
      }
    });
  }
  
  @Override
  public void modelChanged(ElevatorSystemModel model)
  {
    Set<Elevator> elevators = model.getElevators();
    Set<Floor> floors = model.getFloors();
    
    Platform.runLater(new Runnable()
    {
      public void run()
      {
        for(Elevator e : elevators)
        {
          int i = e.getNumber();
          if(elevatorPresenters != null && elevatorPresenters[i] != null && i >= 0 && i < elevatorPresenters.length)
          {
            for(int j = 0; j < floors.size(); j++)
            {          
              elevatorPresenters[i].setElevatorButton(j, e.getFloorButtonsActive().contains(j));
            }
            elevatorPresenters[i].setElevatorPosition(e.getCurrentFloor(), e.getDoorStatus());
            
          }
          if(i == selectedElevator)
          {
            setAccel(e.getAcceleration());
            setWeight(e.getWeight());
            setCapacity(e.getCapacity());
            setSpeed(e.getSpeed());
          }
        }
        
        for(Floor f : floors)
        {
          int i = f.getNr();
          if(floorButtonPresenter != null)
          {
            floorButtonPresenter.setDownButton(i, f.getDownButton());
            floorButtonPresenter.setUpButton(i, f.getUpButton());
          }
        }
      }
    });
  }
}










