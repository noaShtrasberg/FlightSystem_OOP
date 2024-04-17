import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightSystem {
    private String name;
    private ArrayList<Airline> airlines;
    private List<Flight> flights;
    private static FlightSystem fliSystem = new FlightSystem("SkyScanner");

    private FlightSystem(String n) {
        this.name = n;
        this.airlines = new ArrayList<>();
        this.flights = new ArrayList<>();
    }
    public static FlightSystem instance() {
        return fliSystem;
    }
    public Airline addAirline(String name){
        boolean newAirline = true;
        for(int i=0 ; i<this.airlines.size() ; i++)
            if(this.airlines.get(i).getName().equals(name))
                newAirline = false;
        if(!newAirline)
            System.out.println("This company " + name + " is already exist. Please choose another name");
        else {
            Airline a = new Airline(name);
            this.airlines.add(a);
            System.out.println("The company " + a.getName() + " was created successfully!");
            return a;
        }
        return null;
    }
    public void buyTicketSystem(Airline a, Flight f, User user){
        if(a.getFlights().contains(f))
            f.buyTicket(user);
        else
            System.out.println("This flight doesn't exit at this certain airline");
    }
    public void undoTicketSystem(Airline a, Flight f, User user){
        if(a.getFlights().contains(f))
            f.undoTicket(user);
        else {
            System.out.println("This flight doesn't exit at this certain airline");
        }
    }
    public void signUpdatesSystem(Airline a, Flight f, Person person){
        if(a.getFlights().contains(f))
            f.signUpdates(person);
        else {
            System.out.println("This flight doesn't exit at this certain airline");
        }
    }
    public Flight createFlightSystem(Airline a, String id, double price, String or, String dest,
                                     LocalDateTime dep, long due, int max){
        boolean newFlight = true;
        for(int i=0 ; i<this.flights.size() ; i++){
            if(this.flights.get(i).getID().equals(id)) {
                newFlight = false;
                System.out.println("This flight is already exist");
            }
        }
        if (newFlight){
            Flight f = a.createFlight(id, price, or, dest, dep, due, max);
            this.flights.add(f);
            return f;
        }
        return null;
    }
    public void cancelFlightSystem(Airline a, Flight f){
        boolean canceled = a.cancelFlight(f);
        if(canceled)
            this.flights.remove(f);
    }
    public void sortFlights(String type) {
        if (type.equals("Time") || type.equals("Price") || type.equals("Duration")) {
            SortFlightStrategy s = SortStrategyFactory.sort(type);
            List<Flight> sortedList = s.sortFlights(this.flights);
            for (Flight f : sortedList)
                System.out.println(f.toString());
        }
    }
}
