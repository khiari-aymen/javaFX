/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.javaT1_3A18.utils;

/**
 *
 * @author khiar
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
    private String URL = "jdbc:mysql://localhost:3306/test";
    private String Login = "root";
    private String Password = "";
    private Connection cnx;
    private static DB instance;
    
    
    private DB(){
        try {
            cnx = DriverManager.getConnection(URL, Login, Password);
            System.out.println("Connexion Réussite");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public Connection getCnx(){
        return cnx;
    }
    
    public static DB getInstance(){
        if(instance ==  null){
            instance = new DB();
        }
        return instance;
    }
}