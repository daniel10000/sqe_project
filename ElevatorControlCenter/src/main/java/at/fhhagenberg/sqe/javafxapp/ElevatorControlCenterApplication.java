package at.fhhagenberg.sqe.javafxapp;

import java.rmi.Naming;

import at.fhhagenberg.sqe.controller.Commander;
import at.fhhagenberg.sqe.controller.ElevatorController;
import at.fhhagenberg.sqe.data.DataUpdater;
import at.fhhagenberg.sqe.domain.ElevatorSystemModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sqelevator.ElevatorSystemDummy;
import sqelevator.IElevator;

public class ElevatorControlCenterApplication extends Application 
{	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Main.fxml"));
		
		Parent root = loader.load();
		
		ElevatorController controller = loader.getController();
		
//		IElevator elevator = new ElevatorSystemDummy();
		IElevator elevator = (IElevator)Naming.lookup("rmi://localhost/ElevatorSim");
		
    DataUpdater updater = new DataUpdater(elevator);

		ElevatorSystemModel model = new ElevatorSystemModel();

		Commander commander = new Commander(elevator, model);
		
		updater.registerElevator(model);
		updater.registerUpdateable(model);
		updater.registerUpdateable(commander);
		model.registerModelNotifyable(controller);
		
		controller.setCommandable(commander);
		
		Scene scene = new Scene(root, 500, 500);		
		scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(420);
		primaryStage.setMinHeight(440);
		primaryStage.setTitle("ElevatorSytem");

		updater.start();

		primaryStage.setOnHidden(e -> updater.stop());		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
