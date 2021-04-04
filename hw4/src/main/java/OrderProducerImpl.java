import java.util.Deque;

public class OrderProducerImpl implements OrderProducer{
    Deque<Order> orderQueue;
    TimeManager godOfTime;
    int totalOrders = 0;

    OrderProducerImpl(Deque<Order> orderQueue, TimeManager timeManager) {
        this.orderQueue = orderQueue;
        this.godOfTime = timeManager;
    }

    @Override
    public void run() {
        while (true) {
            Order order = produce();
            while (true) {
                synchronized (orderQueue) {
                    while ( orderQueue.size() > 100) {
                        doWait();
                    }
                    orderQueue.add(order);
                    orderQueue.notifyAll();
                    System.out.println("Order №"+order.getOrderId()+" generated");
                    break;
                }
            }
        }
    }

    private void doWait() {
        try {
            orderQueue.wait();
        } catch (InterruptedException ignore) {
        }
    }

    private Order produce() {
        try {
            Thread.sleep(godOfTime.RandomOrderCreationTimeGenerator());
        } catch (InterruptedException ignore) {
        } finally {
            return new Order(++totalOrders);
        }
    }
}
