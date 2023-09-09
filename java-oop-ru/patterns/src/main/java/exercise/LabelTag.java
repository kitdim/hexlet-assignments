package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String value;
    private TagInterface tag;
    LabelTag(String value, TagInterface tag) {
        this.value = value;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" + value + tag.render() + "</label>";
    }
}
// END
