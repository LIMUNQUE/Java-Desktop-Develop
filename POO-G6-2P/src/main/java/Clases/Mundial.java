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
    private String ganador;
    private String segundo;
    private String tercero;
    private String cuarto;
    private String numEquipos;
    private String numGoles;
    private String numPartidos;
    private String asistencia;
    
    
    public Mundial(String año, String ganador, String segundo, String tercero, String cuarto,
            String numGoles, String numEquipos, String numPartidos, String asistencia){
        this.año = año;
        this.ganador = ganador;
        this.segundo = segundo;
        this.tercero = tercero;
        this.cuarto = cuarto;
        this.numEquipos = numEquipos;
        this.numGoles = numGoles;
        this.numPartidos = numPartidos;
        this.asistencia = asistencia;
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
        public String getGanador() {
        return ganador;
    }
    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    public String getSegundo() {
        return segundo;
    }
    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }
    public String getTercero() {
        return tercero;
    }
    public void setTercero(String tercero) {
        this.tercero = tercero;
    }
    public String getCuarto() {
        return cuarto;
    }
    public void setCuarto(String cuarto) {
        this.cuarto = cuarto;
    }
    public String getAsistencia() {
        return asistencia;
    }
    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }
    
    
}
