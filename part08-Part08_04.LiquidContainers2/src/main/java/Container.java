/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class Container {

    private int curAmount;
    private int maxAmount;

    public Container() {
        this.curAmount = 0;
        this.maxAmount = 100;
    }

    public void add(int amount) {
        if (amount > 0) {
            this.curAmount += amount;

            if (this.curAmount > this.maxAmount) {
                this.curAmount = this.maxAmount;
            }
        }
    }

    public void remove(int amount) {
        if (amount > 0) {
            this.curAmount -= amount;

            if (this.curAmount < 0) {
                this.curAmount = 0;
            }
        }
    }

    public int contains() {
        return this.curAmount;
    }

    public int getMax() {
        return this.maxAmount;
    }

    @Override
    public String toString() {
        return this.contains() + "/" + this.getMax();
    }

}
