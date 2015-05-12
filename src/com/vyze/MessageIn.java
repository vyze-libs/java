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
        private Miniworld[] miniworlds;

        Miniworlds(JsonObject obj) {
            super(obj);

            Object[] miniworlds = ((JsonObject) obj.get("miniworlds")).getArray();

            this.miniworlds = new Miniworld[miniworlds.length];

            for (int i = 0; i < miniworlds.length; i++) {
                this.miniworlds[i] = new Miniworld((JsonObject) miniworlds[i]);
            }
        }

        public Miniworld[] getMiniworlds() {
            return miniworlds;
        }
    }

    public static class CreateMiniworld extends MessageIn {
        private boolean success;
        private Miniworld miniworld;

        CreateMiniworld(JsonObject obj) {
            super(obj);

            success = (Boolean) obj.get("success");
            miniworld = new Miniworld((JsonObject) obj.get("miniworld"));
        }

        public Miniworld getMiniworld() {
            return miniworld;
        }

        public boolean isSuccess() {
            return success;
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
        }

        return null;
    }

    private String cmd;

    public String getCmd() {
        return cmd;
    }
}
