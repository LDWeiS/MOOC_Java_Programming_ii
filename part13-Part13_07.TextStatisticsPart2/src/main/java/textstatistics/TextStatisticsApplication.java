package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.event.ChangeListener;


public class TextStatisticsApplication extends Application{
    
    @Override
    public void start(Stage window) throws Exception {
        TextArea textInput = new TextArea();
        Label letter = new Label("Letters: 0");
        Label word = new Label("Words: 0");
        Label lWord = new Label("The longest word is: ");
        
        BorderPane layout = new BorderPane();
        layout.setCenter(textInput);

        HBox hLay = new HBox(); 
        hLay.setSpacing(20);
        hLay.getChildren().addAll(letter, word, lWord);
        
        layout.setBottom(hLay);

        
        textInput.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
        
            letter.setText("Letters: " + characters);
            word.setText("Words: " + words);
            lWord.setText("The longest word is: " + longest);
        });
        
        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");
    }

}
