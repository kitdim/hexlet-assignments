package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    SingleTag(String tagName, Map<String, String> attribute) {
        super(tagName, attribute);
    }

    @Override
    public String toString() {
        return String.format("<%s%s>", getNameTag(), stringifyAttributes());
    }
}
// END
//"<img class="v-10" id="wop">