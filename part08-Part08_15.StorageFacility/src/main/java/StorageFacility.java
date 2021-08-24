
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> store;
    
    public StorageFacility() {
        this.store = new HashMap<>();
    }
    
    public void add(String unit, String item){
        this.store.putIfAbsent(unit, new ArrayList<>());
        this.store.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit){
        return this.store.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item){
        if (!this.store.containsKey(storageUnit)){
            return;
        }
        
        this.store.get(storageUnit).remove(item);
        
        if (this.store.get(storageUnit).isEmpty()){
            this.store.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits(){
        ArrayList<String> units = new ArrayList<>();
        
        for (String storage:store.keySet()){
            if (this.store.get(storage) != null) {
                units.add(storage);
            }
        }
        
        return units;
    }
    
}
