import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonFileReader {
    static public Map<?, ?> openJSON(String filename) throws IOException {
        Reader reader = null;
        try {
            Gson gson = new Gson();
            reader = Files.newBufferedReader(Paths.get(filename));
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            return map;
        } catch (Exception ex) {
            return null;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
