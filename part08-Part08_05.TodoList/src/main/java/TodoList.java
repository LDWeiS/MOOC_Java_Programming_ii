
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
public class TodoList {
    
    private ArrayList<String> list;
    
    public TodoList() {
        this.list = new ArrayList<>();
    }
    
    public void add(String string) {
        this.list.add(string);
    }
    
    public void remove(int index) {
        this.list.remove(index - 1);
    }
    
    public void print(){
        int index = 1;
        
        for (String item:list){
            System.out.println(index + ": " + item);
            index++;
        }
    }
    
}
