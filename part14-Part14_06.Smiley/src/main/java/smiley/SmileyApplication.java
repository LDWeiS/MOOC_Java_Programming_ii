package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {
    
    @Override
    public void start (Stage window) {
        BorderPane layout = new BorderPane();
        
        Canvas paintingCanvas = new Canvas(640, 640);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        layout.setCenter(paintingCanvas);
        
        painter.setFill(Color.WHITE);
        painter.clearRect(0, 0, 640, 480);
        
        painter.setFill(Color.BLACK);
        
        //Eyes
        painter.fillRect(160, 80, 80, 80);
        painter.fillRect(400, 80, 80, 80);
        
        //Mouth
        painter.fillRect(80, 320, 80, 80);
        painter.fillRect(480, 320, 80, 80);
        painter.fillRect(160, 400, 320, 80);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(SmileyApplication.class);
        System.out.println("Hello world!");
    }

}
