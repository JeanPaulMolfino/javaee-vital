/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author javaee
 */
public class medidaVemec {
    private int presionmin;
    private int presionmax;
    private int volumendegas;
    private int frecuenciaaporte;
    private int composicionmezcla;
    private int humedadaire;
    private int temperaturaentrada;
    private int temperaturasalida;
    private int presionentrada;
    private int presionsalida;
    private Date fecha;

    public int getPresionmax() {
        return presionmax;
    }

    public void setPresionmax(int presionmax) {
        this.presionmax = presionmax;
    }

    public medidaVemec() {
    }

    public medidaVemec(int presionmin, int presionmax, int volumendegas, int frecuenciaaporte, int composicionmezcla, int humedadaire, int temperaturaentrada, int temperaturasalida, int presionentrada, int presionsalida, Date fecha) {
        this.presionmin = presionmin;
        this.presionmax = presionmax;
        this.volumendegas = volumendegas;
        this.frecuenciaaporte = frecuenciaaporte;
        this.composicionmezcla = composicionmezcla;
        this.humedadaire = humedadaire;
        this.temperaturaentrada = temperaturaentrada;
        this.temperaturasalida = temperaturasalida;
        this.presionentrada = presionentrada;
        this.presionsalida = presionsalida;
        this.fecha = fecha;
    }

    

    public int getPresionmin() {
        return presionmin;
    }

    public void setPresionmin(int presionmin) {
        this.presionmin = presionmin;
    }

    public int getVolumendegas() {
        return volumendegas;
    }

    public void setVolumendegas(int volumendegas) {
        this.volumendegas = volumendegas;
    }

    public int getFrecuenciaaporte() {
        return frecuenciaaporte;
    }

    public void setFrecuenciaaporte(int frecuenciaaporte) {
        this.frecuenciaaporte = frecuenciaaporte;
    }

    public int getComposicionmezcla() {
        return composicionmezcla;
    }

    public void setComposicionmezcla(int composicionmezcla) {
        this.composicionmezcla = composicionmezcla;
    }

    public int getHumedadaire() {
        return humedadaire;
    }

    public void setHumedadaire(int humedadaire) {
        this.humedadaire = humedadaire;
    }

    public int getTemperaturaentrada() {
        return temperaturaentrada;
    }

    public void setTemperaturaentrada(int temperaturaentrada) {
        this.temperaturaentrada = temperaturaentrada;
    }

    public int getTemperaturasalida() {
        return temperaturasalida;
    }

    public void setTemperaturasalida(int temperaturasalida) {
        this.temperaturasalida = temperaturasalida;
    }

    public int getPresionentrada() {
        return presionentrada;
    }

    public void setPresionentrada(int presionentrada) {
        this.presionentrada = presionentrada;
    }

    public int getPresionsalida() {
        return presionsalida;
    }

    public void setPresionsalida(int presionsalida) {
        this.presionsalida = presionsalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
