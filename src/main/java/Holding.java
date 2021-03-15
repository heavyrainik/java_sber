import java.util.Map;

public class Holding implements Client {
    private final String name;
    private final Double inn;
    private final ClientTypes clientType = ClientTypes.HOLDING;
    private final boolean isSanctioned;

    Holding(Map<?, ?> clientInfo) {
        name = (String) clientInfo.get("name");
        inn = (Double) clientInfo.get("inn");
        isSanctioned = (boolean) clientInfo.get("isSanctioned");
    }

    public String getName()  {
        return name;
    }

    public Double getInn() {
        return inn;
    }

    public ClientTypes getClientType() {
        return clientType;
    }

    public boolean IsSanctioned() {
        return isSanctioned;
    }
}
