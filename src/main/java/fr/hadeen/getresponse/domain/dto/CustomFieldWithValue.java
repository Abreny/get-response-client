package fr.hadeen.getresponse.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomFieldWithValue {
    private String customFieldId;
    private List<String> value = new ArrayList<>();

    public CustomFieldWithValue() {

    }
    public CustomFieldWithValue(String id) {
        this.customFieldId = id;
    }

    public String getCustomFieldId() {
        return customFieldId;
    }

    public void setCustomFieldId(String customFieldId) {
        this.customFieldId = customFieldId;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public CustomFieldWithValue addValue(String value) {
        this.value.add(value);
        return this;
    }
}
