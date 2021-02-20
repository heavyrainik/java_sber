import java.util.Map;

public class Holding implements Client {
    final private String name;
    final private Double inn;
    final private ClientTypes clientType = ClientTypes.HOLDING;
    final private Boolean isSanctioned;

    Holding(Map clientInfo) {
        name = (String) clientInfo.get("name");
        inn = (Double) clientInfo.get("inn");
        isSanctioned = (Boolean) clientInfo.get("isSanctioned");
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

    public Boolean getIsSanctioned() {
        return isSanctioned;
    }
}
