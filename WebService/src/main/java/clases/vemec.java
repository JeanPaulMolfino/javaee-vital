/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author javaee
 */
public class vemec {
    private int id;
    private String marca;
    private String modelo;
    private String ubicacion;

    

    public vemec() {
    }

    public vemec(int id, String marca, String modelo, String ubicacion) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "vemec{" + "id=" + getId() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", ubicacion=" + getUbicacion() + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
