package com.vyze;

import com.cedarsoftware.util.io.JsonObject;

/**
 * Created by Julian on 5/13/2015.
 */
public class Group {
    private int id;
    private String name;
    private int users;

    Group(JsonObject obj) {
        id = ((Long) obj.get("id")).intValue();
        name = (String) obj.get("name");
        users = ((Long) obj.get("users")).intValue();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUsers() {
        return users;
    }
}
