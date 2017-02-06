package za.co.entelect.jbootcamp.models;

import java.util.ArrayList;
import java.util.List;

public class SearchObject {
    private String property;
    private String value;
    private List<String> allSearchProperties = new ArrayList<>();

    public SearchObject() {
    }

    public SearchObject(String property, String value, List<String> allSearchProperties) {
        this.property = property;
        this.value = value;
        this.allSearchProperties = allSearchProperties;
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

    public List<String> getAllSearchProperties() {
        return allSearchProperties;
    }

    public void setAllSearchProperties(List<String> allSearchProperties) {
        this.allSearchProperties = allSearchProperties;
    }
}
