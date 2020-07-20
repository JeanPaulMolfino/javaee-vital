package controller;

import Config.conexion;
import clases.infoVemec;
import clases.medidaVemec;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class controller_slave {

    private static final controller_slave instance = new controller_slave();
    conexion con = new conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());

    public static controller_slave getInstance() {
        return instance;
    }

    private controller_slave() {
    }

    
    public void data_vemec(infoVemec info) {
        //ToDo Insertar Registros Base de datos
        try {
            for (medidaVemec medida : info.getDatos()) {
                String[] variables = {
                    Integer.toString(info.getIdvemec()),
                    medida.getFecha().toString(),
                    Integer.toString(medida.getPresionmax()),
                    Integer.toString(medida.getPresionmin()),
                    Integer.toString(medida.getVolumendegas()),
                    Integer.toString(medida.getFrecuenciaaporte()),
                    Integer.toString(medida.getComposicionmezcla()),
                    Integer.toString(medida.getHumedadaire()),
                    Integer.toString(medida.getTemperaturaentrada()),
                    Integer.toString(medida.getTemperaturasalida()),
                    Integer.toString(medida.getPresionentrada()),
                    Integer.toString(medida.getPresionsalida()),
                    Integer.toString(info.getIdvemec())
                };
                String sql = "insert into historiales("
                        + "idvemec, "
                        + "timestap, "
                        + "presionmaxima, "
                        + "presionminima, "
                        + "volgasaporta, "
                        + "frecaporte, "
                        + "compomezcla, "
                        + "humedadaire, "
                        + "tempentrada, "
                        + "tempsalida, "
                        + "presentrada, "
                        + "pressalida) "
                        + "values (?,?,?,?,?,?,?,?,?,?,?,?);";
                this.jdbcTemplate.update(sql, variables);
                this.jdbcTemplate.update("update vemecs set alerta=" + (info.getAlerta()? 1 : 0) + ", alertab="+ (info.getAlertaBateria()? 1 : 0) +" where id=" + info.getIdvemec());
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    
    public List<Object> read_alertas() {
        String sql = "select v.id as idvemec, concat(p.nombre, ' ', p.apellido) as paciente, v.ubicacion from vemecs as v inner join pacientes as p where v.alerta=1 and v.idpaciente = p.id";
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }
    
    public List<Object> read_alertasBateria() {
        String sql = "select v.id as idvemec, concat(p.nombre, ' ', p.apellido) as paciente, v.ubicacion from vemecs as v inner join pacientes as p where v.alertab=1 and v.idpaciente = p.id";
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }
    
    public List<Object> read_vemecdata(String idvemec) {
        List<Object> result = null;
        String[] variables = {idvemec};
        try {
            String sql = "SELECT "
                    + "timestap, "
                    + "presionmaxima, "
                    + "presionminima, "
                    + "volgasaporta, "
                    + "frecaporte, "
                    + "compomezcla, "
                    + "humedadaire, "
                    + "tempentrada, "
                    + "tempsalida, "
                    + "presentrada, "
                    + "pressalida"
                    + " FROM historiales where idvemec = ? order by timestap DESC";
            result = this.jdbcTemplate.queryForList(sql, variables);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Object> read_vemecdata_3minutes(String idvemec) {
        List<Object> result = null;
        String[] variables = {idvemec};
        try {
            String sql = "SELECT h.* FROM historiales as h where h.idvemec = ? and h.timestap >= date_sub(NOW(), INTERVAL '3:0' MINUTE_SECOND) order by h.timestap ASC";
            result = this.jdbcTemplate.queryForList(sql, variables);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}