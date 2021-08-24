
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        Collections.sort(numbers);
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        Random lotto = new Random();
        
        while (this.numbers.size() < 7){
            int lottoNumber = lotto.nextInt(45) + 1;
            
            if (!containsNumber(lottoNumber)) {
                this.numbers.add(lottoNumber);
            }
        } 
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return this.numbers.contains(number);
    }
}

