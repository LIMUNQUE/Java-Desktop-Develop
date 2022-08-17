/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.poo.g6.p;

import Clases.AnioMundialException;
import Clases.Mundial;
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
    
    private static String anioEscogido;
    
    private GridPane nuevaSeccion = new GridPane();
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
        hbox1.setSpacing(30);
        rootVentanaMundial.getChildren().addAll(lblTitulo,hbox1);
        rootVentanaMundial.setAlignment(Pos.TOP_CENTER);
        rootVentanaMundial.setSpacing(20);
        Insets insetRoot = new Insets(20, 5, 5, 20);
        rootVentanaMundial.setPadding(insetRoot);
        
        btnConsultar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                anioEscogido = anioMundial.getText();
                mostrarInformacion();
                
            }
        });
        
    }
    
    public void mostrarInformacion(){
        
        
        ArrayList<Mundial> datosMundiales = LecturaEscrituraArchivos.LeeArchivoMundial("WorldCups.csv");
        nuevaSeccion.getChildren().clear();
        nuevaSeccion.setPadding(new Insets(30,0,0,0));
        nuevaSeccion.setHgap(30);
        nuevaSeccion.setVgap(15);
        
        for(Mundial datoMundial : datosMundiales){
            if(datoMundial.getAño().equals(anioEscogido)){
                Label ganador = new Label(datoMundial.getGanador());
                ganador.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label segundo = new Label(datoMundial.getSegundo());
                segundo.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label tercero = new Label(datoMundial.getTercero());
                tercero.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label cuarto = new Label(datoMundial.getCuarto());
                cuarto.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label numeroGoles = new Label("Goles anotados: "+datoMundial.getNumGoles());
                numeroGoles.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label numeroEquipos = new Label("Equipos: "+datoMundial.getNumEquipos());
                numeroEquipos.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label numeroPartidos = new Label("Partidos jugados: "+datoMundial.getNumPartidos());
                numeroPartidos.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label asistencia = new Label("Asistencia: "+datoMundial.getAsistencia());
                asistencia.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                
                nuevaSeccion.add(numeroGoles, 4, 1);
                nuevaSeccion.add(numeroEquipos, 4, 2);
                nuevaSeccion.add(numeroPartidos, 4, 3);
                nuevaSeccion.add(asistencia, 4, 4);
            }
        }
        
        
        
        Label premios = new Label("Premios");
        premios.setStyle("-fx-font-size: 25;-fx-text-fill: black;-fx-font-weight: bold;-fx-underline:true");
        Label datos = new Label("Datos generales");
        datos.setStyle("-fx-font-size: 25;-fx-text-fill: black;-fx-font-weight: bold;-fx-underline:true");
        Label lblganador = new Label("Ganador");
        lblganador.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
        Label lblsegundo = new Label("Segundo");
        lblsegundo.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
        Label lbltercero = new Label("Tercero");
        lbltercero.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
        Label lblcuarto = new Label("Cuarto");
        lblcuarto.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
        nuevaSeccion.setGridLinesVisible(false);
        nuevaSeccion.addColumn(0,premios,lblganador,lblsegundo,lbltercero,lblcuarto);
        nuevaSeccion.add(datos, 4, 0);
        
        rootVentanaMundial.getChildren().add(nuevaSeccion);
    }
    
}
