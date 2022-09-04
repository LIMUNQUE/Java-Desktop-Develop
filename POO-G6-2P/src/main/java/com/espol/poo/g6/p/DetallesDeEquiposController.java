/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.poo.g6.p;

import Clases.ManejoDeArchivos;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import Clases.ManejoDeArchivos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Gerson
 */
public class DetallesDeEquiposController implements Initializable {

    @FXML
    private Label lblequipo1;
    @FXML
    private Label lblequipo2;
    @FXML
    private ScrollPane jugadoresE1;
    @FXML
    private ScrollPane jugadoresE2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lblequipo1.setText("Germany");
        String iniciales1 = "GER";

        lblequipo2.setText("Argentina");
        String iniciales2 = "ARG";

        ArrayList<String[]> jugadores = ManejoDeArchivos.Leer("WorldCupPlayersBrasil2014.csv", ",");
        
        HBox cartillas1 = new HBox();
        cartillas1.setSpacing(50);
        
        HBox cartillas2 = new HBox();
        cartillas2.setSpacing(50);
        
        for (String[] jugador:jugadores) {
            VBox cartilla = new VBox();
            cartilla.setSpacing(10);
            cartilla.setPadding(new Insets(10,0,0,0){});
            cartilla.setAlignment(Pos.CENTER);
            if (jugador[1].equals("300186501") && jugador[2].equals(iniciales1) && jugador[4].equals("S")) {
                try (FileInputStream input = new FileInputStream(App.pathUI+"imagen.png")) {
                    Image imagen = new Image(input);
                    ImageView imgv = new ImageView(imagen);
                    imgv.setFitHeight(100);
                    imgv.setFitWidth(100);
                    Label nombre = new Label("Nombre de jugador");
                    cargarImagenHilo(imgv, nombre, jugador[6], jugador);
                    cartilla.getChildren().addAll(imgv,nombre);
                    cartillas1.getChildren().add(cartilla);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (jugador[1].equals("300186501") && jugador[2].equals(iniciales2) && jugador[4].equals("S")) {
                try (FileInputStream input = new FileInputStream(App.pathUI+"imagen.png")) {
                    Image imagen = new Image(input);
                    ImageView imgv = new ImageView(imagen);
                    imgv.setFitHeight(100);
                    imgv.setFitWidth(100);
                    Label nombre = new Label("Nombre de jugador"); //jugador[6]
                    cargarImagenHilo(imgv, nombre, jugador[6], jugador);
                    cartilla.getChildren().addAll(imgv,nombre);
                    cartillas2.getChildren().add(cartilla);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        jugadoresE1.setContent(cartillas1);
        jugadoresE2.setContent(cartillas2);
    }

    /**
     * Este método modifica cada cartilla del conjunto de cartillas de jugadores 
     * setea el imageView y el label con la imagen y el nombre del jugador respectivamente
     * @param imgv Imagen que setea después de entre 5 o 15 segundos
     * @param label Texto que se va a setear
     * @param nombre El nombre del jugador
     * @param jugador el jugador con sus datos
     */
    public void cargarImagenHilo(ImageView imgv, Label label, String nombre, String[] jugador){
        Thread hilo = new Thread(new Runnable(){
           
            @Override
            public void run(){
                try (FileInputStream input = new FileInputStream(App.pathJugadores + nombre + ".jpg")){
                    Random rd = new Random();
                    int naleatorio = rd.nextInt(5000,15001);
                    Image imagen = new Image(input);
                    imgv.setFitHeight(125);
                    imgv.setFitWidth(100);
                    Thread.sleep(naleatorio);
                    Platform.runLater(() -> {
                        imgv.setImage(imagen);
                        imgv.setOnMouseClicked(t -> cargarDetalleIndividual(imagen, jugador));
                        label.setText(nombre);
                    });
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            
        });
        
        hilo.start();
    }
    
    /**
     * Este método crea una ventana nueva  y recibe la imagen que se aplica al ImageView de la ventana 
     * y los datos del jughador que se setean en unos labels
     * @param imagen la imagen que se setea en el ImageView
     * @param jugador son los datos del jugador
     */
    public void cargarDetalleIndividual(Image imagen, String[] jugador){
        VBox root = new VBox();
        root.setPrefSize(320, 300);
        root.setAlignment(Pos.CENTER);
            Label nombreJ = new Label(jugador[6]);
            ImageView imgv = new ImageView(imagen);
            imgv.setFitHeight(200);
            imgv.setFitWidth(175);
            Label inicialE = new Label(jugador[2]);
            Label nCamisa = new Label("Camiseta número "+jugador[5]);
            Label directT = new Label("Director Técnico "+jugador[3]);
            Label contador = new Label();
            
            Button btncerrar = new Button();
            btncerrar.setText("Cerrar");
            
            btncerrar.setOnMouseClicked((MouseEvent e) -> {
                Stage s = (Stage) btncerrar.getScene().getWindow();
                s.close();
            });
            
            root.getChildren().addAll( nombreJ,imgv, inicialE, nCamisa, directT, contador, btncerrar);
            
            Scene escena = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(escena);
        escena.getStylesheets().add(DetallesDeEquiposController.class.getResource("App.css").toExternalForm());
        stage.setTitle("Detalle de Jugador");
        stage.show();
        Thread gg = crearThreadNuevaVentana(contador);
        gg.setDaemon(true);
        gg.start();
        
        
        
    }
    
    /**
     * Esté método modifica el contador con 10 segundos 
     * y tiene un runlater para el propósito, recibe el 
     * label que se modifica y se aplica un sleep de 1 segundo dentro del hilo
     * además al finalizar el hilo cierra la ventana en la que se encuentra el label
     * @param l el label que hace de contador
     * @return retorna un hilo
     */
    public Thread crearThreadNuevaVentana(Label l) {
        Thread hilo = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 1; i<11; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    int n = i;
                    Platform.runLater(() -> {
                        l.setText(n + " segundos");
                    });
                }
                
                Platform.runLater(() -> {
                    Stage s = (Stage) l.getScene().getWindow();
                    s.close();
                });
            }
        });
        return hilo;
    }
    
}