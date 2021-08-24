package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    
    @Override
    public void start(Stage windows) {
        //First scene
        BorderPane firstView = new BorderPane();
        firstView.setTop(new Label("First view!"));
        Button nextView1 = new Button("To the second view!");
        firstView.setCenter(nextView1);
        
        //Second scene
        VBox secondView = new VBox();        
        Button nextView2 = new Button("To the third view!");
        Label textSecond = new Label("Second View!");
        secondView.getChildren().addAll(nextView2, textSecond);
        
        //Third scene
        GridPane thirdView = new GridPane();
        Label textThird = new Label("Third View!");
        Button nextView3 = new Button("To the first view!");
        thirdView.add(textThird, 0, 0);
        thirdView.add(nextView3, 1, 1);

        Scene first = new Scene(firstView);
        Scene second = new Scene(secondView);
        Scene third = new Scene(thirdView);

        nextView1.setOnAction((event) -> {
            windows.setScene(second);
        });

        nextView2.setOnAction((event) -> {
            windows.setScene(third);
        });
        
        nextView3.setOnAction((event) -> {
            windows.setScene(first);
        });


        windows.setScene(first);
        windows.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
        System.out.println("Hello world!");
    }

}
