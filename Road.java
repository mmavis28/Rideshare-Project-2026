import java.util.ArrayList;

public class Road {

    private Station[] stations;
    private String roadName;
    private int turnNum;

    private ArrayList<Car> active;
    private ArrayList<Car> idle;

    public Road(String nameOfRoad){
        Station [] stations = new Station[31];
        roadName = nameOfRoad;
        turnNum = 0;

        active = new ArrayList<Car>();
        idle = new ArrayList<Car>();
    }

    //setters 


    
}
