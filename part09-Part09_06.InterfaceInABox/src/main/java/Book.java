/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Book implements Packable{
    
    private String author;
    private String bookname;
    private double weight;
      
    public Book (String author, String bookname, double weight){
        this.author = author;
        this.bookname = bookname;
        this.weight = weight;
    }
    
    @Override
    public double weight(){
        return this.weight;
    }
    
    @Override
    public String toString(){
        return author + ": " + bookname;
    }
}
