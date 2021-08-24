
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Herd implements Movable{
    
    private List<Movable> cells;
    
    public Herd(){
        this.cells = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable){
        cells.add(movable);
    }
    
    @Override
    public void move(int dx, int dy){
        for (Movable cell:cells){
            cell.move(dx, dy);
        }
    }
    
    @Override
    public String toString(){
        String coordinates = "";
        
        for (Movable cell:cells){
            coordinates += cell.toString().trim() + "\n";
        }
        
        return coordinates;
    }
}
