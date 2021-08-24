/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Hideout<T> {
    
    private T hidden;
    
    public Hideout () {
        this.hidden = null;
    }
    
    public void putIntoHideout(T toHide) {
        this.hidden = toHide;
    }
    
    public T takeFromHideout() {
        T temp = this.hidden;
        this.hidden = null;
        
        return temp;
    }
    
    public boolean isInHideout() {
        return this.hidden != null;
    }
    
}
