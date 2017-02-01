package za.co.entelect.jbootcamp.models;

public class SearchObject {
    private String property;
    private String value;

    public SearchObject() {
    }

    public SearchObject(String property, String value) {
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
