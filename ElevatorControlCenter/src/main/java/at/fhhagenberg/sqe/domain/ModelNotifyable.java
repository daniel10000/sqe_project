package at.fhhagenberg.sqe.domain;

public interface ModelNotifyable
{
  void initialized(int elevatorCount, int floorCount);
	void modelChanged(ElevatorSystemModel model);
}
