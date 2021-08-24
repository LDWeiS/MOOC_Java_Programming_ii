
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nick Woi
 */
public class ChangeHistory {

    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();

    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        this.history.clear();
    }

    @Override
    public String toString() {
        return history.toString();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }

        return (double) Collections.max(history);
    }

    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }

        return Collections.min(history);
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Double item : history) {
            total += item;
        }

        return total / history.size();
    }
}
