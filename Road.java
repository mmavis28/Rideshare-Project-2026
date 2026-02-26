import java.util.ArrayList;

public class Road {

    private Station[] stations;
    private String roadName;
    private int turnNum;

    private ArrayList<Car> active;
    private ArrayList<Car> idle;
    private ArrayList<Passenger> droppedOffPassengers;

    public Road(String nameOfRoad){
        stations = new Station[32];
        for (int i = 1; i <= 31; i++){
            stations[i] = new Station(i); //set station number 1-31
        }
        roadName = nameOfRoad;
        turnNum = 0;

        active = new ArrayList<Car>();
        idle = new ArrayList<Car>();
        droppedOffPassengers = new ArrayList <Passenger>();
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

            //adds passengers to starting station
            int start = p.getStartingStation();
            stations[start].addPassenger(p);
        }
    }

    public void generateCars(int numCars){
        for (int i = 0; i < numCars; i++){
            Car c = new Car();
            active.add(c);

            //adds car to starting station
            int start = c.getCurrentStop();
            stations[start].addCar(c);
        }
    }

    //actual turn 

    public void turn(){
        //increase turn number
        turnNum ++;

        for (int i = active.size()-1; i >= 0; i--){
            Car c = active.get(i);
            
            //if passengers are at their stop drop them off
            Station current = stations[c.getCurrentStop()];

            for (int k = 0; i < droppedOffPassengers.size(); i++){
                Passenger p = droppedOffPassengers.get(i);
                current.arrivedPassenger(p);
            }


            //if car is at their stop make it idle and drop all passengers off
            if (c.getDestination() == c.getCurrentStop()){
                idle.add(c);
                active.remove(c);
                c.unloadAllPass();
            }

            //if there is space pickup a passenger
            
            for (int j = current.getWaiting().size()-1; j >= 0; j--){ //uses the size of waiting array in station
                if (c.isCarFull() == false){ //if the car isn't full then add passenger
                    Passenger p = current.getWaiting().get(j); //getWaiting().get(j) access the getWaiting array in Station

                    if (p.getDirection() == c.getDirection()){ //if the pass (j) and the car (c) are going the same direction then it works
                        c.addPassenger(p); //adds pass j from waiting to car
                        current.getWaiting().remove(j); //removes pass j from waiting since in car
                    }
                }
            }
            
        //update car position
        if (c.isCarIdle() == false){
            int oldStation = c.getCurrentStop(); //previous stop since car with move()
            stations [oldStation].removeCar(c); //old station gets removed from stations array
        }
            
        // move the car again
         c.move();   

         if (c.isCarIdle() == false){
            int newStation = c.getCurrentStop(); //station updates
            stations[newStation].addCar(c); //new station gets added to stations array
        }

        }

    }

    public String toString(){
        String s = "Road: " + roadName + " is on turn " + turnNum + ". Number of active cars = " + active.size() + ". Number of idle cars = " + idle.size() + ". \n";
        s += "\n";
        //printing all the stations
        for (int i = 1; i <= 31; i++){ //road 1-31
            s += stations[i].toString() + "\n";
        }
        return s;
    }
}
