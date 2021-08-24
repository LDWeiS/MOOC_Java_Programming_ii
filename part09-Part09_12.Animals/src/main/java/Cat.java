/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Cat extends Animal implements NoiseCapable{
    
    private String name;
    
    public Cat(String name){
        super(name);
    }
    
    public Cat(){
        super("cat");
    }
    
    @Override
    public void makeNoise(){
        this.purr();
    }
    
    public void purr(){
        System.out.println(this.getName() + " purrs");
    }
    
}
