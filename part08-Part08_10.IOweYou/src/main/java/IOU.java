
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class IOU {
    
    private HashMap<String, Double> iouList;
    
    public IOU() {
        this.iouList = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount){
        this.iouList.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom){
        if (!this.iouList.containsKey(toWhom)) {
            return 0;
        } else {
        return this.iouList.get(toWhom);
        }
    }
}
