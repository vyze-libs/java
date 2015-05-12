import com.vyze.Connection;
import com.vyze.MessageIn;
import com.vyze.MessageOut;
import org.java_websocket.WebSocketImpl;

/**
 * Created by Julian on 5/6/2015.
 */
public class Example1 {

    public static void main(String[] args) {

        WebSocketImpl.DEBUG = true;

        Connection c = new Connection() {
            @Override
            public void onOpen() {
                send(new MessageOut.CreateSession("username", "password"));
            }

            @Override
            public void onMessage(MessageIn msg) {
                switch (msg.getCmd()) {

                }
            }

            @Override
            public void onClose() {

            }
        };

        c.connect("ws://vy-global.vyze.me:12345/ws");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
