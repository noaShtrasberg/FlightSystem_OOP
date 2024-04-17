import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        FlightSystem IsraelAirline = FlightSystem.instance();
        Airline ELAL = IsraelAirline.addAirline("ELAL");
        Airline Lufthansa = IsraelAirline.addAirline("Lufthansa");
        Airline ELAL2 = IsraelAirline.addAirline("ELAL");
        Airline Arkia = IsraelAirline.addAirline("Arkia");
        Airline IsraAir = IsraelAirline.addAirline("IsraAir");
        LocalDateTime timef1 = LocalDateTime.of(2024, 4, 16, 10, 30, 0);
        LocalDateTime checkTimef1 = LocalDateTime.of(2024, 4, 13, 10, 30, 0);
        LocalDateTime newTimef1 = LocalDateTime.of(2024, 8, 16, 8, 30, 0);
        LocalDateTime timef2 = LocalDateTime.of(2024, 4, 29, 6, 45, 0);
        LocalDateTime timef3 = LocalDateTime.of(2024, 4, 29, 8, 45, 0);
        Flight f1 = IsraelAirline.createFlightSystem(ELAL, "123A", 3000, "Israel", "Greece", timef3, 4, 200);
        Flight f2 = IsraelAirline.createFlightSystem(IsraAir, "456A", 1000, "Israel", "India", timef2, 6, 250);
        Flight f3 = IsraelAirline.createFlightSystem(ELAL, "456A", 5000, "Greece", "India", timef1, 7, 250);
        Flight f4 = IsraelAirline.createFlightSystem(Lufthansa, "789A", 8000, "Greece", "USA", timef1, 8, 250);
        Flight f5 = IsraelAirline.createFlightSystem(Arkia, "102A", 8000, "Greece", "USA", timef1, 8, 250);
        Lufthansa.add(Arkia);
        ELAL.add(IsraAir);
        User Noa = new User("Noa");
        User Elnatan = new User("Elnatan");
        Employee Hagit = new Employee("Hagit");
        User Yair = new User("Yair");
        IsraelAirline.buyTicketSystem(ELAL, f1, Noa);
        IsraelAirline.signUpdatesSystem(ELAL, f1, Hagit);
        IsraelAirline.buyTicketSystem(Lufthansa, f4, Elnatan);
        IsraelAirline.signUpdatesSystem(ELAL, f4, Hagit);
        IsraelAirline.cancelFlightSystem(Arkia, f5);
        IsraelAirline.undoTicketSystem(ELAL, f1, Yair);
        ELAL.changePrice(f1, 2700);
        ELAL.changeTime(f1, checkTimef1);
        ELAL.changeTime(f1, newTimef1);
        System.out.println();
        System.out.println(ELAL.toString());

        IsraelAirline.sortFlights("Price");
        System.out.println();
        IsraelAirline.sortFlights("Time");
        System.out.println();
        IsraelAirline.sortFlights("Duration");
    }
}