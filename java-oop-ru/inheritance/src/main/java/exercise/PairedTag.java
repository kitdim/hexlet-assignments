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
        StringBuilder result = new StringBuilder("<" + nameTag);
        for (Map.Entry<String, String> entry : attribute.entrySet()) {
            result.append(" ")
                    .append(entry.getKey())
                    .append("=\"" + entry.getValue() + "\"");
        }
        result.append(">");
        result.append(body);
        for (var tag : children) {
            result.append(tag);
        }
        result.append("</" + this.nameTag + ">");
        return result.toString();
    }
}
// END
