package com.vyze;

import com.cedarsoftware.util.io.JsonObject;

/**
 * Created by Julian on 5/13/2015.
 */
public class Field {
    private int id;
    private int classId;
    private String name;
    private int type;
    private int count;
    private int position;
    private Permission[] perms;

    Field(JsonObject obj) {
        id = ((Long) obj.get("id")).intValue();
        classId = ((Long) obj.get("classId")).intValue();
        name = (String) obj.get("name");
        type = ((Long) obj.get("type")).intValue();
        count = ((Long) obj.get("count")).intValue();
        position = ((Long) obj.get("position")).intValue();

        java.lang.Object[] perms = ((JsonObject) obj.get("perms")).getArray();
        this.perms = new Permission[perms.length];

        for (int i = 0; i < perms.length; i++) {
            this.perms[i] = new Permission((JsonObject) perms[i]);
        }
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

    public int getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public int getPosition() {
        return position;
    }

    public Permission[] getPerms() {
        return perms;
    }
}
