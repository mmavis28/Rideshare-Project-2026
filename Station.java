import java.util.ArrayList;

public class Station {

    private int stationNum;
    private ArrayList<Passenger> waiting;
    private ArrayList<Passenger> arrived;
    private ArrayList<Car> carsAtStation;

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

    private int numCarsAtStation(){
        return carsAtStation.size();
    }

    //setters

    public void addPassenger(Passenger num){
        waiting.add(num);
    }

    public void removePassenger(Passenger num){
        waiting.remove(num);
    }

    public void arrivedPassenger(Passenger num){
        arrived.add(num); //only need an add no remove because only passengers who are at their destination go to the arrived arrayList
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
    
    //print out all passengers 

}
