package at.fhhagenberg.sqe.controller;

public interface Commandable
{
	void setTargetFloor(int nr, int floor);
	
	void setMode(ElevatorMode mode);
	ElevatorMode getMode();
	
	void toggleMode();
}
