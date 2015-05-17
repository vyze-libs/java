package com.vyze;

import com.cedarsoftware.util.io.JsonObject;
import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.Readers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Julian on 5/12/2015.
 */
public class MessageIn {

    public static class CreateSession extends MessageIn {
        private String sid;
        private boolean success;

        CreateSession(JsonObject obj) {
            super(obj);
            this.sid = (String) obj.get("sid");
            this.success = (Boolean) obj.get("success");
        }

        public String getSid() {
            return sid;
        }

        public boolean getSuccess() {
            return success;
        }
    }

    public static class Login extends MessageIn {

        Login(JsonObject obj) {
            super(obj);
        }
    }

    public static class Miniworlds extends MessageIn {
        private com.vyze.Miniworld[] miniworlds;

        Miniworlds(JsonObject obj) {
            super(obj);

            java.lang.Object[] miniworlds = ((JsonObject) obj.get("miniworlds")).getArray();
            this.miniworlds = new com.vyze.Miniworld[miniworlds.length];

            for (int i = 0; i < miniworlds.length; i++) {
                this.miniworlds[i] = new com.vyze.Miniworld((JsonObject) miniworlds[i]);
            }
        }

        public com.vyze.Miniworld[] getMiniworlds() {
            return miniworlds;
        }
    }

    public static class CreateMiniworld extends MessageIn {
        private boolean success;
        private com.vyze.Miniworld miniworld;

        CreateMiniworld(JsonObject obj) {
            super(obj);

            success = (Boolean) obj.get("success");
            miniworld = new com.vyze.Miniworld((JsonObject) obj.get("miniworld"));
        }

        public com.vyze.Miniworld getMiniworld() {
            return miniworld;
        }

        public boolean isSuccess() {
            return success;
        }
    }

    public static class Miniworld extends MessageIn {
        private com.vyze.Miniworld miniworld;
        private Class[] classes;
        private Field[] fields;
        private Group[] groups;

        Miniworld(JsonObject obj) {
            super(obj);

            miniworld = new com.vyze.Miniworld((JsonObject) obj.get("miniworld"));

            java.lang.Object[] classes = ((JsonObject) obj.get("classes")).getArray();
            this.classes = new Class[classes.length];

            for (int i = 0; i < classes.length; i++) {
                this.classes[i] = new Class((JsonObject) classes[i]);
            }

            java.lang.Object[] fields = ((JsonObject) obj.get("fields")).getArray();
            this.fields = new Field[fields.length];

            for (int i = 0; i < fields.length; i++) {
                this.fields[i] = new Field((JsonObject) fields[i]);
            }

            java.lang.Object[] groups = ((JsonObject) obj.get("groups")).getArray();
            this.groups = new Group[groups.length];

            for (int i = 0; i < groups.length; i++) {
                this.groups[i] = new Group((JsonObject) groups[i]);
            }
        }

        public com.vyze.Miniworld getMiniworld() {
            return miniworld;
        }

        public Class[] getClasses() {
            return classes;
        }

        public Field[] getFields() {
            return fields;
        }

        public Group[] getGroups() {
            return groups;
        }
    }

    public static class CreateObject extends MessageIn {
        private int classId;
        private int objectId;
        private int errorCode;
        private String errorMsg;

        CreateObject(JsonObject obj) {
            super(obj);

            classId = ((Long) obj.get("classId")).intValue();
            objectId = ((Long) obj.get("objectId")).intValue();
            errorCode = ((Long) obj.get("errorCode")).intValue();
            errorMsg = (String) obj.get("errorMsg");
        }

        public int getClassId() {
            return classId;
        }

        public int getObjectId() {
            return objectId;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class Objects extends MessageIn {
        private int classId;
        private com.vyze.Object[] objects;

        Objects(JsonObject obj) {
            super(obj);

            classId = ((Long) obj.get("classId")).intValue();

            java.lang.Object[] objects = ((JsonObject) obj.get("objects")).getArray();
            this.objects = new com.vyze.Object[objects.length];

            for (int i = 0; i < objects.length; i++) {
                this.objects[i] = new com.vyze.Object((JsonObject) objects[i]);
            }
        }

        public int getClassId() {
            return classId;
        }

        public Object[] getObjects() {
            return objects;
        }
    }

    public MessageIn(JsonObject obj) {
        cmd = (String) obj.get("cmd");
    }

    public static MessageIn fromJson(String json) {
        JsonObject obj = (JsonObject) JsonReader.jsonToMaps(json);

        String cmd = (String) obj.get("cmd");

        if (cmd == null) {
            return null;
        }

        System.out.println("IN: " + cmd);

        switch (cmd) {
            case "create_session":
                return new CreateSession(obj);
            case "login":
                return new Login(obj);
            case "miniworlds":
                return new Miniworlds(obj);
            case "create_miniworld":
                return new CreateMiniworld(obj);
            case "miniworld":
                return new Miniworld(obj);
            case "create_object":
                return new CreateObject(obj);
            case "objects":
                return new Objects(obj);
        }

        return null;
    }

    private String cmd;

    public String getCmd() {
        return cmd;
    }
}
