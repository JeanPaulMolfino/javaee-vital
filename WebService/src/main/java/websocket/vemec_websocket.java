package websocket;

import clases.infoVemec;
import com.google.gson.Gson;
import controller.controller_vemec;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import static java.lang.System.out;
/**
 *
 * @author javaee
 */
@ServerEndpoint("/vemec")
public class vemec_websocket {

    //private Logger logger = Logger.getLogger(this.getClass().getName());
    private static Set<vemec_websocket> vemec_websockets = new CopyOnWriteArraySet<>();

    @OnMessage
    public void onMessage(final String message, Session client) throws IOException {
        //client.getBasicRemote().sendText("Hello");  
        Gson gson = new Gson();
        infoVemec info = gson.fromJson(message, infoVemec.class);
        controller_vemec.getInstance().data_vemec(info);
    }

    @OnOpen
    public void onOpen(Session sesion) {
        try {
            vemec_websockets.add(this);
            out.println("Hello World");
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
