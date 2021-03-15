import java.util.Map;

abstract class ClientCreator {
    final String filename;

    ClientCreator(String filename) {
        this.filename = filename;
    }

    public Client createClient() throws Exception {
        Map<?, ?> map = JsonFileReader.openJSON(filename);

        if (map == null) {
            System.out.print("Reading error");
            return null;
        }

        return createClient(map);
    }

    abstract public Client createClient(Map<?, ?> map) throws Exception;
}
