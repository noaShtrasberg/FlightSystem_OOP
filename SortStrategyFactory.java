import java.util.List;

public abstract class SortStrategyFactory {
    public static SortFlightStrategy sort(String s){
        if(s.equals("Price"))
            return new PriceStrategy();
        if(s.equals("Time"))
            return new TimeStrategy();
        return new DurationStrategy();
    }
}
