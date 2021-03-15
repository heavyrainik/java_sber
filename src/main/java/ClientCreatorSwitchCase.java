import java.util.Map;

public class ClientCreatorSwitchCase extends ClientCreator {
    ClientCreatorSwitchCase(String file_name) {
        super(file_name);
    }

    @Override
    public Client createClient(Map<?, ?> clientInfo) throws Exception {
        String clientType = (String) clientInfo.get("clientType");

        return switch (clientType) {
            case "INDIVIDUAL" -> new Individual(clientInfo);
            case "LEGAL_ENTITY" -> new LegalEntity(clientInfo);
            case "HOLDING" -> new Holding(clientInfo);
            default -> throw new Exception("bad client type");
        };
    }
}


