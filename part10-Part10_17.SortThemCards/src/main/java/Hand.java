
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Hand implements Comparable<Hand>{
    
    private List<Card> playHand;
    
    public Hand(){
        this.playHand = new ArrayList<>();
    }
    
    public void add(Card card){
        this.playHand.add(card);
    }
    
    public void print() {
        this.playHand.stream()
                .forEach(card -> System.out.println(card));
    }
    
    public void sort(){      
        this.playHand = playHand.stream()
            .sorted((c1,c2)-> c1.compareTo(c2))
            .collect(Collectors.toList());
    }
    
    @Override
    public int compareTo(Hand hand){
        
        int thisHand = this.playHand.stream()
                .map(card -> card.getValue())
                .reduce(0, (handSum, card) -> handSum + card);
        
        int otherHand = hand.playHand.stream()
                .map(card -> card.getValue())
                .reduce(0, (handSum, card) -> handSum + card);
        
        if (thisHand == otherHand){
            return 0;
        } else if (thisHand > otherHand) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public void sortBySuit() {
        Collections.sort(this.playHand, new BySuitInValueOrder());
    }
    
}
