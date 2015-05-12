package com.vyze;

import org.json.JSONObject;

/**
 * Created by Julian on 5/12/2015.
 */
public abstract class MessageOut {

    protected String cmd;

    /**
     * Creates a new session and establishes a connection to it. Also logs in the specified user.
     */
    public static class CreateSession extends MessageOut {
        private String username;
        private String password;

        public CreateSession(String username, String password) {
            cmd = "create_session";
        }

        @Override
        public String toJson() {
            JSONObject obj = new JSONObject();

            obj.put("cmd", cmd);
            obj.put("userName", username);
            obj.put("password", password);

            return obj.toString();
        }
    }

    /**
     * Establishes a connection to a session.
     */
    public static class Session extends MessageOut {

        public Session(String sid) {

        }

        @Override
        public String toJson() {
            return "";
        }
    }

    /**
     * Needs an established connection to a session and changes the current user.
     */
    public static class Login extends MessageOut {

        public Login(String username, String password) {

        }

        @Override
        public String toJson() {
            return "";
        }
    }

    /**
     * Requests a list of miniworlds for the connected user.
     */
    public static class GetMiniworlds extends MessageOut {

        @Override
        public String toJson() {
            return "";
        }
    }

    /**
     * Creates a new miniworld for the connected user.
     */
    public static class CreateMiniworld extends MessageOut {

        @Override
        public String toJson() {
            return "";
        }
    }

    public abstract String toJson();

}
