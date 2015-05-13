package com.vyze;

import com.cedarsoftware.util.io.JsonObject;

/**
 * Created by Julian on 5/13/2015.
 */
public class Value extends JsonStructure {
    private int fieldId;
    private java.lang.Object value;
    private boolean isObject;

    public Value(int fieldId, java.lang.Object value) {
        this.fieldId = fieldId;
        this.value = value;
    }

    @Override
    JsonObject toJsonObject() {
        JsonObject obj = new JsonObject();

        obj.put("fieldId", fieldId);
        obj.put("value", value);
        obj.put("isNull", false);
        obj.put("isObject", false);

        return obj;
    }
}
