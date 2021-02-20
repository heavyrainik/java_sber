import java.util.Map;

public class InitializatorSwitchCase extends Initializator {
    InitializatorSwitchCase(String file_name) {
        super(file_name);
    }

    @Override
    public Object createClient(Map clientInfo) {
        String clientType = (String) clientInfo.get("clientType");

        return switch (clientType) {
            case "INDIVIDUAL" -> new Individual(clientInfo);
            case "LEGAL_ENTITY" -> new LegalEntity(clientInfo);
            case "HOLDING" -> new Holding(clientInfo);
            default -> null;
        };
    }
}


