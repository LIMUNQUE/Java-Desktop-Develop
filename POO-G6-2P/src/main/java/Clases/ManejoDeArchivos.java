/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.espol.poo.g6.p.App;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.image.Image;
/**
 *
 * @author Joshua
 */
public class ManejoDeArchivos {
    Image a;
    public static ArrayList<String[]> Leer(String path,String divissor){
        ArrayList<String[]> texto = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String linea;
            while((linea=reader.readLine())!=null){
                texto.add(linea.split(divissor));
            }
        }catch(IOException e){System.out.println(e.getMessage());}
        return texto;
    }
    
    public static Image cargarImagen(String pais){
        try(FileInputStream input = new FileInputStream(App.pathPaises+pais+".png")){
                return new Image(input,80,69,true,false);
            }
            catch(IOException exc){System.out.println(exc.getMessage());}
        return null;
    }
    
    public static boolean serializarObjeto(String direccionArchivo, Serializable objeto){
        boolean sw = false;
        try (FileOutputStream fos = new FileOutputStream(direccionArchivo);
                ObjectOutputStream salida = new ObjectOutputStream(fos);){
            salida.writeObject(objeto);
            sw = true;
        }catch(Exception e){e.printStackTrace();}
        return sw;
    }
    
    public static <E> E deserializarObjeto(String direccionArchivo, Class<E> claseObjetivo){
        E objeto = null;
        try(FileInputStream fis = new FileInputStream(direccionArchivo);
                ObjectInputStream entrada = new ObjectInputStream(fis);){
            objeto = (E) entrada.readObject();
            
        }catch(Exception e){e.printStackTrace();}
        
        return objeto;
    }
}
