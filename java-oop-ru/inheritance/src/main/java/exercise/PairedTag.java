package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String body;
    private List<Tag> children;
    PairedTag(String nameTag, Map<String, String> attribute, String body, List<Tag> children) {
        super(nameTag, attribute);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String attributes = stringifyAttributes();
        String name = getNameTag();
        String value = children.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));

        return String.format("<%s%s>%s%s</%s>", name, attributes, body, value, name);
    }
}
// END
