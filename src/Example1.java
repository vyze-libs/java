import com.vyze.Connection;
import org.java_websocket.WebSocketImpl;

/**
 * Created by Julian on 5/6/2015.
 */
public class Example1 {

    public static void main(String[] args) {

        WebSocketImpl.DEBUG = true;

        Connection c = new Connection();
        c.connect("wss://vy-global.vyze.me:12345/wss");
        //c.connect("ws://localhost:12345/ws");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
