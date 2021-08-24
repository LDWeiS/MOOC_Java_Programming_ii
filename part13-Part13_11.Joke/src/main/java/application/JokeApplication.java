package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {
    
    @Override
    public void start(Stage window) {
        Button joke = new Button("Joke");
        Button ans = new Button("Answer");
        Button exp = new Button("Explanation");
        Label lols = new Label("What do you call a bear with no teeth?");
        
        GridPane firstView = new GridPane();
        firstView.add(joke, 1, 0);
        firstView.add(ans, 1, 1);
        firstView.add(exp, 1, 2);
        firstView.add(lols, 1, 3);
        
        firstView.setPrefSize(300, 180);
        firstView.setAlignment(Pos.CENTER);
        firstView.setVgap(10);
        firstView.setHgap(10);
        firstView.setPadding(new Insets(20, 20, 20, 20));
        
        Scene firstScene = new Scene(firstView);
        
        joke.setOnAction((event) -> {
            lols.setText("What do you call a bear with no teeth?");
        });
        
        ans.setOnAction((event) -> {
            lols.setText("A gummy bear.");
        });
        
        exp.setOnAction((event) -> {
            lols.setText("Because they only have gums LOLS!");
        });
        
        window.setScene(firstScene);
        window.show();
        
    }


    public static void main(String[] args) {
        launch(JokeApplication.class);
        System.out.println("Hello world!");
    }
}
