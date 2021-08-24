
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Checker testChecker = new Checker();

        while (true) {
            System.out.print("Enter a string: ");
            String day = scanner.nextLine();

            if (day.equals("")) {
                break;
            }

            if (testChecker.isDayOfWeek(day)) {
                System.out.println("The form is correct.");
            } else {
                System.out.println("The form is incorrect.");
            }

            if (testChecker.allVowels(day)) {
                System.out.println("The form is correct.");
            } else {
                System.out.println("The form is incorrect.");
            }
            
            if (testChecker.timeOfDay(day)) {
                System.out.println("The form is correct.");
            } else {
                System.out.println("The form is incorrect.");
            }
        }

        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
    }
}
