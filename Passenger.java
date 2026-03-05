import java.util.*;

public class Passenger{

    private int passNum;
    private static int passGen = 1;
    private int currentStation;
    private int startingStation;
    private int destination; 
    private boolean direction; //false for backwards true for forward
    private boolean inCar; 
    private boolean atDestination;

    public Passenger(){
        passNum = passGen;
        passGen ++;
        startingStation = (int)((Math.random()*31)+ 1); //randomly generate a stating station from 1-31
        destination = (int)((Math.random()*31)+ 1); //randomly generate a destination from 1-31
        currentStation = startingStation; //initializes passenger at their starting station
        inCar = false; //all don't stat in a car
        
        if (startingStation > destination){
            direction = false;
        } //moving backwards ex Station 1 -> Station 6
        
        if (startingStation <= destination){
            direction = true;
        } //moving forward ex: Station 6 -> Station 1

        if (currentStation == destination){
            atDestination = true;
        } //if the passenger starting station is where their destination is sets they are at their destination already

        else{
            atDestination = false; 
        }

    }

    //getters 
    public int getPassengerNum(){
        return passNum;
    }

    public int getStartingStation(){
        return startingStation;
    }

    public int getCurrentStation(){
        return currentStation;
    }

    public int getDestination(){
        return destination;
    }

    public boolean getDirection(){
        return direction;
    }

    public boolean getAtDestination(){
        return atDestination;
    }

    public boolean getinCar(){
        return inCar;
    }

    //setters
    public void setIsAtDestination(){
        if (currentStation == destination){
            atDestination = true;
        }
        else{
            atDestination = false;
        }
    }

    public void setCurrentStation(int newStation){ //updates currentStation
        currentStation = newStation;
    }

    //toString

    public String toString(){
        return "Passenger " + passNum + ": {Location = Station " + currentStation + ", Destination = Station " + destination + "}";
    }


    //oldtoString

    //public String toString(){
        //String s = "Passenger " + passNum + ": passenger is currently at Station " + currentStation + ", passenger's destination is Station " + destination + ".";

        //if (inCar == true){
        //    s += "Passenger " + passNum + " is currently in a car, ";
        //}
        //else{
        //    s += "Passanger " + passNum + "is currently not in a car, ";
        //}

        //if (atDestination == true){
        //    s += "Passenger " + passNum + " is at their destination: Station " + destination + ".";
        //}
        //else{
        //    s += "Passenger " + passNum + " is still traveling to their destination: Station " + destination + ".";
        //}

        //return s;
    //}


}