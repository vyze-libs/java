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
public abstract class Connection {

    private ExecutorService executor = Executors.newFixedThreadPool(4);
    private WebSocketClient wc;

    public void connect(String url) {
        try {
            Map<String,String> headers = new HashMap<String,String>();

            // The Vyze server needs this header component for some reason
            headers.put("Origin", "http://vy-mw1.vyze.me");

            final Connection that = this;

            wc = new WebSocketClient(new URI(url), new Draft_17(), headers, 10000) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    that.onOpen();
                }

                @Override
                public void onMessage(String s) {
                    MessageIn msg = MessageIn.fromJson(s);
                    that.onMessage(msg);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    that.onClose();
                }

                @Override
                public void onError(Exception e) {
                }
            };

            wc.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void send(MessageOut msg) {
        System.out.println("OUT: " + msg.getCmd());
        System.out.println(msg.toJson());
        wc.send(msg.toJson());
    }

    public void process(MessageIn msg) {
        // TODO: Implement
    }

    public abstract void onOpen();
    public abstract void onMessage(MessageIn msg);
    public abstract void onClose();
}
