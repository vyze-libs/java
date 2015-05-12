package com.vyze;

import com.cedarsoftware.util.io.JsonObject;
import com.cedarsoftware.util.io.JsonWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Julian on 5/12/2015.
 */
public abstract class MessageOut extends JsonStructure {

    protected String cmd;

    /**
     * Creates a new session and establishes a connection to it. Also logs in the specified user.
     */
    public static class CreateSession extends MessageOut {
        private String username;
        private String password;

        public CreateSession(String username, String password) {
            cmd = "create_session";

            this.username = username;
            this.password = password;
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObject obj = super.toJsonObject();

            obj.put("username", username);
            obj.put("password", password);

            return obj;
        }
    }

    /**
     * Establishes a connection to a session.
     */
    public static class Session extends MessageOut {
        private String sid;

        public Session(String sid) {
            cmd = "session";

            this.sid = sid;
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObject obj = super.toJsonObject();

            obj.put("sid", sid);

            return obj;
        }
    }

    /**
     * Needs an established connection to a session and changes the current user.
     */
    public static class Login extends MessageOut {

        public Login(String username, String password) {
            cmd = "login";
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObject obj = super.toJsonObject();

            return obj;
        }
    }

    /**
     * Requests a list of miniworlds for the connected user.
     */
    public static class GetMiniworlds extends MessageOut {

        public GetMiniworlds() {
            cmd = "get_miniworlds";
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObject obj = super.toJsonObject();

            return obj;
        }
    }

    /**
     * Creates a new miniworld for the connected user.
     */
    public static class CreateMiniworld extends MessageOut {

        public CreateMiniworld() {
            cmd = "create_miniworld";
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObject obj = super.toJsonObject();

            obj.put("cmd", "create_miniworld");

            return obj;
        }
    }

    public JsonObject toJsonObject() {
        JsonObject obj = new JsonObject();

        obj.put("cmd", cmd);

        return obj;
    }

    public String getCmd() {
        return cmd;
    }

}
