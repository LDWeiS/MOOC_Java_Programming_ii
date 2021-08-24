/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author Nick Woi
 */
public class SaveableDictionary {

    private Map<String, String> dictionary;
    private String fileName;

    public SaveableDictionary() {        
        this.dictionary = new HashMap<>();
    }
    
    public SaveableDictionary(String file) {
        
        this();
        this.fileName = file;
        
    }
    
    public boolean load() {
        
        try(Scanner fileReader = new Scanner(new FileReader(fileName))) {
            
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                
                dictionary.put(parts[0], parts[1]);
                dictionary.put(parts[1], parts[0]);
            }              
            return true;
        
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            saveWords(writer);
            writer.close();
            
        } catch (Exception e) {
            return false;
        }
        
        return true;       
    }
    

    public void add(String words, String translation) {
        
        if (!dictionary.containsKey(words)) {
            dictionary.put(words, translation);
            dictionary.put(translation, words);
        }        
    }

    public String translate(String word) {           
        return dictionary.get(word);
    }
    
    public void delete(String word) {
        String translation = translate(word);
        
        dictionary.remove(word); 
        dictionary.remove(translation);        
    }
    
    private void saveWords(PrintWriter writer) throws IOException {

        List<String> allreadySaved = new ArrayList<>();
        
        dictionary.keySet().stream().forEach(word -> {

            if (allreadySaved.contains(word)) {
                return;
            }

            String builder = word + ":" + dictionary.get(word);
            writer.println(builder);

            allreadySaved.add(word);
            allreadySaved.add(dictionary.get(word));

        });

    }
}
