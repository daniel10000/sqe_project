package at.fhhagenberg.sqe.controller;

public interface ElevatorClickedNotifyable
{
  void elevatorFloorClicked(int elevator, int floor);
  void elevatorSelected(int elevator);
}
