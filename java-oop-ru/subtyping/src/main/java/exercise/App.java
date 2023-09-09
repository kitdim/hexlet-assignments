package exercise;

import java.util.Map;
import java.util.Map.Entry;

// BEGIN
class App {
    public static void main(String[] args) {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        // Получение значения по ключу
        storage.get("key", "default"); // "value"
        storage.set("dd", "test");
        System.out.println(storage.toMap());
        System.out.println(storage.toMap());
    }
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
