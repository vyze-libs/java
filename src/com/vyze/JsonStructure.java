package com.vyze;

import com.cedarsoftware.util.io.JsonObject;
import com.cedarsoftware.util.io.JsonWriter;

/**
 * Created by Julian on 5/12/2015.
 */
abstract class JsonStructure {

    abstract JsonObject toJsonObject()    ;

    public String toJson() {
        return JsonWriter.objectToJson(toJsonObject());
    }

}
