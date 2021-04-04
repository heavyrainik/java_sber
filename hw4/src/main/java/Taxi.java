import java.util.Deque;

public interface Taxi extends Runnable {
    void run();

    void placeOrder(Order order);

    void setAvalibility(Deque<Taxi> orderQueue);
}
