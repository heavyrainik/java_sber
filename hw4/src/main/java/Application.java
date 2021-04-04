import java.util.ArrayDeque;
import java.util.Deque;

public class Application {
    public static void main(String[] args) {
        Deque<Order> orderQueue = new ArrayDeque<>();

        TimeManager timeManager = TimeManagerCreator();
        OrderProducer orderProducer = OrderProducerCreator(orderQueue, timeManager);
        Dispatcher dispatcher = DispatcherCreator(orderQueue, timeManager);

        Thread thread1 = new Thread(orderProducer);
        Thread thread2 = new Thread(dispatcher);

        thread1.start();
        thread2.start();
    }

    private static Dispatcher DispatcherCreator(Deque<Order> orderQueue, TimeManager timeManager){
        Deque<Taxi> taxis = new ArrayDeque<Taxi>();

        for (int i = 1; i < 21; i++) {
            taxis.add(new TaxiImpl(i, timeManager));
        }

        return new DispatcherImpl(taxis, orderQueue);
    }

    private static OrderProducer OrderProducerCreator(Deque<Order> orderQueue, TimeManager timeManager) {
        return new OrderProducerImpl(orderQueue, timeManager);
    }

    private static TimeManager TimeManagerCreator() {
        return new GodOfTime();
    }
}
