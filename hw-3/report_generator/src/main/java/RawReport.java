import java.io.OutputStream;
import java.util.List;

public class RawReport implements Report {
    List<String> fieldNames;
    List<String> fieldValues;

    RawReport(List<String> fieldNames, List<String> fieldValues) {
        this.fieldNames = fieldNames;
        this.fieldValues = fieldValues;
    }

    @Override
    public byte[] asBytes() {
        return new byte[0];
    }

    @Override
    public void writeTo(OutputStream os) {

    }

    public String toString(){
        return fieldNames.toString() + fieldValues.toString();
    }

    public List<String> getFieldValues() {
        return fieldValues;
    }

    public List<String> getFieldNames() {
        return fieldNames;
    }
}
