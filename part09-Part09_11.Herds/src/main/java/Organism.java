/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Organism implements Movable{
    
    private int xplane;
    private int yplane;
    
    public Organism(int xplane, int yplane) {
        this.xplane = xplane;
        this.yplane = yplane;
    }
    
    @Override
    public void move(int dx, int dy){
        this.xplane += dx;
        this.yplane += dy;
    }
    
    @Override
    public String toString(){
        return "x: " + xplane + "; y: " + yplane;
    }
    
}
