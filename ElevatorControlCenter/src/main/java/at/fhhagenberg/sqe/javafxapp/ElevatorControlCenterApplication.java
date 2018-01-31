package at.fhhagenberg.sqe.javafxapp;

import at.fhhagenberg.sqe.controller.ElevatorController;
import at.fhhagenberg.sqe.domain.ElevatorSystemModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ElevatorControlCenterApplication extends Application 
{	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Main.fxml"));
		
		Parent root = loader.load();
		
		ElevatorController controller = loader.getController();
		
//		ElevatorSystemModel model = new ElevatorSystemModel();
//		
//		model.registerModelNotifyable(controller);
		
		Scene scene = new Scene(root, 500, 500);		
		scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(420);
		primaryStage.setMinHeight(440);
		primaryStage.setTitle("ElevatorSytem");
		primaryStage.setOnHidden(e -> controller.shutdown());
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
