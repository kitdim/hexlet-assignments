package exercise;

import java.util.Map.Entry;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var map = storage.toMap();
        for (var item : storage.toMap().keySet()) {
            storage.unset(item);
        }
        for (Entry<String, String> entry : map.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
