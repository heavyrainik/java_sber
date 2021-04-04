import java.util.concurrent.ThreadLocalRandom;

public class GodOfTime implements TimeManager{
    public int RandomOrderCreationTimeGenerator() {
        return ThreadLocalRandom.current().nextInt(5, 20 + 1);
    }

    public int RandomOrderTimeGenerator() {
        return ThreadLocalRandom.current().nextInt(5, 300);
    }
}
