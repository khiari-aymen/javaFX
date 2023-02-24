/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.javaT1.jui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author khiar
 */
public class AbonnementController implements Initializable {

    @FXML
    private AnchorPane Abonnement_kh;
    @FXML
    private TableView<?> table_kh;
    @FXML
    private TableColumn<?, ?> idAbonnement_kh1;
    @FXML
    private TableColumn<?, ?> nom_kh1;
    @FXML
    private TableColumn<?, ?> prix_kh1;
    @FXML
    private Button ajouter_kh;
    @FXML
    private Button modifier_kh;
    @FXML
    private Button supprimer_kh;
    @FXML
    private TextField nom_kh;
    @FXML
    private TextField prix_kh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_type(ActionEvent event) {
    }

    @FXML
    private void modifier_type(ActionEvent event) {
    }

    @FXML
    private void supprimer_type(ActionEvent event) {
    }
    
}
