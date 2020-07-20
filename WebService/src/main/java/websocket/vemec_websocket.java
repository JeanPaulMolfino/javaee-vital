package websocket;

import clases.infoVemec;
import clases.medidaVemec;
import com.google.gson.Gson;
import controller.controller_slave;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ServerEndpoint("/vemec")
public class vemec_websocket {

    //private Logger logger = Logger.getLogger(this.getClass().getName());
    private static Set<vemec_websocket> vemec_websockets = new CopyOnWriteArraySet<>();
    List<medidaVemec> Listado;
    int idVemec;
    Calendar ultimoenvio;
    int timer;

    @OnMessage
    public void onMessage(final String message, Session client) throws IOException {
        out.println("Llego mensaje");
        Gson gson = new Gson();
        infoVemec info = gson.fromJson(message, infoVemec.class);
        controller_slave.getInstance().data_vemec(info);
        idVemec = info.getIdvemec();
        Calendar temporal = (Calendar) ultimoenvio.clone();
        temporal.add(Calendar.MINUTE, timer);
        Listado.addAll(info.getDatos());
        out.println("Van: " + Listado.size());
        
        if (Calendar.getInstance().compareTo(temporal) > 0 && !Listado.isEmpty()) {
            out.println("Envio promedio");
            enviarpromedio();
            out.println("Promedio enviado");
            ultimoenvio = (Calendar) Calendar.getInstance().clone();
        }
        
        timer = controller_vemec.getInstance().getupdatetime();
    }

    @OnOpen
    public void onOpen(Session sesion) {
        try {
            Listado = new ArrayList<medidaVemec>();
            ultimoenvio = (Calendar) Calendar.getInstance().clone();
            timer = controller_vemec.getInstance().getupdatetime();
            vemec_websockets.add(this);
            out.println("Conexion realizada");
            sesion.getBasicRemote().sendText("Conectado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        vemec_websockets.remove(this);
        if (!Listado.isEmpty()) {
            enviarpromedio();
            out.println("Envio de manera abrupta");
        }
    }

    @OnError
    public void onError(Throwable t) {
    }

    private void enviarpromedio() {
        medidaVemec promedio = new medidaVemec();
        int presionmin = 0;
        int presionmax = 0;
        int volumendegas = 0;
        int frecuenciaaporte = 0;
        int composicionmezcla = 0;
        int humedadaire = 0;
        int temperaturaentrada = 0;
        int temperaturasalida = 0;
        int presionentrada = 0;
        int presionsalida = 0;

        for (medidaVemec var : Listado) {
            presionmin += var.getPresionmin();
            presionmax += var.getPresionmax();
            volumendegas += var.getVolumendegas();
            frecuenciaaporte += var.getFrecuenciaaporte();
            composicionmezcla += var.getComposicionmezcla();
            humedadaire += var.getHumedadaire();
            temperaturaentrada += var.getTemperaturaentrada();
            temperaturasalida += var.getTemperaturasalida();
            presionentrada += var.getPresionentrada();
            presionsalida += var.getPresionsalida();
        }

        presionmin = presionmin / Listado.size();
        presionmax = presionmax / Listado.size();
        volumendegas = volumendegas / Listado.size();
        frecuenciaaporte = frecuenciaaporte / Listado.size();
        composicionmezcla = composicionmezcla / Listado.size();
        humedadaire = humedadaire / Listado.size();
        temperaturaentrada = temperaturaentrada / Listado.size();
        temperaturasalida = temperaturasalida / Listado.size();
        presionentrada = presionentrada / Listado.size();
        presionsalida = presionsalida / Listado.size();

        promedio.setPresionmin(presionmin);
        promedio.setPresionmax(presionmax);
        promedio.setVolumendegas(volumendegas);
        promedio.setFrecuenciaaporte(frecuenciaaporte);
        promedio.setComposicionmezcla(composicionmezcla);
        promedio.setHumedadaire(humedadaire);
        promedio.setTemperaturaentrada(temperaturaentrada);
        promedio.setTemperaturasalida(temperaturasalida);
        promedio.setPresionentrada(presionentrada);
        promedio.setPresionsalida(presionsalida);
        infoVemec enviar = new infoVemec();
        enviar.setIdvemec(idVemec);
        List<medidaVemec> a = new ArrayList<medidaVemec>();
        a.add(promedio);
        enviar.setDatos(a);
        Listado.clear();
        controller_vemec.getInstance().promedio(enviar);
    }
}
