package com.vyze;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

/**
 * Created by Julian on 5/12/2015.
 */
public class MessageIn {

    public static class CreateSession extends MessageIn {
        private String sid;
        private boolean success;

        CreateSession(JSONObject obj) {
            super(obj);
            this.sid = obj.getString("sid");
            this.success = obj.getBoolean("success");
        }

        public String getSid() {
            return sid;
        }

        public boolean getSuccess() {
            return success;
        }
    }

    public static class Session extends MessageIn {

        Session(JSONObject obj) {
            super(obj);
        }
    }

    public static class Login extends MessageIn {

        Login(JSONObject obj) {
            super(obj);
        }
    }

    public static class GetMiniworlds extends MessageIn {

        GetMiniworlds(JSONObject obj) {
            super(obj);
        }
    }

    public static class CreateMiniworld extends MessageIn {

        CreateMiniworld(JSONObject obj) {
            super(obj);
        }
    }

    public MessageIn(JSONObject obj) {
        cmd = obj.getString("cmd");
    }

    public static MessageIn fromJson(String json) {
        JSONObject obj = new JSONObject(json);

        String cmd = obj.getString("cmd");

        if (cmd == null) {
            return null;
        }

        switch (cmd) {
            case "create_session":
                return new CreateSession(obj);
        }

        return null;
    }

    private String cmd;

    public String getCmd() {
        return cmd;
    }
}
