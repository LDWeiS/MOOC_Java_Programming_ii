package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        //Main window interface
        BorderPane main = new BorderPane();
        
        // Monthly savings slider
        BorderPane monthly = new BorderPane();
        
        Label textMonthly = new Label("Monthly savings");
        
        Slider saving = new Slider(25, 250, 25);
        saving.setSnapToTicks(true);
        saving.setShowTickMarks(true);
        saving.setBlockIncrement(500);
        saving.setShowTickLabels(true);
        
        Label displayPercent = new Label(String.valueOf(saving.getValue()));

        monthly.setLeft(textMonthly);
        BorderPane.setMargin(textMonthly, new Insets(10));
        monthly.setCenter(saving);
        BorderPane.setMargin(saving, new Insets(10));
        monthly.setRight(displayPercent);
        BorderPane.setMargin(displayPercent, new Insets(10));
        
        // Yearly interest slider
        BorderPane annual = new BorderPane();
        
        Label annualMonthly = new Label("Yearly interest rate");
        
        Slider interest = new Slider(0, 10, 0);
        interest.setShowTickMarks(true);
        interest.setShowTickLabels(true);
        interest.setMajorTickUnit(1);
        interest.setMinorTickCount(0);
        interest.setSnapToTicks(true);
        
        Label displayInterest = new Label(String.valueOf(interest.getValue()));
        
        annual.setLeft(annualMonthly);
        BorderPane.setMargin(annualMonthly, new Insets(10));
        annual.setCenter(interest);
        BorderPane.setMargin(interest, new Insets(10));
        annual.setRight(displayInterest);
        BorderPane.setMargin(displayInterest, new Insets(10));
        
        // Sliders at top of main window
        VBox sliders = new VBox();
        
        sliders.setPadding(new Insets(10));
        sliders.setSpacing(10);
        
        sliders.getChildren().addAll(monthly, annual);
        
        // Line chart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");
        lineChart.setAnimated(false);
        lineChart.setLegendVisible(false);
        
        XYChart.Series savings = new XYChart.Series();
        XYChart.Series intSavings = new XYChart.Series();
        
        // Listeners for graph update
        // Savings graph information
        saving.setOnMouseReleased((event) -> {
            displayPercent.setText(String.valueOf(saving.getValue()));
            
            lineChart.getData().remove(savings);
            savings.getData().clear();
            
            // Calculate savings and add data to the chart
            Double annualValue = saving.getValue() * 12;

            for (int i = 0; i < 31; i++) {
                int yearlySavings = (int) Math.round(annualValue * i);
                savings.getData().add(new XYChart.Data(i, yearlySavings));
            }

            lineChart.getData().add(savings);
 
        });
        
        // Interest graph information
        interest.setOnMouseReleased((event) -> {
            double interestValue = interest.getValue();
            displayInterest.setText(String.valueOf(interestValue));
            
            lineChart.getData().remove(intSavings);
            intSavings.getData().clear();
            
            // Calculate savings and add data to the chart
            double annualValue = saving.getValue() * 12;
            double totalSavings = 0;
            
            intSavings.getData().add(new XYChart.Data(0, 0));

            for (int i = 1; i <= 30; i++) {
                totalSavings += annualValue * Math.pow((1 + interestValue/100), i);
                intSavings.getData().add(new XYChart.Data(i, totalSavings));
            }

            lineChart.getData().add(intSavings);
        });
        
        main.setTop(sliders);
        main.setCenter(lineChart);
        
        Scene view = new Scene(main, 320, 300);
        stage.setScene(view);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
        System.out.println("Hello world!");
    }

}
