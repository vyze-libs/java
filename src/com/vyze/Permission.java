package com.vyze;

import com.cedarsoftware.util.io.JsonObject;

import java.util.Map;

/**
 * Created by Julian on 5/12/2015.
 */
public class Permission {
    private int id;
    private boolean special;
    private int groupId;
    private int perms;

    Permission(JsonObject obj) {
        id = ((Long) obj.get("id")).intValue();
        special = (Boolean) obj.get("special");
        groupId = ((Long) obj.get("groupId")).intValue();
        perms = ((Long) obj.get("perms")).intValue();
    }

    public int getId() {
        return id;
    }

    public boolean isSpecial() {
        return special;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getPerms() {
        return perms;
    }
}
