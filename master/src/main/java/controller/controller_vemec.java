package controller;

import Config.conexion;
import clases.infoVemec;
import clases.medidaVemec;
import clases.vemec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class controller_vemec {

    private static final controller_vemec instance = new controller_vemec();
    conexion con = new conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());

    public static controller_vemec getInstance() {
        return instance;
    }

    private controller_vemec() {
    }

    public Boolean create_vemec(String marca, String modelo, String ubicacion) {
        String[] variables = {marca, modelo, ubicacion};
        try {
            String sql = "insert into vemecs(marca, modelo, ubicacion) values (?,?,?)";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update_vemec(String idVemec, String marca, String modelo, String ubicacion) {
        String[] variables = {marca, modelo, ubicacion, idVemec};
        try {
            String sql = "update vemecs set marca=?, modelo=?, ubicacion=? where id = ?";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete_vemec(String selected) {
        String[] variables = {selected};
        try {
            String sql = "delete from vemecs where id = ?";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Object> read_vemec() {
        String sql = "select v.id, v.marca, v.modelo, v.ubicacion, concat(p.nombre, ' ', p.apellido, ' ', p.ci) as paciente from vemecs as v left join pacientes as p on v.idpaciente = p.id";
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }
    
    public List<Object> read_fullvemec() {
        String sql = "select v.id, v.marca, concat(p.nombre, ' ', p.apellido, ' ', p.ci), v.modelo as paciente from vemecs as v left join pacientes as p on v.idpaciente = p.id";
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }
    
    public List<Object> read_vemecbysala(int idsala) {
        String sql = "select v.id, v.marca, v.modelo, p.id as idpaciente, concat(p.nombre, ' ', p.apellido, ' ', p.ci) as paciente from vemecs as v inner join pacientes as p on v.idpaciente = p.id where p.idcategoria="+ idsala +";";
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }

    public Object read_vemec2() {
        String sql = "select v.id, v.marca, v.modelo, v.ubicacion, p.nombre, p.apellido, p.ci from vemecs as v left join pacientes as p on v.idpaciente = p.id";
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }
    public Object read_personaporvemec(int idvemec) {
        String sql = "select p.id, "
                + "p.ci, p.nombre, "
                + "p.apellido, "
                + "p.edad, "
                + "p.nacionalidad, "
                + "p.email, "
                + "c.nombre as categoria, "
                + "n.estado, "
                + "p.sexo "
                + "from vemecs as v inner join pacientes as p inner join niveles as n inner join categorias as c on p.idpeligro = n.id and p.id = v.idpaciente and p.idcategoria = c.id "
                + "where v.id =" + idvemec;
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }

    public vemec find_vemec(int id) {
        String[] variables = {Integer.toString(id)};
        vemec result = null;
        try {
            String sql = "select * from vemecs where id = " + id;
            result = (vemec) this.jdbcTemplate.queryForObject(sql,
                    new Object[]{id}, new RowMapper() {
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    vemec re = new vemec();
                    re.setId(rs.getInt("id"));
                    re.setMarca(rs.getString("marca"));
                    re.setModelo(rs.getString("modelo"));
                    re.setUbicacion(rs.getString("ubicacion"));
                    return re;
                }
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return result;
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
                        + "pressalida,"
                        + "idpaciente) "
                        + "values (?,?,?,?,?,?,?,?,?,?,?,?,(Select idpaciente from vemecs where id=?));";
                this.jdbcTemplate.update(sql, variables);
                this.jdbcTemplate.update("update vemecs set alerta=" + (info.getAlerta()? 1 : 0) + " where id=" + info.getIdvemec());
            }
        } catch (DataAccessException e) {
            throw e;
        }
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
    
    public List<Object> read_deptos() {
        List<Object> result = null;
        try {
            String sql = "SELECT * from departamentos";
            result = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Object> read_categorias(int iddepto) {
        List<Object> result = null;
        try {
            String sql = "SELECT * from categorias where iddepartamento = " + Integer.toString(iddepto) + ";";
            result = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Object> read_pacientessinvemecs() {
        List<Object> result = null;
        try {
            String sql = "SELECT p.id, concat(p.nombre, ' ', p.apellido) as nombre, p.ci from pacientes as p left join vemecs as v on p.id = v.idpaciente where v.id IS NULL";
            result = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public void update_asignarvemec(int idpaciente, int idvemec) {
        try {
            String[] variables = {Integer.toString(idpaciente), Integer.toString(idvemec)};
            String sql = "update vemecs set idpaciente=? where id=?";
            this.jdbcTemplate.update(sql, variables);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    
    public void update_riesgopaciente(int idpaciente, String nivel) {
        try {
            String[] variables = {nivel, Integer.toString(idpaciente)};
            String sql = "update pacientes set idpeligro=(Select id from niveles where estado=?) where id=?";
            this.jdbcTemplate.update(sql, variables);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
