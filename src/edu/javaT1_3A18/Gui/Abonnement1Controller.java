/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.javaT1_3A18.Gui;

import com.sun.javafx.css.CalculatedValue;
import edu.javaT1_3A18.entites.Abonnement;
import edu.javaT1_3A18.entites.AbonnementCRUD;
import edu.javaT1_3A18.entites.Type;
import edu.javaT1_3A18.entites.TypeCRUD;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author khiar
 */
public class Abonnement1Controller implements Initializable {

    @FXML
    private TableView<Type> table_kh;
  
    @FXML
    private Button ajouter_kh;
    @FXML
    private Button modifier_kh;
    @FXML
    private Button supprimer_kh;
    
    @FXML
    private AnchorPane Abonnement_kh;
    @FXML
    private TableColumn<Type, String> nom_kh1;
    
    @FXML
    private TableColumn<Type, Integer> idAbonnement_kh1;
    @FXML
    private TableColumn<Type, Float> prix_kh1;

    /**
     * Initializes the controller class.
     */
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        
        idAbonnement_kh1.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom_kh1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prix_kh1.setCellValueFactory(new PropertyValueFactory<>("prix"));
        

        // Charge les abonnements dans la table
        ObservableList<Type> abonnementList = FXCollections.observableArrayList(new TypeCRUD().getAllTypes());
        abonnementList.addAll(abonnementList);
        
        
        // TODO
}    

    @FXML
    private void ajouter_type(ActionEvent event) {
        // Création d'un nouveau Type
        
       

        // Création de la boîte de dialogue pour saisir les informations du nouveau type
        Dialog<Type> dialog = new Dialog<>();
        dialog.setTitle("Ajouter un nouveau type");
        dialog.setHeaderText("Saisissez les informations du nouveau type");

        // Création des champs pour saisir les informations
        Label nomLabel = new Label("Nom :");
        TextField nomTextField = new TextField();
        Label prixLabel = new Label("Prix :");
        TextField prixTextField = new TextField();

        // Ajout des champs à la boîte de dialogue
        VBox vbox = new VBox(nomLabel, nomTextField, prixLabel, prixTextField);
        dialog.getDialogPane().setContent(vbox);

        // Ajout des boutons OK et Annuler à la boîte de dialogue
        ButtonType okButtonType = new ButtonType("OK", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        // Écouteur pour valider la saisie et ajouter le nouveau type
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                Type nouveauType = new Type();
                nouveauType.setNom(nomTextField.getText());
                try {
                    nouveauType.setPrix(Float.parseFloat(prixTextField.getText()));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                new TypeCRUD().createType(nouveauType);
                ObservableList<Type> data = FXCollections.observableArrayList(nouveauType);
                table_kh.getItems().addAll(data);
            }
            return null;
        });

        // Affichage de la boîte de dialogue
        dialog.showAndWait();
    
    }

    @FXML
    private void modifier_type(ActionEvent event) {
        // Vérifier si un élément est sélectionné dans la table
    if (table_kh.getSelectionModel().getSelectedItem() == null) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Aucune sélection");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un abonnement à modifier.");
        alert.showAndWait();
        return;
    }
    
    // Récupérer l'abonnement sélectionné dans la table
    Type abonnement = (Type) table_kh.getSelectionModel().getSelectedItem();
    
    // Ouvrir une boîte de dialogue pour modifier l'abonnement
    Dialog<Type> dialog = new Dialog<>();
    dialog.setTitle("Modifier un abonnement");
    
    // Créer les champs de saisie pour les attributs de l'abonnement
    Label label1 = new Label("Nom: ");
    Label label2 = new Label("Prix: ");
    TextField textField1 = new TextField(abonnement.getNom());
    TextField textField2 = new TextField(Float.toString(abonnement.getPrix()));
    
    VBox vbox = new VBox(10, label1, textField1, label2, textField2);
    dialog.getDialogPane().setContent(vbox);
    
    // Ajouter les boutons "Enregistrer" et "Annuler"
    ButtonType buttonTypeSave = new ButtonType("Enregistrer");
    ButtonType buttonTypeCancel = new ButtonType("Annuler");
    dialog.getDialogPane().getButtonTypes().addAll(buttonTypeSave, buttonTypeCancel);
    
    // Attendre la réponse de l'utilisateur
    dialog.setResultConverter(dialogButton -> {
        if (dialogButton == buttonTypeSave) {
            // Vérifier si les champs de saisie sont valides
            if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Champs de saisie vides");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs de saisie.");
                alert.showAndWait();
                return null;
            }
            
            // Modifier l'abonnement dans la base de données
            String nom = textField1.getText();
            float prix = Float.parseFloat(textField2.getText());
            abonnement.setNom(nom);
            abonnement.setPrix(prix);
            boolean result = new TypeCRUD().updateType(abonnement);
            
            if (result) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Abonnement modifié");
                alert.setHeaderText(null);
                alert.setContentText("L'abonnement a été modifié avec succès.");
                alert.showAndWait();
                
                // Rafraîchir la table avec les nouveaux abonnements
                table_kh.getItems().clear();
                table_kh.getItems().addAll(new TypeCRUD().getAllTypes());
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Une erreur s'est produite lors de la modification de l'abonnement.");
                alert.showAndWait();
            }
            
            return abonnement;
        }
        return null;
    });
    
    dialog.showAndWait();
    }

   @FXML
private void supprimer_type(ActionEvent event) {
    Type selectedType = (Type) table_kh.getSelectionModel().getSelectedItem();
    if (selectedType != null) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Supprimer l'abonnement " + selectedType.getNom() + " ?");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer cet abonnement ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            new TypeCRUD().deleteType(selectedType);
            table_kh.getItems().remove(selectedType);
        }
    } else {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Aucune sélection");
        alert.setHeaderText("Aucun abonnement sélectionné");
        alert.setContentText("Veuillez sélectionner un abonnement dans la table.");
        alert.showAndWait();
    }
}






}
    



