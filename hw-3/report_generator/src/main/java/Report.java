import java.io.OutputStream;
import java.util.List;

interface Report {
    byte[] asBytes();

    void writeTo(OutputStream os);

    public List<String> getFieldValues();

    public List<String> getFieldNames();
}

