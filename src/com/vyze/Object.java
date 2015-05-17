package com.vyze;

import com.cedarsoftware.util.io.JsonObject;
import com.cedarsoftware.util.io.JsonWriter;

/**
 * Created by Julian on 5/13/2015.
 */
public class Object extends JsonStructure {
    private int id;
    private int classId;
    private String name;
    private Value[] values;

    public Object(JsonObject obj) {
        id = ((Long) obj.get("id")).intValue();
        classId = ((Long) obj.get("classId")).intValue();
        name = (String) obj.get("name");

        java.lang.Object[] values = ((JsonObject) obj.get("values")).getArray();
        this.values = new Value[values.length];

        for (int i = 0; i < values.length; i++) {
            this.values[i] = new Value((JsonObject) values[i]);
        }
    }

    public Object(int classId) {
        this.classId = classId;
        this.values = new Value[0];
    }

    public void addValue(Value val) {
        Value[] newValues = new Value[values.length + 1];
        System.arraycopy(values, 0, newValues, 0, values.length);
        newValues[values.length] = val;
        values = newValues;
    }

    @Override
    JsonObject toJsonObject() {
        JsonObject obj = new JsonObject();

        obj.put("id", id);
        obj.put("classId", classId);

        java.lang.Object[] vals = new java.lang.Object[values.length];

        for (int i = 0; i < values.length; i++) {
            vals[i] = values[i].toJsonObject();
        }

        obj.put("values", vals);
        obj.put("superObjects", new java.lang.Object[0]);

        return obj;
    }

    public int getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public Value[] getValues() {
        return values;
    }
}
