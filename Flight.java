import java.time.LocalDateTime;
import java.util.ArrayList;

public class Flight {
    private final String ID;
    private double price;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private long duration;
    private LocalDateTime landingTime;
    private final int maxPassengers;
    private ArrayList<Observer> passengers;
    private ArrayList<Observer> updates;
    public Flight(String id, double price, String or, String dest, LocalDateTime dep,  long due, int max){
        this.ID = id;
        this.price = price;
        this.origin = or;
        this.destination = dest;
        this.departureTime = dep;
        this.duration = due;
        this.maxPassengers = max;
        this.landingTime = this.departureTime.plusHours(this.duration);
        this.passengers = new ArrayList<>(); // only passengers
        this.updates = new ArrayList<>(); // users, passengers and employees
    }
    public double getPrice(){
        return this.price;
    }
    public long getDuration(){
        return this.duration;
    }
    public String getOrigin(){
        return this.origin;
    }
    public String getDestination(){
        return this.destination;
    }
    public String getID() {
        return ID;
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    public LocalDateTime getDepartureTime(){
        return this.departureTime;
    }
    public void setDepartureTime(LocalDateTime newTime){
        this.departureTime = newTime;
    }
    public void buyTicket(User user){
            if(this.maxPassengers == this.passengers.size())
                System.out.println("This flight is full");
            else {
                if(this.passengers.contains(user))
                    System.out.println("You are already registered for the flight");
                else {
                    this.passengers.add(user);
                    this.updates.add(user);
                    System.out.println(user.name + " signed to the flight from " + this.origin + " to " + this.destination + " successfully");
                }
            }
    }
    public void undoTicket(User user){
        if(this.passengers.contains(user)){
            this.passengers.remove(user);
            this.updates.remove(user);
            System.out.println(user.name + " canceled the ticket to the flight from " + this.origin + " to " + this.destination);
        }
        else {
            System.out.println("You are not on this flight");
        }
    }
    public void signUpdates(Person person){
        if(this.updates.contains(person))
            System.out.println("You are already registered for updates");
        else {
            this.updates.add(person);
            System.out.println(person.name + " signed for updates about the flight from " + this.origin + " to " + this.destination + " successfully");
        }
    }
    public void notifyTime(){
        for (Observer ob : updates)
            ob.update_time(this);
    }
    public void notifyPrice(){
        for (Observer ob : updates)
            if(!(this.passengers.contains(ob)))
                ob.update_price(this);
    }
    public void notifyCanceled(){
        for (Observer ob : updates)
            ob.update_canceled(this);
    }
    @Override
    public String toString(){
        return "Flight number " + this.ID +" from " + this.origin + " to " + this.destination + " will be at " + this.departureTime;
    }
}
