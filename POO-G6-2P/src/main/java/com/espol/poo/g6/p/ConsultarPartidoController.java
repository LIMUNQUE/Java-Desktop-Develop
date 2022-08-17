/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.poo.g6.p;

import java.io.IOException;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Leemos el archivo y lo guardamos para no tener que leerlo nuevamente
        texto = ManejoDeArchivos.Leer("WorldCupMatchesBrasil2014.csv");
        cbxFase.getItems().addAll("Group","Round of 16","Quarter-finals","Play-off for third place","Semi-finals","Final");
        
        cbxFase.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                //Si en Fase se selecciona Group se debe mostrar los Grupos
                if(cbxFase.getValue().equals("Group")){
                    cbxGrupos.getItems().addAll("A","B","C","D","E","F","G","H");
                }
                else{//Caso contrario no se muestran
                    cbxGrupos.getItems().clear();
                    Actualizar();
                }
            }
        });
        
        cbxGrupos.setOnAction(e->Actualizar());
    }    
    
    @FXML
    private Button brnConsultar;
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
        if(cbxFase.getValue()!=null){//Si el ComboBox no tiene un valor no se muestra nada
            infoContainer.getChildren().clear();
            Label puntaje=new Label(null);
            String path;
            for(String[] dato: texto){//Leer  el doc en busca del partido Solicitado
                if(cbxGrupos.getValue()==null){
                    path = cbxFase.getValue();
                }
                else{
                    path = cbxFase.getValue()+" "+cbxGrupos.getValue();
                }//Si es un Grupo se busca tambien por su letra
                if(dato[2].equals(path)){
                    if(dato[5].equals(cbx1.getValue())){
                        if(dato[8].equals(cbx2.getValue())){
                            //Se guarda en el label puntaje el valor de ambos goals
                            puntaje.setText(dato[6] + " - " + dato[7]);
                        }
                    }
                }
            }
            
            puntaje.setFont(new Font("Serif", 24));
            infoContainer.setAlignment(Pos.CENTER);
            if(puntaje.getText()==null){
                //Si puntaje no tiene texto es porque no se encontró el dato
                puntaje.setText("No se encontró el partido");
                infoContainer.getChildren().addAll(puntaje);
            }
            else{//Caso contrario se muestra el contenido
                Label lblresp = new Label("Resultados del Partido");
                lblresp.setFont(new Font("Serif", 24));
                Label grupo;
                if(cbxFase.getValue().equals("Group")) grupo = new Label("Grupo " + cbxGrupos.getValue());
                else grupo = new Label(cbxFase.getValue());
         
                grupo.setFont(new Font("Serif", 14));
                infoContainer.getChildren().addAll(lblresp,grupo,puntaje);
            }
            
        }
        
    }

    public void Actualizar(){
        cbx1.getItems().clear();//Se limpian los combobox
        cbx2.getItems().clear();
        ArrayList<String> countriesLeft = new ArrayList<>();
        ArrayList<String> countriesRight = new ArrayList<>();
        String path;
        for(String[] dato: texto){//Se recorre el texto de los partidos
            if(cbxGrupos.getValue()==null){
                path = cbxFase.getValue();
            }
            else{//Si cbxGrupo tiene un valor entonces se buscara por la palabra grupo + su letra
                path = cbxFase.getValue()+" "+cbxGrupos.getValue();
            }
            if(dato[2].equals(path)){
                //Nos aseguramos que los paises no se repitan
                if(!countriesLeft.contains(dato[5])){//Paises que concuerden de lado izquierdo
                    countriesLeft.add(dato[5]);
                }
                if(!countriesRight.contains(dato[8])){//Paises que concuerden de lado derecho
                    countriesRight.add(dato[8]);
                }
            }
        }//Agregamos la lista de paises al ComboBox
        cbx1.getItems().addAll(countriesLeft);
        cbx2.getItems().addAll(countriesRight);
    }
}
