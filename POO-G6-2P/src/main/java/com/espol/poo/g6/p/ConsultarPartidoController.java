/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.poo.g6.p;

import Clases.Jugador;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import Clases.ManejoDeArchivos;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joshua
 */
public class ConsultarPartidoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ArrayList<String[]> texto;
    ArrayList<String[]> textoJugadores;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Leemos el archivo y lo guardamos para no tener que leerlo nuevamente
        texto = ManejoDeArchivos.Leer("WorldCupMatchesBrasil2014.csv", "\\|");
        textoJugadores = ManejoDeArchivos.Leer("WorldCupPlayersBrasil2014.csv", ",");
        cbxFase.getItems().addAll("Group", "Round of 16", "Quarter-finals", "Play-off for third place", "Semi-finals", "Final");

        cbxFase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Si en Fase se selecciona Group se debe mostrar los Grupos
                if (cbxFase.getValue().equals("Group")) {
                    cbxGrupos.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");
                } else {//Caso contrario no se muestran
                    cbxGrupos.getItems().clear();
                    Actualizar();
                }
            }
        });

        cbxGrupos.setOnAction(e -> Actualizar());
    }
    @FXML
    private ComboBox<String> cbx1;
    @FXML
    private ComboBox<String> cbx2;
    @FXML
    private ComboBox<String> cbxFase;
    @FXML
    private ComboBox<String> cbxGrupos;
    @FXML
    private VBox infoContainer;

    @FXML
    void Consultar(ActionEvent event) {
        if (cbxFase.getValue() != null) {//Si el ComboBox no tiene un valor no se muestra nada
            infoContainer.getChildren().clear();
            Label puntaje = new Label(null);
            String path;
            ImageView imgvLeft;
            ImageView imgvRight;

            String fechaPartido;
            if (cbxGrupos.getValue() == null) {
                path = cbxFase.getValue();
            } //Si es un Grupo se busca tambien por su letra
            else {
                path = cbxFase.getValue() + " " + cbxGrupos.getValue();
            }
            for (String[] dato : texto) {//Leer  el doc en busca del partido Solicitado
                if (dato[2].equals(path)) {//Se pregunta si el equipo es el solicitado
                    if (dato[5].equals(cbx1.getValue()) && dato[8].equals(cbx2.getValue())) {
                        //Se guarda en el label puntaje el valor de ambos goals
                        imgvLeft = new ImageView(ManejoDeArchivos.cargarImagen(dato[5]));
                        imgvRight = new ImageView(ManejoDeArchivos.cargarImagen(dato[8]));
                        String[] datoFecha = dato[1].split(" ");
                        fechaPartido = datoFecha[0] + "-" + datoFecha[1] + "-" + datoFecha[2];

                        //Empezamos a escribir el container
                        //Título
                        Label lblresp = new Label("Resultados del Partido");
                        lblresp.setFont(new Font("Serif", 24));

                        //Fecha
//                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//                        Label fecha = null;
//                        try {
//                            Date date = (Date)formatter.parse(fechaPartido);
//                            Calendar calendar = Calendar.getInstance();
//                            calendar.setTime(date);
//                            
//                            LocalDate someDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) +1, calendar.get(Calendar.DAY_OF_MONTH));
//                            String dia = someDate.getDayOfWeek().toString();
//                            fecha = new Label(dia.substring(0, 1).toUpperCase() + dia.substring(1).toLowerCase()
//                                    + " " + Integer.parseInt(datoFecha[0]) + " " + someDate.getMonth().name());
//
//                            fecha.setFont(new Font("Serif", 20));
//                            fecha.setPadding(new Insets(10, 0, 20, 0));
//                        } catch (ParseException | RuntimeException ex) {
//                            System.out.println(ex.getMessage());
//                        }

                        //DETALLES
//                        Label fechaActual = new Label(dato[1]);
                        Label lugar = new Label(dato[3]);
                        Label ciudad = new Label(dato[4]);
                        HBox containerDetalles = new HBox();
                        VBox detalles = new VBox();
                        //*Grupo
                        Label grupo;
                        if (cbxFase.getValue().equals("Group")) {
                            grupo = new Label("Grupo " + cbxGrupos.getValue());
                        } else {
                            grupo = new Label(cbxFase.getValue());
                        }
                        grupo.setFont(new Font("Serif", 13));
                        detalles.getChildren().addAll( grupo, lugar, ciudad);

                        //Pais1
                        HBox paisLeft = new HBox();
                        Label nombreLeft = new Label(dato[5]);
                        nombreLeft.setFont(new Font("Serif", 14));
                        paisLeft.getChildren().addAll(nombreLeft, imgvLeft);
                        paisLeft.setSpacing(5);
                        //Pais2
                        HBox paisRight = new HBox();
                        Label nombreRight = new Label(dato[8]);
                        nombreRight.setFont(new Font("Serif", 14));
                        paisRight.getChildren().addAll(nombreRight, imgvRight);
                        paisRight.setSpacing(5);

                        if (dato[5].compareTo(dato[8]) < 0) {
                            puntaje.setText(dato[6] + " - " + dato[7]);
                            containerDetalles.getChildren().addAll(detalles, paisLeft, puntaje, paisRight);
                        } else {
                            puntaje.setText(dato[7] + " - " + dato[6]);
                            containerDetalles.getChildren().addAll(detalles, paisRight, puntaje, paisLeft);
                        }

                        containerDetalles.setSpacing(50);
                        containerDetalles.setAlignment(Pos.CENTER);
                        //Añadir al container
                        HBox hboxFecha = new HBox();
                        //hboxFecha.getChildren().addAll(fecha);
                        VBox botones = new VBox();
                        String estilo = "-fx-text-fill: white;-fx-font-weight: bold;-fx-background-color:#40abe8";
                        Button btnExportar = new Button("Exportar resultados de grupos");
                        btnExportar.setMinWidth(200);
                        btnExportar.setStyle(estilo);
                        Button btnVer = new Button("Ver detalles de equipos");
                        btnVer.setMinWidth(200);
                        btnVer.setStyle(estilo);
                        botones.getChildren().addAll(btnExportar, btnVer);
                        botones.setAlignment(Pos.CENTER);
                        botones.setSpacing(10);
                        infoContainer.getChildren().clear();
                        infoContainer.getChildren().addAll(lblresp, hboxFecha, containerDetalles, botones);
                        infoContainer.setSpacing(5);

                        //Lógica de los botones
                        btnExportar.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                Stage stage = new Stage();
                                VBox root = new VBox();
                                Label msg = new Label("¿Está seguro que desea exportar el grupo de jugadores seleccionado?");
                                msg.setFont(new Font("Serif", 15));
                                Button btnAceptar = new Button("aceptar");
                                Button btnCancelar = new Button("Cancelar");
                                HBox buttons = new HBox();
                                buttons.getChildren().addAll(btnAceptar, btnCancelar);
                                buttons.setSpacing(10);
                                buttons.setAlignment(Pos.CENTER_RIGHT);
                                root.getChildren().addAll(msg, buttons);
                                root.setSpacing(40);
                                root.setAlignment(Pos.CENTER);

                                btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent e2) {
                                        Stage s = (Stage) btnCancelar.getScene().getWindow();
                                        s.close();
                                    }
                                });

                                btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent e2) {
                                        //Serializar
                                        String path;
                                        if (cbxGrupos.getValue() == null) {
                                            path = cbxFase.getValue();
                                        } else {
                                            path = cbxFase.getValue() + " " + cbxGrupos.getValue();
                                        }

                                        ArrayList<Jugador> jugadores = new ArrayList<>();
                                        for (String[] dato : texto) {
                                            if (dato[2].equals(path)) {
                                                for (String[] datoJugador : textoJugadores) {
                                                    if (datoJugador[0].equals(dato[16]) && datoJugador[1].equals(dato[17])) {
                                                        Jugador j = new Jugador(datoJugador[6], datoJugador[2], datoJugador[5], datoJugador[3]);
                                                        jugadores.add(j);
                                                    }
                                                }
                                            }
                                        }
                                        ManejoDeArchivos.serializarObjeto("jugadores.Dat", jugadores);
                                        System.out.println("Se pudo generar el archivo correctamente");

                                    }
                                });

                                Scene scene = new Scene(root, 420, 240);
                                stage.setScene(scene);          
                                stage.show();
                            }
                        });

                        btnVer.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e2) {
                                //Abrir la ventana de detalles
                                try{
                                Stage stage = new Stage();
                                Parent root = FXMLLoader.load(getClass().getResource("DetalleDeEquipos.fxml"));
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                                } catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }

            puntaje.setFont(new Font("Serif", 24));
            infoContainer.setAlignment(Pos.CENTER);
            if (puntaje.getText() == null) {
                //Si puntaje no tiene texto es porque no se encontró el dato
                puntaje.setText("No se encontró el partido");
                infoContainer.getChildren().addAll(puntaje);
            }
        }
    }

    public void Actualizar() {
        cbx1.getItems().clear();//Se limpian los combobox
        cbx2.getItems().clear();
        ArrayList<String> countriesLeft = new ArrayList<>();
        ArrayList<String> countriesRight = new ArrayList<>();
        String path;
        for (String[] dato : texto) {//Se recorre el texto de los partidos
            if (cbxGrupos.getValue() == null) {
                path = cbxFase.getValue();
            } else {//Si cbxGrupo tiene un valor entonces se buscara por la palabra grupo + su letra
                path = cbxFase.getValue() + " " + cbxGrupos.getValue();
            }
            if (dato[2].equals(path)) {
                //Nos aseguramos que los paises no se repitan
                if (!countriesLeft.contains(dato[5])) {//Paises que concuerden de lado izquierdo
                    countriesLeft.add(dato[5]);
                }
                if (!countriesRight.contains(dato[8])) {//Paises que concuerden de lado derecho
                    countriesRight.add(dato[8]);
                }
            }
        }//Agregamos la lista de paises al ComboBox
        cbx1.getItems().addAll(countriesLeft);
        cbx2.getItems().addAll(countriesRight);
    }
    
}
