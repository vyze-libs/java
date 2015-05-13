package com.vyze;

import com.cedarsoftware.util.io.JsonObject;

/**
 * Created by Julian on 5/13/2015.
 */
public class Class {
    private int id;
    private String name;
    private long diskUsage;
    private int objectCount;
    private int position;
    private int positionX, positionY;
    private int[] superClassIds;
    private Permission[] perms;

    Class(JsonObject obj) {
        id = ((Long) obj.get("id")).intValue();
        name = (String) obj.get("name");
        diskUsage = (Long) obj.get("diskUsage");
        objectCount = ((Long) obj.get("objectCount")).intValue();
        position = ((Long) obj.get("position")).intValue();
        positionX = ((Long) obj.get("positionX")).intValue();
        positionY = ((Long) obj.get("positionY")).intValue();

        java.lang.Object[] superClassIds = ((JsonObject) obj.get("superClassIds")).getArray();
        this.superClassIds = new int[superClassIds.length];

        for (int i = 0; i < superClassIds.length; i++) {
            this.superClassIds[i] = ((Long) superClassIds[i]).intValue();
        }

        java.lang.Object[] perms = ((JsonObject) obj.get("perms")).getArray();
        this.perms = new Permission[perms.length];

        for (int i = 0; i < perms.length; i++) {
            this.perms[i] = new Permission((JsonObject) perms[i]);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDiskUsage() {
        return diskUsage;
    }

    public int getObjectCount() {
        return objectCount;
    }

    public int getPosition() {
        return position;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int[] getSuperClassIds() {
        return superClassIds;
    }

    public Permission[] getPerms() {
        return perms;
    }
}
