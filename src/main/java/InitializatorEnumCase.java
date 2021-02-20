import java.util.Map;

public class InitializatorEnumCase extends Initializator {
    private enum ClientTypes {
        INDIVIDUAL {
            public Object createClient(Map map) {
                return new Individual(map);
            }
        },
        LEGAL_ENTITY {
            public Object createClient(Map map) {
                return new LegalEntity(map);
            }
        },
        HOLDING {
            public Object createClient(Map map) {
                return new Holding(map);
            }
        };

        public abstract Object createClient(Map map);
    }
    InitializatorEnumCase(String filename){super(filename);}

    @Override
    public Object createClient(Map clientInfo) {
        return (ClientTypes.valueOf((String) clientInfo.get("clientType"))).createClient(clientInfo);
    }
}
