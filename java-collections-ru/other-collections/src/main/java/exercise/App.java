package exercise;

import java.util.*;

// BEGIN
public class App {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, Object> changes = new HashMap<>(data1);
        changes.putAll(data2);

        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        for (String elem : changes.keySet()) {
            if (!data1.containsKey(elem)) {
                result.put(elem, "added");
            } else if (!data2.containsKey(elem)) {
                result.put(elem, "deleted");
            } else if (data1.containsValue(changes.get(elem))) {
                result.put(elem, "unchanged");
            } else if (!data1.containsValue(changes.get(elem))) {
                result.put(elem, "changed");
            }
        }
        return result;
    }
}
//END
