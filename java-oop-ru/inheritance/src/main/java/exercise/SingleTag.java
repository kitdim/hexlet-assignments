package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    SingleTag(String tagName, Map<String, String> attribute) {
        super(tagName, attribute);
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
        return result.toString();
    }
}
// END
//"<img class="v-10" id="wop">