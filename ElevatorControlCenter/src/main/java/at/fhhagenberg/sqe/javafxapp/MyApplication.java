package at.fhhagenberg.sqe.javafxapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
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

public class MyApplication extends Application 
{
	int rowNum = 5;
	int colNum = 5;
	int gridHeight = 10;
	int gridWidth = 10;
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(true);
		grid.setHgap(5);
		grid.setVgap(5);
		//Node content = createContent();
		//pane.setCenter(content);
		//BorderPane.setAlignment(content, Pos.CENTER);

		Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.WHITE};

		for (int row = 0; row < rowNum; row++) 
		{
		    for (int col = 0; col < colNum; col++) 
		    {
		    	
		        int n = 3;
		        Rectangle rec = new Rectangle();
		        rec.setWidth(40);
		        rec.setHeight(40);
		        if(col == 0)
		        {
		        	n = 4;
		        }
		        rec.setFill(colors[n]);
		        GridPane.setRowIndex(rec, row);
		        GridPane.setColumnIndex(rec, col);
		        grid.getChildren().addAll(rec);
		    }
		}
		
		Scene scene = new Scene(grid, 800, 800);
		scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("ElevatorSytem");
		primaryStage.show();
	}
	
	/*
	private Node createContent() {
		HBox line = new HBox(5.0);
		line.setAlignment(Pos.CENTER_LEFT);

		line.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

		TextField a = new TextField();
		a.setText("0");
		a.setId("a");
		a.getStyleClass().addAll("summand");

		TextField b = new TextField();
		b.setText("0");
		b.setId("b");
		b.getStyleClass().addAll("summand");

		Label result = new Label(String.format("%.2f", 0.0));
		result.setId("result");
		result.getStyleClass().addAll("sum");

		Button compute = new Button("=");
		compute.setId("compute");
		compute.setOnAction(evt -> result.setText(computeSum(a.getText(), b.getText())));

		line.getChildren().addAll(a, new Label("+"), b, compute, result);

		return line;
	}
	*/
	
	private String computeSum(String a, String b) {
		return String.format("%.2f", Double.parseDouble(a) + Double.parseDouble(b));
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
