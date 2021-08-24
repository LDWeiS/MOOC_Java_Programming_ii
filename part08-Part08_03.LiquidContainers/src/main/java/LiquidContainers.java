
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int container1 = 0;
        int container2 = 0;
        int maxContainer = 100;
        String[] comIn = new String[2];

        while (true) {
            System.out.println("First: " + container1 + "/" + maxContainer);
            System.out.println("Second: " + container2 + "/" + maxContainer);

            String input = scan.nextLine();
            System.out.println("");
            
            if (input.equals("quit")) {
                break;
            }
            
            comIn = input.split(" ");
            
            String command = comIn[0];
            int amount = Integer.valueOf(comIn[1]);
            
            if (amount < 0) {
                    continue;
                }
            
            if (command.equals("add")) {               
                container1 += amount;
                
                if (container1 > maxContainer) {
                    container1 = maxContainer;
                }
            }
            
            if (command.equals("move")) {
                if (container1 < amount) {
                    amount = container1;
                }
                
                container2 += amount;
                if (container2 > maxContainer) {
                    container2 = maxContainer;
                }
                
                container1 -= amount;
                if (container1 < 0) {
                    container1 = 0;
                }               
                
            }
            
            if (command.equals("remove")) {
                if (container2 < amount) {
                    container2 = 0;
                } else {
                    container2 -= amount;
                } 
                
            }
        }
    }
}
