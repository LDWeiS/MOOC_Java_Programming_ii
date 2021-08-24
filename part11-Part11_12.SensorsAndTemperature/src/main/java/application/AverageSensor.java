/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nick Woi
 */
public class AverageSensor implements Sensor {
    
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;
    
    public AverageSensor () {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd){
        this.sensors.add(toAdd);
    }
    
    @Override
    public void setOn() {
        for (Sensor sensor:sensors) {
            sensor.setOn();
        }
    }
    
    @Override
    public void setOff() {
        for (Sensor sensor:sensors) {
            sensor.setOff();
        }
    }
    
    @Override
    public int read() {
        if (sensors.isEmpty()) {
                throw new IllegalArgumentException("No sensor.");
            }
        
        int ave = 0;
        
        for (Sensor sensor:sensors) {
            if (!sensor.isOn()) {
                throw new IllegalArgumentException("Sensor is off.");
            }
            ave += sensor.read();
        }
        
        readings.add(ave/sensors.size());
        return ave/sensors.size();
    }
    
    @Override
    public boolean isOn() {
        boolean isOn = false;
        
        for (Sensor sensor:sensors) {
            if (sensor.isOn()){
                isOn = true;
            }
        }
        
        return isOn;
    }
    
    public List<Integer> readings(){
        return this.readings;
    }
        
}
