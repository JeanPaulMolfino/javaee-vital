/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Config.conexion;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author javaee
 */
public class controller_paciente {

    private static final controller_paciente instance = new controller_paciente();
    conexion con = new conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());

    public static controller_paciente getInstance() {
        return instance;
    }

    private controller_paciente() {
    }

    public Boolean create_pacientes(String ci, String nombre, String apellido, String edad, String nacionalidad, String email, Boolean sexo) {
        String[] variables = {ci, nombre, apellido, edad, nacionalidad, email, (sexo? "1" : "0")};
        try {
            String sql = "insert into pacientes(ci, nombre, apellido, edad, nacionalidad, email, sexo) values (?,?,?,?,?,?,?)";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Object> read_paciente() {
        String sql = "select * from pacientes";
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }

    public Boolean update_pacientes(String ci, String nombre, String apellido, String edad, String id) {
        String[] variables = {ci, nombre, apellido, edad, id};
        try {
            String sql = "update into set ci=?, nombre=?, apellido=?, edad=? where id=?";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete_paciente(String selected) {
        String[] variables = {selected};
        try {
            String sql = "delete from pacientes where id = ?";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Object> find_pacienteID(int id) {
        List<Object> result = null;
        try {
            String sql = "select * from pacientes where id = " + id;
            result = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Object> find_pacienteCI(int ci) {
        List<Object> result = null;
        try {
            String sql = "select * from pacientes where ci = " + ci;
            result = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public Boolean create_log(int idPaciente, String categoria, String descripcion) {
        String[] variables = {Integer.toString(idPaciente), categoria, descripcion};
        try {
            String sql = "insert into logs(idpaciente, categoria, descripcion, timestap) values (?,?,?, (select now()))";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Object> list_logsbypaciente(int idpaciente) {
        String sql = "select * from logs where idpaciente="+Integer.toString(idpaciente);
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }
    
    public void create_referente(int idpaciente, String nombre, String telefono, String filial) {
        String[] variables = {nombre, telefono, filial, Integer.toString(idpaciente)};
        try {
            String sql = "insert into referentes(nombre, telefono, filial, idpaciente) values (?,?,?,?)";
            this.jdbcTemplate.update(sql, variables);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
    
    public List<Object> list_referentes(int idpaciente) {
        String sql = "select * from referentes where idpaciente="+Integer.toString(idpaciente);
        List<Object> datos = null;
        try {
            datos = this.jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return datos;
    }
    
    public Boolean update_referente(int idreferente, String nombre, String telefono, String filial) {
        String[] variables = {nombre, telefono, filial, Integer.toString(idreferente)};
        try {
            String sql = "update into set nombre=?, telefono=?, filial=? where id=?";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean delete_referente(int idreferente) {
        String[] variables = {Integer.toString(idreferente)};
        try {
            String sql = "delete from referentes where id = ?";
            this.jdbcTemplate.update(sql, variables);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
}
