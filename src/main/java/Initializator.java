import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

abstract class Initializator {
    final String filename;

    Initializator(String file_name) {
        filename = file_name;
    }

    public Object createClient() {
        Map<?, ?> map = openJSON();

        if (map == null) {
            System.out.print("Reading error");
            return null;
        }

        return createClient(map);
    }

    abstract public Object createClient(Map map);

    private Map<?, ?> openJSON() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(filename));
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            reader.close();

            return map;
        } catch (Exception ex) {
            return null;
        }
    }
}
