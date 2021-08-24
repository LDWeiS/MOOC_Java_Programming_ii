package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {
    
    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Universit of Helsinki, Shanghai ranking");
        
        
        XYChart.Series shangHai = new XYChart.Series();
        shangHai.setName("Shanghai");
        
        shangHai.getData().add(new XYChart.Data(2007, 73));
        shangHai.getData().add(new XYChart.Data(2008, 68));
        shangHai.getData().add(new XYChart.Data(2009, 72));
        shangHai.getData().add(new XYChart.Data(2010, 72));
        shangHai.getData().add(new XYChart.Data(2011, 74));
        shangHai.getData().add(new XYChart.Data(2012, 73));
        shangHai.getData().add(new XYChart.Data(2013, 76));
        shangHai.getData().add(new XYChart.Data(2014, 73));
        shangHai.getData().add(new XYChart.Data(2015, 67));
        shangHai.getData().add(new XYChart.Data(2016, 56));
        shangHai.getData().add(new XYChart.Data(2017, 56));
        
        lineChart.getData().add(shangHai);
        
        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
        System.out.println("Hello world!");
    }

}
