import java.util.ArrayList;

public class Road {

    private Station[] stations;
    private String roadName;
    private int turnNum;
    private int totalPasengers;

    private ArrayList<Car> active;
    private ArrayList<Car> idle;

    public Road(String nameOfRoad){
        stations = new Station[32]; 
        for (int i = 1; i <= 31; i++){
            stations[i] = new Station(i); //set station number 1-31
        }
        roadName = nameOfRoad;
        turnNum = 0;
        totalPasengers = 0;

        active = new ArrayList<Car>();
        idle = new ArrayList<Car>();
    }

    //adding things to station

    public void addCar(Car c){
        active.add(c);
        stations[c.getCurrentStop()].addCar(c); //adds car to station
    }

    public void addPassenger (Passenger p){
        totalPasengers ++;
        int start = p.getStartingStation();

        if (p.getStartingStation() == p.getDestination()){ //if the passenger starts off at their destination makes them arrived
            stations[start].arrivedPassenger(p);
        }
        else{
            stations[start].addPassenger(p);
        }
    }

    public void generatePassengers(int numPass){

        totalPasengers = numPass;

        for (int i = 0; i < numPass; i++){
            Passenger p = new Passenger();
            addPassenger(p); //uses above to add
        }
    }

    public void generateCars(int numCars){
        for (int i = 0; i < numCars; i++){
            Car c = new Car();
            addCar(c);
        }
    }

    //percent complete

    public double percentArrived(){

        int arrived = 0;

        for (int i = 1; i <= 31; i++){
            arrived += stations[i].getArrived().size();
        }
        return ((arrived*100.0)/totalPasengers);
    }

    //actual turn 

    public void turn(){
        //increase turn number
        turnNum ++;

        //itterating backwards through the list so we can remove cars
        for (int i = active.size() - 1; i >= 0; i--){
            Car c = active.get(i);
            Station current = stations[c.getCurrentStop()]; 

            //dropping off passengers if there at their station/stop
            ArrayList <Passenger> dropped = c.dropOffPasengers(); //hold all passengers dropped off
            for (int k = 0; k < dropped.size(); k++){
                Passenger p = dropped.get(k);
                stations[p.getCurrentStation()].arrivedPassenger(p);
            }


            //if car is at their stop make it idle and drop all passengers off
            if (c.getDestination() == c.getCurrentStop()){
                active.remove(i); //at position in overall for loop
                idle.add(c);

                //unloads all Passengers and adds them to whichever list is best 
                ArrayList<Passenger> remaining = c.unloadAllPass();
                for (int a = 0; a < remaining.size(); a++){
                    Passenger p = remaining.get(a);
                    stations[p.getCurrentStation()].arrivedPassenger(p);
                }
            }

            //if there is space pickup a passenger
            for (int j = current.getWaiting().size()-1; j >= 0; j--){ //uses the size of waiting array in station
                if (c.isCarFull() == false){ //if the car isn't full then add passenger
                    Passenger p = current.getWaiting().get(j); //getWaiting().get(j) access the getWaiting array in Station

                    if (p.getDirection() == c.getDirection() && c.isCarIdle() == false){ //if the pass (j) and the car (c) are going the same direction then it works and is car is not idle
                        c.addPassenger(p); //adds pass j from waiting to car
                        current.getWaiting().remove(j); //removes pass j from waiting since in car
                    }
                }
            }
        
            
        //update car position
        if (c.isCarIdle() == false){
            int oldStation = c.getCurrentStop(); //previous stop since car with move()
            stations [oldStation].removeCar(c); //old station gets removed from stations array
            c.move(); // move the car again
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
        s += "---------------------------------------------------------------------------";
        return s;
    }
}
