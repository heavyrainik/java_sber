import java.util.Deque;

public class DispatcherImpl implements Dispatcher {
    final Deque<Taxi> availableTaxisQueue;
    final Deque<Order> orderQueue;

    DispatcherImpl(Deque<Taxi> availableTaxisQueue, Deque<Order> orderQueue){
        this.availableTaxisQueue = availableTaxisQueue;
        this.orderQueue = orderQueue;
    }

    @Override
    public void notifyAvailable(Taxi taxi) {
        taxi.setAvalibility(availableTaxisQueue);
    }

    @Override
    public void run() {
        for (var taxi : availableTaxisQueue) {
            notifyAvailable(taxi);
        }

        Taxi taxi;
        Order order;

        while (true) {
            order = getOrder();
            taxi = getTaxi();

            taxi.placeOrder(order);

            Thread ride = new Thread(taxi);
            ride.start();
        }
    }

    private Taxi getTaxi() {
        Taxi taxi;
        synchronized (availableTaxisQueue) {
            while (availableTaxisQueue.isEmpty()) {
                waitForTaxi();
            }

            taxi = availableTaxisQueue.removeFirst();
        }
        return taxi;
    }

    private void waitForTaxi() {
        try {
            availableTaxisQueue.wait();
        } catch (InterruptedException ignore) {
        }
    }

    private void waitForOrder() {
        try {
            orderQueue.wait();
        } catch (InterruptedException ignore) {
        }
    }

    private Order getOrder() {
        while (true) {
            synchronized (orderQueue) {
                while (orderQueue.isEmpty()) {
                    waitForOrder();
                }
                Order order = orderQueue.removeFirst();
                orderQueue.notifyAll();
                return order;
            }
        }
    }
}
