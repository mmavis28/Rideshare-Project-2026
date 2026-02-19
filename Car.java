public class Car {

    private int carNum;
    private int carGen = 1;
    private int numPass;
    private boolean fullCar;
    private boolean direction;
    private int startingStop;
    private int currentStop;
    private int destination;
    private boolean isIdle;
    private boolean atDestination;

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

    }

    //getters

    public int getCarNum(){
        return carNum;
    }

    public int getNumPass(){
        return numPass;
    }

    public boolean isCarFull(){
        return fullCar;
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

}
