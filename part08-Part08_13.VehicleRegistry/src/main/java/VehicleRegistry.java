
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
public class VehicleRegistry {
    
    private HashMap<LicensePlate, String> registry;
    
    public VehicleRegistry(){
        this.registry = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner){
        if (registry.containsKey(licensePlate) &&
                registry.containsValue(null)){
            registry.put(licensePlate, owner);
            return true;  
        }
        
        if (!registry.containsKey(licensePlate)){
            registry.put(licensePlate, owner);
            return true;  
        }
        
        return false;
    }
    
    public String get(LicensePlate licensePlate) {
        return registry.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (registry.containsKey(licensePlate)) {
            registry.remove(licensePlate);
            return true;
        }
        
        return false;
    }
    
    public void printLicensePlates() {
        for (LicensePlate plate:registry.keySet()){
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        
        for (HashMap.Entry<LicensePlate, String> entry:registry.entrySet()){
            if(!owners.contains(entry.getValue())) {
                owners.add(entry.getValue());
            }
        }
        
        for (int i = 0; i < owners.size(); i++) {
            System.out.println(owners.get(i));
        }
    }
    
}
