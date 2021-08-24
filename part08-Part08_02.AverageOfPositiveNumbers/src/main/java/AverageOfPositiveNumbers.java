
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numsAll = new ArrayList<>();
        int numsTotal = 0;

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());

            if (input > 0) {
                numsAll.add(input);
            } else if (input < 0){
                ;
            } else {
                break;
               
            }
        }
        
        if (numsAll.isEmpty()) {
            System.out.println("Cannot calculate the average");           
        } else {
            for (int num : numsAll) {
                numsTotal += num;
            }
            
            System.out.println((double)numsTotal / numsAll.size());
            
        }
    }
}
