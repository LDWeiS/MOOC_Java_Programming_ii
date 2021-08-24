
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Input numbers, type 'end' to stop");
        
        while (true){
            String input = scanner.nextLine();
            
            if (input.equals("end")){
                break;
            }
            
            try {
                int number = Integer.valueOf(input);
                numbers.add(number);
            } catch (Exception e){
                System.out.println("Not a number");
            }
            
        }
        
        double average = numbers.stream()
            .mapToInt(s -> Integer.valueOf(s))
            .average()
            .getAsDouble();
        
        System.out.print("average of the numbers: " + average);
        // Write your program here

    }
}
