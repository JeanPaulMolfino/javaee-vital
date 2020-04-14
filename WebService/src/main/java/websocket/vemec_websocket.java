package websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author javaee
 */
@ServerEndpoint("/vemec")
public class vemec_websocket {
    
    //private Logger logger = Logger.getLogger(this.getClass().getName());
    private static Set<vemec_websocket> vemec_websockets = new CopyOnWriteArraySet<>();

    @OnMessage
    public void onMessage(final String message, Session client) throws IOException{
        client.getBasicRemote().sendText("Hello");      
    }

    @OnOpen
    public void onOpen(Session sesion) {
        try {
            vemec_websockets.add(this);
            sesion.getBasicRemote().sendText("Conectado");
        } catch (IOException e) {
        }
    }

    @OnClose
    public void onClose() {
        vemec_websockets.remove(this);
    }

    @OnError
    public void onError(Throwable t) {
    }

}
