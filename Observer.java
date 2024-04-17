public interface Observer {
    public void update_time(Flight flight);
    public void update_canceled(Flight flight);
    public void update_price(Flight flight);
}
