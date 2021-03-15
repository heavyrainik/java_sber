import java.util.Map;

public enum CreateClientType {
    INDIVIDUAL {
        public Client createClient(Map map) {
            return new Individual(map);
        }
    },
    LEGAL_ENTITY {
        public Client createClient(Map map) {
            return new LegalEntity(map);
        }
    },
    HOLDING {
        public Client createClient(Map map) {
            return new Holding(map);
        }
    };

    abstract public Client createClient(Map clientInfo);
}
