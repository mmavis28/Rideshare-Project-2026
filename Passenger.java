import java.util.*;

public class Passenger{

    private int passNum;
    private int passGen = 1;
    private int currentStation;
    private int startingStation;
    private int destination; //false for backwards true for forward
    private boolean direction;
    private boolean inCar;
    private boolean atDestination;

    public Passenger(){
        passNum = passGen;
        passGen ++;
        startingStation = (int)((Math.random()*31)+ 1);
        destination = (int)((Math.random()*31)+ 1);
        currentStation = startingStation;
        inCar = false;
        
        if (startingStation > destination){
            direction = false;
        }
        
        if (startingStation <= destination){
            direction = true;
        }

        if (currentStation == destination){
            atDestination = true;
        }
        else{
            atDestination = false;
        }

    }

    //getters 
    public int getPassengerName(){
        return passNum;
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

    public void setCurrentStation(int newStation){
        currentStation = newStation;
    }

    //toString

    public String toString(){
        return "Passenger " + passNum + ": Location = Station " + currentStation + ", Destination = Station " + destination + ".";
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