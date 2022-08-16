/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.poo.g6.p;

import LecturaEscritura.LecturaEscrituraArchivos;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VentanaConsultaMundialController implements Initializable {
    
    @FXML
    private VBox rootVentanaMundial;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HBox hbox1 = new HBox();
        Label lblTitulo = new Label("Consulta Histórica de Copas Mundiales");
        Label anio = new Label("Año:");
        TextField anioMundial = new TextField();
        Button btnConsultar = new Button("Consultar");
        
        lblTitulo.setStyle("-fx-font-size: 20;-fx-text-fill: black;-fx-font-weight: bold");
        btnConsultar.setStyle("-fx-background-color: #259bd7;-fx-text-fill: white;-fx-background-radius:4");
        
        hbox1.getChildren().addAll(anio,anioMundial,btnConsultar);
        hbox1.setAlignment(Pos.TOP_CENTER);
        hbox1.setSpacing(20);
        rootVentanaMundial.getChildren().addAll(lblTitulo,hbox1);
        rootVentanaMundial.setAlignment(Pos.TOP_CENTER);
        rootVentanaMundial.setSpacing(20);
        Insets insetRoot = new Insets(20, 5, 5, 20);
        rootVentanaMundial.setPadding(insetRoot);
        
        btnConsultar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                mostrarInformacion();
            }
        });
        
    }
    
    public void mostrarInformacion(){
        
        //ArrayList<String> datosMundiales = LecturaEscrituraArchivos.LeeArchivoMundial("WorldCups.csv");
        
        GridPane nuevaSeccion = new GridPane();
        nuevaSeccion.maxHeight(200);
        nuevaSeccion.maxWidth(600);
        Label premios = new Label("Premios");
        premios.setStyle("-fx-font-size: 15;-fx-text-fill: black;-fx-font-weight: bold");
        Label datos = new Label("Datos generales");
        datos.setStyle("-fx-font-size: 15;-fx-text-fill: black;-fx-font-weight: bold");
        Label ganador = new Label("Ganador");
        ganador.setStyle("-f-font-size: 10");
        Label segundo = new Label("Segundo");
        ganador.setStyle("-f-font-size: 10");
        Label tercero = new Label("Tercero");
        ganador.setStyle("-f-font-size: 10");
        Label cuarto = new Label("Cuarto");
        ganador.setStyle("-f-font-size: 10");
        nuevaSeccion.setGridLinesVisible(true);
        
        nuevaSeccion.addColumn(0,premios,ganador,segundo,tercero,cuarto);
        
        
        rootVentanaMundial.getChildren().add(nuevaSeccion);
    }
    
}
