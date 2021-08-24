package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {
    
    @Override
    public void start(Stage window) {
        //Components for first view
        Label enterName = new Label("Enter your name and start.");
        TextField nameBox = new TextField();
        Button nextView1 = new Button("Start");
        
        //Components for second view
        Label displayWelcome = new Label("Welcome");
        
        //First scene
        GridPane firstView = new GridPane();
        firstView.add(enterName, 0, 0);
        firstView.add(nameBox, 0, 1);
        firstView.add(nextView1, 0, 2);
        
        //First scene styling
        firstView.setPrefSize(300, 180);
        firstView.setAlignment(Pos.CENTER);
        firstView.setVgap(10);
        firstView.setHgap(10);
        firstView.setPadding(new Insets(20, 20, 20, 20));
        
        //Set first scene
        Scene firstScene = new Scene(firstView);
        
        //Second scene
        StackPane secondView = new StackPane();
        secondView.setPrefSize(300, 180);
        secondView.getChildren().add(displayWelcome);
        secondView.setAlignment(Pos.CENTER);
        
        //Set second scene
        Scene secondScene = new Scene(secondView);
                
        //Command action
        nameBox.textProperty().addListener((change, oldValue, newValue) -> {
            String name = newValue;
            displayWelcome.setText("Welcome " + name + "!");
        });
        
        nextView1.setOnAction((event) -> {
            window.setScene(secondScene);
        });
        
        window.setTitle("Greetings!");
        window.setScene(firstScene);
        window.show();
    }


    public static void main(String[] args) {
        launch(GreeterApplication.class);
        System.out.println("Hellow world! :3");
    }
}
