import java.util.ArrayList;

public class Station {

    private int stationNum;
    private ArrayList<Passenger> waiting; //passengers waiting for a car to get them to their station
    private ArrayList<Passenger> arrived;  //passengers that are at their arrived station
    private ArrayList<Car> carsAtStation; //cars at different stations

    public Station(int stationNumber){
        stationNum = stationNumber;
        waiting = new ArrayList<Passenger>();
        arrived = new ArrayList<Passenger>();
        carsAtStation = new ArrayList<Car>();
    }

    //getters

    public int getStationNum(){
        return stationNum;
    }

    public ArrayList<Passenger> getWaiting(){
        return waiting;
    }

    public ArrayList<Passenger> getArrived(){
        return arrived;
    }

    public ArrayList<Car> getCarsAtStation(){
        return carsAtStation;
    }

    public int numWaiting(){
        return waiting.size();
    }

    public int numArrived(){
        return arrived.size();
    }

    public int numCarsAtStation(){
        return carsAtStation.size();
    }

    //setters

    public void addPassenger(Passenger num){ //adds new passenger to waiting
        waiting.add(num);
    }

    public void removePassenger(Passenger num){ //removes passenger from waiting
        waiting.remove(num);
    }

    public void arrivedPassenger(Passenger num){
        arrived.add(num); //only need an add no remove because only passengers who are at their destination go to the arrived arrayList
    }

    public void addCar(Car c){
        carsAtStation.add(c); 
    }

    public void removeCar(Car c){
        carsAtStation.remove(c);
    } 

    //toString

    public String toString(){
        String s = "Station " + stationNum + ": \n";
        s += "  Waiting Passengers: (" + numWaiting() + ") \n";
        for (int i = 0; i < numWaiting(); i++){
            s += "      " + waiting.get(i).toString() + "\n";
        }
        s += "  Arrived Passengers: (" + numArrived() + ") \n";
        for (int i = 0; i < numArrived(); i++){
            s += "      " + arrived.get(i).toString() + "\n";
        }

        s += "  Cars at Station: (" + numCarsAtStation() + ") \n";
        for (int i = 0; i < numCarsAtStation(); i++){
            s += "      " + carsAtStation.get(i).toString() + "\n";
        }

        return s;
    }

}
