/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Joshua
 */
public class  ManejoDeArchivos {
    public static ArrayList<String[]> Leer(String path){
        ArrayList<String[]> texto = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String linea;
            while((linea=reader.readLine())!=null){
                texto.add(linea.split("\\|"));
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return texto;
    }
    
}
