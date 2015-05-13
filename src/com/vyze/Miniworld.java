package com.vyze;

import com.cedarsoftware.util.io.JsonObject;
import com.cedarsoftware.util.io.Readers;

import java.lang.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Created by Julian on 5/6/2015.
 */
public class Miniworld {
    private int id;
    private String name;
    private int classCount;
    private int objectCount;
    private long diskUsage;
    private String url;
    private Date createdAt;
    private String host;
    private Permission[] perms;

    Miniworld(JsonObject obj) {
        id = ((Long) obj.get("id")).intValue();
        name = (String) obj.get("name");
        classCount = ((Long) obj.get("classCount")).intValue();
        objectCount = ((Long) obj.get("objectCount")).intValue();
        diskUsage = (Long) obj.get("diskUsage");
        url = (String) obj.get("url");

        try {
            createdAt = ISO8601DateParser.parse((String) obj.get("createdAt"));
        } catch (ParseException e) {
            e.printStackTrace();
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

    public int getClassCount() {
        return classCount;
    }

    public int getObjectCount() {
        return objectCount;
    }

    public long getDiskUsage() {
        return diskUsage;
    }

    public String getUrl() {
        return url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getHost() {
        return host;
    }

    public Permission[] getPerms() {
        return perms;
    }
}
