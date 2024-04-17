import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DurationStrategy implements SortFlightStrategy{
    @Override
    public List<Flight> sortFlights(List<Flight> flights) {
        Comparator<Flight> comparator = new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                return Long.compare(f1.getDuration(), f2.getDuration());
            }
        };
        List<Flight> list = new ArrayList<>(flights);
        list.sort(comparator);
        return list;
    }
}
