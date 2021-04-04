import java.util.Deque;

public class TaxiImpl implements Taxi {
    private final int driverId;
    private final TimeManager timeManager;
    private Order order;
    private Deque<Taxi> availableTaxisQueue;

    TaxiImpl(int driverId, TimeManager timeManager) {
        this.driverId = driverId;
        this.timeManager = timeManager;
    }

    @Override
    public void run() {
        System.out.println("Taxi №" + driverId + " proceeding Order №"+order.getOrderId());
        try {
            Thread.sleep(timeManager.RandomOrderTimeGenerator());
        } catch (InterruptedException ignore) {
        }

        synchronized (availableTaxisQueue) {
            availableTaxisQueue.add(this);
        }

        System.out.println("Taxi №" + driverId + " has completed Order №"+order.getOrderId());
    }

    @Override
    public void placeOrder(Order order) {
        this.order = order;
    }

    @Override
    public void setAvalibility(Deque<Taxi> availableTaxisQueue) {
        this.availableTaxisQueue = availableTaxisQueue;
    }
}
