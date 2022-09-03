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
import java.util.Set;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
            cartilla.setPadding(Insets.EMPTY);
            cartilla.setAlignment(Pos.CENTER);
            if (jugador[1].equals("300186501") && jugador[2].equals(iniciales1) && jugador[4].equals("S")) {
                try (FileInputStream input = new FileInputStream(App.pathUI+"imagen.png")) {
                    Image imagen = new Image(input);
                    ImageView imgv = new ImageView(imagen);
                    imgv.setFitHeight(100);
                    imgv.setFitWidth(100);
                    Label nombre = new Label(jugador[6]);
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
                    Label nombre = new Label(jugador[6]);
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

}
