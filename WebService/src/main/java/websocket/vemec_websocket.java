package websocket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @OnMessage
    public void onMessage(final String message, Session client) throws IOException, InterruptedException {
        //for (Session peer : client.getOpenSessions()) {
            while(true){
                try{
                client.getBasicRemote().sendText("Hello");
                Thread.sleep(1000);
                }catch(Exception ex){
                    continue;
                }
            }
        //}
    }

    @OnOpen
    public void onOpen(Session sesion) {
        try {
            sesion.getBasicRemote().sendText("Conectado");
        } catch (Exception e) {
        }
    }

    @OnClose
    public void onClose() {
    }

    @OnError
    public void onError(Throwable t) {
    }

}
