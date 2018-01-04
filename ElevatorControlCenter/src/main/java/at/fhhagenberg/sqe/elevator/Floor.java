package at.fhhagenberg.sqe.elevator;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Floor 
{
	private BooleanProperty upButton = new SimpleBooleanProperty();
	private BooleanProperty downButton = new SimpleBooleanProperty();
	
	public Floor() 
	{
		this.upButton.set(false);
		this.downButton.set(false);	
	}

	public Boolean getUpButton() 
	{
		return upButton.get();
	}

	public void setUpButton(Boolean upButton) 
	{
		this.upButton.set(upButton);
	}

	public Boolean getDownButton()
	{
		return downButton.get();
	}

	public void setDownButton(Boolean downButton)
	{
		this.downButton.set(downButton);
	}
}
