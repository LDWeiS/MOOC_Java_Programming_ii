package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application {
    
    @Override
    public void start(Stage window) {
        TextField input = new TextField("");
        Button update = new Button("Update");
        Label output = new Label("");
        
        update.setOnAction((event) -> {
            output.setText(input.getText());
        });

        VBox notifier = new VBox();
        notifier.setSpacing(10);
        notifier.getChildren().addAll(input, update, output);


        Scene scene = new Scene(notifier);

        window.setScene(scene);
        window.show();
        
    }


    public static void main(String[] args) {
        launch(NotifierApplication.class);
        System.out.println("Hello world!");
    }

}
