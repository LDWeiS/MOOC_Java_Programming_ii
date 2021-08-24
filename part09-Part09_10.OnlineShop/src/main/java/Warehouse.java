
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Warehouse {
    
    private Map<String, Integer> store;
    private Map<String, Integer> inventory;
    
    public Warehouse(){
        this.store = new HashMap<>();
        this.inventory = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock){
        this.store.put(product, price);
        this.inventory.put(product, stock);
    }
    
    public int price(String product){
        if (!store.containsKey(product)){
            return -99;
        }
        
        return store.get(product); 
    }
    
    public int stock(String product){
        if (!inventory.containsKey(product)){
            return 0;
        }
        
        return inventory.get(product);
    }
    
    public boolean take(String product){
        if(this.stock(product) == 0){
            return false;
        } else {
            inventory.put(product, inventory.get(product) - 1);
            return true;
        }

    }
    
    public Set<String> products(){
        return this.store.keySet();
    }
    

}
