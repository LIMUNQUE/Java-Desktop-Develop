/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class Jugador {
    
    private String nombre;
    private String numCamiseta;
    private String directorTecnico;
    private String fotoJugador;
    
    public Jugador(String nombre, String numCamiseta, String directorTecnico, String fotoJugador){
        this.nombre = nombre;
        this.numCamiseta = numCamiseta;
        this.directorTecnico = directorTecnico;
        this.fotoJugador = fotoJugador;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumCamiseta() {
        return numCamiseta;
    }
    public void setNumCamiseta(String numCamiseta) {
        this.numCamiseta = numCamiseta;
    }
    public String getDirectorTecnico() {
        return directorTecnico;
    }
    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }
    public String getFotoJugador() {
        return fotoJugador;
    }
    public void setFotoJugador(String fotoJugador) {
        this.fotoJugador = fotoJugador;
    }
    
    
}
