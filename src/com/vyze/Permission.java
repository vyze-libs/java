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
        id = (Integer) obj.get("id");
        special = (Boolean) obj.get("special");
        groupId = (Integer) obj.get("groupId");
        perms = (Integer) obj.get("perms");
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
