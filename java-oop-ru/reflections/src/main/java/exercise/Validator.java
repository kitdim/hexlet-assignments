package exercise;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

// BEGIN
public class Validator {
    public static List<String> validate(Object address) {
        var result = new ArrayList<String>();
        for (var field : address.getClass().getDeclaredFields()) {
            var isNotNull = field.isAnnotationPresent(NotNull.class);
            try {
                field.setAccessible(true);
                if (isNotNull && field.get(address) == null)
                    result.add(field.getName());
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object address) {
        var fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> result = new LinkedHashMap<>();
        try {
            for (var field : fields) {
                field.setAccessible(true);
                boolean isNotNull = field.isAnnotationPresent(NotNull.class);
                boolean isMinLength = field.isAnnotationPresent(MinLength.class);
                List<String> value = new ArrayList<>();
                String key = field.getName();

                if (isNotNull && field.get(address) == null) {
                    value.add("can not be null");
                }

                if (isMinLength && field.get(address).toString().length() < field.getAnnotation(MinLength.class).minLength()) {
                    var size = field.getAnnotation(MinLength.class).minLength();
                    value.add("length less than " + size);
                }

                if (!value.isEmpty()) {
                    result.put(key, value);
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
// END
