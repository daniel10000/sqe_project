package at.fhhagenberg.sqe.javafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ElevatorControlCenterApplication extends Application 
{	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
		
		Scene scene = new Scene(root, 500, 500);		
		scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(420);
		primaryStage.setMinHeight(440);
		primaryStage.setTitle("ElevatorSytem");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
