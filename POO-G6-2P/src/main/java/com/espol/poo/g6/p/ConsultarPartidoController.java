/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.poo.g6.p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Joshua
 */
public class ConsultarPartidoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> countries = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("WorldCupMatchesBrasil2014.csv"))){
            String linea;
            
            reader.readLine();
            while((linea=reader.readLine())!=null){
                String[] data = linea.split("\\|");
                if(!countries.contains(data[5])){
                    countries.add(data[5]);
                }
            }
        }catch(IOException exc){
            System.out.println(exc.getMessage());
        }
        cbx1.getItems().addAll(countries);
        cbx2.getItems().addAll(countries);
        cbxFase.getItems().addAll("Grupos","Ronda de 16","Cuartos de Final","Semifinal","Final");
        cbxGrupos.getItems().addAll("A","B","C","D","E","F","G","H");
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
    void Consultar(ActionEvent event) {
        
    }

    
}
