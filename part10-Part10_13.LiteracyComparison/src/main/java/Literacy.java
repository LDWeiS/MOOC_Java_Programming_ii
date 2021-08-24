/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Literacy{
    
    private String country;
    private int year;
    private String gender;
    private double litPercent;
    
    public Literacy (String country, int year, String gender, double litPercent){
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.litPercent = litPercent;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public double getPercent() {
        return this.litPercent;
    }
    
    public int getLitPer() {
        return (int)this.litPercent;
    }
    
    @Override
    public String toString(){
        return this.getCountry() 
                + " (" 
                + this.getYear() 
                + "), "
                + this.getGender()
                + ", "
                + this.getPercent();
    }
    
    
}
