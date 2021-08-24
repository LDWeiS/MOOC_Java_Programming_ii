
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
public class BoxWithMaxWeight extends Box{
    
    private int capacity;
    private ArrayList<Item> thingsInBox;
    
    public BoxWithMaxWeight(int capacity){
        this.capacity = capacity;
        this.thingsInBox = new ArrayList<>();
    }

    @Override
    public void add(Item item){
        if (item.getWeight() <= this.getCapacity() - this.getCurrent()){
            thingsInBox.add(item);
        }
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public int getCurrent(){
        int current = 0;
        
        for (Item thing:thingsInBox){
            current += thing.getWeight();
        }
        
        return current;
    }
    
    @Override
    public boolean isInBox(Item item){
    return thingsInBox.contains(item);
//        for (Item thing:thingsInBox){
//            if (item.equals(thing)){
//                return true;
//            }
//        }
//        
//        return false;
    }
    
    
    
}
