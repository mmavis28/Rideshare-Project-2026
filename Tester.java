import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        Road main = new Road("Wilson Driveway");

        int numPass = 50;
        int numCars1 = 20;
        int numCars2 = 40;

        main.generatePassengers(numPass);
        main.generateCars(numCars1); //can change to numCars1

        System.out.println("Initial Road: ");
        System.out.println(main);

        int numTurns = 10;
        for (int i = 0; i < numTurns; i++){
            main.turn();
            System.out.println(main.toString());
        }

        System.out.println("Rideshare complete!");
    }
    
}
