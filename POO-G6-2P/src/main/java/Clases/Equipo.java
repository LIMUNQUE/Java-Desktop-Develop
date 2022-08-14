/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Equipo {
    
    private String nombreEquipo;
    private ArrayList<Jugador> listaJugadores;
    
    public Equipo(String nombreEquipo, ArrayList<Jugador> listaJugadores){
        this.nombreEquipo = nombreEquipo;
        this.listaJugadores = listaJugadores;
    }
    
    public String getNombreEquipo() {
        return nombreEquipo;
    }
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }
    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    
    
}
