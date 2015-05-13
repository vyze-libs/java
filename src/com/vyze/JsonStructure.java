package com.vyze;

import com.cedarsoftware.util.io.JsonObject;
import com.cedarsoftware.util.io.JsonWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Julian on 5/12/2015.
 */
abstract class JsonStructure {

    abstract JsonObject toJsonObject();

    public String toJson() {
        Map args = new HashMap();
        args.put(JsonWriter.PRETTY_PRINT, Boolean.FALSE);
        return JsonWriter.objectToJson(toJsonObject(), args);
    }

}
