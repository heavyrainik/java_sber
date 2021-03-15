import java.util.Map;

public class Individual implements Client {
    final private String name;
    final private Double inn;
    final private ClientTypes clientType = ClientTypes.INDIVIDUAL;
    final private boolean isSanctioned;

    Individual(Map<?, ?> clientInfo) {
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
