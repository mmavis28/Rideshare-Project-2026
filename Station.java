import java.util.ArrayList;

public class Station {

    private int stationNum;
    private ArrayList<Passenger> waiting;
    private ArrayList<Passenger> arrived;

    public Station(int stationNumber){
        stationNum = stationNumber;
        waiting = new ArrayList<Passenger>();
        arrived = new ArrayList<Passenger>();
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

    public int numWaiting(){
        return waiting.size();
    }

    public int numArrived(){
        return arrived.size();
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
        return "Station " + stationNum + ": Waiting = " + waiting.size() + ", Arrived = " + arrived.size() + ".";
    }


}
