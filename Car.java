import java.util.ArrayList;

public class Car {

    private int carNum;
    private static int carGen = 1;
    private int numPass;
    private boolean fullCar;
    private boolean direction; //false for backwards true for forward
    private int startingStop;
    private int currentStop;
    private int destination;
    private boolean isIdle;
    private boolean atDestination;
    private ArrayList<Passenger> passInCar; //holds passengers in the car

    public Car(){
        carNum = carGen;
        carGen ++;
        numPass = 0;
        fullCar = false;
        startingStop = (int)((Math.random()*31)+ 1);
        currentStop = startingStop;
        destination = (int)((Math.random()*31)+ 1);
        isIdle = false;
        
        if (startingStop > destination){
            direction = false;
        }
        
        if (startingStop <= destination){
            direction = true;
        }

        passInCar = new ArrayList<Passenger>();

    }

    //getters

    public int getCarNum(){
        return carNum;
    }

    public int getNumPass(){
        return numPass;
    }

    public boolean isCarFull(){
        if (passInCar.size() >= 3){
            return true;
        }
        else{
            return false;
        }
    } 

    public int getStartStop(){
        return startingStop;
    }

    public int getCurrentStop(){
        return currentStop;
    }

    public int getDestination(){
        return destination;
    }

    public boolean isCarIdle(){
        return isIdle;
    }

    public boolean getDirection(){
        return direction;
    }

    public boolean isAtDestination(){
        return atDestination;
    }

    //setters

    public void setDirection(){
        if (startingStop > destination){
            direction = false;
        }
        
        else{
            direction = true;
        }

    }

    public void setDestination(){
        if (currentStop == destination){
            atDestination = true;
            isIdle = true;
        }
        else{
            atDestination = false;
            isIdle = false;
        }
    }

    //moving the car
    public void move(){
        if (isIdle == false){
            if (direction == true){
                if (currentStop < 31){ //keeps the car in bounds
                    currentStop ++; //moves to the next station forward
                }  
            }
            else{
                if (currentStop > 1){ //keeps the car in bounds
                    currentStop --; //moves to the next station backward
                }
            }
        }
    }


    //working with the passengers 

    public void addPassenger(Passenger num){
        if (passInCar.size() < 3){
            passInCar.add(num);
        }
        numPass ++;

    }

    public void dropOffPassengers(){
        if (isIdle == false){
        for (int i = passInCar.size() -1 ; i >= 0; i--){ //removing values from an array so going backwards 

            Passenger p = passInCar.get(i);

            if (p.getDestination() == currentStop){ //if passenger is at their destination
                p.setCurrentStation(currentStop); //sets currentstop
                p.setIsAtDestination();
                passInCar.remove(i); //removes if at destination
            }
        }
        numPass = passInCar.size();
        }
    }

    public void unloadAllPass(){
        for (int i = passInCar.size()-1; i >= 0; i--){
            Passenger p = passInCar.get(i);

            p.setCurrentStation(currentStop); //update current location
            p.setIsAtDestination(); //check if they arrived 
            passInCar.remove(i); //then removes all passengers from car

        }
        numPass = 0; // num passengers in car is 0 now
    }

    //toString

    public String toString(){
        String s = "Car " + carNum + ": {Location = Station " + currentStop + ", Destination = Station " + destination + "}";
        s += " Passengers = [";
        for (int i = 0; i < passInCar.size(); i++){
            s += passInCar.get(i) + " ";
        }
        s += "]";
        return s;
    }


    //old toString

    //public String toString(){
    //    String s = "Car " + carNum + ": " + numPass + " passengers, car is currently at Station " + currentStop + ", cars destination is Station " + destination + ".";
    //    s += " STATUS: ";
        
    //    if (isIdle == true){
    //        s += carNum + "is Idle, ";
    //    }
    //    else{
    //        s += carNum + "is Active, ";
    //  }

    //    if (fullCar == true){
    //        s += carNum + "is full ";
    //    }
    //    else{
    //        s += carNum + "has avalible seats";
    //    }



    //    return s;
    //}

}
