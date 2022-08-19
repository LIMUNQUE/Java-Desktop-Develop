/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.poo.g6.p;

import Clases.AnioMundialException;
import Clases.Mundial;
import LecturaEscritura.LecturaEscrituraArchivos;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    private GridPane nuevaSeccion = new GridPane();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rootVentanaMundial.setStyle("-fx-background-color: white");

        HBox hbox1 = new HBox();
        Label lblTitulo = new Label("Consulta Histórica de Copas Mundiales");
        Label anio = new Label("Año:");
        TextField anioMundial = new TextField();
        Button btnConsultar = new Button("Consultar");
        Button btnRefrescar = new Button("Limpiar consulta");

        lblTitulo.setStyle("-fx-font-size: 20;-fx-text-fill: black;-fx-font-weight: bold");
        btnConsultar.setStyle("-fx-background-color: #259bd7;-fx-text-fill: white;-fx-background-radius:4");
        btnRefrescar.setStyle("-fx-background-color: #259bd7;-fx-text-fill: white;-fx-background-radius:4");

        hbox1.getChildren().addAll(anio, anioMundial, btnConsultar);
        hbox1.setAlignment(Pos.TOP_CENTER);
        hbox1.setSpacing(30);
        rootVentanaMundial.getChildren().addAll(lblTitulo, hbox1);
        rootVentanaMundial.setAlignment(Pos.TOP_CENTER);
        rootVentanaMundial.setSpacing(20);
        Insets insetRoot = new Insets(20, 5, 5, 20);
        rootVentanaMundial.setPadding(insetRoot);

        btnConsultar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Label advertencia = new Label();
              
                if (anioMundial.getText().equals("")) {
                    advertencia.setText("Ingrese una fecha para consultar");
                    advertencia.setStyle("-fx-font-size: 15;-fx-text-fill: red;-fx-font-weight: bold");
                    try{
                    rootVentanaMundial.getChildren().remove(2);
                    }catch(IndexOutOfBoundsException e){
                    }
                    rootVentanaMundial.getChildren().add(advertencia);
                } else if (!verificacionAnio(anioMundial.getText())) {
                    advertencia.setText("En el año ingresado no hubo mundial. Intente de nuevo.");
                    advertencia.setStyle("-fx-font-size: 15;-fx-text-fill: red;-fx-font-weight: bold");
                    try{
                    rootVentanaMundial.getChildren().remove(2);
                    }catch(IndexOutOfBoundsException e){
                    }   
                    rootVentanaMundial.getChildren().add(advertencia);
                } else {
                    try{
                    rootVentanaMundial.getChildren().remove(2);
                    }catch(IndexOutOfBoundsException e){
                    }   
                    nuevaSeccion.setPadding(new Insets(30, 0, 0, 0));
                    nuevaSeccion.setHgap(30);
                    nuevaSeccion.setVgap(15);

                    Label premios = new Label("Premios");
                    premios.setStyle("-fx-font-size: 20;-fx-text-fill: black;-fx-font-weight: bold;-fx-underline:true");
                    Label datos = new Label("Datos generales");
                    datos.setStyle("-fx-font-size: 20;-fx-text-fill: black;-fx-font-weight: bold;-fx-underline:true");
                    Label lblganador = new Label("Ganador");
                    lblganador.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                    Label lblsegundo = new Label("Segundo");
                    lblsegundo.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                    Label lbltercero = new Label("Tercero");
                    lbltercero.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                    Label lblcuarto = new Label("Cuarto");
                    lblcuarto.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");

                    mostrarDatosGenerales(anioMundial.getText());

                    mostrarPremios(anioMundial.getText());

                    nuevaSeccion.setGridLinesVisible(false);
                    nuevaSeccion.addColumn(0, premios, lblganador, lblsegundo, lbltercero, lblcuarto);
                    nuevaSeccion.add(datos, 4, 0);

                    try {
                        rootVentanaMundial.getChildren().add(nuevaSeccion);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    rootVentanaMundial.getChildren().remove(1);
                    rootVentanaMundial.getChildren().add(1, btnRefrescar);
                }
            }
            
        });

        btnRefrescar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                limpiarSeccion();
                rootVentanaMundial.getChildren().remove(1);
                rootVentanaMundial.getChildren().add(1, hbox1);
            }
        });

    }

    public void mostrarDatosGenerales(String anioEscogido) {

        ArrayList<Mundial> datosMundiales = LecturaEscrituraArchivos.LeeArchivoMundial("WorldCups.csv");

        for (Mundial datoMundial : datosMundiales) {
            if (datoMundial.getAño().equals(anioEscogido)) {
                Label ganador = new Label(datoMundial.getGanador());
                ganador.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label segundo = new Label(datoMundial.getSegundo());
                segundo.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label tercero = new Label(datoMundial.getTercero());
                tercero.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label cuarto = new Label(datoMundial.getCuarto());
                cuarto.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label numeroGoles = new Label("Goles anotados: " + datoMundial.getNumGoles());
                numeroGoles.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label numeroEquipos = new Label("Equipos: " + datoMundial.getNumEquipos());
                numeroEquipos.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label numeroPartidos = new Label("Partidos jugados: " + datoMundial.getNumPartidos());
                numeroPartidos.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label asistencia = new Label("Asistencia: " + datoMundial.getAsistencia());
                asistencia.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");

                nuevaSeccion.add(numeroGoles, 4, 1);
                nuevaSeccion.add(numeroEquipos, 4, 2);
                nuevaSeccion.add(numeroPartidos, 4, 3);
                nuevaSeccion.add(asistencia, 4, 4);
            }

        }

    }

    public void mostrarPremios(String anioEscogido) {

        ArrayList<Mundial> datosMundiales = LecturaEscrituraArchivos.LeeArchivoMundial("WorldCups.csv");

        for (Mundial datoMundial : datosMundiales) {
            if (datoMundial.getAño().equals(anioEscogido)) {
                Label ganador = new Label(datoMundial.getGanador());
                ganador.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label segundo = new Label(datoMundial.getSegundo());
                segundo.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label tercero = new Label(datoMundial.getTercero());
                tercero.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");
                Label cuarto = new Label(datoMundial.getCuarto());
                cuarto.setStyle("-fx-font-size: 15;-fx-text-fill: grey;-fx-font-style: Italic");

                mostrarImagenesPremios(anioEscogido, ganador.getText(), segundo.getText(),
                        tercero.getText(), cuarto.getText());

                nuevaSeccion.add(ganador, 2, 1);
                nuevaSeccion.add(segundo, 2, 2);
                nuevaSeccion.add(tercero, 2, 3);
                nuevaSeccion.add(cuarto, 2, 4);
            }

        }

    }

    public void mostrarImagenesPremios(String anioEscogido, String ganador,
            String segundo, String tercero, String cuarto) {

        ImageView banderaGanador = new ImageView();
        ImageView banderaSegundo = new ImageView();
        ImageView banderaTercero = new ImageView();
        ImageView banderaCuarto = new ImageView();

        try ( FileInputStream lector = new FileInputStream(App.pathImg + "imagenesMundial/" + ganador + ".png")) {

            Image imagenGanador = new Image(lector);
            banderaGanador.setImage(imagenGanador);
            banderaGanador.setFitWidth(40);
            banderaGanador.setPreserveRatio(true);

        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        try ( FileInputStream lector = new FileInputStream(App.pathImg + "imagenesMundial/" + segundo + ".png")) {

            Image imagenSegundo = new Image(lector);
            banderaSegundo.setImage(imagenSegundo);
            banderaSegundo.setFitWidth(40);
            banderaSegundo.setPreserveRatio(true);

        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        try ( FileInputStream lector = new FileInputStream(App.pathImg + "imagenesMundial/" + tercero + ".png")) {

            Image imagenTercero = new Image(lector);
            banderaTercero.setImage(imagenTercero);
            banderaTercero.setFitWidth(40);
            banderaTercero.setPreserveRatio(true);

        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        try ( FileInputStream lector = new FileInputStream(App.pathImg + "imagenesMundial/" + cuarto + ".png")) {

            Image imagenCuarto = new Image(lector);
            banderaCuarto.setImage(imagenCuarto);
            banderaCuarto.setFitWidth(40);
            banderaCuarto.setPreserveRatio(true);

        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        mostrarCopasGanadas(ganador, segundo, tercero, cuarto);

        nuevaSeccion.add(banderaGanador, 1, 1);
        nuevaSeccion.add(banderaSegundo, 1, 2);
        nuevaSeccion.add(banderaTercero, 1, 3);
        nuevaSeccion.add(banderaCuarto, 1, 4);

    }

    public void mostrarCopasGanadas(String primero, String segundo, String tercero, String cuarto) {

        ArrayList<Mundial> datosMundiales = LecturaEscrituraArchivos.LeeArchivoMundial("WorldCups.csv");

        HBox copasPrimero = new HBox();
        HBox copasSegundo = new HBox();
        HBox copasTercero = new HBox();
        HBox copasCuarto = new HBox();

        ImageView imgv1 = null;
        ImageView imgv2 = null;
        ImageView imgv3 = null;
        ImageView imgv4 = null;

        try ( FileInputStream lector = new FileInputStream(App.pathImg + "imagenesMundial/copa2014.png")) {
            Image copa = new Image(lector);

            for (Mundial datoMundial : datosMundiales) {
                if (datoMundial.getGanador().equals(primero)) {
                    imgv1 = new ImageView(copa);
                    imgv1.setFitWidth(20);
                    imgv1.setPreserveRatio(true);
                    copasPrimero.getChildren().add(imgv1);
                } else if (datoMundial.getGanador().equals(segundo)) {
                    imgv2 = new ImageView(copa);
                    imgv2.setFitWidth(20);
                    imgv2.setPreserveRatio(true);
                    copasSegundo.getChildren().add(imgv2);
                } else if (datoMundial.getGanador().equals(tercero)) {
                    imgv3 = new ImageView(copa);
                    imgv3.setFitWidth(20);
                    imgv3.setPreserveRatio(true);
                    copasTercero.getChildren().add(imgv3);
                } else if (datoMundial.getGanador().equals(cuarto)) {
                    imgv4 = new ImageView(copa);
                    imgv4.setFitWidth(20);
                    imgv4.setPreserveRatio(true);
                    copasCuarto.getChildren().add(imgv4);
                }
            }

        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        nuevaSeccion.add(copasPrimero, 3, 1);
        nuevaSeccion.add(copasSegundo, 3, 2);
        nuevaSeccion.add(copasTercero, 3, 3);
        nuevaSeccion.add(copasCuarto, 3, 4);

    }

    public void limpiarSeccion() {
        nuevaSeccion.getChildren().clear();
    }

    public boolean verificacionAnio(String anio) {
        ArrayList<String> anios = new ArrayList<>();
        try ( BufferedReader lector = new BufferedReader(new FileReader("WorldCups.csv"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                anios.add(datos[0]);
            }
        } catch (IOException e1) {
            System.out.println("No se ha encontrado el archivo");
        }
        return anios.contains(anio);
    }

}
