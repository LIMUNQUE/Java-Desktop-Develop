/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class Mundial {
    
    private String año;
    private String numEquipos;
    private String numGoles;
    private String numPartidos;
    
    public Mundial(String año, String numEquipos, String numGoles, String numPartidos){
        this.año = año;
        this.numEquipos = numEquipos;
        this.numGoles = numGoles;
        this.numPartidos = numPartidos;
    }
    
    public String getAño() {
        return año;
    }
    public void setAño(String año) {
        this.año = año;
    }
    public String getNumEquipos() {
        return numEquipos;
    }
    public void setNumEquipos(String numEquipos) {
        this.numEquipos = numEquipos;
    }
    public String getNumGoles() {
        return numGoles;
    }
    public void setNumGoles(String numGoles) {
        this.numGoles = numGoles;
    }
    public String getNumPartidos() {
        return numPartidos;
    }
    public void setNumPartidos(String numPartidos) {
        this.numPartidos = numPartidos;
    }
    
}
