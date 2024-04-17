import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TimeStrategy implements SortFlightStrategy{
    @Override
    public List<Flight> sortFlights(List<Flight> flights) {
        Comparator<Flight> comparator = new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                return f1.getDepartureTime().compareTo(f2.getDepartureTime());
            }
        };
        List<Flight> list = new ArrayList<>(flights);
        list.sort(comparator);
        return list;
    }
}
