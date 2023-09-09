package exercise;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String filepath;
    FileKV(String filepath, Map<String, String> map) {
        this.filepath = filepath;
        map.entrySet().forEach(entry -> set(entry.getKey(), entry.getValue()));
    }
    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(filepath);
        Map<String, String> map = Utils.unserialize(content);
        map.put(key, value);
        Utils.writeFile(filepath, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(filepath);
        Map<String, String> map = Utils.unserialize(content);
        map.remove(key);
        Utils.writeFile(filepath, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(content);
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(filepath);
        return Utils.unserialize(content);
    }
}
// END
