
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
                
            } else {
                int numCube = Integer.valueOf(input);
                cubed(numCube);
                
            }
        }
    }

    public static void cubed(int input) {
        System.out.println((int)Math.pow(input, 3));
    }
}
