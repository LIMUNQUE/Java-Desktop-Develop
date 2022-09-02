/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LecturaEscritura;

import Clases.Mundial;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class LecturaEscrituraArchivos {
    
    /**
     * Metodo que recibe un string y crea objetos de clase Mundial y los agrega en una ArrayList Mundial.
     * @param nombreArchivo String requerido donde irá el nombre del archivo Mundial.csv
     * @return Retorna un ArrayList que contiene objetos de clase Mundial.
     */
    public static ArrayList<Mundial> LeeArchivoMundial(String nombreArchivo){
        ArrayList<Mundial> listaMundial = new ArrayList<>();
        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while((linea = lector.readLine())!= null){
                String [] datos = linea.split(",");
                Mundial mundial = new Mundial(datos[0],datos[2],datos[3],datos[4],datos[5],datos[6],
                        datos[7],datos[8],datos[9]);
                listaMundial.add(mundial);
            }
        }catch(FileNotFoundException e){
            System.out.println("No se ha encontrado el archivo.");
        }catch(IOException e1){
            System.out.println(e1.getMessage());
        }
        return listaMundial;
    }
    
    
}
