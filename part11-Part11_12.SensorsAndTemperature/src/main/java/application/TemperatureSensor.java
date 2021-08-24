/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Nick Woi
 */
public class TemperatureSensor implements Sensor {
    
    private boolean status;
    
    public TemperatureSensor () {
        this.status = false;
    }
    
    @Override
    public void setOn() {
        this.status = true;
    }
    
    @Override
    public void setOff() {
        this.status = false;
    }
    
    @Override
    public int read() {
        Random rd = new Random();
        
        if (this.status == false) {
            throw new IllegalArgumentException("Sensor is off.");
        }
        
        return rd.nextInt(30 + 30) - 30;
    }
    
    @Override
    public boolean isOn() {
        return this.status;
    }
    
}
