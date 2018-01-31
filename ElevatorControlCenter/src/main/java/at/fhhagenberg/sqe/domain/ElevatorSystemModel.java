package at.fhhagenberg.sqe.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ElevatorSystemModel
{
	private Map<Integer, Elevator> elevators = new HashMap<Integer, Elevator>();
	private Map<Integer, Floor> floors = new HashMap<Integer, Floor>();

	private Set<ModelNotifyable> controllers;
	
	public ElevatorSystemModel()
	{
	}
	
	public void registerModelNotifyable(ModelNotifyable controller)
	{
		controllers.add(controller);
	}
	
	public void deregisterModelNotifyable(ModelNotifyable controller)
	{
		controllers.remove(controller);
	}
	
	
}
