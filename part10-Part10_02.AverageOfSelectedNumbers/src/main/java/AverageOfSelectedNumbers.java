
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        System.out.println("Input numbers, type 'end' to stop.");
        
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            numbers.add(Integer.valueOf(input));
            
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String filter = scanner.nextLine();
        
        if (filter.equals("n")){
            System.out.println("Average of the positive numbers: " + numbers.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number < 0)
                    .average()
                    .getAsDouble());
        } else if (filter.equals("p")){
            System.out.println("Average of the positive numbers: " + numbers.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number > 0)
                    .average()
                    .getAsDouble());
        }
        
        
        // toteuta ohjelmasi tänne

    }
}
