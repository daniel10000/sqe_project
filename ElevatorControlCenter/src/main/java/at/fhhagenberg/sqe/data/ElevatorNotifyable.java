package at.fhhagenberg.sqe.data;

import at.fhhagenberg.sqe.domain.DoorStatus;

public interface ElevatorNotifyable
{
	void commitedDirectionChanged(int nr, int direction);
	
	void accelChanged(int nr, int accel);
	
	void buttonChanged(int nr, int floor, boolean active);
		
	void floorChanged(int nr, int floor, DoorStatus status);
	
	void elevatorNumChanged(int nr);
	
	void positionChanged(int nr, int position);
	
	void speedChanged(int nr, int speed);
	
	void weightChanged(int nr, int weight);
	
	void capacityChanged(int nr, int capacity);
	
	void buttonUpChanged(int floor, boolean active);
	
	void buttonDownChanged(int floor, boolean active);
	
	// floor height
	
	void floorNumChanged(int nr);
	
	// TODO get services floors
	// TODO get target
	// TODO set committed direction
	// TODO set services floors
	// TODO set target
	// TODO get clock tick
}










