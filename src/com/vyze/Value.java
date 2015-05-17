package com.vyze;

import com.cedarsoftware.util.io.JsonObject;

import java.lang.*;

/**
 * Created by Julian on 5/13/2015.
 */
public class Value extends JsonStructure {
    private int fieldId;
    private boolean isNull;
    private java.lang.Object value;
    private boolean isObject;

    public Value(JsonObject obj) {
        fieldId = ((Long) obj.get("fieldId")).intValue();
        isNull = (Boolean) obj.get("isNull");
        value = obj.get("value");
    }

    public Value(int fieldId, boolean isNull, java.lang.Object value) {
        this.fieldId = fieldId;
        this.isNull = isNull;
        this.value = value;
    }

    @Override
    JsonObject toJsonObject() {
        JsonObject obj = new JsonObject();

        obj.put("fieldId", fieldId);
        obj.put("value", value);
        obj.put("isNull", isNull);
        obj.put("isObject", false);

        return obj;
    }

    public int getFieldId() {
        return fieldId;
    }

    public boolean isNull() {
        return isNull;
    }

    public java.lang.Object getValue() {
        return value;
    }

    public boolean isObject() {
        return isObject;
    }
}
