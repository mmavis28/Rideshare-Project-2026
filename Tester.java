import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        Road main = new Road("Wilson Driveway"); //new road wilson driveway

        int numPass = 50; //number of passengers
        int numCars1 = 20;
        int numCars2 = 40;

        main.generatePassengers(numPass); //generates 50 passengers into the road
        main.generateCars(numCars2); //can change to numCars1

        System.out.println("Initial Road: ");
        System.out.println(main); //all starting positions

        int numTurns = 10;
        for (int i = 0; i < numTurns; i++){ //loops through turns to print turn method 10 times
            main.turn(); //runs turns
            System.out.println(main.toString()); //prints out turns
        }

        System.out.println("Rideshare complete!");
        System.out.println("Percentage of passengers that arrived at their destination: " + main.percentArrived() + "%");
    }
    
}
