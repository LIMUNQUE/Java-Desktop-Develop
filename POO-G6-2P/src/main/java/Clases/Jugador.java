/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Jugador implements Serializable{
    
    
    private String numCamiseta;
    private String directorTecnico;
    private String team;
    private String name;
    private String matchID;
    /*private String roundID;
    private String coachName;
    private String shirtNumber;
    private String position;*/
    public Jugador(String matchhID,String nombre,String team, String numCamiseta, String directorTecnico){
        this.matchID = matchID;
        this.name = nombre;
        this.team = team;
        this.numCamiseta = numCamiseta;
        this.directorTecnico = directorTecnico;
    }
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getTeam() {return team;}
    public void setTeam(String team) {this.team = team;}
    public String getNumCamiseta() {return numCamiseta;}
    public void setNumCamiseta(String numCamiseta) {this.numCamiseta = numCamiseta;}
    public String getDirectorTecnico() {return directorTecnico;}
    public void setDirectorTecnico(String directorTecnico) {this.directorTecnico = directorTecnico;}
    public String getMatchID() {return matchID;}
    public void setMatchID(String matchID) {this.matchID = matchID;}
    
    public String toString(){
        return "Jugador: "+name+"  -  Team: " + team;
    }
}
