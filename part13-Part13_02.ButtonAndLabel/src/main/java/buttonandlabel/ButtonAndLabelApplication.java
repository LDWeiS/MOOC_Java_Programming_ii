package buttonandlabel;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndLabelApplication extends Application {
    
    @Override
    public void start(Stage window) {
        Button buttonComponent = new Button("Text Element");
        Label textComponent = new Label("Text element");
        
        FlowPane root = new FlowPane();
        root.getChildren().add(buttonComponent);
        root.getChildren().add(textComponent);
        
        Scene view = new Scene(root);
        
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
        System.out.println("Hello world!");
    }

}
