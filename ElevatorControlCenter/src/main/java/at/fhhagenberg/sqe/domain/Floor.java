package at.fhhagenberg.sqe.domain;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Floor 
{
	private BooleanProperty upButton = new SimpleBooleanProperty();
	private BooleanProperty downButton = new SimpleBooleanProperty();
	//private IntegerProperty height = new SimpleIntegerProperty();
	
	public Floor() 
	{
		//this.height.set(7);
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
	/*
	public Integer getHeight()
	{
		return height.get();
	}

	public void setHeight(Integer height)
	{
		this.height.set(height);
	}
	*/
}
