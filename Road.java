import java.util.ArrayList;

public class Road {

    private Station[] stations;
    private String roadName;
    private int turnNum;

    private ArrayList<Car> active;
    private ArrayList<Car> idle;

    public Road(String nameOfRoad){
        Station [] stations = new Station[32];
        for (int i = 0; i < 32; i++){
            stations[i] = new Station(i); //set station number 1-31
        }
        roadName = nameOfRoad;
        turnNum = 0;

        active = new ArrayList<Car>();
        idle = new ArrayList<Car>();
    }

    //adding things to station

    public void addCar(Car c){
        active.add(c);
    }

    public void addPassenger (Passenger p){
        int start = p.getStartingStation();
        stations[start].addPassenger(p);
    }

    public void generatePassengers(int numPass){
        for (int i = 0; i < numPass; i++){
            Passenger p = new Passenger();
            int start = p.getStartingStation();
            stations[start].addPassenger(p);
        }
    }

    public void generateCars(int numCars){
        for (int i = 0; i < numCars; i++){
            Car c = new Car();
            active.add(c);
        }
    }

    //actual turn 

    public void turn(){
        //increase turn number
        turnNum ++;

        for (int i = active.size(); i > 0; i--){
            Car c = active.get(i);
            
            //if passengers are at their stop drop them off
            c.dropOffPassengers();

            //if car is at their stop make it idle and drop all passengers off
            if (c.getDestination() == c.getCurrentStop()){
                idle.add(c);
                active.remove(c);
                c.unloadAllPass();
            }

            //if there is space pickup a passenger


        // move the car again
         c.move();   
        }

    }
}
