package at.fhhagenberg.sqe.controller;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ElevatorController
{
	@FXML
	Rectangle elevator1Floor3;
	
	@FXML
	Rectangle elevator1Floor2;
	
	@FXML
	Rectangle elevator1Floor1;
	
	@FXML
	Rectangle elevator1Floor0;
	
		
	@FXML
	Rectangle elevator2Floor3;
	
	@FXML
	Rectangle elevator2Floor2;
	
	@FXML
	Rectangle elevator2Floor1;
	
	@FXML
	Rectangle elevator2Floor0;
	
	
	@FXML
	Rectangle elevator3Floor3;
	
	@FXML
	Rectangle elevator3Floor2;
	
	@FXML
	Rectangle elevator3Floor1;
	
	@FXML
	Rectangle elevator3Floor0;
	
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
	ImageView floor3UpButton;
	
	@FXML
	ImageView floor3DownButton;
	
	@FXML
	ImageView floor2UpButton;
	
	@FXML
	ImageView floor2DownButton;
	
	@FXML
	ImageView floor1UpButton;
	
	@FXML
	ImageView floor1DownButton;
	
	
	@FXML
	ImageView floor0UpButton;
	
	@FXML
	ImageView floor0DownButton;
	
	@FXML
	Rectangle elevator1SelectedFloor3;
	
	@FXML
	Rectangle elevator1SelectedFloor2;
	
	@FXML
	Rectangle elevator1SelectedFloor1;
	
	@FXML
	Rectangle elevator1SelectedFloor0;
	
	@FXML
	Rectangle elevator2SelectedFloor3;
	
	@FXML
	Rectangle elevator2SelectedFloor2;
	
	@FXML
	Rectangle elevator2SelectedFloor1;
	
	@FXML
	Rectangle elevator2SelectedFloor0;
	
	@FXML
	Rectangle elevator3SelectedFloor3;
	
	@FXML
	Rectangle elevator3SelectedFloor2;
	
	@FXML
	Rectangle elevator3SelectedFloor1;
	
	@FXML
	Rectangle elevator3SelectedFloor0;
	
	@FXML
	ImageView elevator1Direction;
	
	@FXML
	ImageView elevator2Direction;
	
	@FXML
	ImageView elevator3Direction;
	
	@FXML
	protected void buttonPressed(){
		String text = "Hello";//textArea.getText();
		//textArea.setText(text);
		Image img = floor3UpButton.getImage();
		floor3UpButton.setImage(new Image("./arrow_up_green.png"));
		String str = img.impl_getUrl();
		//textArea.clear();
	}
	
	@FXML
	protected void elevator1Pressed() 
	{
		textFieldElevatorNr.setText("1");
	}
	
	@FXML
	protected void elevator2Pressed() 
	{
		textFieldElevatorNr.setText("2");
	}
	
	@FXML
	protected void elevator3Pressed() 
	{
		textFieldElevatorNr.setText("3");
	}
	
	private IntegerProperty counter;
	
	public IntegerProperty counterProperty() {
	    return counter;
	}
}
