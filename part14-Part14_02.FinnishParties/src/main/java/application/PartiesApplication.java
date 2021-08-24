package application;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    
    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        xAxis.setLabel("Year");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        HashMap<String, HashMap<Integer, Double>> values = read("partiesdata.tsv");
        
        // go through the parties and add them to the chart
        values.keySet().stream().forEach(party -> {
            // a different data set for every party
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            // add the party's support numbers to the data set
            values.get(party).entrySet().stream().forEach(pair -> {
            data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            // and add the data set to the chart
            lineChart.getData().add(data);
        });

        Scene view = new Scene(lineChart, 640, 480);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
        System.out.println("Hello world!");
    }
    
    private HashMap<String, HashMap<Integer, Double>> read(String file) {
        HashMap<String, HashMap<Integer, Double>> dataOut = new HashMap<>();
        ArrayList<Integer> yearList = new ArrayList<>();

        try(Scanner data = new Scanner(Paths.get(file))) {
            
            String yearLine = data.nextLine();
            String[] year = yearLine.split("\t");
            for (int i = 1; i < year.length; i++){
                yearList.add(Integer.valueOf(year[i]));
            }
            
            while(data.hasNext()) {
                String partyLine = data.nextLine();
                String[] partyData = partyLine.split("\t");
                String partyName = partyData[0];
                
                HashMap<Integer, Double> yearData = new HashMap<>();
                for (int i = 1; i < partyData.length; i++){
                    if (!partyData[i].equals("-")) {
                        yearData.put(yearList.get(i-1), Double.valueOf(partyData[i]));                        
                    }
                }
                
                dataOut.put(partyName, yearData);
            }   

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return dataOut;
    }

}
