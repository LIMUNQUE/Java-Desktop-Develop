/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.espol.poo.g6.p.App;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;
/**
 *
 * @author Joshua
 */
public class ManejoDeArchivos {
    Image a;
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
    
    public static Image cargarImagen(String pais){
        try(FileInputStream input = new FileInputStream(App.pathPaises+pais+".png")){
                return new Image(input,80,69,true,false);
            }
            catch(IOException exc){System.out.println(exc.getMessage());}
        return null;
    }
    
}
