package FlightControl;

import FlightControl.UserInterface.TextUI;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.logic.FlightControl;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        FlightControl ft = new FlightControl();
        Scanner scan = new Scanner(System.in);
        TextUI start = new TextUI(ft, scan);
        
        start.start();
    }
}
