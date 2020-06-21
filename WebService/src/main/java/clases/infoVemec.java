/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;

/**
 *
 * @author javaee
 */
public class infoVemec {
    private int idvemec;
    private Boolean alerta;
    private List<medidaVemec> datos;

    public infoVemec() {
    }

    public infoVemec(int idvemec, Boolean alerta, List<medidaVemec> datos) {
        this.idvemec = idvemec;
        this.alerta = alerta;
        this.datos = datos;
    }

    public int getIdvemec() {
        return idvemec;
    }

    public void setIdvemec(int idvemec) {
        this.idvemec = idvemec;
    }
    
    public Boolean getAlerta() {
        return alerta;
    }

    public void setAlerta(Boolean alerta) {
        this.alerta = alerta;
    }

    public List<medidaVemec> getDatos() {
        return datos;
    }

    public void setDatos(List<medidaVemec> datos) {
        this.datos = datos;
    }
    
    
}
