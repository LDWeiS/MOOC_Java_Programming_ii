
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class DictionaryOfManyTranslations {
    
    private HashMap<String, ArrayList<String>> dictTrans;
    
    public DictionaryOfManyTranslations() {
        this.dictTrans = new HashMap<>();
    }
    
    public void add(String word, String translation){
        this.dictTrans.putIfAbsent(word, new ArrayList<>());
        this.dictTrans.get(word).add(translation);
    }
    
    public ArrayList<String> translate(String word){       
        return this.dictTrans.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word){
        this.dictTrans.remove(word);
    }
    
}
