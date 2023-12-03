package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag {
    protected String nameTag;
    protected Map<String, String> attribute;

    Tag(String nameTag, Map<String, String> attribute) {
        this.nameTag = nameTag;
        this.attribute = attribute;
    }
    public String stringifyAttributes() {
        return attribute.keySet().stream()
                .map(key -> {
                    String value = attribute.get(key);
                    return String.format(" %s=\"%s\"", key, value);
                })
                .collect(Collectors.joining(""));
    }

    public String getNameTag() {
        return nameTag;
    }
}
// END
