package com.vyze;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Julian on 5/6/2015.
 */
public class Connection {

    private ExecutorService executor = Executors.newFixedThreadPool(4);
    private WebSocketClient wc;

    public void connect(String url) {
        try {
            Map<String,String> headers = new HashMap<String,String>();

            // The Vyze server needs this header component for some reason
            headers.put("Origin", "http://vy-mw1.vyze.me");

            wc = new WebSocketClient(new URI(url), new Draft_17(), headers) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("Connection opened.");
                }

                @Override
                public void onMessage(String s) {
                    System.out.println("New message: " + s);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("You have been disconnected from: " + getURI() + "; Code: " + code + " " + reason);
                }

                @Override
                public void onError(Exception e) {
                    System.out.println("Connection error: " + e.toString());
                }
            };

            wc.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
