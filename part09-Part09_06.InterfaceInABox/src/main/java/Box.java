
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Box implements Packable{
    
    private ArrayList<Packable> box;
    private double max;
    
    public Box(double maximumCapacity) {
        this.box = new ArrayList<>();
        this.max = maximumCapacity;
    }
    
    @Override
    public double weight(){
        double current = 0;
        
        for (Packable item:box){
            current += item.weight();
        }
        
        return current;
    }
    
    public void add(Packable item){
        if (this.getCapacity() >= item.weight()){
            box.add(item);
        }
    }

    
    public double getCapacity(){
        return this.getMax() - weight();
    }
    
    public double getMax(){
        return this.max;
    }
    
    @Override
    public String toString(){
        return "Box: " + box.size() + " items, total weight " + weight() + " kg";
    }
    
}
