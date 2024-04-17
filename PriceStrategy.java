import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriceStrategy implements SortFlightStrategy{
    @Override
    public List<Flight> sortFlights(List<Flight> flights) {
        Comparator<Flight> comparator = new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                return Double.compare(f1.getPrice(), f2.getPrice());
            }
        };
        List<Flight> list = new ArrayList<>(flights);
        list.sort(comparator);
        return list;
    }
}
