import java.util.Map;

public class ClientCreatorEnumCase extends ClientCreator {

    ClientCreatorEnumCase(String filename){super(filename);}

    @Override
    public Client createClient(Map<?, ?> clientInfo) {
        return (CreateClientType.valueOf((String) clientInfo.get("clientType"))).createClient(clientInfo);
    }
}
