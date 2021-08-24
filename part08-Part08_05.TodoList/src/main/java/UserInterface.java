
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Woi
 */
public class UserInterface {
    
    private TodoList list;
    private Scanner scanner;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start(){
        
        while (true) {
            System.out.print("Command: ");
            String comIn = this.scanner.nextLine();
            
            if (comIn.equals("stop")){
                break;
            }
            
            if (comIn.equals("add")) {
                System.out.print("To add: ");
                String taskIn = this.scanner.nextLine();
                this.list.add(taskIn);
            }
            
            if (comIn.equals("remove")) {
                System.out.print("Which one is removed? ");
                int index = Integer.valueOf(this.scanner.nextLine());
                this.list.remove(index);
            }
            
            if (comIn.equals("list")) {
                this.list.print();
            }
        }
        
    }
    
}
