package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input title of application: ");
        String appTitle = scanner.nextLine();
        
        Application.launch(UserTitle.class, "--name=" + appTitle);
        System.out.println("Hello world!");
    }

}
