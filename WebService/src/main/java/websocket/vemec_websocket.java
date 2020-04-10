
package websocket;

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
    public String onMessage(String message) {
        return null;
    }

    @OnOpen
    public void onOpen(Session sesion) {
        try{
            sesion.getBasicRemote().sendText("Conectado");
        }
        catch(Exception e){
        }
    }

    @OnClose
    public void onClose() {
    }

    @OnError
    public void onError(Throwable t) {
    }
    
}
