/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class Partido {
    
    private String fase;
    private Equipo equipo1;
    private Equipo equipo2;
    private Date fechaPartido;
    private String hora;
    private int golesEquipo1;
    private int golesEquipo2;
    
    
    public Partido(String fase, Equipo equipo1, Equipo equipo2, Date fechaPartdio, String hora,
            int golesEquipo1, int goleEquipo2){
        this.fase = fase;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fechaPartido = fechaPartido;
        this.hora = hora;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    
    
    public String getFase() {
        return fase;
    }
    public void setFase(String fase) {
        this.fase = fase;
    }
    public Equipo getEquipo1() {
        return equipo1;
    }
    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }
    public Equipo getEquipo2() {
        return equipo2;
    }
    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }
    public Date getFechaPartido() {
        return fechaPartido;
    }
    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public int getGolesEquipo1() {
        return golesEquipo1;
    }
    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }
    public int getGolesEquipo2() {
        return golesEquipo2;
    }
    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }
}
