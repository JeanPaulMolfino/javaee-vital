package controller;

import Config.conexion;
import clases.vemec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
            String sql = "insert into vemec(marca, modelo, ubicacion) values (?,?,?)";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {

        }
        return false;
    }

    public Boolean update_vemec(vemec selected) {
        String[] variables = {selected.getMarca(), selected.getModelo(), selected.getUbicacion(), Integer.toString(selected.getId())};
        try {
            String sql = "update vemecs set marca=?, modelo=?, ubicacion=? where id = ?";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {

        }
        return false;
    }

    public Boolean delete_vemec(vemec selected) {
        String[] variables = {Integer.toString(selected.getId())};
        try {
            String sql = "delete from mensajes where id = ?";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {

        }
        return false;
    }

    public List<vemec> read_vemec() {
        String sql = "select * from vemecs";
        List<vemec> datos = null;
        //
            datos = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(vemec.class));
        //} catch (DataAccessException e) {

        //}
        return datos;
    }

    public vemec find_vemec(int id) {
        String[] variables = {Integer.toString(id)};
        vemec result = null;
        try {
            String sql = "delete from mensajes where id = " + id;
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

        }
        return result;
    }

}
