import java.time.LocalDateTime;
import java.util.ArrayList;

public class Airline {
    private String name;
    private ArrayList<Airline> subAirline;
    private ArrayList<Flight> flights;
    public Airline(String n){
        this.name = n;
        this.subAirline = new ArrayList<>();
        this.flights = new ArrayList<>();
    }
    public void add(Airline a){
        this.subAirline.add(a);
        System.out.println(a.name + " is now a subAirline of airline " + this.name);
    }
    public void remove(Airline a){
        this.subAirline.remove(a);
    }
    public ArrayList<Airline> getSubAirline(){
        return this.subAirline;
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<Flight> getFlights(){
        return this.flights;
    }
    public Flight createFlight(String id, double price, String or, String dest, LocalDateTime dep, long due, int max){
        Flight f = new Flight(id, price, or, dest, dep, due, max);
        this.flights.add(f);
        System.out.println("The flight from " + or + " to " + dest + " with ID: " + id + " created successfully!");
        return f;
    }
    public void changePrice(Flight f, double newPrice){
        f.setPrice(newPrice);
        f.notifyPrice();
    }
    public void changeTime(Flight f, LocalDateTime newTime){
        if(newTime.isBefore(LocalDateTime.now()))
            System.out.println("It is not possible to advance to this time");
        else {
            f.setDepartureTime(newTime);
            f.notifyTime();
        }
    }
    public Boolean cancelFlight(Flight f){
            if(!(this.flights.contains(f)))
                System.out.println("The company cannot cancel a flight that doesn't belong to it");
            else {
                System.out.println("The flight from " + f.getOrigin() + " to " + f.getDestination() + " with ID: "
                        + f.getID() + " was canceled");
                f.notifyCanceled();
                this.flights.remove(f);
                return true;
            }
        return false;
    }
    @Override
    public String toString(){
        String airlineString = "Airline name: " + this.name +"\n";
        for(Flight f : this.flights)
            airlineString = airlineString + f.toString() + "\n";
        for(Airline subAir : this.subAirline) {
            airlineString = airlineString + "subAirline: " + subAir.toString();
        }
        return airlineString;
    }
}
