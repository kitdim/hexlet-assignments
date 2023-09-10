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

    @Override
    public abstract String toString();
}
// END
