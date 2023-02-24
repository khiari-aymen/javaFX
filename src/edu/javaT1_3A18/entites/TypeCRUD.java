/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.javaT1_3A18.entites;

import edu.javaT1_3A18.utils.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khiar
 */
public class TypeCRUD {
    

     private final Connection connection = DB.getInstance().getCnx();

    public TypeCRUD() {
        // initialiser la connexion à la base de données
       
    }

    // méthode pour créer un nouvel objet Type
    public void createType(Type type) {
        String query = "INSERT INTO types (nom, prix) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, type.getNom());
            statement.setFloat(2, type.getPrix());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // méthode pour lire un objet Type à partir de son nom
    public Type readType(int id) {
        String query = "SELECT * FROM types WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Type type = new Type();
                type.setId(resultSet.getInt("id"));
                type.setNom(resultSet.getString("nom"));
                type.setPrix(resultSet.getFloat("prix"));
                return type;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // méthode pour mettre à jour un objet Type existant
    public boolean updateType(Type type) {
        String query = "UPDATE types SET nom = ?, prix = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setFloat(2, type.getPrix());
            statement.setString(1, type.getNom());
            statement.setInt(3, type.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // méthode pour supprimer un objet Type existant
    public void deleteType(Type type) {
        String query = "DELETE FROM types WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,type.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // méthode pour récupérer tous les objets Type dans la base de données
    public List<Type> getAllTypes() {
        String query = "SELECT * FROM types";
        List<Type> types = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Type type = new Type();
                type.setId(resultSet.getInt("id"));
                type.setNom(resultSet.getString("nom"));
                type.setPrix(resultSet.getFloat("prix"));
                types.add(type);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
}   

    


