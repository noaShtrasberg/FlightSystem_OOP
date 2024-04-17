public abstract class Person implements Observer{
    protected String name;
    public Person(String n){
        this.name = n;
    }
    @Override
    public void update_time(Flight flight) {
        System.out.println("Hello " + this.name + ": Time update: The time of the flight from " +
                flight.getOrigin() + " to " + flight.getDestination() + " was change. The flight will leave" +
                " at " + flight.getDepartureTime());
    }

    @Override
    public void update_canceled(Flight flight) {
        System.out.println("Hello " + this.name + ": The flight from " +
                flight.getOrigin() + " to " + flight.getDestination() + " was canceled");
    }

    @Override
    public void update_price(Flight flight) {
        System.out.println("Hello " + this.name + ": Price update: The price of the flight from " +
                flight.getOrigin() + " to " + flight.getDestination() + " is now " + flight.getPrice());
    }
}
