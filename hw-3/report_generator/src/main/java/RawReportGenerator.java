import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RawReportGenerator<T> implements ReportGenerator<T>{
    @Override
    public RawReport generate(List<T> entities) throws IllegalAccessException {
        List<String> field_names = new ArrayList<>();
        List<String> field_values = new ArrayList<>();

        Class<?> clazz = entities.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field_names.add(field.getName());
        }

        for (T entity: entities) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                field_values.add(field.get(entity).toString());
            }
        }

        return new RawReport(field_names, field_values);
    }
}
