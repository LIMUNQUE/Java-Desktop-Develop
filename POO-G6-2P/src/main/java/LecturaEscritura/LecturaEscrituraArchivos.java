/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LecturaEscritura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class LecturaEscrituraArchivos {
    
    public static ArrayList<String> LeeArchivoMundial(String nombreArchivo){
        ArrayList<String> lineas = new ArrayList<>();
        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while((linea = lector.readLine())!= null){
                lineas.add(linea);
            }
        }catch(IOException e1){
            System.out.println("No se ha encontrado el archivo");
        }
        return lineas;
    }
    
    
}
